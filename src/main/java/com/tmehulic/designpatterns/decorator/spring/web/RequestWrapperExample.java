package com.tmehulic.designpatterns.decorator.spring.web;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.jspecify.annotations.NonNull;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Configuration
public class RequestWrapperExample {

    @Bean
    public FilterRegistrationBean<CustomFilter> customFilter() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @RestController
    static class CustomController {
        @PostMapping("/example")
        public String handle(@RequestBody String body) {
            return "SUCCESS";
        }
    }

    static class CustomFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(
                @NonNull HttpServletRequest request,
                @NonNull HttpServletResponse response,
                @NonNull FilterChain filterChain)
                throws ServletException, IOException {

            ContentCachingResponseWrapper wrappedResponse =
                    new ContentCachingResponseWrapper(response);

            filterChain.doFilter(request, wrappedResponse);

            byte[] body = wrappedResponse.getContentAsByteArray();

            wrappedResponse.setHeader("X-DECORATOR-EXAMPLE", String.valueOf(body.length));

            wrappedResponse.copyBodyToResponse();
        }
    }
}

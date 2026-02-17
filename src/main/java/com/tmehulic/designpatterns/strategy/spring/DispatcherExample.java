package com.tmehulic.designpatterns.strategy.spring;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Configuration
public class DispatcherExample {

    @Bean
    public HandlerMapping customHandlerMapping() {
        return new CustomHandler();
    }

    @Bean
    public HandlerAdapter customHandlerAdapter() {
        return new CustomAdapter();
    }

    static class CustomHandler implements HandlerMapping, Ordered {

        @Override
        public @Nullable HandlerExecutionChain getHandler(@NonNull HttpServletRequest request) {
            if (request.getRequestURI().contains("hello")) {
                Object logger = (Runnable) () -> System.out.println("The method is invoked!");
                return new HandlerExecutionChain(logger);
            }
            return null;
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }

    static class CustomAdapter implements HandlerAdapter, Ordered {
        @Override
        public boolean supports(@NonNull Object handler) {
            return handler instanceof Runnable;
        }

        @Override
        public @Nullable ModelAndView handle(
                @NonNull HttpServletRequest request,
                @NonNull HttpServletResponse response,
                @NonNull Object handler)
                throws IOException {
            ((Runnable) handler).run();
            response.getWriter().write("It actually works!");
            return null;
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }
}

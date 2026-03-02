package com.tmehulic.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class DesignPatternsApplication {

    static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    public static class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults())
                    .formLogin(Customizer.withDefaults())
                    .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll());
            return http.build();
        }
    }
}

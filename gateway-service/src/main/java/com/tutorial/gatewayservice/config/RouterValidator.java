package com.tutorial.gatewayservice.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {
    private static final List<String> places = Arrays.asList(
            "/secutiry/auth/login",
            "/secutiry/auth/validate",
            "/uploads/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security",
            "/csrf"
    );
    public Predicate<ServerHttpRequest> isSecured =
            request -> places
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}

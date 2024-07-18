package com.online_quiz_api.online_quiz_api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.CorsRegistry;
@Configuration
@EnableWebFlux
public class CorsGlobalConfiguration implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("GET", "PUT", "PATCH", "OPTIONS", "DELETE", "POST")
          .maxAge(3600);
    }
}
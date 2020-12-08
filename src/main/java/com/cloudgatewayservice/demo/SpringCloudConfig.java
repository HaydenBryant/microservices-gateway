package com.cloudgatewayservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SpringCloudConfig {

    @Value("${api.key}")
    private String apiKey;
//    @Autowired
//    private NewsApiController controller;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/topHeadlines")
                        .uri("http://newsapi.org/v2/top-headlines?country=us&apiKey=" + apiKey))

                .route(r -> r.path("/consumer/**")
                        .uri("http://localhost:8082"))

                .route(r -> r.path("/addUser").and().method(HttpMethod.POST)
                        .filter(f -> f)
                        .uri("http://localhost:8082")
                        )

                .build();
    }
}

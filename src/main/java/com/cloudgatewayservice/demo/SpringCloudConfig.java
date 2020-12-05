package com.cloudgatewayservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

//    @Value("${api.key}")
//    private String apiKey;
    @Autowired
    private NewsApiController controller;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/topHeadlines")
                        .uri(controller.getTopHeadlines()))
//                        .id("employeeModule"))

                .route(r -> r.path("/search/**")
                        .uri("http://localhost:8082/"))
//                        .id("consumerModule"))
                .build();
    }
}

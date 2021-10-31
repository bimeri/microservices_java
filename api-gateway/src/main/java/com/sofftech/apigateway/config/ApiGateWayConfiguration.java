package com.sofftech.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * Created by N.Bimeri on 10/08/2021.
 */@Configuration
public class ApiGateWayConfiguration {
     @Bean
     public RouteLocator routeLocatorBuilders(RouteLocatorBuilder routeLocatorBuilder){
         return routeLocatorBuilder.routes()
             .route(p -> p.path("/get")
             .filters(f -> f.addRequestHeader("MyHeader", "MyUri")
                            .addRequestHeader("MyToken", "Token"))
             .uri("http://httpbin.org:80"))
             .route(p -> p.path("/currency-exchange").uri("lb://currency-exchange/**"))
             .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
             .route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
             .route(p -> p.path("/currency-conversion-new/**").filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}")).uri("lb://currency-conversion"))
             .build();
     }
}

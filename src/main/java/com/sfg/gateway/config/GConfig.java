package com.sfg.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//@Profile("google")
//@Configuration
public class GConfig {

  @Bean
  public RouteLocator googleConfig(RouteLocatorBuilder builder) {
    System.out.println("Google config loaded.");
    return builder.routes()
        .route(r -> r.path("/googlesearch")
            .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
            .uri("https://google.com")
            .id("google"))
        .build();
  }
}

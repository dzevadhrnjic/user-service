package com.user_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MetricsRouterConfig {

//    @Bean
//    public RouterFunction<ServerResponse> metricsProxy() {
//
//        final WebClient webClient = WebClient.create();
//
//        return route(GET("/metrics"), request ->
//                webClient.get()
//                        .uri("http://localhost:9001/actuator/prometheus")
//                        .retrieve()
//                        .bodyToMono(String.class)
//                        .flatMap(body -> ServerResponse.ok()
//                                .contentType(MediaType.parseMediaType("text/plain; version=0.0.4; charset=utf-8"))
//                                .bodyValue(body))
//        );
//    }

    @Bean
    public RouterFunction<ServerResponse> metricsRedirect() {
        return route(GET("/metrics"),
                request -> ServerResponse.temporaryRedirect(URI.create("/actuator/prometheus")).build());
    }
}

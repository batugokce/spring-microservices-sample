package dev.batugokce.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Value("${services.order-service}")
    private String orderServiceUrl;

    @Value("${services.customer-service}")
    private String customerServiceUrl;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org/api"))
                .route(p -> p
                        .path("/api/v1/order")
                        .uri(orderServiceUrl))
                .route(p -> p
                        .path("/api/v1/customer")
                        .uri(customerServiceUrl))
                .build();
    }

}

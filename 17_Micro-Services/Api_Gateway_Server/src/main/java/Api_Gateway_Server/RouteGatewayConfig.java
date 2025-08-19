package Api_Gateway_Server;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteGatewayConfig
{

    public RouteGatewayConfig() {
        System.out.println("🚀 RouteGatewayConfig loaded!");
    }

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("category-service",
                        r -> r.path("/category/**")
                                .filters(f -> f.rewritePath("/category/?(?<remaining>.*)", "/${remaining}"))
                                .uri("lb://QUIZ-CATEGORY"))
                .route("quiz-service",
                        r -> r.path("/quizes/**")
                                .filters(f -> f.rewritePath("/quizes/?(?<remaining>.*)", "/${remaining}"))
                                .uri("lb://QUIZ-APP-SERVICE"))
                .build();
    }
}

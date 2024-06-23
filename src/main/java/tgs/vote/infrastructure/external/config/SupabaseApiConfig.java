package tgs.vote.infrastructure.external.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class SupabaseApiConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer ");
            requestTemplate.header("apikey", "");
        };
    }
}

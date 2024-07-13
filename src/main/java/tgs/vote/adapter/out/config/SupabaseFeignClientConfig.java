package tgs.vote.adapter.out.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class SupabaseFeignClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer ");
            requestTemplate.header("apikey", "");
        };
    }
}

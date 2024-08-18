package tgs.vote.adapter.out.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class SupabaseFeignClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV0aWVibm51anRweWN3cnplaXBrIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcxNDQ0MjY0MCwiZXhwIjoyMDMwMDE4NjQwfQ.iZsZC0QS_ggsZA4fz6XNE8ZAVp2JVgNZJnsQpOvjuVw");
            requestTemplate.header(
                    "apikey",
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV0aWVibm51anRweWN3cnplaXBrIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcxNDQ0MjY0MCwiZXhwIjoyMDMwMDE4NjQwfQ.iZsZC0QS_ggsZA4fz6XNE8ZAVp2JVgNZJnsQpOvjuVw");
        };
    }
}

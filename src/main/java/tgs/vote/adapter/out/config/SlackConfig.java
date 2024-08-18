package tgs.vote.adapter.out.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SlackConfig {

    @Value("${slack.token}")
    private String slackToken;

    @Value("${slack.client-id}")
    private String clientId;

    @Value("${slack.client-secret}")
    private String clientSecret;

    @Value("${slack.redirect-url}")
    private String redirectUri;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String getSlackToken() {
        return "Bearer " + slackToken;
    }

    @Bean
    public String getClientId() {
        return clientId;
    }

    @Bean
    public String getClientSecret() {
        return clientSecret;
    }

    @Bean
    public String getRedirectUri() {
        return redirectUri;
    }
}

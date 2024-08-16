package org.atmosware.internship.switching_between_profiles.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@Configuration
public class AppConfig {

    @Value("${test.property}")
    private String testProperty;

    public String getTestProperty() {
        return testProperty;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

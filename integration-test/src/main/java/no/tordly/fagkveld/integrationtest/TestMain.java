
package no.tordly.fagkveld.integrationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@EnableRetry
@SpringBootApplication
public class TestMain {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("http://api:8080")
                .defaultMessageConverters()
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }
}

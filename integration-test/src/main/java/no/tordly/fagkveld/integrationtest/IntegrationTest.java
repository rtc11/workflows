package no.tordly.fagkveld.integrationtest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IntegrationTest implements CommandLineRunner {
    private final RestTemplate rest;

    @Retryable(maxAttempts = 10)
    private String getUUid() {
        return rest.getForObject("/uuid", String.class);
    }

    @Override
    public void run(String... args) {
        String uuid = getUUid();

        if (uuid == null) {
            throw new RuntimeException("Fant ingen uuid");
        } else {
            System.out.println("Fant uuid " + UUID.fromString(uuid));
            System.exit(0);
        }
    }
}

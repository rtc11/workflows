package no.tordly.fagkveld;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/uuid")
public class Api {

    @GetMapping(value = "/{amount}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<?> get10RandomUuids(@PathVariable("amount") Integer amount) {
        return Flux.fromStream(Stream.iterate(UUID.randomUUID(), i -> UUID.randomUUID()))
                .delayElements(Duration.ofMillis(300))
                .limitRequest(amount);
    }
}

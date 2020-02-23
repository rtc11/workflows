package no.tordly.fagkveld.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Api {

    @GetMapping("/uuid")
    public String getRandom() {
        return UUID.randomUUID().toString();
    }
}

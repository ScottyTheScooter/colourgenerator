package de.dhbwravensburg.webeng.colourgenproject.service;

import de.dhbwravensburg.webeng.colourgenproject.dto.NeoFeedResponse;
import de.dhbwravensburg.webeng.colourgenproject.dto.NeoPalette;
//import de.dhbwravensburg.webeng.colourgenproject.exception.ExternalApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class ColourNeoService {

    private final RestClient colourRestClient;
    private final String apiKey;

    public ColourNeoService(RestClient colourRestClient, @Value("${colour.api.key") String apiKey) {
        this.colourRestClient = colourRestClient;
        this.apiKey = apiKey;
    }

    public List<NeoPalettes> fetchPalettesForDate(String hex) {
        try {
            NeoFeedResponse response = colourRestClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/scheme")
                            .queryParam("hex", hex)
                            .queryParam()
                            .build())
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new ExternalApiException("COLOUR API client error:" + res.getStatusCode())
                    })
                    .onStatus(HttpStatusCode::is5xxClientError, (req, res) -> {
                        throw new ExternalApiException("COLOUR API server error:" + res.getStatusCode())
                    })
                    .body(NeoFeedResponse.class);
            if (response == null || response.) {
            }
        }
    }

}

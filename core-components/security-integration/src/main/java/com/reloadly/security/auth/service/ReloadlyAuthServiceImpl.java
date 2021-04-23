package com.reloadly.security.auth.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.reloadly.commons.model.ReloadlyAuthToken;
import com.reloadly.security.config.ReloadlyAuthProperties;
import com.reloadly.security.exception.ReloadlyAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ReloadlyAuthServiceImpl implements ReloadlyAuth {

    private final ReloadlyAuthProperties properties;
    private final RestTemplate restTemplate;

    public ReloadlyAuthServiceImpl(ReloadlyAuthProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    @Override
    public ReloadlyAuthToken verifyToken(String token) throws ReloadlyAuthException {
        Assert.hasLength(properties.getReloadlyAuthServiceEndpoint(), "Authentication endpoint URL can not be empty.");

        // Exchange
        try {
            ResponseEntity<ReloadlyAuthToken> response =
                    restTemplate.postForEntity(properties.getReloadlyAuthServiceEndpoint().concat("/verify"), new AuthRequest(token),
                            ReloadlyAuthToken.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new ReloadlyAuthException("Token verification failed.");
            }
        } catch (RestClientException e) {
            throw new ReloadlyAuthException("Token verification failed. Root cause: " + e.getMessage(), e);
        }
    }

    static class AuthRequest {
        final String token;
        @JsonCreator
        public AuthRequest(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
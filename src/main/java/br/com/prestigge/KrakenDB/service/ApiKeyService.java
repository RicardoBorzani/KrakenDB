package br.com.prestigge.KrakenDB.service;

import br.com.prestigge.KrakenDB.exception.InvalidApiKeyException;
import br.com.prestigge.KrakenDB.model.ApiKey;
import br.com.prestigge.KrakenDB.repository.ApiKeyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@ComponentScan("br.com.prestigge.KrakenDB.repository")
public class ApiKeyService {
    @Autowired
    private ApiKeyRepository apiKeyRepository;

    public void validateApiKey(String apiKey) throws InvalidApiKeyException {
        ApiKey key = apiKeyRepository.findByApiKey(apiKey);
        if (key == null) {
            throw new InvalidApiKeyException("API key is invalid or expired.");
        }
        if (key.getExpirationDate().isBefore(LocalDateTime.now())) {
            throw new InvalidApiKeyException("API key has expired.");
        }
        // valid key
    }
}

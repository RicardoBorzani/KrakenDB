package br.com.prestigge.KrakenDB.service;

import br.com.prestigge.KrakenDB.exception.InvalidApiKeyException;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyValidator {

    public void validateApiKey(String apiKey) throws InvalidApiKeyException {
        // Lógica para validar a chave da API
        if (apiKey == null || !apiKey.equals("minha-chave-da-api")) {
            throw new InvalidApiKeyException("API key inválida.");
        }
    }
}

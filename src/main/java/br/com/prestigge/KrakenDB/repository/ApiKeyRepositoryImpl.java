package br.com.prestigge.KrakenDB.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.prestigge.KrakenDB.model.ApiKey;

@Repository
public class ApiKeyRepositoryImpl implements ApiKeyRepository {

    private Map<String, ApiKey> apiKeyMap = new HashMap<>();

    @Override
    public ApiKey findByApiKey(String apiKey) {
        return apiKeyMap.get(apiKey);
    }
}
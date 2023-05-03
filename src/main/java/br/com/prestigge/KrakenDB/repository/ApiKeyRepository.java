package br.com.prestigge.KrakenDB.repository;

import br.com.prestigge.KrakenDB.model.ApiKey;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository {
    ApiKey findByApiKey(String apiKey);
}

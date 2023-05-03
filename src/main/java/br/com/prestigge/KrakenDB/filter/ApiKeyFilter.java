package br.com.prestigge.KrakenDB.filter;

import br.com.prestigge.KrakenDB.exception.InvalidApiKeyException;
import br.com.prestigge.KrakenDB.service.ApiKeyValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiKeyFilter.class);
    
    private final ApiKeyValidator apiKeyValidator;

    public ApiKeyFilter(ApiKeyValidator apiKeyValidator) {
        this.apiKeyValidator = apiKeyValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("X-Api-Key");
        if (apiKey == null) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "API key is missing.");
            return;
        }
        LOGGER.debug("Received request with API key: {}", apiKey);
        try {
            apiKeyValidator.validateApiKey(apiKey);
            LOGGER.debug("Request with API key {} validated successfully.", apiKey);
            filterChain.doFilter(request, response);
        } catch (InvalidApiKeyException e) {
            LOGGER.warn("Request with invalid API key {}.", apiKey);
            response.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        }
    }
}

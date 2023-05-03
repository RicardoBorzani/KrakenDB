package br.com.prestigge.KrakenDB.config;

import br.com.prestigge.KrakenDB.filter.ApiKeyFilter;
import br.com.prestigge.KrakenDB.service.ApiKeyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("br.com.prestigge.KrakenDB.repository")
public class WebSecurityConfig {
    @Autowired
    private ApiKeyValidator apiKeyValidator;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        ApiKeyFilter apiKeyFilter = new ApiKeyFilter(apiKeyValidator);
        http.addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .disable()
                .csrf()
                .disable();
        return http.build();
    }
}

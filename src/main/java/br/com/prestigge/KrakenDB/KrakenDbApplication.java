package br.com.prestigge.KrakenDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.prestigge.KrakenDB")
public class KrakenDbApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(KrakenDbApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KrakenDbApplication.class, args);
		LOGGER.debug("Debug message");
		LOGGER.info("Info message");
		LOGGER.warn("Warn message");
		LOGGER.error("Error message");
	}
}

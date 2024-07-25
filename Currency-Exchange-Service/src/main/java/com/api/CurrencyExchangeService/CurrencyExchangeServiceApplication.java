package com.api.CurrencyExchangeService;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	/*
	 * @Bean public Customizer<Resilience4JCircuitBreakerFactory>
	 * globalCustomConfiguration() { // Customizing Circuit Breaker configuration
	 * CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
	 * .failureRateThreshold(50) // Threshold for failure rate in percentage
	 * .slowCallRateThreshold(50) // Threshold for slow call rate in percentage
	 * .slowCallDurationThreshold(Duration.ofSeconds(2)) // Threshold for slow call
	 * duration .permittedNumberOfCallsInHalfOpenState(5) // Number of calls allowed
	 * in half open state .minimumNumberOfCalls(10) // Minimum number of calls to
	 * calculate failure rate
	 * .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED) //
	 * Sliding window type .slidingWindowSize(10) // Size of the sliding window
	 * .build();
	 * 
	 * // Returning a customizer to apply the custom configuration return factory ->
	 * factory.configure(builder -> builder
	 * .circuitBreakerConfig(circuitBreakerConfig) // Other customizations can be
	 * added here ); }
	 */
	
}

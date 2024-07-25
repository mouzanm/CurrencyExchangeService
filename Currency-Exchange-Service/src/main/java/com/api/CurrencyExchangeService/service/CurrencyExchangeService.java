package com.api.CurrencyExchangeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import org.springframework.stereotype.Service;

import com.api.CurrencyExchangeService.controller.CurrencyExchnageFeignClient;


@Service
public class CurrencyExchangeService {
	
	@Autowired
	Resilience4JCircuitBreakerFactory circuitBreakerFactory;
	@Autowired
	private CurrencyExchnageFeignClient currencyFeignClient;
	
	public String exchange(String source_curr, String target_curr, int source_amt) {
		CircuitBreaker circuitBreaker=circuitBreakerFactory.create("circuitBreaker");
		// TODO Auto-generated method stub
		/*
		 * CircuitBreaker circuitBreaker = (CircuitBreaker)
		 * circuitBreakerFactory.create("circuitbreaker");
		 */
		/*
		 * String target_amt=currencyFeignClient.rate(source_curr, target_curr,
		 * source_amt); return circuitBreaker.run(()->target_amt,
		 * throwable->getDefaulMessage(throwable));
		 */
		return circuitBreaker.run(()->currencyFeignClient.rate(source_curr, target_curr, source_amt), throwable->getDefaulMessage(throwable));
	}

	private String getDefaulMessage(Throwable throwable) {
		// TODO Auto-generated method stub
		return "This is Fallback Message"+throwable.getMessage();
	}

}

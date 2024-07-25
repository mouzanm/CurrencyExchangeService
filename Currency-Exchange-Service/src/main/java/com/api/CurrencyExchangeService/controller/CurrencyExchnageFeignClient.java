package com.api.CurrencyExchangeService.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*@FeignClient(value = "userFeignClient",url="http://localhost:8082/api/currency-rate")*/
@FeignClient("currency-rate-service/api/currency-rate")
public interface CurrencyExchnageFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/rate/{source_curr}/{target_curr}/{source_amt}", produces = "application/json")
	public String rate(@PathVariable("source_curr") String source_curr,@PathVariable("target_curr") String target_curr,@PathVariable("source_amt") int source_amt);
}

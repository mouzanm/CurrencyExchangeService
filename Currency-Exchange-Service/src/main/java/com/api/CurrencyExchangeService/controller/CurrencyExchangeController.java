package com.api.CurrencyExchangeService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.api.CurrencyExchangeService.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);
@Autowired
	CurrencyExchangeService service;

	/* @RequestMapping("/api/exchange/{source_curr}/{target_curr}/{source_amt}") */
	@PostMapping("/api/exchange/")
	/*
	 * public String exchnage(@PathVariable("source_curr") String
	 * source_curr,@PathVariable("target_curr") String
	 * target_curr,@PathVariable("source_amt") int source_amt) {
	 */
		public String exchnage(@RequestBody ExchnageRequestBean bean) {
			 System.out.println("Hello from exchange service");
			 String target_amt=service.exchange(bean.getSource_curr(),bean.getTarget_curr(),bean.getSource_amt()); 
		
		  LOGGER.debug("The Exchange value for "+bean.getSource_curr()+" to "+bean.getTarget_curr()+
		  " for the amount "+bean.getSource_amt()+" is " + target_amt);
		 
		LOGGER.debug(target_amt);
		return "The Exchange value for "+bean.getSource_curr()+" to "+bean.getTarget_curr()+
				  " for the amount "+bean.getSource_amt()+" is " + target_amt;
		
	}
}

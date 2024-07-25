package com.api.CurrencyExchangeService.controller;

public class ExchnageRequestBean {
private String source_curr;
private String target_curr;
private int source_amt;
public String getSource_curr() {
	return source_curr;
}
public void setSource_curr(String source_curr) {
	this.source_curr = source_curr;
}
public String getTarget_curr() {
	return target_curr;
}
public void setTarget_curr(String target_curr) {
	this.target_curr = target_curr;
}
public int getSource_amt() {
	return source_amt;
}
public void setSource_amt(int source_amt) {
	this.source_amt = source_amt;
}


}

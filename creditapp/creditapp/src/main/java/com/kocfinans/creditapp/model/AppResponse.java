package com.kocfinans.creditapp.model;

import java.math.BigDecimal;

import lombok.Builder;

@Builder(toBuilder = true)
public class AppResponse {
    private Boolean appResult;
    private BigDecimal limit;
    private String message;
    
    
	public Boolean getAppResult() {
		return appResult;
	}
	public void setAppResult(Boolean appResult) {
		this.appResult = appResult;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
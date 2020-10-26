package com.kocfinans.creditapp.model;


import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class AppRequest {

    @NotBlank(message = "IdentityNo is mandatory!")
    private String identityNo;
    
    private String name;
    
    private String surname;
    
    @NotBlank(message = "Salary is mandatory !")
    
    private BigDecimal salary;
    
    private String phoneNumber;
    
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal monthlyIncome) {
		this.salary = monthlyIncome;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
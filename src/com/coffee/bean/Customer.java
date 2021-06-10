package com.coffee.bean;

public class Customer {
	private String customerName, phoneNumber;
	//private long phoneNumber;
	public Customer() {
		
	}
	public Customer(String phoneNumber,String customerName){
		this.customerName=customerName;
		this.phoneNumber=phoneNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}

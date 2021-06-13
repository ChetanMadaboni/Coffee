package com.coffee.bean;

public class Bill {
	private String customerName,coffeeName,addOn,size;
	
	private int price;
	public Bill() {
		
	}
	public Bill(String customerName,String coffeeName, String addOn, String size, int price) {
		super();
		this.coffeeName = coffeeName;
		this.addOn = addOn;
		this.size = size;
		this.price = price;
		this.customerName=customerName;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getAddOn() {
		return addOn;
	}
	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}

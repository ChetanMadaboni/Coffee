package com.coffee.bean;

public class Bill {
	private String customerName,coffeeName,addOn,size,date;
	
	private int price;
	public Bill() {
		
	}
	public Bill(String customerName,String coffeeName, String size, int price,String date) {
		super();
		this.coffeeName = coffeeName;
		///this.addOn = addOn;
		this.size = size;
		this.price = price;
		this.customerName=customerName;
		this.date=date;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
//	public String getAddOn() {
//		return addOn;
//	}
//	public void setAddOn(String addOn) {
//		this.addOn = addOn;
//	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

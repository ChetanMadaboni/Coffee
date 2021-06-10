package com.coffee.bean;

public class AddOns {
	private int addOnId,addOnPrice;
	private String name;
	
	public AddOns() {
		
	}
	public AddOns(int addOnId, int addOnPrice, String name) {
		super();
		this.addOnId = addOnId;
		this.addOnPrice = addOnPrice;
		this.name = name;
	}
	public int getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(int addOnId) {
		this.addOnId = addOnId;
	}
	public int getAddOnPrice() {
		return addOnPrice;
	}
	public void setAddOnPrice(int addOnPrice) {
		this.addOnPrice = addOnPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

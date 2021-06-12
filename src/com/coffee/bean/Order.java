package com.coffee.bean;

public class Order {
	private int coffeeid,addonid,sizeid;
	
	public Order(){
		
	}
	

	public Order(int coffeeid, int addonid, int sizeid) {
		super();
		this.coffeeid = coffeeid;
		this.addonid = addonid;
		this.sizeid = sizeid;
	}

	public int getCoffeeid() {
		return coffeeid;
	}	

	public void setCoffeeid(int coffeeid) {
		this.coffeeid = coffeeid;
	}

	public int getAddonid() {
		return addonid;
	}

	public void setAddonid(int addonid) {
		this.addonid = addonid;
	}

	public int getSizeid() {
		return sizeid;
	}

	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	
	@Override
	public String toString() {
		return "Order [coffeeid=" + coffeeid + ", addonid=" + addonid + ", sizeid=" + sizeid + "]";
	}

	
}

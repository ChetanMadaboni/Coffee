package com.coffee.bean;

public class AddOnsOrder {
	private int addonid;
	private int coffeeid;
	public AddOnsOrder(int addonid,int coffeeid) {
		super();
		this.addonid = addonid;
		this.coffeeid=coffeeid;
	}

	public int getAddonid() {
		return addonid;
	}

	public void setAddonid(int addonid) {
		this.addonid = addonid;
	}

	public int getCoffeeid() {
		return coffeeid;
	}

	public void setCoffeeid(int coffeeid) {
		this.coffeeid = coffeeid;
	}
	
}

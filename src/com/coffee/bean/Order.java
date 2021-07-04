package com.coffee.bean;

import java.util.ArrayList;

public class Order {
	private int coffeeid,addonid,sizeid;
	private ArrayList<AddOnsOrder> addonsorder;
	public ArrayList<AddOnsOrder> getAddonsorder() {
		return addonsorder;
	}


	public void setAddonsorder(ArrayList<AddOnsOrder> addonsorder) {
		this.addonsorder = addonsorder;
	}


	public Order(){
		
	}
	

	public Order(int coffeeid, int sizeid,ArrayList<AddOnsOrder> addonsorder) {
		super();
		this.coffeeid = coffeeid;
		//this.addonid = addonid;
		this.sizeid = sizeid;
		this.addonsorder=addonsorder;
	}

	public int getCoffeeid() {
		return coffeeid;
	}	

	public void setCoffeeid(int coffeeid) {
		this.coffeeid = coffeeid;
	}
//
//	public int getAddonid() {
//		return addonid;
//	}
//
//	public void setAddonid(int addonid) {
//		this.addonid = addonid;
//	}

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

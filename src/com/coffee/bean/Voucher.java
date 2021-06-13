package com.coffee.bean;

public class Voucher {
	private String vname;
	private int price;
	public Voucher() {
		
	}
	public Voucher(String vname,int price) {
		this.vname=this.vname;
		this.price=price;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

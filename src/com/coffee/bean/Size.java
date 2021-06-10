package com.coffee.bean;

public class Size {
	private int sizeid,sizeprice;
	private String sizename;
	
	public Size(){
		
	}
	Size(int sizeid, int sizeprice, String sizename) {
		super();
		this.sizeid = sizeid;
		this.sizeprice = sizeprice;
		this.sizename = sizename;
	}
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	public int getSizeprice() {
		return sizeprice;
	}
	public void setSizeprice(int sizeprice) {
		this.sizeprice = sizeprice;
	}
	public String getSizename() {
		return sizename;
	}
	public void setSizename(String sizename) {
		this.sizename = sizename;
	}
	
}

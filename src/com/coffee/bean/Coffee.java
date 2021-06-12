package com.coffee.bean;

public class Coffee {
	private String coffeeName;
	private int coffeePrice,coffeeId;
	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public Coffee() {
	}
	
	public Coffee(int coffeeId,String coffeeName, int coffeePrice) {
		super();
		this.coffeeName = coffeeName;
		this.coffeePrice = coffeePrice;
		this.coffeeId=coffeeId;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public int getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	@Override
	public String toString() {
		return "Coffee [coffeeName=" + coffeeName + ", coffeePrice=" + coffeePrice + "]";
	}
	
}

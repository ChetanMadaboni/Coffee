package com.coffee.customer;

import java.util.Scanner;

import com.coffee.presentation.CoffeePresentation;
import com.coffee.presentation.CoffeePresentationImpli;

public class CustomerMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		CoffeePresentation cp=new CoffeePresentationImpli();
		cp.checkCustomer();
		cp.showMenu();
	}

}

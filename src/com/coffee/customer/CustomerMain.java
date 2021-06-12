package com.coffee.customer;

import java.util.ArrayList;
import java.util.Scanner;

import com.coffee.bean.Order;
import com.coffee.presentation.CoffeePresentation;
import com.coffee.presentation.CoffeePresentationImpli;

public class CustomerMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("**********STARBUCKS**********");
		System.out.println();
		CoffeePresentation cp=new CoffeePresentationImpli();
		cp.checkCustomer();
		boolean flag=true;
		ArrayList<Order> arr=new ArrayList<Order>();
		while(flag) {
			cp.showMenu();
			System.out.println("Please enter you coffeeId");
			int coffeechoice=sc.nextInt();
			cp.showAddOns();
			System.out.println("Please enter you coffeeId");
			int addchoice=sc.nextInt();
			cp.showSize();
			System.out.println("Please enter you coffee size");
			int sizechoice=sc.nextInt();
			System.out.println("Do You want to Continue?");
			System.out.println("0->Continue");
			System.out.println("1->Exit");
			int exitchoice=sc.nextInt();
			if(exitchoice==1) {
				flag=false;
			}else {
				flag=true;
			}
			Order o=new Order(coffeechoice,addchoice,sizechoice);
			arr.add(o);
		}
		System.out.println("  "+"Your Order has been Placed!");
		cp.orderEntry(arr);
		
	}

}

package com.coffee.customer;

import java.util.Scanner;

import com.coffee.presentation.CoffeePresentation;
import com.coffee.presentation.CoffeePresentationImpli;

public class CustomerMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		CoffeePresentation cp=new CoffeePresentationImpli();
		cp.checkCustomer();
		boolean flag=true;
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
			
			
		}
		System.out.println("Your Order has been Placed!");
		
	}

}

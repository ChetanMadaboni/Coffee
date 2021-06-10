package com.coffee.helper;

import java.util.Scanner;

import com.coffee.bean.Customer;

public class CustomerInputOutput {

	public static Customer inputCustomer() {
		Scanner sc=new Scanner(System.in);
		Customer customer =new Customer();
		System.out.println("Please enter your name!");
		customer.setCustomerName(sc.next());
		System.out.println("Please enter your PhoneNumber!");
		customer.setPhoneNumber(sc.next());
		return customer;

	}

}

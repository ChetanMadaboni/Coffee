package com.coffee.helper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.coffee.bean.Customer;

public class CustomerInputOutput {
	 String phonenumber;
	
	public  Customer checkCustomer() {
		Scanner sc=new Scanner(System.in);
		Customer customer =new Customer();
		//System.out.println("Please enter your name!");
		//customer.setCustomerName(sc.next());
		boolean flag=false;
		System.out.println("Please enter your PhoneNumber!");
		while(flag==false) {
			
			phonenumber=sc.next();
			Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
			Matcher match = ptrn.matcher(phonenumber); 
			if(match.find() && match.group().equals(phonenumber)) {
				flag=true;
				customer.setPhoneNumber(phonenumber);
			}else {
				System.out.println("Please Enter valid Phonenumber");
			}
			
		}
		
		return customer;
	}
	
	public Customer enterCustomer() {
		Scanner sc=new Scanner(System.in);
		Customer customer =new Customer();
		System.out.println("Please enter your name!");
		customer.setCustomerName(sc.next());
		customer.setPhoneNumber(phonenumber);
		return customer;
	}

}

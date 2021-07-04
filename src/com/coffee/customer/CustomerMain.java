package com.coffee.customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.coffee.bean.AddOns;
import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Order;
import com.coffee.bean.Voucher;
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
		ArrayList<ArrayList<AddOnsOrder>> addonsarr=new ArrayList<ArrayList<AddOnsOrder>>();
		while(flag) {
			cp.showMenu();
			System.out.println("Please enter you coffeeId");
			int coffeechoice=sc.nextInt();
			boolean addonsflag=false;
			System.out.println("Please enter you AddOnId");
			ArrayList<AddOnsOrder> addonsarrp=new ArrayList<AddOnsOrder>();
			while(addonsflag==false) {
				cp.showAddOns();
				int addchoice=sc.nextInt();
				if(addchoice>0 && addchoice<5) {
					AddOnsOrder add=new AddOnsOrder(addchoice,coffeechoice);
					addonsarrp.add(add);
					System.out.println("Do You want to Add more Addons?:");
					System.out.println("1->Yes");
					System.out.println("0->No");
					int addcontinuechoice=sc.nextInt();
					if(addcontinuechoice==1) {
						addonsflag=false;
					}else {
						addonsflag=true;
					}
				}else {
					System.out.println("Please enter valid ID:");
				}
			}
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
			Order o=new Order(coffeechoice,sizechoice,addonsarrp);
			arr.add(o);
			addonsarr.add(addonsarrp);
		}
		Voucher voucher=new Voucher();
		int voucherStatus=1;
		while(voucherStatus==1) {
			System.out.println("Do You have any voucher?");
			System.out.println("1->Yes");
			System.out.println("0->No");
			voucherStatus=sc.nextInt();
			voucher=new Voucher();
			if(voucherStatus==1) {
				System.out.println("Please Enter your vouchercode!");
				String voucherCode=sc.next();
				voucher=cp.checkVoucher(voucherCode);
				if(voucher.getVname()!=null) {
					voucherStatus=0;
				}
			}	
		}
		
		
		System.out.println();
		System.out.println("  "+"Your Order has been Placed!");
		cp.addonsEntry(addonsarr);
		cp.orderEntry(arr);
		cp.displayBillDetails();
		cp.getBill(voucher);
		try {
			cp.setStatus();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

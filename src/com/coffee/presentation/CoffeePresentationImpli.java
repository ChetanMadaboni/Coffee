package com.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.bean.Order;
import com.coffee.bean.Size;
import com.coffee.helper.CustomerInputOutput;
import com.coffee.service.CoffeeService;
import com.coffee.service.CoffeeServiceImpli;
import com.coffee.service.OrderService;
import com.coffee.service.OrderServiceImpli;


public class CoffeePresentationImpli implements CoffeePresentation {
	private CoffeeService coffeeService=new CoffeeServiceImpli();
	private OrderService orderService =new OrderServiceImpli();
	Customer c1=CustomerInputOutput.inputCustomer();;
	@Override
	public void checkCustomer() {
			try {
				
				Customer c=coffeeService.checkCustomer(c1);
				if(c.getCustomerName()!=null) {
					System.out.println("Welcome Back to StarBucks! "+c.getCustomerName());
				}
				else {
					if(coffeeService.insertCustomer(c1)) {
					System.out.println("Heartly Welcome to StarBucks!");	
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void showMenu() {
		Collection<Coffee> coffees=null;
		try {
			coffees = coffeeService.getCoffees();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(Coffee coffee:coffees) {
			System.out.println(" "+coffee.getCoffeeId()+" "+coffee.getCoffeeName()+" "+coffee.getCoffeePrice());
		}
	}

	@Override
	public void showAddOns() {
		Collection<AddOns> addOns=null;
		try {
			addOns = coffeeService.getAddOns();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(AddOns a:addOns) {
			System.out.println(" "+a.getAddOnId()+" "+a.getName()+" "+a.getAddOnPrice());
		}
		
	}

	@Override
	public void showSize() {
		Collection<Size> sizes=null;
		try {
			sizes = coffeeService.getSize();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(Size s:sizes) {
			System.out.println(" "+s.getSizeid()+" "+s.getSizename()+" "+s.getSizeprice());
		}
		
	}

	@Override
	public void orderEntry(ArrayList<Order> orders) {
		String name=c1.getCustomerName();
		try {
			orderService.orderEntry(orders,name);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}

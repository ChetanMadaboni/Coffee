package com.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.bean.Bill;
import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.bean.Order;
import com.coffee.bean.Size;
import com.coffee.bean.Voucher;
import com.coffee.helper.CustomerInputOutput;
import com.coffee.service.BillService;
import com.coffee.service.BillServiceImpli;
import com.coffee.service.CoffeeService;
import com.coffee.service.CoffeeServiceImpli;
import com.coffee.service.OrderService;
import com.coffee.service.OrderServiceImpli;
import com.coffee.service.VoucherService;
import com.coffee.service.VoucherServiceImpli;


public class CoffeePresentationImpli implements CoffeePresentation {
	private CoffeeService coffeeService=new CoffeeServiceImpli();
	private OrderService orderService =new OrderServiceImpli();
	private Customer c1=CustomerInputOutput.inputCustomer();
	private VoucherService voucherService=new VoucherServiceImpli();
	private BillService billService=new BillServiceImpli();
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

	@Override
	public Voucher checkVoucher(String vouchername) {
		Voucher voucher=null;
		try {
			voucher=voucherService.checkVoucher(vouchername);
			if(voucher.getVname()!=null) {
				System.out.println("Voucher Applied Successfully");
			}
			else {
				System.out.println("Voucher Does not Exists!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voucher;
	}

	@Override
	public void getBill(Voucher voucher) {
		int total=0;
		Collection<Bill> bills=null;
		try {
			bills = billService.getBill();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(Bill b:bills) {
			total+=b.getPrice();
			System.out.println(" "+b.getCoffeeName()+" "+b.getAddOn()+" "+b.getSize()+" "+b.getPrice()+" ");
		}
		System.out.println("Final Bill Invoice: ");
		System.out.println("Total value: "+total);
		System.out.println("Voucher Discount : "+voucher.getPrice());
		int netValue=total-voucher.getPrice();
		System.out.println("Net Value: "+netValue);
		Double gst=(0.18)*netValue;
		System.out.println("GST: 18% "+gst);
		Double serviceTax=(0.08)*netValue;
		System.out.println("Service Tax: 8%"+serviceTax);
		System.out.println("Total bill: "+(netValue+gst+serviceTax));
		
		
	}

	@Override
	public void setStatus() throws ClassNotFoundException, SQLException {
		
		billService.setStatus();
	}

	
	

}

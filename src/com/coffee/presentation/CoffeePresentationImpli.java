package com.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Bill;
import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.bean.Order;
import com.coffee.bean.Size;
import com.coffee.bean.Voucher;
import com.coffee.helper.CustomerInputOutput;
import com.coffee.service.AddOnService;
import com.coffee.service.AddOnServiceImpli;
import com.coffee.service.AddOnsOrderService;
import com.coffee.service.AddOnsOrderServiceImpli;
import com.coffee.service.BillService;
import com.coffee.service.BillServiceImpli;
import com.coffee.service.CoffeeService;
import com.coffee.service.CoffeeServiceImpli;
import com.coffee.service.CustomerService;
import com.coffee.service.CustomerServiceImpli;
import com.coffee.service.OrderService;
import com.coffee.service.OrderServiceImpli;
import com.coffee.service.SizeService;
import com.coffee.service.SizeServiceImpli;
import com.coffee.service.VoucherService;
import com.coffee.service.VoucherServiceImpli;


public class CoffeePresentationImpli implements CoffeePresentation {
	private CustomerInputOutput cio=new CustomerInputOutput();
	private CustomerService customerService=new CustomerServiceImpli();
	private OrderService orderService =new OrderServiceImpli();
	private Customer c1=cio.checkCustomer();
	private VoucherService voucherService=new VoucherServiceImpli();
	private BillService billService=new BillServiceImpli();
	private CoffeeService coffeeservice=new CoffeeServiceImpli();
	private AddOnService addOnService=new AddOnServiceImpli();
	private SizeService sizeService=new SizeServiceImpli();
	private AddOnsOrderService addonorderserv=new AddOnsOrderServiceImpli();
	private Customer c;
	@Override
	public void checkCustomer() {
			try {
				
				 c=customerService.checkCustomer(c1);
				if(c.getCustomerName()!=null) {
					System.out.println("Welcome Back to StarBucks! "+c.getCustomerName());
				}
				else {
					 Customer c2=cio.enterCustomer();
					if(customerService.insertCustomer(c2)) {
					System.out.println("Heartly Welcome to StarBucks!");	
					}
				}
			} catch (ClassNotFoundException | SQLException e) {e.printStackTrace();
			}
		
	}

	@Override
	public void showMenu() {
		Collection<Coffee> coffees=null;
		try {
			coffees = coffeeservice.getCoffees();
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
			addOns = addOnService.getAddOns();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(AddOns a:addOns) {
			if(a.getAddOnPrice()!=0) {
			System.out.println(" "+a.getAddOnId()+" "+a.getName()+" "+a.getAddOnPrice());
			}else {
				System.out.println(" "+a.getAddOnId()+" "+a.getName());
			}
		}
		
	}

	@Override
	public void showSize() {
		Collection<Size> sizes=null;
		try {
			sizes = sizeService.getSize();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		for(Size s:sizes) {
			if(s.getSizeprice()!=0) {
			System.out.println(" "+s.getSizeid()+" "+s.getSizename()+" "+s.getSizeprice());
			}else {
				System.out.println(" "+s.getSizeid()+" "+s.getSizename());
			}
		}
		
	}

	@Override
	public void orderEntry(ArrayList<Order> orders) {
		String name=c1.getCustomerName();
		try {
			orderService.orderEntry(orders,c.getCustomerName());
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
				
		ArrayList<Object> arr;
		try {
			arr = billService.getBill(voucher);
			System.out.println();
			System.out.println(" Final Bill Invoice: ");
			System.out.println(" Total value: "+arr.get(0));
			System.out.println(" Voucher Discount : "+arr.get(1));
			System.out.println(" Net Value: "+arr.get(2));
			System.out.println(" GST: 18 % "+arr.get(3));
			System.out.println(" Service Tax: 8 % "+arr.get(4));
			System.out.println(" Total bill: "+arr.get(5));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public void displayBillDetails() {
		Collection<Bill> bills=null;
		try {
			bills = billService.billdetails();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println();
		for(Bill b:bills) {
			//total+=b.getPrice();
			System.out.println(" "+b.getCoffeeName()+" "+" "+b.getSize()+" "+b.getPrice()+" "+b.getDate());
		}
		
	}
	@Override
	public void setStatus() throws ClassNotFoundException, SQLException {
		
		billService.setStatus();
	}

	@Override
	public void addonsEntry(ArrayList<ArrayList<AddOnsOrder>> addonsorder) {
		try {
			addonorderserv.addOnsEntry(addonsorder);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}

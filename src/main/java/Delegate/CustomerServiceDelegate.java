package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.Customer;

import services.CustomerServiceRemote;

public class CustomerServiceDelegate {
private static final String jndiName ="petroFactory-ejb/CustomerService!services.CustomerServiceRemote";
	
	private static CustomerServiceRemote getProxy(){
		return (CustomerServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static List<Customer> findAllCostumers(){
		return getProxy().findAllCustomers();
	}
	public static List<Customer> filterUsersByName(String name)
	{
		return getProxy().filterCustomerByName(name);
	}
}

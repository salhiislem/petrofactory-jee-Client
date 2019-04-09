package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.Employee;
import services.EmployeeServiceRemote;
import services.UserServiceRemote;
import utils.Role;

public class EmployeeServiceDelegate {
private static final String jndiName ="petroFactory-ejb/EmployeeService!services.EmployeeServiceRemote";
	
	private static EmployeeServiceRemote getProxy(){
		return (EmployeeServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static List<Employee> findAllEmployees(){
		return getProxy().findAllEmployees();
	}
	public static List<Employee> filterEmployeesByName(String name)
	{
		return getProxy().filterEmployeesByName(name);
	}
	public List<Employee> filterEmployeesByrole(Role role)
	{
		return getProxy().filterEmployeesByrole(role);
	}
	public static List<Employee> filterUsersByNameANDrole(String name, Role role)
	{
		return getProxy().filterEmployeesByName(name);
	}
	public static void updateEmployee(Employee emp){
		getProxy().updateEmployee(emp);
	}
}

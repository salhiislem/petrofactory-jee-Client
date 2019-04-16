package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Employee;
import services.EmployeeServiceRemote;
import services.SkillsServiceRemote;
import utils.Role;




public class EmployeeService {
	public static void main(String[] args)throws NamingException{
		String jndiName="petroFactory-ejb/EmployeeService!services.EmployeeServiceRemote";
		Context context=new InitialContext();
		EmployeeServiceRemote proxy=(EmployeeServiceRemote) context.lookup(jndiName);
		//User u= new User("firstname","lastname","username","123","islem.salhi@esprit.tn","53070799","blabla");
		//proxy.createUser(u);
		//boolean b=proxy.activateAccount("0ab66fcd8117c12dd17a2ae08726d540");
		//System.out.println(b);
		
		//proxy.deleteUser(proxy.findUserById(1).getId());
	//User user=proxy.findByMail("islem.salhi@esprit.tn");
		//System.out.println(user.getFirstname());
		//proxy.deleteUser(1);
		//List<Employee> users=proxy.findAllEmployees();
		//for (Employee us: users){System.out.println(us.getEmployeeRole());}
		
		//List<Employee> users=proxy.filterEmployeesByNameANDrole("outay", Role.Manager);
		//for (Employee us: users)
		//{System.out.println(us.getFirstname());}
		//User us=proxy.loginUser("username", "123");
		//System.out.println(us.getFirstname());
		//User u1=new User(4);
		//boolean b=proxy.changePwd(u1, "123", "1234");
		//System.out.println(b);4
		
	}}

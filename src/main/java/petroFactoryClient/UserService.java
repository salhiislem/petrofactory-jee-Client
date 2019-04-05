package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.UserServiceRemote;


public class UserService {
	public static void main(String[] args)throws NamingException{
		String jndiName="petroFactory-ejb/UserService!services.UserServiceRemote";
		Context context=new InitialContext();
		UserServiceRemote proxy=(UserServiceRemote) context.lookup(jndiName);
		User u= new User("firstname","lastname","username","123","islem.salhi@esprit.tn","53070799","blabla");
		//proxy.createUser(u);
		//boolean b=proxy.activateAccount("0ab66fcd8117c12dd17a2ae08726d540");
		//System.out.println(b);
		
		//proxy.deleteUser(proxy.findUserById(1).getId());
	//User user=proxy.findByMail("islem.salhi@esprit.tn");
		//System.out.println(user.getFirstname());
		//proxy.deleteUser(1);
		List<User> users=proxy.filterUsersByName("out");

		System.out.println(users.size());
		for (User us: users){
			System.out.println(us.getUsername());}
		//User us=proxy.loginUser("username", "123");
		//System.out.println(us.getFirstname());
		//User u1=new User(4);
		//boolean b=proxy.changePwd(u1, "123", "1234");
		//System.out.println(b);
	}
}

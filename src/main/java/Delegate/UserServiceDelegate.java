package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.User;
import services.UserServiceRemote;

public class UserServiceDelegate {
	private static final String jndiName ="petroFactory-ejb/UserService!services.UserServiceRemote";
	
	private static UserServiceRemote getProxy(){
		return (UserServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	
	public static void createUser(User user) {
		getProxy().createUser(user);
	}
	
	public static boolean activateAccount(String confirmationToken) {
		return getProxy().activateAccount(confirmationToken);
	}
	
	public static User findUserById(int id){
		return getProxy().findUserById(id);
	}
	
	public static List<User> findAllUsers(){
		return getProxy().findAllUsers();
	}
	
	public static void updateUser(User user){
		getProxy().updateUser(user);
	}
	
	public static void deleteUser(int id){
		getProxy().deleteUser(id);
	}
	
	public static User loginUser(String username, String pwd){
		return getProxy().loginUser(username,pwd);
	}
	public static boolean changePwd(User user, String oldPwd, String newPwd)
	{
		return getProxy().changePwd(user, oldPwd, newPwd);
	}
	public static User findByMail(String mail)
	{
		return getProxy().findByMail(mail);
	}
	public static List<User> filterUsersByName(String name)
	{
		return getProxy().filterUsersByName(name);
	}
}

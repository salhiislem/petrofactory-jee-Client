package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.User;
import utils.Emailer;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.twilio.type.PhoneNumber;

import Delegate.UserServiceDelegate;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class CodeController implements Initializable {
	@FXML
	private TextField mailid;
	@FXML
	private Button btnid;
	@FXML
	private Label remarque;
	 public String mesg,email,code;
	 Stage stage= new Stage();
	    Scene scene;
	 public void setEmail(String email) {
	        this.email = email;
	    }
	 
	  public void setCode(String code) {
	        this.code = code;
	        System.out.println("====>"+code);
	    }
	// Event Listener on Button[#btnid].onAction
	@FXML
	public void SendMail(ActionEvent event) throws IOException {
		 System.out.println(this.code);

	        if( mailid.getText().equals(this.code)    )
	        {
	            
	        	UserServiceDelegate UD=new UserServiceDelegate();
	        	User u=UD.findByMail(this.email);
	        	String y = getSaltString();
	        	 System.out.println(y);
	        	
		          System.out.println();

	          mesg="Your username: "+u.getUsername()+"\n"+"Your password:"+u.getPassword() ;
	          System.out.println(u.getUsername());
	          Emailer um=new Emailer();
	          um.SendEmail(this.email, "Password recovery", mesg);
	       		
	       			Parent root = FXMLLoader.load(getClass().getResource("Log.fxml"));
	       			Scene scene = new Scene(root);
	       	          Node node =(Node)event.getSource();
	       	             stage = (Stage)node.getScene().getWindow();
	       	             stage.close();
	       	             
	       	  
	       	         stage.setScene(scene);
	       	         stage.show();
	       	         stage.setResizable(false);	
	      
	        }
	        else 
	        { 
	        	remarque.setText("Code Invalide");
	        	}	
	        }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	protected String getSaltString() {
	     String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	     StringBuilder salt = new StringBuilder();
	     Random rnd = new Random();
	     while (salt.length() < 5) { // length of the random string.
	         int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	         salt.append(SALTCHARS.charAt(index));
	     }
	     String saltStr = salt.toString();
	     return saltStr;

	 }
}

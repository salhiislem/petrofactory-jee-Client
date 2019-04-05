package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import Delegate.UserServiceDelegate;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistence.User;

public class LogController {
	@FXML
	private ImageView back;
	@FXML
	private Button btn_login;
	@FXML
	private Label verif;
	@FXML
	private Button forgotten;
	@FXML
	private TextField username;
	@FXML
	private PasswordField pwd;
	@FXML
	private ImageView imageview;
	@FXML
	private Button btn_signup;
	Stage stage= new Stage();
    Scene scene;
	// Event Listener on Button[#btn_login].onMouseClicked
	@FXML
	public void btn_login_signal(MouseEvent event) throws IOException {
		
		UserServiceDelegate us=new UserServiceDelegate();
		User user=us.loginUser(username.getText(),pwd.getText());
		System.out.println(user.getFirstname());
		Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
		Scene scene = new Scene(root);
          Node node =(Node)event.getSource();
             stage = (Stage)node.getScene().getWindow();
             stage.close();
             
  
         stage.setScene(scene);
         stage.show();
         stage.setResizable(false);	
	}
	// Event Listener on Button[#forgotten].onAction
	@FXML
	public void forgotten_signal(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ForgotPass.fxml"));
		Scene scene = new Scene(root);
          Node node =(Node)event.getSource();
             stage = (Stage)node.getScene().getWindow();
             stage.close();
             
  
         stage.setScene(scene);
         stage.show();
         stage.setResizable(false);	}
	// Event Listener on Button[#btn_signup].onAction
	@FXML
	public void btn_signup_signal(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		Scene scene = new Scene(root);
          Node node =(Node)event.getSource();
             stage = (Stage)node.getScene().getWindow();
             stage.close();
             
  
         stage.setScene(scene);
         stage.show();
         stage.setResizable(false);		}
}

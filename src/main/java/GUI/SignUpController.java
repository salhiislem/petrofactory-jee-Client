package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.User;
import utils.Gender;

import java.io.IOException;

import Delegate.UserServiceDelegate;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

import javafx.scene.control.CheckBox;

import javafx.scene.control.DatePicker;

public class SignUpController {
	@FXML
	private TextField email;
	@FXML
	private TextField lastname;
	@FXML
	private TextField username;
	@FXML
	private TextField firstname;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField repeat_password;
	@FXML
	private DatePicker birthday;
	@FXML
	private CheckBox terms;
	@FXML
	private Label erreur;
	@FXML
	private TextField numTel;
	@FXML
	private TextField address;
	@FXML
	private CheckBox female;
	@FXML
	private CheckBox male;
	@FXML
	private Button reset;
	@FXML
	private Button ajouter;

	// Event Listener on Button[#reset].onAction
	@FXML
	public void ResetAll(ActionEvent event) {
		// TODO Autogenerated
	}
	Stage stage= new Stage();
    Scene scene;
	// Event Listener on Button[#ajouter].onAction
	@FXML
	public void ajouter_utilisateur(ActionEvent event) throws IOException {
		 if (!terms.isSelected()){
			 Parent root = FXMLLoader.load(getClass().getResource("Term.fxml"));
	           
	            Scene sc = new Scene(root);
	            Stage stage=  new Stage();
	            stage.setScene(sc);
	            stage.show();
	            terms.setSelected(true);
		        }
		
		 else if(!password.getText().equals(repeat_password.getText()))
		{
			erreur.setText("Check your password!");
		}
		else
		{UserServiceDelegate us=new UserServiceDelegate();
			User user=new User(firstname.getText(),lastname.getText(), java.sql.Date.valueOf(birthday.getValue()),username.getText(),password.getText(),email.getText(),numTel.getText(),address.getText());
			if(female.isSelected()){
				user.setGender(Gender.FEMALE);
				
			}else if(male.isSelected()){
				user.setGender(Gender.MALE);
			}
			us.createUser(user);
			Parent root = FXMLLoader.load(getClass().getResource("Log.fxml"));
			Scene scene = new Scene(root);
	          Node node =(Node)event.getSource();
	             stage = (Stage)node.getScene().getWindow();
	             stage.close();
	             
	  
	         stage.setScene(scene);
	         stage.show();
	         stage.setResizable(false);
		}
	}
}

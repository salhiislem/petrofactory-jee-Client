package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.User;

import java.io.IOException;

import Delegate.UserServiceDelegate;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ConfirmationTokenController {
	@FXML
	private TextField confirmationT;
	@FXML
	private Button btnid;
	@FXML
	private Label remarque;
	 public User user;
	 Stage stage= new Stage();
	    Scene scene;
	
	// Event Listener on Button[#btnid].onAction
	public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	@FXML
	public void activeAccount(ActionEvent event) throws IOException {

	UserServiceDelegate UD=new UserServiceDelegate();
    boolean b=UD.activateAccount(confirmationT.getText());
    if (b)
    {
		
    	Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
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

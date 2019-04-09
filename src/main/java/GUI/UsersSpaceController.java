package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

public class UsersSpaceController {
	@FXML
	private AnchorPane holderPane;
	@FXML
	private JFXButton btnWork1;
	@FXML
	private JFXButton btnWork2;
	@FXML
	private JFXButton btnWork4;

	// Event Listener on JFXButton[#btnWork1].onAction
	@FXML
	public void switchEmployees(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("employeesList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	}
	// Event Listener on JFXButton[#btnWork2].onAction
	@FXML
	public void switchCustomers(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomersList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	}
	// Event Listener on JFXButton[#btnWork4].onAction
	@FXML
	public void switchAllUsers(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UsersList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	}
}

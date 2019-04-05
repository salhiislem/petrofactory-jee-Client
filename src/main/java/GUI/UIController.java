package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class UIController implements Initializable{
	@FXML
	private Button btnHome;
	@FXML
	private Button btnStations;
	@FXML
	private Button btnJobRequest;
	@FXML
	private Button btnTrucks;
	@FXML
	private Button btnFuel;
	@FXML
	private Button btnUsers;
	@FXML
	private Button btnExit;
	@FXML
	private AnchorPane holderPane;
	
    AnchorPane Home, Stations, Users, Fuel, Trucks, JobRequests;

    public static AnchorPane rootP;

    public void initialize(URL url, ResourceBundle rb) {
        rootP = holderPane;
    }
    public static void setNode(Node node) {
        rootP.getChildren().clear();
        rootP.getChildren().add(node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
	
	// Event Listener on Button[#btnHome].onAction
	@FXML
	public void switchHome(ActionEvent event) throws IOException {
		 Home = FXMLLoader.load(getClass().getResource("Home.fxml"));
	        setNode(Home);
	}
	// Event Listener on Button[#btnStations].onAction
	@FXML
	public void switchSTATIONS(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnJobRequest].onAction
	@FXML
	public void switchJobRequest(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnTrucks].onAction
	@FXML
	public void switchTrucks(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnFuel].onAction
	@FXML
	public void switchFuel(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnUsers].onAction
	@FXML
	public void switchUsers(ActionEvent event) throws IOException {
		 Users = FXMLLoader.load(getClass().getResource("UsersList.fxml"));
	        setNode(Users);	}
	// Event Listener on Button[#btnExit].onAction
	@FXML
	public void exit(ActionEvent event) {
		// TODO Autogenerated
	}
}

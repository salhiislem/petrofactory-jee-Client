package esprit.petrofactory.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXManagmentController implements Initializable{
	@FXML
	private Button bnt1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn;
	// Event Listener on Button[#bnt1].onMouseClicked
	@FXML
	public void Gaspump(MouseEvent event) {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXFuel.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             bnt1.getScene().setRoot(root);
             
         } catch (IOException ex) {
            
         System.out.println("error");
         }	}
	// Event Listener on Button[#btn2].onMouseClicked
	@FXML
	public void Pumpmeter(MouseEvent event) {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXPumpMeter.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             btn2.getScene().setRoot(root);
             
         } catch (IOException ex) {
            
         System.out.println("error");
         }	
	}
	// Event Listener on Button[#btn3].onMouseClicked
	@FXML
	public void Fuelorder(MouseEvent event) {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXService.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             btn3.getScene().setRoot(root);
             
         } catch (IOException ex) {
            
         System.out.println("error");
         }	
	}
	// Event Listener on Button[#btn4].onMouseClicked
	@FXML
	public void report(MouseEvent event) {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXReport.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             bnt1.getScene().setRoot(root);
             
         } catch (IOException ex) {
             
         System.out.println("error");
         	}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Image img = new Image("./esprit/petrofactory/interfaces/madrid.jpg.jpg");
		
	}
	@FXML
	public void mail(MouseEvent event) {
		SendingMailPP sm=new SendingMailPP("tsssssssssssss", "mohamedamine.khemiri@esprit.tn", "Rappel");
		SendingMailPP.envoyer();
	}
}

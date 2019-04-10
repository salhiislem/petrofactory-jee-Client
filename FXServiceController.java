package esprit.petrofactory.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.services.FuelServiceRemote;

public class FXServiceController implements Initializable
{
	@FXML
	private ComboBox <String> cb ;
	@FXML
	private TextField tf_qtt;
	@FXML
	private Label lab;
	@FXML
	private Label lab1;
	@FXML
	private Button btn1;
	@FXML
	private Button btn_rtr;

	// Event Listener on Button[#btn1].onMouseClicked
	@FXML
	public void total(MouseEvent event) throws NamingException {
		try {
			
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<String> tp = FXCollections.observableArrayList(proxy.tpm());
	    	 cb.setItems(tp);
	    	 String t = cb.getSelectionModel().getSelectedItem();
	    	 Float qtt = Float.parseFloat(tf_qtt.getText());
	    	 
	    	 
	    	 
	    	 //*********** Mise à jour système *******************//
	    	 
	    	 int s = proxy.Show(t);
	    	 Float f= proxy.Amount(s);
	    	 Float y = f-qtt;
	    	 if(y<0){
	    		 Alert alert = new Alert(AlertType.ERROR);
	    		   	alert.setTitle("Error");
	    		   	alert.setHeaderText(null);
	    		   	alert.setContentText("Insufficient fuel !");
	    		   	alert.showAndWait(); 
	    	 }
	    	 else{
	    	 Float am = proxy.AmountSold(t);
	    	 Float tt = am*qtt;	    	 
	    	 String a ="";
	    	 a+=tt;
	    	 lab.setText(a);
	    	 proxy.updateSystem(y, s);}
		}catch(Exception e){			}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<String> tp = FXCollections.observableArrayList(proxy.tpm());
	    	 cb.setItems(tp);
	    	 
		}catch(Exception e){		
		}
		
	}
	
	@FXML
	public void Retour(MouseEvent event) throws NamingException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXManagment.fxml"));
        Parent root;
        try {
            root = loader.load();
            
            btn_rtr.getScene().setRoot(root);
            
        } catch (IOException ex) {
           
        System.out.println("error");
        }	
	}
}

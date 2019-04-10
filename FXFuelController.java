package esprit.petrofactory.interfaces;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tn.esprit.petroFact.entity.Fuel;
import tn.esprit.petroFact.entity.Report;
import tn.esprit.petroFact.services.FuelServiceRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXFuelController implements Initializable{
	@FXML
	private TableView<Fuel> tab_fuel;
	@FXML
	private TableColumn<Fuel, String> id_type;
	@FXML
	private TableColumn<Fuel, Float> id_amount;
	@FXML
	private TableColumn<Fuel, Float> id_price;
	@FXML
	private Button del_F;
	@FXML
	private Button add_F;
	@FXML
	private TextField tf_price;
	@FXML
	private TextField tf_type;
	@FXML
	private TextField tf_amount;
	@FXML
	private Button btn_rtr;
	@FXML
	private Label lb ;
	// Event Listener on Button[#del_F].onMouseClicked
	@FXML
	public void delete(MouseEvent event) throws NamingException {
		
		InitialContext ic;
	   	 ic = new InitialContext();
	   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
	   	Fuel productselected = tab_fuel.getSelectionModel().getSelectedItem();
	        proxy.deleteFuel(productselected.getIdFuel());
	        ArrayList<Fuel> fuels = (ArrayList<Fuel>) proxy.fuels();
	            ObservableList obs= FXCollections.observableArrayList(fuels);
	            tab_fuel.setItems(obs);
	            id_type.setCellValueFactory(new PropertyValueFactory<Fuel, String>("type"));
				 id_amount.setCellValueFactory(new PropertyValueFactory<Fuel, Float>("amount"));
				 id_price.setCellValueFactory(new PropertyValueFactory<Fuel, Float>("price"));
				 fuels.clear();
				 Alert alert = new Alert(AlertType.INFORMATION);
				   	alert.setTitle("Success");
				   	alert.setHeaderText(null);
				   	alert.setContentText("Pumpman affected !");
				
	}
	// Event Listener on Button[#add_F].onMouseClicked
	@FXML
	public void add(MouseEvent event) throws NamingException, ParseException {
		Fuel g=null;
		g = new Fuel(tf_type.getText(),Float.parseFloat(tf_price.getText()),Float.parseFloat(tf_amount.getText()));
		
		if(tf_type.getText().length()==0 ){
			Alert alert = new Alert(AlertType.ERROR);
		   	alert.setTitle("Warning");
		   	alert.setHeaderText(null);
		   	alert.setContentText("please complete all fields!");
   	 }else
		try {
			
    	 InitialContext ic;
    	 ic = new InitialContext();
    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
    	 
    	 proxy.ajouterFuel(g);
    	 Alert alert = new Alert(AlertType.INFORMATION);
 	   	alert.setTitle("Success");
 	   	alert.setHeaderText(null);
 	   	alert.setContentText("Fuel added !");
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXFuel.fxml"));
         Parent root;
         
             root = loader.load();
             
             add_F.getScene().setRoot(root);
             
         } catch (IOException ex) {
            
         System.out.println("error");
         }	
 	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<Fuel> data= FXCollections.observableArrayList(proxy.fuels());
	    	 tab_fuel.setItems(data);
			 id_type.setCellValueFactory(new PropertyValueFactory<Fuel, String>("type"));
			 id_amount.setCellValueFactory(new PropertyValueFactory<Fuel, Float>("Amount"));
			 id_price.setCellValueFactory(new PropertyValueFactory<Fuel, Float>("price"));
	     }catch (Exception ex) {
	         System.out.println("exception");
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

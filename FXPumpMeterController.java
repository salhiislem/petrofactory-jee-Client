package esprit.petrofactory.interfaces;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.entity.Pumpman;
import tn.esprit.petroFact.entity.Report;
import tn.esprit.petroFact.services.FuelServiceRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXPumpMeterController implements Initializable {
	@FXML
	private TableView<PumpMeter> tab_pump;
	@FXML
	private TableColumn<PumpMeter, Integer> id_num;
	@FXML
	private TableColumn<PumpMeter, String> id_type;
	@FXML
	private TableColumn<PumpMeter, Float> id_price;
	@FXML
	private Button delete;
	@FXML
	private Button btn_rtr;
	
	@FXML
	private TextField tf_num;
	@FXML
	private TextField tf_type;
	@FXML
	private TextField tf_price;
	@FXML
	private Button btn_add;
	@FXML
	private ComboBox<String> cb;
	@FXML
	private ComboBox<Pumpman> cb1;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	public void changeTypePmCellEvent(TableColumn.CellEditEvent edditedCell) throws NamingException {
		PumpMeter discussionselected =(PumpMeter) tab_pump.getSelectionModel().getSelectedItem();   
	    	  Context ic = new InitialContext();
		 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	     discussionselected.setType(edditedCell.getNewValue().toString());
	     proxy.updateTypePm( discussionselected.getType(),discussionselected.getIdPM());
		}

	// Event Listener on Button[#delete].onMouseClicked
	@FXML
	public void del_pump(MouseEvent event) throws NamingException {
		
		InitialContext ic;
	   	 ic = new InitialContext();
	   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
	   	PumpMeter productselected = tab_pump.getSelectionModel().getSelectedItem();
	        proxy.deletePump(productselected.getIdPM());
	        ArrayList<PumpMeter> discussions = (ArrayList<PumpMeter>) proxy.pms();
	            ObservableList obs= FXCollections.observableArrayList(discussions);
	            tab_pump.setItems(obs);
	            id_num.setCellValueFactory(new PropertyValueFactory<PumpMeter, Integer>("num"));
	            id_type.setCellValueFactory(new PropertyValueFactory<PumpMeter, String>("type"));
				 id_price.setCellValueFactory(new PropertyValueFactory<PumpMeter, Float>("amountSold"));
		
	}
	// Event Listener on Button[#btn_add].onMouseClicked
	@FXML
	public void add_pump(MouseEvent event) throws NamingException {
		PumpMeter g=null;
		try {
			g = new PumpMeter(Integer.parseInt(tf_num.getText()),tf_type.getText(),Float.parseFloat(tf_price.getText()));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}
    	 InitialContext ic;
    	 ic = new InitialContext();
    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
    	 proxy.ajouterPump(g);
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXPumpMeter.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             btn_add.getScene().setRoot(root);
             
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
	    	 
	    	 ObservableList<PumpMeter> data= FXCollections.observableArrayList(proxy.pms());
	    	 
	    	 tab_pump.setItems(data);
	    	 id_num.setCellValueFactory(new PropertyValueFactory<PumpMeter, Integer>("num"));
			 id_type.setCellValueFactory(new PropertyValueFactory<PumpMeter, String>("type"));
			 id_price.setCellValueFactory(new PropertyValueFactory<PumpMeter, Float>("amountSold"));
			
			 tab_pump.setEditable(true);
		     id_type.setCellFactory(TextFieldTableCell.forTableColumn());
		     ObservableList<String> list = FXCollections.observableArrayList(proxy.typeGas());
	    	 
			 cb.setItems(list);
			ObservableList<Pumpman> list1 = FXCollections.observableArrayList(proxy.mans());
			 cb1.setItems(list1);
	     }catch (Exception ex) {
	         System.out.println("exception");
	     }
	}
	@FXML
	public void affecter(MouseEvent event) {
		PumpMeter productselected = tab_pump.getSelectionModel().getSelectedItem();
		Integer i = productselected.getIdPM();
	}
	// Event Listener on Button[#btn4].onMouseClicked
	@FXML
	public void Done(MouseEvent event) throws NamingException {

		InitialContext ic;
	   	 ic = new InitialContext();
	   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
	   	PumpMeter productselected = tab_pump.getSelectionModel().getSelectedItem();
	   	String s = productselected.getType();
	   	Integer i = productselected.getIdPM();
	   	 String prod = cb.getSelectionModel().getSelectedItem();
	   	 Integer j =proxy.GetIdG(prod);
	   	 if(prod.equals(s)){
	   	proxy.affecterPm(i, j);
	   	Alert alert = new Alert(AlertType.INFORMATION);
	   	alert.setTitle("Success");
	   	alert.setHeaderText(null);
	   	alert.setContentText("GasPump affected !");

	   	alert.showAndWait();
	   	 }
	   	 else{
	   		Alert alert = new Alert(AlertType.ERROR);
	   		alert.setTitle("Error");
	   		alert.setHeaderText("Warning");
	   		alert.setContentText("Incompatible Type!");
	   		alert.showAndWait();
	   	 }
	   		 
	}
	@FXML
	public void affecter1(MouseEvent event) {
		PumpMeter productselected = tab_pump.getSelectionModel().getSelectedItem();
		Integer i = productselected.getIdPM();
	}
	// Event Listener on Button[#btn4].onMouseClicked
	@FXML
	public void Done1(MouseEvent event) throws NamingException {

		InitialContext ic;
	   	 ic = new InitialContext();
	   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
	   	PumpMeter productselected = tab_pump.getSelectionModel().getSelectedItem();
	   	Integer i = productselected.getIdPM();
	   	 Pumpman prod = cb1.getSelectionModel().getSelectedItem();
	   	 Integer j = prod.getId();
	   	proxy.affecterPmToPm(i, j);
	   	Alert alert = new Alert(AlertType.INFORMATION);
	   	alert.setTitle("Success");
	   	alert.setHeaderText(null);
	   	alert.setContentText("Pumpman affected !");

	   	alert.showAndWait();
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
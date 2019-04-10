package esprit.petrofactory.interfaces;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.entity.Pumpman;
import tn.esprit.petroFact.entity.Report;
import tn.esprit.petroFact.services.FuelServiceRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXReportController implements Initializable{
	
	@FXML
	private DatePicker tf_date;
	@FXML
	private TextField tf_type;
	@FXML
	private TextField tf_ppm;
	@FXML
	private TextField tf_ia;
	@FXML
	private TextField tf_s;
	@FXML
	private TextField tf_fa;
	@FXML
	private TextField tf_gain;
	@FXML
	private Button btn_add;
	@FXML
	private Button btn_s;
	@FXML
	private Button btn_sort;
	@FXML
	private Button btn_rtr;
	@FXML
	private TableView<Report> tab_rep;
	@FXML
	private TableColumn <Report, String>id_type;
	@FXML
	private TableColumn <Report, Float>id_ia;
	@FXML
	private TableColumn <Report, Float>id_fa;
	@FXML
	private TableColumn <Report, Double>id_gain;
	@FXML
	private TableColumn <Report, Date>id_date;
	@FXML
	private ComboBox<PumpMeter> cb;

	
	
	// Event Listener on TableColumn[#id_type].onEditCommit
		@FXML
		public void changeTypeCellEvent(TableColumn.CellEditEvent edditedCell) throws NamingException {
			
			     Report discussionselected =(Report) tab_rep.getSelectionModel().getSelectedItem();
			   
			    	 Context ic;
			     
				 ic = new InitialContext();
				 FuelServiceRemote proxy=
						 (FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
			     discussionselected.setType(edditedCell.getNewValue().toString());
			     proxy.updateType( discussionselected.getType(),discussionselected.getIdR());
			    
				}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=
	    			 (FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<Report> data= FXCollections.observableArrayList(proxy.reports());
	    	 tab_rep.setItems(data);
			 id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
		     
		     tab_rep.setEditable(true);
		     id_type.setCellFactory(TextFieldTableCell.forTableColumn());
		     
	     }catch (Exception ex) {
	         System.out.println("exception");
	     }}	
	// Event Listener on Button[#btn_add].onMouseClicked
	@FXML
	public void add_rep(MouseEvent event) throws NamingException, ParseException {
		
		 Date dateI = new Date( System.currentTimeMillis() );
		 Date dat=java.sql.Date.valueOf(tf_date.getValue());
		        {
		
		Report	g = new Report(Date.from(tf_date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
				tf_type.getText(),Float.parseFloat(tf_ia.getText()),Float.parseFloat(tf_fa.getText()),
				Double.parseDouble(tf_gain.getText()));
		
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
   	 	if(dat.compareTo(dateI)<=0){
   	 	Alert alert = new Alert(AlertType.ERROR);
	   	alert.setTitle("Error");
	   	alert.setHeaderText(null);
	   	alert.setContentText("Invalid Date !");
	   	alert.showAndWait();
   	 	}
   	 	else if(tf_date.getValue().isEqual(null) || tf_type.getText().equals(null) || tf_ia.getText().equals(null) || tf_fa.getText().equals(null) || tf_gain.getText().equals(null)){
   	 	Alert alert = new Alert(AlertType.ERROR);
	   	alert.setTitle("Error");
	   	alert.setHeaderText(null);
	   	alert.setContentText("please complete all fields !");
	   	alert.showAndWait();
   	 		
   	 	}
   	 	else{
		try {
			InitialContext ic;
		   	 ic = new InitialContext();
		   	FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");
			proxy.ajouterRep(g);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}}
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXReport.fxml"));
         Parent root;
         try {
             root = loader.load();
             
             btn_add.getScene().setRoot(root);
             
         } catch (IOException ex) {
            
         System.out.println("error");
         }	
         }
	}
	


	// Event Listener on Button[#btn_del].onMouseClicked
	@FXML
	public void del_rep(MouseEvent event) throws NamingException {
		InitialContext ic;
   	 ic = new InitialContext();
   	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
        Report productselected = tab_rep.getSelectionModel().getSelectedItem();
        proxy.deleteRep(productselected.getIdR());
        ArrayList<Report> discussions = (ArrayList<Report>) proxy.reports();
            ObservableList obs= FXCollections.observableArrayList(discussions);
            tab_rep.setItems(obs);
            id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
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
	
	public void SortedByDate(MouseEvent event){
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=
	    			 (FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<Report> data= FXCollections.observableArrayList(proxy.reportsByDate());
	    	 tab_rep.setItems(data);
			 id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
		     
		     tab_rep.setEditable(true);
		     id_type.setCellFactory(TextFieldTableCell.forTableColumn());
	}catch (Exception ex) {
        System.out.println("exception");
    }
	}
	
	@FXML
	public void Search(MouseEvent event) throws NamingException {
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 String s = tf_s.getText();
	    	 FuelServiceRemote proxy=
	    			 (FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<Report> data= FXCollections.observableArrayList(proxy.ReportByType(s));
	    	 tab_rep.setItems(data);
			 id_type.setCellValueFactory(new PropertyValueFactory<Report, String>("type"));
			 id_ia.setCellValueFactory(new PropertyValueFactory<Report, Float>("initialAmount"));
			 id_fa.setCellValueFactory(new PropertyValueFactory<Report, Float>("finalAmount"));
		     id_gain.setCellValueFactory(new PropertyValueFactory<Report, Double>("gain"));
		     id_date.setCellValueFactory(new PropertyValueFactory<Report, Date>("date"));
		     
		     tab_rep.setEditable(true);
		     id_type.setCellFactory(TextFieldTableCell.forTableColumn());
	}catch (Exception ex) {
       System.out.println("exception");
   }
	}
}

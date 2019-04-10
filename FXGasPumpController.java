package esprit.petrofactory.interfaces;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.services.FuelServiceRemote;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class FXGasPumpController implements Initializable{
	private TableView <GasPump> tab_gas;
	@FXML
	private TableColumn <GasPump, Integer>id_num;
	@FXML
	private TableColumn <GasPump, String>id_type;
	@FXML
	private TableColumn <GasPump, Float>id_amount;
	@FXML
	private Button btn_delGas;
	@FXML
	private Button btn_addGas;
	@FXML
	private TextField tf_num;
	@FXML
	private TextField tf_type;
	@FXML
	private TextField tf_amount;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		try {
	    	 Context ic;
	    	 ic = new InitialContext();
	    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote");	    	 
	    	 ObservableList<GasPump> data= FXCollections.observableArrayList(proxy.gaspumps());
	    	 tab_gas.setItems(data);
			 id_num.setCellValueFactory(new PropertyValueFactory<GasPump, Integer>("num"));
		     id_type.setCellValueFactory(new PropertyValueFactory<GasPump, String>("type"));
		     id_amount.setCellValueFactory(new PropertyValueFactory<GasPump, Float>("amount"));
		     ObservableList<String> d= FXCollections.observableArrayList(proxy.type());
		     
	     }catch (Exception ex) {
	         System.out.println("exception");
	     }

	}

    @FXML
    private void add (MouseEvent event) throws NamingException, NumberFormatException{
    	
    	 GasPump g= new GasPump(Integer.parseInt(tf_num.getText()),Float.parseFloat(tf_amount.getText()),tf_type.getText());
    	 InitialContext ic;
    	 ic = new InitialContext();
    	 FuelServiceRemote proxy=(FuelServiceRemote) ic.lookup("petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote"); 
    	 proxy.ajouterGas(g);
    	
    }
}
package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Delegate.CustomerServiceDelegate;
import Delegate.EmployeeServiceDelegate;
import Delegate.UserServiceDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;
import persistence.Employee;
import persistence.User;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class EmployeesListController implements Initializable {
	@FXML
	private AnchorPane holderPane;
	@FXML
	private TableView userTable;
	@FXML
	private TableColumn nom;
	@FXML
	private TableColumn prenom;
	@FXML
	private TableColumn rol;
	@FXML
	private TableColumn mail;
	@FXML
	private TableColumn address;
	@FXML
	private TableColumn tel;
	@FXML
	private TableColumn salary;
	@FXML
	private TableColumn Contrat;
	@FXML
	private TableColumn start;
	@FXML
	private TableColumn end;
	@FXML
	private TextField filterNom;
	@FXML
	private ComboBox filterRole;
	@FXML
	private Button export;
	@FXML
	private Label nbUsers;
	@FXML
	private Label users_affiche;
	@FXML
	private Label employeesnb;
	@FXML
	private Label employees;
	@FXML
	private Label customersnb;
	@FXML
	private Label customers;
	
	@FXML
	private Button delete;
	@FXML
	private Label screen;
	@FXML
	private Button filter;

	// Event Listener on Button[#export].onAction
	@FXML
	public void exportAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Label[#users_affiche].onMouseClicked
	@FXML
	public void users_affiche(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UsersList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }		}
	// Event Listener on Label[#employees].onMouseClicked
	@FXML
	public void Employees_affiche(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeesList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	
	}
	// Event Listener on Label[#customers].onMouseClicked
	@FXML
	public void customers_affiche(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Label[#joobreqnb].onMouseClicked
	@FXML
	public void managers_affiche(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#delete].onMouseClicked
	@FXML
	public void deleteUser(MouseEvent event) {
		 User a=(User) userTable.getSelectionModel().getSelectedItem();
	        if (a==null)
	        {
	            screen.setText("No selected Employee");
	        }
	        else
	        {UserServiceDelegate UD=new UserServiceDelegate();
	        UD.deleteUser(a.getId());
	           
	        userTable.getItems().remove(a);
	            screen.setText(" Employee deleted");
	            }	}
	// Event Listener on Button[#filter].onMouseClicked
	@FXML
	public void filter(MouseEvent event) {

	}
	private String roles[]={"PDG","Manager","Worker","Pumpman","Transporter","Customer"};
	public  void loadDemande(List<Employee> users) 
	{
	   
	                
		
	        
	            ObservableList obs= FXCollections.observableArrayList(users);
	            userTable.setItems(obs);
	               nom.setCellValueFactory(new PropertyValueFactory<>("firstname"));
	            prenom.setCellValueFactory(new PropertyValueFactory<>("lastname"));
	            rol.setCellValueFactory(new PropertyValueFactory<>("EmployeeRole")); 
	            mail.setCellValueFactory(new PropertyValueFactory<>("email"));
	            address.setCellValueFactory(new PropertyValueFactory<>("address"));
	            tel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
	            salary.setCellValueFactory(new PropertyValueFactory<>("salaire"));
	            Contrat.setCellValueFactory(new PropertyValueFactory<>("typeContrat"));
	            start.setCellValueFactory(new PropertyValueFactory<>("dateEmbauche"));
	            end.setCellValueFactory(new PropertyValueFactory<>("dateFinContrat"));
	          


	            userTable.setOnMouseReleased((MouseEvent event)->{
	         
	             User a=(User) userTable.getSelectionModel().getSelectedItem();
	             //System.out.println(a.getFirstname());
	                     });
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		filterRole.getItems().addAll(roles);
		//filterRole.getItems().setAll(Role.values());
		EmployeeServiceDelegate ED=new EmployeeServiceDelegate();
		UserServiceDelegate UD=new UserServiceDelegate();
		int nbusers= UD.findAllUsers().size();
		System.out.println(nbusers);
		nbUsers.setText(Integer.toString(nbusers));
		List<Employee> users= ED.findAllEmployees();
		loadDemande(users) ;	
		
		int n= ED.findAllEmployees().size();
		employeesnb.setText(Integer.toString(n));
		CustomerServiceDelegate CD=new CustomerServiceDelegate();
		int nc= CD.findAllCostumers().size();
		customersnb.setText(Integer.toString(nc));		
		
		
	}
	@FXML
	public void rechercheNom(MouseEvent event) {
		EmployeeServiceDelegate ED=new EmployeeServiceDelegate();
		if(filterNom.getText().equals(""))
		{
			screen.setText("No name selected for search");
		}
		else if(!filterNom.getText().equals("")){
			List<Employee> l=ED.filterEmployeesByName(filterNom.getText());
			System.out.println(filterNom.getText());
			loadDemande(l);
		}
	}
}

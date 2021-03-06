package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
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
import persistence.Customer;
import persistence.Employee;
import persistence.User;
import utils.AccountState;
import utils.Gender;
import utils.Role;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class UsersListController implements Initializable {
	@FXML
	private AnchorPane holderPane;
	@FXML
	private TableView userTable;
	@FXML
	private TableColumn nom;
	@FXML
	private TableColumn prenom;
	
	@FXML
	private TableColumn bd;
	@FXML
	private TableColumn gender;
	@FXML
	private TableColumn mail;
	
	@FXML
	private TableColumn address;
	@FXML
	private TableColumn tel;
	@FXML
	private TableColumn Acc;
	@FXML
	private TextField filterNom;
	@FXML
	private ComboBox filterRole;
	@FXML
	private Button export;
	@FXML
	private Button filter;
	@FXML
	private Button search;
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
	private Label screen;
	@FXML
	private Label customers;
	@FXML
	private Label managersnb;
	@FXML
	private Label managers;
	private String roles[]={"Employee","Customer"};
	
	public  void loadDemande(List<User> users) 
	{
	   
	                
	
	        
	            ObservableList obs= FXCollections.observableArrayList(users);
	            userTable.setItems(obs);
	               nom.setCellValueFactory(new PropertyValueFactory<>("firstname"));
	            prenom.setCellValueFactory(new PropertyValueFactory<>("lastname"));
	            bd.setCellValueFactory(new PropertyValueFactory<>("birthday")); 
	            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
	            address.setCellValueFactory(new PropertyValueFactory<>("address"));
	            tel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
	            mail.setCellValueFactory(new PropertyValueFactory<>("email"));
	            Acc.setCellValueFactory(new PropertyValueFactory<>("accountState"));
	           


	            userTable.setOnMouseReleased((MouseEvent event)->{
	         
	             User a=(User) userTable.getSelectionModel().getSelectedItem();
	             //System.out.println(a.getFirstname());
	                     });
	}
	@FXML
	public void filter(MouseEvent event) {
		UserServiceDelegate UD=new UserServiceDelegate();
		EmployeeServiceDelegate ED=new EmployeeServiceDelegate();
		CustomerServiceDelegate CD =new CustomerServiceDelegate();
		String a=roles[filterRole.getSelectionModel().getSelectedIndex()];
		if(filterNom.getText().equals("")&& a.equals(""))
		{
			screen.setText("No selected filter type");
		}
		else if ((!filterNom.getText().equals("") ) && a.equals("")){
			List<User> l=UD.filterUsersByName(filterNom.getText());
			System.out.println(filterNom.getText());
			loadDemande(l);
		}
		else if(filterNom.getText().equals("")&& (!a.equals("")))
		{
			if(a.equals("Employee")){
				FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeesList.fxml"));
		        try {
		            holderPane.getChildren().clear();
		            holderPane.getChildren().add(loader.load());
		        } catch (IOException ex) {
		            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
		        }
			}
			
			
			else if (a.equals("Customer")){
				
			}
		}
		
	}
	
	@FXML
	public void rechercheNom(MouseEvent event) {
		UserServiceDelegate UD=new UserServiceDelegate();
		if(filterNom.getText().equals(""))
		{
			screen.setText("No name selected for search");
		}
		else if(!filterNom.getText().equals("")){
			List<User> l=UD.filterUsersByName(filterNom.getText());
			System.out.println(filterNom.getText());
			loadDemande(l);
		}
	}
	
	
	
	// Event Listener on Button[#export].onAction
	
	
	
	@FXML
	public void exportAction(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	}
	// Event Listener on Label[#employees].onMouseClicked
	@FXML
	public void Employees_affiche(MouseEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("employeesList.fxml"));
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomersList.fxml"));
        try {
            holderPane.getChildren().clear();
            holderPane.getChildren().add(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
        }	}
	// Event Listener on Label[#managers].onMouseClicked
	@FXML
	public void managers_affiche(MouseEvent event) {
		// TODO Autogenerated
	}
	@FXML
	public void users_affiche(MouseEvent event) {
		UserServiceDelegate UD=new UserServiceDelegate();
		List<User> users= UD.findAllUsers();
		loadDemande(users) ;	
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		UserServiceDelegate UD=new UserServiceDelegate();
		filterRole.getItems().addAll(roles);
		//filterRole.getItems().setAll(Role.values());
		int nbusers= UD.findAllUsers().size();
		System.out.println(nbusers);
		nbUsers.setText(Integer.toString(nbusers));
		List<User> users= UD.findAllUsers();
		loadDemande(users) ;	
		EmployeeServiceDelegate ED=new EmployeeServiceDelegate();
		int n= ED.findAllEmployees().size();
		employeesnb.setText(Integer.toString(n));
		CustomerServiceDelegate CD=new CustomerServiceDelegate();
		int nc= CD.findAllCostumers().size();
		customersnb.setText(Integer.toString(nc));
	}
	@FXML
	public void deleteUser(MouseEvent event) {
		
        User a=(User) userTable.getSelectionModel().getSelectedItem();
        if (a==null)
        {
            screen.setText("No selected User");
        }
        else
        {UserServiceDelegate UD=new UserServiceDelegate();
        UD.deleteUser(a.getId());
           
        userTable.getItems().remove(a);
            screen.setText(" User deleted");
            }
	}
	
}

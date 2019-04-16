package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXRadioButton;

import Delegate.SkillsServiceDelegate;

public class ConditionToAcceptController {
	@FXML
	private Button accept;
	@FXML
	private AnchorPane holderPane;
	@FXML
	private JFXRadioButton experience;
	@FXML
	private ToggleGroup requests;
	@FXML
	private JFXRadioButton skil;

	// Event Listener on Button[#accept].onAction
	@FXML
	public void accepterCv(ActionEvent event) {

if(skil.isSelected())
{
	FXMLLoader loader = new FXMLLoader(getClass().getResource("adjustRequestBySkills.fxml"));
	  
    try {
        holderPane.getChildren().clear();
        holderPane.getChildren().add(loader.load());
      
  		
    } catch (IOException ex) {
        Logger.getLogger(ConditionToAcceptController.class.getName()).log(Level.SEVERE, null, ex);
    }	
	}
}
}

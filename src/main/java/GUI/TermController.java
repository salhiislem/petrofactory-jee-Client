package GUI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;

public class TermController implements Initializable {
	@FXML
	private TextArea txt;
	@FXML
	private CheckBox terms;
	@FXML
	private Button signupbtn;


    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
          try {
              FileReader reader = new FileReader("src\\main\\java\\GUI\\terms.txt");

            BufferedReader buffer = new BufferedReader(reader);
            String s;
            while((s=buffer.readLine())!=null)
            {
            txt.appendText(s + "\n");
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TermController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TermController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
	
	// Event Listener on Button[#signupbtn].onAction
	@FXML
	public void signUp(ActionEvent event) {

        if (!terms.isSelected()){
        	
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
  alert.setTitle("Information Dialog");
  alert.setHeaderText(null);
  alert.setContentText("You must accept terms of use before signing up");
  alert.show();
    }
    else {
        Node node =(Node)event.getSource();
            Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }	}
}

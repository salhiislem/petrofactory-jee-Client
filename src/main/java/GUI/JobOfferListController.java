package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import Delegate.JobOfferServiceDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.JobOffer;

public class JobOfferListController implements Initializable {
	@FXML
	private AnchorPane holderPane;
	@FXML
	private ListView ListView_Produits;
	Stage stage= new Stage();
    Scene scene;

	public Pane AddPane(List<JobOffer> ThreeProduct) {
		Pane pane = new Pane();
		pane.setStyle(" -fx-background-color: white");
		int k = 1;
		for (JobOffer p3 : ThreeProduct) {
			if (k == 1) {
				Pane pane2 = new Pane();
				pane2.setLayoutX(25);
				pane2.setLayoutY(50);
				pane2.setPrefWidth(pane2.getWidth() + 280);
				pane2.setPrefHeight(pane2.getHeight() + 200);

				// pane2.setStyle("-fx-background-radius: 50;");
				pane2.setStyle(
						" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

				JFXButton t1 = new JFXButton("View Applications");

				t1.setStyle("-fx-font-weight: bold; -fx-font-color: white;");

				HBox hb2 = new HBox(t1);

				hb2.setLayoutX(155);
				hb2.setLayoutY(170);

				hb2.setStyle("-fx-background-color:  #25a89f; ; -fx-background-radius:2cm;");
				pane2.getChildren().addAll(hb2);

				Text nomt = new Text("Position : ");
				Label nom = new Label(p3.getPosition());
				Text prixt = new Text("Minimum of experience years : ");
				Label prix = new Label(String.valueOf(p3.getMinimumExperience()) );
				nomt.setLayoutX(50);
				nomt.setLayoutY(160);
				nom.setLayoutX(120);
				nom.setLayoutY(145);
				prixt.setLayoutX(50);
				prixt.setLayoutY(180);
				prix.setLayoutX(270);
				prix.setLayoutY(165);
				nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				
				t1.setOnMouseClicked((MouseEvent event) -> {
					JobOffer.setJobchosen(p3.getId());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("JobRequestsList.fxml"));
					  
			        try {
			            holderPane.getChildren().clear();
			            holderPane.getChildren().add(loader.load());
			          
				  		
			        } catch (IOException ex) {
			            Logger.getLogger(JobOfferListController.class.getName()).log(Level.SEVERE, null, ex);
			        }	
			     

					

				});

				pane.getChildren().addAll(pane2, nomt, prixt, nom, prix);
			}
			///////////////////////////////////
			///////////////////////////////////
			///////////////////////////////////
			///////////////////////////////////
			///////////////////////////////////
			if (k == 2) {
				Pane pane2 = new Pane();
				pane2.setLayoutX(380);
				pane2.setLayoutY(50);
				pane2.setPrefWidth(pane2.getWidth() + 280);
				pane2.setPrefHeight(pane2.getHeight() + 200);
				// pane2.setStyle("-fx-background-radius: 50;");
				pane2.setStyle(
						" -fx-border-radius: 10 ;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

				JFXButton t1 = new JFXButton("View Applications");

				t1.setStyle("-fx-font-weight: bold; -fx-font-color: white;");

				HBox hb2 = new HBox(t1);

				hb2.setLayoutX(155);
				hb2.setLayoutY(170);

				hb2.setStyle("-fx-background-color:  #25a89f;  -fx-background-radius:2cm;");
				pane2.getChildren().addAll(hb2);
				Text nomt = new Text("Position : ");
				Label nom = new Label(p3.getPosition());
				Text prixt = new Text("Minimum of experience years : ");
				Label prix = new Label(String.valueOf(p3.getMinimumExperience()));
				nomt.setLayoutX(405);
				nomt.setLayoutY(160);
				nom.setLayoutX(475);
				nom.setLayoutY(145);
				prixt.setLayoutX(405);
				prixt.setLayoutY(180);
				prix.setLayoutX(630);
				prix.setLayoutY(165);
				nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				t1.setOnMouseClicked((MouseEvent event) -> {
					JobOffer.setJobchosen(p3.getId());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("JobRequestsList.fxml"));
					  
			        try {
			            holderPane.getChildren().clear();
			            holderPane.getChildren().add(loader.load());
			          
				  		
			        } catch (IOException ex) {
			            Logger.getLogger(JobOfferListController.class.getName()).log(Level.SEVERE, null, ex);
			        }	
			     

				});

				pane.getChildren().addAll(pane2, nomt, prixt, nom, prix);
			}
			if (k == 3) {
				Pane pane2 = new Pane();
				pane2.setLayoutX(750);
				pane2.setLayoutY(50);
				pane2.setPrefWidth(pane2.getWidth() + 280);
				pane2.setPrefHeight(pane2.getHeight() + 200);
				// pane2.setStyle("-fx-background-radius: 50;");
				pane2.setStyle(
						" -fx-border-radius: 10 ;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");

				JFXButton t1 = new JFXButton("View Applications");

				t1.setStyle("-fx-font-weight: bold; -fx-font-color: white;");

				HBox hb2 = new HBox(t1);

				hb2.setLayoutX(155);
				hb2.setLayoutY(170);

				hb2.setStyle("-fx-background-color:  #25a89f;  -fx-background-radius:2cm;");
				pane2.getChildren().addAll(hb2);
				Text nomt = new Text("Position : ");
				Label nom = new Label(p3.getPosition());
				Text prixt = new Text("Minimum of experience years : ");
				Label prix = new Label(String.valueOf(p3.getMinimumExperience()));
				nomt.setLayoutX(780);
				nomt.setLayoutY(160);
				nom.setLayoutX(850);
				nom.setLayoutY(145);
				prixt.setLayoutX(780);
				prixt.setLayoutY(180);
				prix.setLayoutX(1000);
				prix.setLayoutY(165);
				nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
				t1.setOnMouseClicked((MouseEvent event) -> {
					JobOffer.setJobchosen(p3.getId());
					FXMLLoader loader = new FXMLLoader(getClass().getResource("JobRequestsList.fxml"));
					  
			        try {
			            holderPane.getChildren().clear();
			            holderPane.getChildren().add(loader.load());
			          
				  		
			        } catch (IOException ex) {
			            Logger.getLogger(JobOfferListController.class.getName()).log(Level.SEVERE, null, ex);
			        }	
			     

				});

				pane.getChildren().addAll(pane2, nomt, prixt, nom, prix);
			}

			k++;

		}
		return pane;
	}


	
    public void getShowPane()
    {
        List <JobOffer> AllProducts  = new ArrayList();
        JobOfferServiceDelegate JD=new JobOfferServiceDelegate();
        List<JobOffer> l=JD.findAllOffers();
            for (JobOffer p:l)
        {
            AllProducts.add(p);
        }
              System.out.println(AllProducts); 
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <JobOffer> ThreeProducts= new ArrayList();
        for (JobOffer p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
            
                   if(j==AllProducts.size())
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                }
            
            
            }
            else
            {
                ThreeProducts.add(p);
                    i++;
                    j++;
                if((i%3==0)||(j==AllProducts.size()))
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
        }
       
         ObservableList<Pane> refresh = FXCollections.observableArrayList();  
       ListView_Produits.setItems(refresh);
       ListView_Produits.setItems(Panes);
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  ListView_Produits.setFocusTraversable( false );
          getShowPane();
     
	}
}

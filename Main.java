package esprit.petrofactory.interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static Stage stage=null;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("./FXFuel.fxml")); 
 	        Scene scene = new Scene(root);
 	       scene.getStylesheets().add("esprit/petrofactory/interfaces/Style.css");
	        primaryStage.setTitle("");
	        primaryStage.initStyle(StageStyle.TRANSPARENT);
	        primaryStage.setScene(scene);
	        stage=primaryStage;
	        primaryStage.show();
	        }}
package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ClientController {
	
	static int userid;

	public static void setUserId(int user_id) {
		userid = user_id;
		System.out.println("Welcome id " + userid);
	}

	public void logout() {
		//Exit JVM
		//System.exit(0);
		try {
			   AnchorPane root;
			   root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			   Scene scene = new Scene(root);   
			   scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			   Main.stage.setScene(scene);
			   Main.stage.setTitle("Login");
			  } catch (Exception e) {
			  System.out.println("Error occured while inflating view: " + e.getMessage());
			  }

	}


}

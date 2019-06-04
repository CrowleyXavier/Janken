package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	private static Stage stage;
	@Override
	public void start(Stage stage) {
		Main.stage=stage;
		changeView("Form.fxml");
		Main.stage.show();

/*		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Form.fxml"));
			Scene scene = new Scene(root,500,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	*/

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changeView(String fxml) {
		try {
			stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
			Main.stage.show();
		}catch(IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}

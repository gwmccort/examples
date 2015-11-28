package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX example that used fxml file to create gui.
 *
 * @author Glen
 *
 */
public class FxmlApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/* (non-Javadoc)
	 * Starts the JavaFX gui and reads fxml file
	 *
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FxmlExample.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("FXML Example");
		stage.setScene(scene);
		stage.show();
	}

}

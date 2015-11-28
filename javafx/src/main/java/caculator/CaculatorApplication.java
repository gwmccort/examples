package caculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CaculatorApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * (non-Javadoc) Starts the JavaFX gui and reads fxml file
	 *
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Caculator.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("FXML Example");
		stage.setScene(scene);
		stage.show();
	}

}

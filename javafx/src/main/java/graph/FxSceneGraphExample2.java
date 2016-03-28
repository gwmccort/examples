package graph;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxSceneGraphExample2 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Label
		Label label = new Label("A Label");
		// Create the Button
		Button button = new Button("A Button");

		// Create the VBox
		VBox root = new VBox();
		// Add the details to the VBox
		root.getChildren().addAll(label, button);
		// Set the vertical spacing between children to 10px
		root.setSpacing(10);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root,300,200);
		// Get the Hand cursor using its name
		Cursor cursor = Cursor.cursor("HAND");
		// Add the Cursor to the Scene
		scene.setCursor(cursor);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Cursor Example");
		// Display the Stage
		stage.show();
	}
}

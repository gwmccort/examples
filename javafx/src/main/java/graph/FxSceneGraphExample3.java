package graph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxSceneGraphExample3 extends Application
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
		// Create the TextField
		final TextField  text = new TextField("A TextField");

		// Add EventHandler to the Button
		button.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
            	text.requestFocus();
            }
        });

		// Create the VBox
		VBox root = new VBox();
		// Add the details to the VBox
		root.getChildren().addAll(label, button, text);
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

		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Focus Owner Example");
		// Display the Stage
		stage.show();
	}
}

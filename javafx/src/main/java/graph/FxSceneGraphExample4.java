package graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

public class FxSceneGraphExample4 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Creating a blue Rectangle
		Rectangle rectangle1 = new Rectangle(10, 10, 20, 20);
		rectangle1.setFill(Color.BLUE);

		// Createing a green Rectangle by usage of a RectangleBuilder
		Rectangle rectangle2 = RectangleBuilder.create()
			.x(100).y(10).width(20).height(20).fill(Color.GREEN).build();

		// Create the RectangleBuilder
		RectangleBuilder builder = RectangleBuilder.create()
			.width(20).height(20).fill(Color.RED);

		// Create two rectangles with the RectangleBuilder
		Rectangle rectangle3 = builder.x(180).y(40).build();
		Rectangle rectangle4 = builder.x(120).y(20).build();

		// Create the VBox by usage of a VBoxBuilder
		VBox root = VBoxBuilder.create().children(LabelBuilder.create()
			.text("A Scene Builder Example").build(),rectangle1,rectangle2,rectangle3,rectangle4).build();

		// Set the vertical spacing between children to 10px
		root.setSpacing(10);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene by usage of a SceneBuilder
		Scene scene = SceneBuilder.create().width(300).height(200).root(root).build();

		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Scene Builder Example");
		// Display the Stage
		stage.show();
	}
}

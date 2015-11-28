package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Button btn = new Button("click me");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("clicked button");
			}
		});

		StackPane pane = new StackPane();
		pane.getChildren().add(btn);
		Scene scene = new Scene(pane, 500, 300);
		stage.setScene(scene);
		stage.show();
	}

}

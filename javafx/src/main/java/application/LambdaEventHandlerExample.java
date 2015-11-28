package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LambdaEventHandlerExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Button btn = new Button("click me");
		btn.setOnAction(e -> System.out.println("click me pushed"));

		Button exitBtn = new Button("exit");
		exitBtn.setOnAction(e -> {
			System.out.println("exit pushed");
			System.exit(0);
		});

		VBox pane = new VBox();
//		pane.getChildren().add(btn);
//		pane.getChildren().add(exitBtn);
		pane.getChildren().addAll(btn, exitBtn);


		Scene scene = new Scene(pane, 500, 300);
		stage.setTitle("My Title");
		stage.setScene(scene);
		stage.show();
	}

}

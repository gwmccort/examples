package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for FxmlApplication, implements event handlers
 *
 * @author Glen
 *
 */
public class FxmlController {

	@FXML
	private Label randLable;

	/**
	 * Print out message when button is clicked.
	 */
	public void clicked() {
		System.out.println("button clicked");
	}

	/**
	 * Generate a random number between 1-50, assign to label and print out.
	 *
	 * @param event
	 */
	public void generateRanom(ActionEvent event) {
		Random r = new Random();
		int myRand = r.nextInt(50) + 1;
		randLable.setText(Integer.toString(myRand));
		System.out.println(myRand);
	}

}

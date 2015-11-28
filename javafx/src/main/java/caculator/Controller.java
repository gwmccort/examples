package caculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

	@FXML
	private Label results;
	private long number1 = 0;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model();

	@FXML
	public void processNumbers(ActionEvent event) {
		if (start) {
			results.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		results.setText(results.getText() + value);
	}

	@FXML
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();

		if (!value.equals("=")){
			if (!operator.isEmpty())
				return;

			operator = value;
			number1 = Long.parseLong(results.getText());
			results.setText("");
		}
		else {
			if (operator.isEmpty())
				return;

			long number2 = Long.parseLong(results.getText());
			float output = model.caculate(number1, number2, operator);
			results.setText(String.valueOf(output));
			operator = "";
			start = true;
		}

	}

}

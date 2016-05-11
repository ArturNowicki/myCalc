package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Calculations;

public class MainController {

	@FXML
	private TextField answerField;
	@FXML
	private Button btnEquals;
	
	private String operator = "";
	private String firstNumber = "";
	private boolean isStart = true;
	private Calculations calc = new Calculations();

	public void processNumber(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			if(!isStart) answerField.clear();
			answerField.appendText(((Button) source).getText());
			isStart = true;
		}
	}

	public void processSymbol(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			String value = ((Button) source).getText();
			if(!"=".equals(value)) {
				operator = value;
				firstNumber = answerField.getText();
				answerField.clear();
			} else {
				answerField.setText(calc.calculate(firstNumber, operator, answerField.getText()));
				isStart=false;
			}
		}
	}
}

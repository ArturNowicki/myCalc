package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class MainController {

	@FXML
	private TextField answerField;
	@FXML
	private Button btnEquals;
	
	private String operator="";

    @FXML
	public void processNumber(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			answerField.appendText(((Button) source).getText());
		}
	}

    public void processKeyboard(ActionEvent event) {
    	btnEquals.setOnAction(e -> {
    		answerField.appendText(((Button) event.getSource()).getText());
    	});
	}

	public void processSymbol(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			String value = ((Button) source).getText();
			if(!"=".equals(value)) {
				operator = value;
				answerField.appendText(operator);
			} else {
//				TODO calculate some shit
			}
			
		}
	}
}

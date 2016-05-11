package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Calculations;

public class MainController {

	@FXML
	private TextField currentCalculation;	
	@FXML
	private TextField answerField;

	private String operator = "";
	private String firstNumber = "";
	private boolean isStart = true;
	private Calculations calc = new Calculations();

	public void processNumber(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			if(!isStart) answerField.clear();
			currentCalculation.appendText(((Button) source).getText());
			answerField.appendText(((Button) source).getText());
			isStart = true;
		}
	}
	
	public void processControl(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			String value = ((Button) source).getText();
			if(value.equals("C")) {
				answerField.clear();
				isStart = true;
				operator = "";
				firstNumber = "";
			}
			if(value.equals("←")) {
				System.out.println(answerField.getText().length());
				if(answerField.getText().length()==1) {
					System.out.println("aa1");
					answerField.clear();
					System.out.println("aa2");
					currentCalculation.deleteText(answerField.getText().length()-1, answerField.getText().length());
					System.out.println("aa3");
					return;
				}
				if(answerField.getText().length()==0) return;
				answerField.deleteText(answerField.getText().length()-1, answerField.getText().length());
				currentCalculation.deleteText(answerField.getText().length()-1, answerField.getText().length());
			}
		}
	}

	public void processSymbol(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			String value = ((Button) source).getText();
			if(!"=".equals(value)) {
				operator = value;
				if(!isStart) currentCalculation.appendText(answerField.getText());
				currentCalculation.appendText(value);
				firstNumber = answerField.getText();
				answerField.clear();
			} else {
				if(firstNumber.equals("")) return;
				answerField.setText(calc.calculate(firstNumber, operator, answerField.getText()));
				currentCalculation.appendText(" = " + answerField.getText() + ";");
				isStart=false;
			}
		}
	}
}

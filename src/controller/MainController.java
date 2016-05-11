package controller;

import java.io.IOException;

import application.LogLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Calculations;

public class MainController {

	@FXML
	private TextField currentCalculation;	
	@FXML
	private TextField answerField;
	@FXML
	private VBox mainVBox;

	private String operator = "";
	private String firstNumber = "";
	private boolean isStart = true;
	private Calculations calc = new Calculations();
	private double xPos=0, yPos=0;
	public void processNumber(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			if(!isStart) answerField.clear();
			currentCalculation.appendText(((Button) source).getText());
			answerField.appendText(((Button) source).getText());
			isStart = true;
		}
	}
	
	public void processControl(ActionEvent event) throws IOException {
		Object source = event.getSource();
		if(source instanceof Button) {
			String value = ((Button) source).getId();
			if(value.equals("btnClear")) {
				answerField.clear();
				isStart = true;
				operator = "";
				firstNumber = "";
			}
			if(value.equals("btnLog")) {
				Stage stage	= (Stage) mainVBox.getScene().getWindow();
				xPos = stage.getX() + stage.getWidth() + 20;
				yPos = stage.getY();
				LogLoader loader = new LogLoader();
				loader.loadLog(xPos, yPos);
			}
			if(value.equals("btnBack")) {
				if(answerField.getText().length()==0) return;
				answerField.deleteText(answerField.getText().length()-1, answerField.getText().length());
				currentCalculation.deleteText(currentCalculation.getText().length()-1, currentCalculation.getText().length());
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

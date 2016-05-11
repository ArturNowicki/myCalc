package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SidePaneControler {

	@FXML
	private TextArea calcHistory;
	@FXML
	private Button btnClear;
	
	public void processChanges(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof Button) {
			// todo some shit
		}
	}
	
}

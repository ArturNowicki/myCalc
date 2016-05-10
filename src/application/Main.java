package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainGUI.fxml"));
		Scene scene = new Scene(root, 290, 400);
		setGlobalEventHandler(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void setGlobalEventHandler(Parent root) {
		root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER)
				fireButtonEvent(ev.getCode());
			ev.consume();
		});
	}

	private void fireButtonEvent(KeyCode code) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

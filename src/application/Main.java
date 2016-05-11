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
import application.LogLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainGUI.fxml"));
		Scene scene1 = new Scene(root, 290, 400);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
		double xPos = primaryStage.getX()+primaryStage.getWidth()+20;
		double yPos = primaryStage.getY();
		LogLoader loader = new LogLoader();
		loader.loadLog(xPos, yPos);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogLoader {

	public void loadLog(double xPos, double yPos) throws IOException {
		Parent side = FXMLLoader.load(getClass().getResource("/fxml/SidePanel.fxml"));
		Scene scene2 = new Scene(side, 290, 400);
		Stage secondStage = new Stage();
		secondStage.setScene(scene2);
		secondStage.setTitle("Log");
		secondStage.setX(xPos);
		secondStage.setY(yPos);
		secondStage.show();		
	}
}

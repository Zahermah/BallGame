package Project;

import java.util.Map;
import java.util.TreeMap;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoadingHighScore {
	ReadHighScore rgh = new ReadHighScore();

	public void start() {
		Stage primaryStage = new Stage();
		BorderPane root = new BorderPane();
		int size = 400;
		Scene scene = new Scene(root, size, size);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Check Highscore");
		primaryStage.setScene(scene);
		primaryStage.show();
		TextArea area = new TextArea();
		Button button = new Button("Load");

		root.setTop(button);
		root.setCenter(area);
		button.setOnAction(e -> {

			TreeMap<Integer, String> list = rgh.reading();
			for (Map.Entry<Integer, String> me : list.entrySet()) {
				String playerScore = me.getValue().toString() + " Score :" + me.getKey().toString();
				area.appendText(playerScore + "\n");

			}
		});

	}

}

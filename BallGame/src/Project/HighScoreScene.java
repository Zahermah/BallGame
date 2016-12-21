package Project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighScoreScene {

	private ReadHighScore rgh = new ReadHighScore();

	public void start(int score) {
		try {
			Stage pri = new Stage();
			int size = 400;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, size, size);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			pri.setTitle("Highscore");
			pri.setScene(scene);
			pri.show();

			VBox vbox = new VBox();
			Button submit = new Button("Submit");
			TextField entername = new TextField();
			entername.setPromptText("Enter your name");
			vbox.getChildren().addAll(entername, submit);
			root.setTop(vbox);
			TextArea highscorelist = new TextArea();
			root.setCenter(highscorelist);

			submit.setOnAction(e -> {

				filewrite(entername.getText() + "," + score);
				TreeMap<Integer, String> list = rgh.reading();
				for (Map.Entry<Integer, String> me : list.entrySet()) {
					String playerScore = me.getValue().toString() + " Score :" + me.getKey().toString();
					highscorelist.appendText(playerScore + "\n");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String filewrite(String playerEntername) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Player.txt"), true))) {
			writer.append(playerEntername + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return playerEntername;
	}

}

package Project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu");
			primaryStage.show();

			Label frontText = new Label("Ball Game Fx ");
			Label creator = new Label("Created by Zaher Mahmoudi");

			frontText.setId("ballgame");
			creator.setId("creator");
			root.setBottom(creator);
			root.setTop(frontText);

			VBox vb = new VBox();
			vb.setAlignment(Pos.CENTER);
			Button play = new Button("Play");
			Button howToPlay = new Button("How to play");
			Button highscore = new Button("Highscore");
			Button exit = new Button("Exit");
			vb.getChildren().addAll(play, highscore, howToPlay, exit);
			root.setCenter(vb);

			play.setOnAction(e -> {
				startGame();

			});
			highscore.setOnAction(e -> {
				showHighScore();
			});
			howToPlay.setOnAction(e -> {
				howtoPlay();
			});
			exit.setOnAction(e -> {
				Platform.exit();
			});
		} catch (Exception e) {
			System.out.println("Cant Start");
			e.printStackTrace();
		}

	}

	private void startGame() {
		Game vec = new Game();
		vec.start();

	}

	private void showHighScore() {
		LoadingHighScore gh = new LoadingHighScore();
		gh.start();
	}

	private void howtoPlay() {
		HowToPlay htp = new HowToPlay();
		htp.start();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

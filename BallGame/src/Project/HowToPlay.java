package Project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HowToPlay {

	public void start() {

		Stage primaryStage = new Stage();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu");
		primaryStage.show();
		HBox vbox = new HBox();
		TextArea ta = new TextArea();
		Button button = new Button("Play Game");

		vbox.setAlignment(Pos.TOP_CENTER);
		ta.setText(
				"Welcome to Ball Game Fx. \nU as player will be the blueball. \nAs the blue ball you have to avoid the red balls (Enemys),\nYou will receive points by moving. \nThe controlls are that u use your mousepointer and attach it to the blue ball \nDont use any hastey movements because then you will lose controll of your ball\n\n Best of Luck!");
		vbox.getChildren().add(ta);
		root.setTop(vbox);
		root.setBottom(button);
		button.setOnAction(e -> {
			primaryStage.close();
			startGame();

		});

	}

	private void startGame() {
		Game game = new Game();
		game.start();
	}

}

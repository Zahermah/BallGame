package Project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {

	private Circle enemy, enemy2, player;
	private Pane window;
	private int life = 10;
	private int score = 0;
	private Stage stage = new Stage();
	Text text = new Text(" Life Left : " + life);
	Text points = new Text(" Score : " + score);

	public void start() {
		window = new Pane();
		Scene scene = new Scene(window, 800, 600);
		stage.setFullScreen(false);
		stage.setTitle("Game");
		stage.setScene(scene);
		stage.setFullScreen(false);
		stage.show();
		stage.setOnCloseRequest(null);
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(text, points);
		window.getChildren().add(hbox);
		enemy = new Circle(35, Color.RED);
		enemy2 = new Circle(30, Color.RED);
		player = new Circle(35, Color.BLUE);
		enemy.relocate(4, 0);
		enemy2.relocate(600, 300);
		player.relocate(500, 400);
		window.getChildren().addAll(enemy, enemy2, player);

		Timeline gameDuration = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {

			float deltaX = 2;
			float deltaY = 1;
			float brtX = 6;
			float brtY = 4;

			@Override
			public void handle(ActionEvent t) {

				player.setOnMouseMoved(e -> {
					player.contains(e.getX(), e.getY());
					player.setCenterX(e.getX());
					player.setCenterY(e.getY());
					updatePhysics();
				});

				enemy.setLayoutX(enemy.getLayoutX() + deltaX);
				enemy.setLayoutY(enemy.getLayoutY() + deltaY);
				enemy2.setLayoutX(enemy2.getLayoutX() + brtX);
				enemy2.setLayoutY(enemy2.getLayoutY() + brtY);

				Bounds bounds = window.getBoundsInLocal();
				Bounds bound = window.getBoundsInLocal();

				boolean atRightBorder = enemy.getLayoutX() >= (bounds.getMaxX() - enemy.getRadius());
				boolean atLeftBorder = enemy.getLayoutX() <= (bounds.getMinX() + enemy.getRadius());
				boolean atBottomBorder = enemy.getLayoutY() >= (bounds.getMaxY() - enemy.getRadius());
				boolean atTopBorder = enemy.getLayoutY() <= (bounds.getMinY() + enemy.getRadius());

				boolean aRightBorder = enemy2.getLayoutX() >= (bound.getMaxX() - enemy2.getRadius());
				boolean aLeftBorder = enemy2.getLayoutX() <= (bound.getMinX() + enemy2.getRadius());
				boolean aBottomBorder = enemy2.getLayoutY() >= (bound.getMaxY() - enemy2.getRadius());
				boolean aTopBorder = enemy2.getLayoutY() <= (bound.getMinY() + enemy2.getRadius());

				if (atRightBorder || atLeftBorder) {
					deltaX *= -1;
				}
				if (atBottomBorder || atTopBorder) {
					deltaY *= -1;
				}
				if (aRightBorder || aLeftBorder) {
					brtX *= -1;
				}
				if (aBottomBorder || aTopBorder) {
					brtY *= -1;
				}
			}
		}));

		gameDuration.setCycleCount(Timeline.INDEFINITE);
		gameDuration.play();

	}

	private void endScene() {

		HighScoreScene highscore = new HighScoreScene();
		highscore.start(score);

	}

	private void updatePhysics() {
		boolean collision = false;
		if (player.getBoundsInParent().intersects(enemy.getBoundsInParent())
				|| player.getBoundsInParent().intersects(enemy2.getBoundsInParent())) {
			collision = true;

			text.setText("Life Left : " + --life);

		}

		if (collision) {
			System.out.println("HIT");

		} else {
			System.out.println("MISS");
			score += 1;
			points.setText(" Score : " + score);

		}
		if (life == 0) {
			System.out.println("You have died");
			stage.close();
			endScene();
		}
		System.out.println("Total Score " + score);

	}



}

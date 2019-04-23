package Pacman;

import java.io.FileNotFoundException;    
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Game extends Application {
	
	MyPlayer player; //game player
	Map map; //game map
	Food food; //game food
	Scene scene, scene2;// game scenes
	
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		map = new Map("C:\\Users\\Erik\\Desktop\\java\\map0.txt");
		player = new MyPlayer(map);
		map.getChildren().addAll(player.ball, player.ball2, player.ball3);
		
		Pane pane2 = new Pane();
		ImageView image = new ImageView ("file:C:\\Users\\Erik\\Desktop\\java\\Pacman\\src\\Pacman\\packman.gif");
		Button btStart = new Button("Start");
		btStart.setOnAction(e -> {
			primaryStage.setScene(scene);
			food = new Food(map, player);}
		);
		btStart.setLayoutX(80);
		btStart.setLayoutY(220);
		btStart.setPrefSize(100, 30);
		btStart.setStyle("-fx-font: 20 forte; -fx-base: #e70100; -fx-text-fill:#fdffff");
		pane2.getChildren().addAll(image,btStart);
		
		player.ball.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN: player.moveDown(); break;
				case UP: player.moveUp(); break;
				case LEFT: player.moveLeft(); break;
				case RIGHT: player.moveRight(); break;
			}
		});
		
		player.ball2.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN: player.moveDown(); break;
				case UP: player.moveUp(); break;
				case LEFT: player.moveLeft(); break;
				case RIGHT: player.moveRight(); break;
			}
		});
		
		player.ball3.setOnKeyPressed(e -> {
			switch (e.getCode()) {
				case DOWN: player.moveDown(); break;
				case UP: player.moveUp(); break;
				case LEFT: player.moveLeft(); break;
				case RIGHT: player.moveRight(); break;
			}
		});
		
		
		
		
		scene2 = new Scene(pane2, 240, map.getSize()*map.getUnit());
		scene = new Scene(map, map.getSize()*map.getUnit(), map.getSize()*map.getUnit());
		primaryStage.setTitle("Packman"); // Set the stage title
		primaryStage.setScene(scene2); // Place the scene in the stage
		primaryStage.show();
		player.ball.requestFocus();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}	
}

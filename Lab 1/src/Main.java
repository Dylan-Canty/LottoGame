// Dylan Canty -- R00141587 -- OOP Semester 2, Project 1

/**
 * To-Do
 * 
 * 1. Make it so AlertBox is just one class and is implemented in Prizes Tab
 * 2. Implement a way so that Prize Tab is disabled until either GuessingGame or LottoCure are won
 * 3. Make the GUI more visually pleasing 
 * 4. Make it so that the user only sees the string of the Prize and not the prize itself
 * 5. Implement setOnAction for user pressing enter
 * 
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public void start(Stage primaryStage) throws FileNotFoundException, IOException, Exception {

			TabPane gameTab = new TabPane();
			gameTab.getTabs().add (new GuessingGame());
			gameTab.getTabs().add (new LottoCure());
			gameTab.getTabs().add (new Prizes());
			BorderPane GameBP = new BorderPane();
			GameBP.setTop(gameTab);


			Scene GameScene = new Scene(GameBP);

			primaryStage.setScene(GameScene);
			primaryStage.setWidth(400);
			primaryStage.setHeight(500);
			primaryStage.show();

			}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
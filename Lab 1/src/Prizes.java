import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Map;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Prizes extends Tab {
	//GUI
	private Button submitButton;

	private HBox title;
	private HBox fourStar;
	private HBox fiveStar;
	private HBox sixStar;
	private HBox buttonBox;
	private HBox filler;
	
	private StackPane layout;
	private VBox frame;
	private ComboBox<String> fourStarPrize;
	private ComboBox<String> fiveStarPrize;
	private ComboBox<String> sixStarPrize;
	
	//Variables
	private static PrizeController unlock = new PrizeController();
	String star4 = "4 * Prizes:";
	String star5 = "5 * Prizes:";
	String star6 = "6 * Prizes:";

	Map<String, PrizeObject> prizeMap;
	java.util.Set<String> prizeKeys; 
	String[] keyValues; 
	String[] starValue; 
	String[] prizeName; 

	private int lineCounter;
	public Prizes() throws FileNotFoundException, IOException, Exception { 

		Label prizeTitle = new Label("Please Choose a Prize!");
		prizeTitle.setStyle("-fx-font-size: 16pt;");
		prizeTitle.setTextFill(Color.RED);

		submitButton = new Button();
		submitButton.setText("Submit");
		
		submitButton.setStyle("-fx-font-size: 15pt;");

		fourStarPrize = new ComboBox<String>();
		fourStarPrize.setPromptText(star4);
		fourStarPrize.setDisable(true);

		fiveStarPrize = new ComboBox<String>();
		fiveStarPrize.setPromptText(star5);
		fiveStarPrize.setDisable(true);

		sixStarPrize = new ComboBox<String>();
		sixStarPrize.setPromptText(star6);
		sixStarPrize.setDisable(true);

		@SuppressWarnings("unused")
		MyHashmap hashmap = new MyHashmap();
		lineCounter = MyHashmap.getCounter();
		prizeMap = MyHashmap.getHashmap(); 
		prizeKeys = prizeMap.keySet();
		keyValues = new String[lineCounter];
		starValue = new String[lineCounter];
		prizeName = new String[lineCounter];

		int q = 0;
		for (String count : prizeKeys) {
			keyValues[q] = count; 
			q++;
		}

		for (int i = 0; i < keyValues.length; i++) { 

			prizeName[i] = prizeMap.get(keyValues[i]).getName(); 
			starValue[i] = prizeMap.get(keyValues[i]).getStar();

		}

		for (int i = 0; i < prizeName.length; i++) { 
			if (starValue[i].equals("4")) { 
				fourStarPrize.getItems().add(prizeName[i]); 
			}

			else if (starValue[i].equals("5")) {
				fiveStarPrize.getItems().add(prizeName[i]);
			}

			else if (starValue[i].equals("6")) {
				sixStarPrize.getItems().add(prizeName[i]);
			}
		}
		
		title = new HBox(); 
		title.getChildren().add(prizeTitle);
		title.setAlignment(Pos.CENTER);

		fourStar = new HBox(10);
		fourStar.getChildren().add(fourStarPrize);
		fourStar.setAlignment(Pos.CENTER);

		fiveStar = new HBox(10);
		fiveStar.getChildren().add(fiveStarPrize);
		fiveStar.setAlignment(Pos.CENTER);

		sixStar = new HBox(10); 
		sixStar.getChildren().add(sixStarPrize);
		sixStar.setAlignment(Pos.CENTER);

		buttonBox = new HBox(); 
		buttonBox.getChildren().add(submitButton);
		buttonBox.setAlignment(Pos.CENTER);
		
		filler = new HBox();

		frame = new VBox(30); 
		frame.getChildren().addAll(title, fourStar, fiveStar, sixStar, filler, buttonBox); 
		frame.setPadding(new Insets(15, 15, 15, 15)); 

		layout = new StackPane();
		layout.getChildren().add(frame);
		
submitButton.setOnAction(e -> {
	Alert popUp = new Alert(AlertType.INFORMATION);
			
	if (fourStarPrize.getValue() == null && fiveStarPrize.getValue() == null && sixStarPrize.getValue() == null){ //No Prizes
		popUp.setTitle("NO WINNER");
		popUp.setHeaderText("Sorry");
		popUp.setContentText("You need to win a game, and select a prize to accept prizes!");
		}
	
	if (fourStarPrize.getValue() != null && fiveStarPrize.getValue() == null && sixStarPrize.getValue() == null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fourStarPrize.getValue() + " prize.");
		fourStarPrize.setDisable(true);
		}
	
	if (fourStarPrize.getValue() == null && fiveStarPrize.getValue() != null && sixStarPrize.getValue() == null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fiveStarPrize.getValue() + " prize.");
		fiveStarPrize.setDisable(true);
		}
	
	if (fourStarPrize.getValue() == null && fiveStarPrize.getValue() == null && sixStarPrize.getValue() != null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + sixStarPrize.getValue() + " prize." );
		sixStarPrize.setDisable(true);
		}
	
	if (fourStarPrize.getValue() != null && fiveStarPrize.getValue() != null && sixStarPrize.getValue() == null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fourStarPrize.getValue() + " prize" + " and the " + fiveStarPrize.getValue() + " prize.");
		}
	
	if (fourStarPrize.getValue() != null && fiveStarPrize.getValue() == null && sixStarPrize.getValue() != null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fourStarPrize.getValue() + " and the " +sixStarPrize.getValue()  );
		fourStarPrize.setDisable(true);
		sixStarPrize.setDisable(true);
		}
	
	if (fourStarPrize.getValue() == null && fiveStarPrize.getValue() != null && sixStarPrize.getValue() != null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fiveStarPrize.getValue() + " and the " +sixStarPrize.getValue()  );
		fiveStarPrize.setDisable(true);
		sixStarPrize.setDisable(true);
		}
	
	if (fourStarPrize.getValue() != null && fiveStarPrize.getValue() != null && sixStarPrize.getValue() != null){
		popUp.setTitle("WINNER");
		popUp.setHeaderText("Congratulations!");
		popUp.setContentText("You have won the " + fourStarPrize.getValue() + " and the " +fiveStarPrize.getValue()+ " and the " +sixStarPrize.getValue() );
		fourStarPrize.setDisable(true);
		fiveStarPrize.setDisable(true);
		sixStarPrize.setDisable(true);
		}

		popUp.show();
});

	setClosable(false);
	setText("Prizes");
	setContent(layout);
		
setOnSelectionChanged(e -> { 
		if(unlock.getFourStarUnlock() == true){
			fourStarPrize.setDisable(false);
		}
		
		if (unlock.getFiveStarUnlock() == true) {
			fiveStarPrize.setDisable(false);
		}
		
		if (unlock.getSixStarUnlock() == true) {
			sixStarPrize.setDisable(false);
		}
		
	});

	}
}

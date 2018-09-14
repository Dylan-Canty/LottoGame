// Dylan Canty -- R00141587 -- OOP Semester 2, Project 1

import javafx.application.Platform;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

import java.util.Random;
 
public class GuessingGame extends Tab {
	
	//GUI
	
	private HBox title;
	private HBox textBox;
	private HBox guessResultBox;
	private HBox allButtons;
	private HBox filler;
	private VBox frame;
	
	private TextField numberInput;
	
	private Button resetButton;
	private Button guessButton;
    private Button quitButton;
	
	//Variables
    static Random rand = new Random();
    static int r = rand.nextInt(100) + 1;
    static int guessesLeft = 6;
    static int input;
    // static boolean completed;
    
private static PrizeController win;
@SuppressWarnings("static-access")
public GuessingGame () {
//GUI Implementation
	resetButton = new Button("Reset");
	guessButton = new Button("Guess");
	quitButton = new Button("Quit");


	resetButton.setStyle("-fx-font-size: 15pt;");
	guessButton.setStyle("-fx-font-size: 15pt;");
	quitButton.setStyle("-fx-font-size: 15pt;");
	

 
	Label numberLabel = new Label("Your Guess:");
	Label guessResult = new Label("");
	Label guessTitle = new Label ("Guess a Number Between 1 and 100!");
	numberInput = new TextField();
	numberInput.setPromptText("1-100");

	guessTitle.setTextFill(Color.RED);
	//guessTitle.setFont(Font.font("Tahoma", 16));
	guessTitle.setStyle("-fx-font-size: 16pt;");

	title = new HBox();
	title.getChildren().add(guessTitle);

	textBox = new HBox();
	textBox.getChildren().add(numberLabel);
	textBox.getChildren().add(numberInput);

	guessResultBox = new HBox();
	guessResultBox.getChildren().addAll(guessResult);
	guessResultBox.setSpacing(1.5);

	allButtons = new HBox(50);
	allButtons.getChildren().addAll(resetButton, guessButton, quitButton);
	
	filler = new HBox();

	//Alignment
	title.setAlignment(Pos.CENTER);
	textBox.setAlignment(Pos.CENTER);
	guessResultBox.setAlignment(Pos.CENTER);
	allButtons.setAlignment(Pos.CENTER);
	filler.setAlignment(Pos.CENTER);

	frame = new VBox(60);
	frame.setPadding(new Insets(15, 15, 15, 15));
	frame.getChildren().addAll(title, textBox, guessResultBox, filler, allButtons);
	

	StackPane guessStack = new StackPane();
	guessStack.getChildren().add(frame);

	setClosable(false); 
	setText("Guessing Game");
	setContent(guessStack);
	
	System.out.println(r + "\n");
	

//Button Actions
	resetButton.setOnAction(e -> {
	
		guessResult.setText("Game Reset");
		guessesLeft = 6;
		r = rand.nextInt(100) + 1;
		guessButton.setVisible(true);
		System.out.println("\n" + r + "\n");
	
	});
	
	guessButton.setOnAction(e -> {
       
		if (guessesLeft > 0){
    	
			input = Integer.valueOf(numberInput.getText());
 
			if (input < r)
			{
				guessesLeft--;
				guessResult.setText("The entered number is too low. You have " + guessesLeft + " guesses left.");
			}
			else if (input > r)
			{
				guessesLeft--;
				guessResult.setText("The entered number is too high. You have " + guessesLeft + " guesses left.");
			}
			else
			{
				AlertBox.display("Congratulations", "You have won a 4* prize! \n"
						+ "Proceed to the Prizes tab to claim your prize!");
				win.winGuessingGame4(); 
				guessButton.setVisible(false);
				// completed = true;
			}
			if (input < 0 || input > 100 )
			{
				guessResult.setText("The number you entered is out of range. You have " + guessesLeft + " guesses left.");
			}
		}
   
		if (guessesLeft == 0){
			guessResult.setText("You have no more guesses left." + "\n" + 
			"The correct number was " + r + "." );
			guessButton.setVisible(false);
		}
       
   
	});

		quitButton.setOnAction(e -> Platform.exit());
	}
}
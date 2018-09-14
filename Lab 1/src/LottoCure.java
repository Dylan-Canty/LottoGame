
import javafx.application.Platform;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import javafx.scene.control.TextArea;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

import java.util.Random;

public class LottoCure extends Tab {

	private TextArea[] displayBox;
	private HBox title;
	private HBox displaySelection;
	private HBox allButtons;
	private HBox lottoResultBox;
	private FlowPane lottoFlow;
	private VBox frame;
	
	private Button[] genButtons;
	private Button submitButton;
	private Button resetButton;
	private Button quitButton;

	static int store = 0; 
	private int[] lottoTicket = lottoGenerator(); 

private static PrizeController prize;
public LottoCure() { 
	
	for (int i = 0; i < lottoTicket.length; i++){
		System.out.println(lottoTicket[i]);
		}
	
	
	submitButton = new Button();
	resetButton = new Button();
	quitButton = new Button();
	
	submitButton.setStyle("-fx-font-size: 15pt;");
	resetButton.setStyle("-fx-font-size: 15pt;");
	quitButton.setStyle("-fx-font-size: 15pt;");

	Label lottoTitle = new Label("Enter your 6 Lotto Numbers!");
	Label result = new Label(" ");
		
	lottoTitle.setStyle("-fx-font-size: 16pt;");
	lottoTitle.setTextFill(Color.RED);

	displayBox = new TextArea[6]; 
	for (int i = 0; i < displayBox.length; i++) {
		displayBox[i] = new TextArea(); 
		displayBox[i].setDisable(true); 
	}

	title = new HBox();
	title.getChildren().add(lottoTitle);
	title.setAlignment(Pos.CENTER);

	displaySelection = new HBox(1);
	displaySelection.setAlignment(Pos.CENTER);
	for (int i = 0; i < displayBox.length; i++) {
		displayBox[i].setPrefSize(30, 30);
		displaySelection.getChildren().addAll(displayBox[i]);
	}

	allButtons = new HBox(50);
	allButtons.getChildren().addAll(submitButton, resetButton, quitButton);
	allButtons.setAlignment(Pos.CENTER);
	
	
	lottoResultBox = new HBox(50);
	lottoResultBox .getChildren().add(result);
	lottoResultBox .setAlignment(Pos.CENTER);

	lottoFlow = new FlowPane();
	genButtons = new Button[45];
	for (int i = 0; i < genButtons.length; i++) {
		int store = i; 
		genButtons[i] = new Button(Integer.toString(i + 1));
		genButtons[i].setPrefWidth(30); 
		genButtons[i].setOnAction(e -> {
			for (int x = 0; x < 6; x++) { 
				if (displayBox[x].getText().isEmpty() == true) { 
					displayBox[x].setText(genButtons[store].getText());
					genButtons[store].setDisable(true);
					break;
				}
			}
		});
		lottoFlow.getChildren().add(genButtons[i]);
	}

	lottoFlow.setVgap(2);
	lottoFlow.setHgap(4);
	lottoFlow.setPrefWrapLength(300); 

	frame = new VBox(30); 
	frame.setPadding(new Insets(15, 15, 15, 15)); 
	frame.getChildren().addAll(title, displaySelection, lottoResultBox, lottoFlow, allButtons);
		
	StackPane lottoStack = new StackPane();
	lottoStack.getChildren().add(frame);
		
	setClosable(false);
	setText("Lotto Cure");
	setContent(lottoStack);
		
	submitButton.setText("Submit");
	submitButton.setOnAction(e ->  result.setText(submitButtonAction(lottoTicket, result).getText()));

	resetButton.setText("Reset");
	resetButton.setOnAction(e -> reset(result));

	quitButton.setText("Quit");
	quitButton.setOnAction(e -> Platform.exit());
	}

	private void reset(Label result) {
		for (int i = 0; i <genButtons.length; i++) {
			int store = i;
			genButtons[store].setDisable(false);
				for (int x = 0; x < 6; x++) {
					if (displayBox[x].getText().isEmpty() == false) {
						displayBox[x].clear();

					}
				}
		}
		result.setText(" ");
	}

	@SuppressWarnings("static-access")
	private Label submitButtonAction(int[] userTicket, Label result) {
		int match = 0;
		int[] myTicket = new int[6]; 
			for (int x = 0; x < displayBox.length; x++) {
			
			myTicket[x] = Integer.parseInt(displayBox[x].getText());

			for(int i = 0; i < 6; i++){ 
				if (myTicket[x] == lottoTicket[i]) { 
				match++;
				
				}
			}
		}
		if(match == 4){
			AlertBox.display("Congratulations", "You have won a 4* prize! \n"
					+ "Proceed to the Prizes tab to claim your prize!");
			prize.winLottoCure4(); 
		}
		if(match == 5){
			AlertBox.display("Congratulations", "You have won a 5* prize! \n"
					+ "Proceed to the Prizes tab to claim your prize!");
			prize.winLottoCure5();
		}
		if(match == 6){
			AlertBox.display("Congratulations", "You have won a 6* prize! \n"
					+ "Proceed to the Prizes tab to claim your prize!");
			prize.winLottoCure6();
		}
		result.setText("You got " + match + " match(es)!");
		return result;
	}
	
	private static int[] lottoGenerator() {
		Random random = new Random();
		final int MAX_VALUE = 46;
		int[] ticket = new int[6];

		for (int x = 0; x < 6; x++) {
			ticket[x] = random.nextInt(MAX_VALUE) + 1;
			for(int i = 0; i < (x - 1); i++) {
				if(ticket[x] == ticket[i]) {
					ticket[x] = random.nextInt(MAX_VALUE) + 1;
				 }				
			}
		}
	return ticket; 
	}

}

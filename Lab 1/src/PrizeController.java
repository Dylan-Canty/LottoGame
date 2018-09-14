// Dylan Canty -- R00141587 -- OOP Semester 2, Project 1

// Deemed it necessary to implement a prize controller for handling the 
// unlocking of prizes as the user wins in each game.

public class PrizeController {

	private static boolean fourStarPrize;
	private static boolean fiveStarPrize;
	private static boolean sixStarPrize;
	static int prizeNumber = 0;

public PrizeController() {
	if(prizeNumber == 0){
		fourStarPrize = false;
		fiveStarPrize = false;
		sixStarPrize = false;
	}
	prizeNumber++;
}
public static void winGuessingGame4() {
	setFourStarUnlock(true);
}
public static void winLottoCure4() {
	setFourStarUnlock(true);
}
public static void winLottoCure5() {
	setFiveStarUnlock(true);
}
public static void winLottoCure6() {
	setSixStarUnlock(true);
}

public boolean getFourStarUnlock() {
	return fourStarPrize;
}

public boolean getFiveStarUnlock() {
	return fiveStarPrize;
}

public boolean getSixStarUnlock() {
	return sixStarPrize;
}

public static void setFourStarUnlock(boolean fourStarUnlocked) {
	fourStarPrize = fourStarUnlocked;
}

public static void setFiveStarUnlock(boolean fiveStarUnlocked) {
	fiveStarPrize = fiveStarUnlocked;
}

public static void setSixStarUnlock(boolean sixStarUnlocked) {
	sixStarPrize = sixStarUnlocked;
}


}
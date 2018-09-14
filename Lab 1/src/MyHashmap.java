// Dylan Canty -- R00141587 -- OOP Semester 2, Project 1

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyHashmap {
	private File prizeFile;
	private String store; 
	private String[] prizeList; 
	private BufferedReader reader; 
	private PrizeObject prize; 
	static int prizeCount; 
	private static Map<String, PrizeObject> myHashmap; 

 public MyHashmap() throws FileNotFoundException, IOException,Exception {

	 prizeCount = 0;
	 //We implement a try/catch for any possible errors.
		try {
			myHashmap = new HashMap<>(); 
			prizeFile = new File("C:/Users/Dylan/Documents/College/OOP Semester 2/Lab 1/Prizes.txt");
			reader = new BufferedReader(new FileReader(prizeFile)); 

			while ((store = reader.readLine()) != null) { 
				prizeList = store.split(":");
				for (int i = 0; i < prizeList.length; i++) { 
					prizeList[i] = prizeList[i].trim(); 
				}
				
				prize = new PrizeObject(prizeList[1], prizeList[2]);
				myHashmap.put(prizeList[0], prize);
				prizeCount++; 
			}
			reader.close();
			
		} 
		
		catch (IOException e) { //Catches any possible errors
			System.err.println("An IOException was caught!"); //Prompts there was an error
			e.printStackTrace();

		}
	}


public static int getCounter() {
	return prizeCount;
	}

public static Map<String, PrizeObject> getHashmap() {
	return myHashmap;
	}
}
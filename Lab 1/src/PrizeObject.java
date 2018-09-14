// Dylan Canty -- R00141587 -- OOP Semester 2, Project 1

public class PrizeObject {
	String name; 
	String prizeNumber;

public PrizeObject(String pName, String pStar) {
	this.name = pName;
	this.prizeNumber = pStar;
}

public String getName() {
	return name;
}

public String getStar() {
	return prizeNumber;
}
}
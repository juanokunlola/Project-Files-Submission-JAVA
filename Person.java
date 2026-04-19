package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The Person.java class extends the basic User class, adding the individual user's coin collection, and whether or not they are interested in receiving
 *  information about recycling collection. 
 * Called by: UserLogin, UserSignUp
 * Contains: Person, getCoins(), setCoins(int uCoins), getRecycle(), setRecycle(boolean choice)
 * */


public class Person extends User{

	private int userCoins;
	private boolean recycle;
	
	public Person(String user, String password, int uCoins, boolean recycleChoice) {
		super(user, password);
		this.userCoins = uCoins;
		this.recycle = recycleChoice;
	}
	
	//getters and setters
	public int getCoins() {
		return userCoins;
	}
	
	public void setCoins(int uCoins) {
		this.userCoins = uCoins;
	}
	
	public boolean getRecycle() {
		return recycle;
	}
	
	public void setRecycle(boolean choice) {
		this.recycle = choice;
	}
}



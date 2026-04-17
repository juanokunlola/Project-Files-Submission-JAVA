package javaTrashTracker;

import java.util.ArrayList;

public class Person extends User{

	private int userCoins;
	private ArrayList <Plant> userGarden = new ArrayList<>();
	private boolean recycle;
	
	public Person(String user, String password, int uCoins, ArrayList <Plant> userGarden, boolean recycleChoice) {
		super(user, password);
		this.userCoins = uCoins;
		this.userGarden = userGarden;
		this.recycle = recycleChoice;
	}
	
	public void successfulDisposal(boolean success){
		this.userCoins = userCoins += 5;
	}
	
	
	//displays all Flowers in the garden
	public void displayFlowers() {
		System.out.println("Your Flowers: ");
		for(int i = 0; i < userGarden.size(); i++) {
			if(userGarden.get(i).getType().equals("Flower")) {
				System.out.println(userGarden.get(i).plantDisplay());
			}
		}
	}
	
	
	//displays all Trees in the garden
	public void displayTrees() {
		System.out.println("Your Trees: ");
		for(int i = 0; i < userGarden.size(); i++) {
			if(userGarden.get(i).getType().equals("Tree")) {
				System.out.println(userGarden.get(i).plantDisplay());
			}
		}
	}
	
	//Counts occurrences of Type of plant
	
	public int countPlantType(String type) {
		int count = 0;
		
		for(int i = 0; i < userGarden.size(); i++) {
			if(userGarden.get(i).getType().equals(type)) {
				count++;
			}
		}
		
		return count;
		
	}
	
	
	
	
	//getters and setters
	public int getCoins() {
		return userCoins;
	}
	
	public void setCoins(int uCoins) {
		this.userCoins = uCoins;
	}
	
	public ArrayList<Plant> getGarden() {
		return userGarden;
	}
	
	public void setGarden(ArrayList<Plant> garden) {
		this.userGarden = garden;
	}
	
	public boolean getRecycle() {
		return recycle;
	}
	
	public void setRecycle(boolean choice) {
		this.recycle = choice;
	}
}



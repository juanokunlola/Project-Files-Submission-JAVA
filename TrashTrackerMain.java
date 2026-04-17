package javaTrashTracker;

import java.util.ArrayList;
import java.io.File;


public class TrashTrackerMain{
		
	
	public static void main(String[] args) {

		/*Scanner scanner = new Scanner(System.in);
		ArrayList <Plant> garden = new ArrayList<>();
		
		//UserLogin login = new UserLogin();
		CollectionDay c = new CollectionDay();
		Person u = new Person("name", "password", 0, garden, true);
		//Organization org = new Organization("name", "password", c.getCollectionDay(), c.getRecycleDay()); 
		
		c.checkCollectionDay();
		c.checkRecycleDay();
		garden.add(Plant.SNAPDRAGON);
		garden.add(Plant.CEDAR);
		u.displayFlowers();
		u.displayTrees();*/
		//
		
		//Automatically set up an admin password + previously existing info for demo purposes
		UserLogin u = new UserLogin(true);
		u.getFrame().dispose();
		
		ArrayList <String> logIns = u.getLoginInfo();
		File logInFile = u.getLoginFile();
		u.newLogIn(logIns, "Admin", "overrid3!U", true, logInFile);
		u.newLogIn(logIns, "Admin", "overrid3!O", false, logInFile);
		
		File userFile = u.getUserFile();
		ArrayList <String> stringArray = u.getUserInfo();
		u.updateUserInfo(stringArray, "Admin", "overrid3!U", 100, true, userFile);
		System.out.println("main: " + userFile);

		
		new LaunchWindow();
	
		
		//log out writes user data to the file, and converts the user's garden into coins to save progress, even if the garden is not saved
		//u.setCoins(u.getCoins() + u.countPlantType("Tree" + u.countPlantType("Flower")));;
		//log out function should trigger new launch window. wherever that ends up
		
		
		
		

		
		
	
		
		//System.out.println("");
		
		
		//scanner.close();
	}

}

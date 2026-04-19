package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The TrashTrackerMain.java class initializes the program. 
 * Calls: UserLogin
 * Directs to: LaunchWindow
 * Contains: TrashTrackerMain, main(String[] args)
 * */

import java.util.ArrayList;
import java.io.File;

public class TrashTrackerMain{
		
	
	public static void main(String[] args) {

		/*Automatically sets up an Admin password + previously existing info for demo purposes.
		This resets the Admin accounts coins every time the program is launched*/
		UserLogin u = new UserLogin(true);
		u.getFrame().dispose();
		
		ArrayList <String> logIns = u.getLoginInfo();
		File logInFile = u.getLoginFile();
		u.newLogIn(logIns, "Admin", "overrid3!U", true, logInFile);
		u.newLogIn(logIns, "Admin", "overrid3!O", false, logInFile);
		
		File userFile = u.getUserFile();
		ArrayList <String> stringArray = u.getUserInfo();
		u.updateUserInfo(stringArray, "Admin", "overrid3!U", 1000, true, userFile);
		
		
		new LaunchWindow();

	}

}

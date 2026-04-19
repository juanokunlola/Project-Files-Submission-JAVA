package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The UserLogin.java class creates the GUI interface for a user to login to their account, separating them based on whether they are an individual 
 *  user, or logging in on behalf of an organization. The program is types sensitive, checks if they are a returning user, and accesses their previous data 
 *  stored in the user files for future use if so. If the username or password is incorrect, the program alerts the user. If the user does not have a previously 
 *  existing login, they can access the class for creating a new user, and return back to the launch window and attempt to log in as the other type of user.
 * Originates: LaunchWindow
 * Called By: CheckCollectionDayWindow, CheckRecycleDayWindow, RewardsWindow, TrashTrackerMain, UserSignUp, UserWindow
 * Directs to: UserWindow, OrgWindow, UserSignUp, LaunchWindow
 * Contains: UserLogin, newLogIn(...), returningUserCheck(...), fetchReturnerCoins(...), fetchReturnerRecycling(...), updateUserInfo(...),
 *  fileReader(File logs, ArrayList<String> fileInfo), fileWriter(File file, ArrayList<String> fileInfo), getUserInfo(), getLoginInfo(), getUserFile(), 
 *  getLoginFile(), getFrame()  
 * */

import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.DayOfWeek;

public class UserLogin implements ActionListener {

	private boolean type; //true indicates individual, false means organization
	private static File userFiles = new File("users.txt");
	private File userLogIns = new File("logIns.txt");
	private ArrayList<String> userInfo = new ArrayList<>();
	private ArrayList<String> logInInfo = new ArrayList<>();
	
	
	private JPanel panel = new JPanel();
	private JLabel userLable = new JLabel("Username");
	private JLabel passLable = new JLabel("Password");
	private JLabel successMessage = new JLabel();
	private JLabel failureMessage1 = new JLabel();
	private JLabel failureMessage2 = new JLabel();
	private JFrame frame = new JFrame();
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton backButton = new JButton("Return");
	private JButton loginButton = new JButton("Login");
	private JButton newUserButton = new JButton("Don't have a username? Sign up here!");
	
	//login, separate person and org files and checks, flip booleans as required
	
	public UserLogin(boolean person) { 
		this.type = person;
		
		//initialize files
		File userFiles = new File("users.txt");
		boolean fileExists = userFiles.exists();
		if (fileExists == true) {
			userFiles.setExecutable(true);
			userFiles.setReadable(true);
			userFiles.setWritable(true);
		}
		else {
		System.out.println("Users File not found");
		}
		
		File userLogIns = new File("logIns.txt");
		boolean logFileExists = userLogIns.exists();
		if (logFileExists == true) {
			userLogIns.setExecutable(true);
			userLogIns.setReadable(true);
			userLogIns.setWritable(true);
		}
		else {
		System.out.println("User Logins File not found");
		}
	
		
		panel.setLayout(null);
		userLable.setBounds(10, 80, 80, 25);
		passLable.setBounds(10, 130, 80, 25);
		username.setBounds(100, 80, 195, 25);
		password.setBounds(100, 130, 195, 25);
		loginButton.setBounds(100, 175, 80, 30);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		newUserButton.setBounds(65, 265, 275, 25);
		newUserButton.setFocusable(false);
		newUserButton.addActionListener(this);
		backButton.setBounds(5, 20, 80, 25);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		successMessage.setBounds(100, 215, 200, 25);
		failureMessage1.setBounds(50, 215, 275, 25);
		failureMessage2.setBounds(75, 230, 275, 25);
		frame.add(successMessage);
		frame.add(failureMessage1);
		frame.add(failureMessage2);

		
		frame.add(panel);
		frame.add(backButton);
		frame.add(userLable);
		frame.add(passLable);
		frame.add(username);
		frame.add(password);
		frame.add(newUserButton);
		frame.add(loginButton);
		frame.setTitle("Track Your Trash!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean logIn = false;
		
		if (e.getSource() == loginButton) {
			fileReader(userLogIns, logInInfo);
			String passwordInput = new String(password.getPassword());
			
			logIn = returningUserCheck(logInInfo, username.getText(), passwordInput, type);
			
			if(logIn == true) {
				successMessage.setText("You have successfully logged in!");
				failureMessage1.setText("");
				failureMessage2.setText("");
				
				}
			else if(logIn == false) {
				successMessage.setText("");
				failureMessage1.setText("Either your username or password is wrong.");
				failureMessage2.setText("Would you like to try again?");
				}
			
			
			
			if(logIn == true && type == true) {
			
				String userInput = username.getText();
				boolean recycler = false;
				int coins = 0;
				fileReader(userFiles, userInfo);
				coins = fetchReturnerCoins(userInfo, userInput, passwordInput, coins, recycler);
				recycler = fetchReturnerRecycling(userInfo, userInput, passwordInput, coins, recycler);
				Person thisUser = new Person(userInput, passwordInput, coins, recycler);
				
				frame.dispose();
				new UserWindow(thisUser);
				
				}
			
			else if(type == false) {	
				String userInput = username.getText();
				frame.dispose();
				Organization logOrg = new Organization(userInput, passwordInput, DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
				new OrgWindow(logOrg);
				} 			
	        } 
		
			
		else if (e.getSource() == newUserButton) {
			frame.dispose();
			new UserSignUp(type);
	        }
		
		else if (e.getSource() == backButton) {
			frame.dispose();
			new LaunchWindow();
		}
	
	}
	

	public void newLogIn(ArrayList<String> logInfo, String user, String password, boolean type, File file) {
		
		fileReader(file, logInfo);
		
		if(type == true) {
			logInfo.add(user + ", " + password + ", U");
		}
		else {
			logInfo.add(user + ", " + password + ", O");
		}
		
		fileWriter(file, logInfo);
	}
	
	public static boolean returningUserCheck(ArrayList<String> logInfo, String user, String password, boolean type) {
		boolean logIn = false;
		String userType = "";
		if(type == true) {
			userType = "U";
		}
		else if (type == false) {
			userType = "O";
		}
		
		String userCheck = user + ", " + password + ", " + userType;
		
		for (String u: logInfo) {
	        if (u.equals(userCheck)) {
	        	logIn = true;
	            break;
	        	}
		}
		return logIn;
	}

	public static int fetchReturnerCoins(ArrayList<String> userInfo, String user, String password, int coins, boolean toggler) {
		
		fileReader(userFiles, userInfo);
		
		String userID = user + ", " + password;
		int funds = 0;
		for (String u: userInfo) {
	
			if (u.startsWith(userID)) {
				StringTokenizer tokenizer = new StringTokenizer(u, ",");
				user = tokenizer.nextToken().trim();
				password = tokenizer.nextToken().trim();
				funds =  Integer.parseInt(tokenizer.nextToken().trim());
				toggler = Boolean.parseBoolean(tokenizer.nextToken().trim());
				}
		}
		
		return funds;
	}

	public static boolean fetchReturnerRecycling(ArrayList<String> userInfo, String user, String password, int coins, boolean toggler) {
		
		fileReader(userFiles, userInfo);
		
		String userID = user + ", " + password;
		for (String u: userInfo) {
	
			if (u.startsWith(userID)) {
				StringTokenizer tokenizer = new StringTokenizer(u, ",");
				user = tokenizer.nextToken().trim();
				password = tokenizer.nextToken().trim();
				coins =  Integer.parseInt(tokenizer.nextToken().trim());
				toggler = Boolean.parseBoolean(tokenizer.nextToken().trim());
				}
		}
		
		return toggler;
	}

	public void updateUserInfo(ArrayList<String> userInfo, String user, String password, int coins, boolean toggle, File file) {
		
		fileReader(file, userInfo);
		
		String userID = user + ", " + password;
		int index = 0;
		boolean updated = false;
		String savedInfo = user + ", " + password + "," + coins + "," + toggle;
		
		for (String u: userInfo) {
	        if (u.startsWith(userID)) {
	            userInfo.set(index, savedInfo);
	            updated = true;
	            break;
	        	}
	        index++;
	        }
		
		if(updated == false) {
			userInfo.add(savedInfo);
		}
		
		fileWriter(file, userInfo);
	}
	
	//FILE NONSENSE

	public static void fileReader(File logs, ArrayList<String> fileInfo) { 
		
		//read file setup
		try {
			FileReader fileR = new FileReader(logs);
			BufferedReader logsFile = new BufferedReader(fileR);
			String line;
			int i = 0;
			
			while ((line = logsFile.readLine()) != null) {
			    if (!fileInfo.contains(line)) {
			    	fileInfo.add(i, line);
			    	i++;
			    }
			}
			logsFile.close();
			}
			catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}
	
	public static void fileWriter(File file, ArrayList<String> fileInfo) {
		
		//write to file setup
		try {
			
			BufferedWriter fileW = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < fileInfo.size(); i++) {
				fileW.write(fileInfo.get(i));
				fileW.newLine();
			}
			
			fileW.close();
			}catch (Exception e) {
			e.getStackTrace();
			}
	}
	
	//Getters and setters
	
	public ArrayList<String> getUserInfo() {
		return userInfo;
	}
	
	public ArrayList<String> getLoginInfo() {
		return logInInfo;
	}
	
	public File getUserFile() {
		return userFiles;
	}
	
	public File getLoginFile() {
		return userLogIns;
	}
	
	public Frame getFrame() {
		return frame;
	}
}


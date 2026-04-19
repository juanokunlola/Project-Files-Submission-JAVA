package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The UserWindow.java class creates the GUI window for users that have logged in as individuals, providing access to the individual-only function
 * 	pages where they can: check the day trash is being collected, check their coin balance, redeem rewards with those coins, read tips for reducing waste, and 
 * 	toggle their interest in whether or not they want to be reminded of recycling opportunities. Upon logging out from this page, all the changes made to the user
 * 	information is saved in the corresponding files for the next time they log in.
 * Originates: UserLogin, UserSignUp, CheckCoinWindow, CheckCollectionWindow, CheckRecycleDayWindow, ChooseRecycleWindow, RewardsWindow 
 * Calls: UserLogin
 * Directs to: CheckCollectionDayWindow, CheckCoinWindow, RewardsWindow, TipsWindow, ChooseRecycleWindow, LaunchWindow
 * Contains: UserWindow
 * */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class UserWindow implements ActionListener{

	private String currentUsername;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;
	private Person currentUser;
	
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel();
	private JButton dayCheckButton = new JButton("Check Day!");
	private JButton coinCheckButton = new JButton("Check Coins!");
	private JButton rewardsRedemption = new JButton("Redeem Rewards!");
	private JButton tipsButtton = new JButton("Tips and Tricks!");
	private JButton recycleButton = new JButton("Recycle Settings");
	private JButton logOut = new JButton("Logout");
	

	
	public UserWindow(Person user) {
		
		this.currentUser = user;
		currentCoins = currentUser.getCoins();
		recycleInterest = currentUser.getRecycle();
		currentUsername = currentUser.getUsername();
		userPassword = currentUser.getPassword();
		 
		
		panel.setLayout(null);
		title.setBounds(235, 80, 250, 30);
		title.setText("Welcome, " + currentUsername + "!");
		
		dayCheckButton.setBounds(200, 150, 180, 30);
		dayCheckButton.setFocusable(false);
		dayCheckButton.addActionListener(this);
		
		coinCheckButton.setBounds(200, 200, 180, 30);
		coinCheckButton.setFocusable(false);
		coinCheckButton.addActionListener(this);
		
		rewardsRedemption.setBounds(200, 250, 180, 30);
		rewardsRedemption.setFocusable(false);
		rewardsRedemption.addActionListener(this);
		
		tipsButtton.setBounds(200, 300, 180, 30);
		tipsButtton.setFocusable(false);
		tipsButtton.addActionListener(this);
		
		recycleButton.setBounds(200, 350, 180, 30);
		recycleButton.setFocusable(false);
		recycleButton.addActionListener(this);
		
		logOut.setBounds(200, 400, 180, 30);
		logOut.setFocusable(false);
		logOut.addActionListener(this);
		
		frame.add(title);
		frame.add(dayCheckButton);
		frame.add(coinCheckButton);
		frame.add(rewardsRedemption);
		frame.add(tipsButtton);
		frame.add(recycleButton);
		frame.add(logOut);

		
		frame.setTitle("Track Your Trash!");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(600,750);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dayCheckButton) {
			frame.dispose();
			new CheckCollectionDayWindow(currentUser);			
		}
		
		else if(e.getSource() == coinCheckButton) {
			frame.dispose();
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			ArrayList <String> stringArray = u.getUserInfo();
			currentUser.setCoins(UserLogin.fetchReturnerCoins(stringArray, currentUsername,userPassword, currentCoins, recycleInterest));
			new CheckCoinWindow(currentUser);
		}
		
		else if(e.getSource() == rewardsRedemption) {
			frame.dispose();
			new RewardsWindow(currentUser);
		}
				
		else if(e.getSource() == tipsButtton) {
			frame.dispose();
			new TipsWindow(currentUser);
		}
		
		else if (e.getSource() == recycleButton) {
			frame.dispose();
			new ChooseRecycleWindow(currentUser);
			
		}
				
		else if(e.getSource() == logOut) {
			//store updated user data in file
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			File userFile = u.getUserFile();
			ArrayList <String> stringArray = u.getUserInfo();
			u.updateUserInfo(stringArray, currentUser.getUsername(), currentUser.getPassword(), currentUser.getCoins(), currentUser.getRecycle(), userFile);
			
			frame.dispose();
			new LaunchWindow();
		}

	}
}

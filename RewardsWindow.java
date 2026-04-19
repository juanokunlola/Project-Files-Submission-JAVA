package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The RewardsWindow.java class allows the user to trade their collected coins for different prizes. It checks first if the user has enough coins to redeem
 *  the reward, and either allows the user to input their email for follow up on their reward after checking to make sure it is a valid email, or tells the user
 *  they do not have enough coins for their purchase. Upon exiting the page, their new coin quantity is stored in the corresponding user info file.
 * Originates: UserWindow (rewardsRedemption)
 * Calls: UserLogin
 * Directs to: UserWindow
 * Contains: RewardsWindow, checkPurchase(int userCoins, int price), isValidEmail(String email), confirmRedemption(int price)
 * */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RewardsWindow implements ActionListener {

	private String currentUsername;
	private int currentCoins;
	private Person currentUser;
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel();
	private JButton redeemPrize1 = new JButton("1. $20 Amazon gift card (100 coins)");
	private JButton redeemPrize2 = new JButton("2. Spotify Premium for 6 months (200 coins)");
	private JButton redeemPrize3 = new JButton("3. Netflix for a year (500 coins)");
	private JButton redeemPrize4 = new JButton("4. New Apple/Samsung Watch (1000 points)");
	private JButton goBack = new JButton("Return");
	
	RewardsWindow(Person user){

		this.currentUser = user;
		currentUsername = currentUser.getUsername();
		currentCoins = currentUser.getCoins();
		
		
		title.setBounds(170, 75, 280, 25);
		title.setText("Welcome " + currentUsername + "! You have " + currentCoins + " coins.");
		redeemPrize1.setBounds(100, 150, 380, 30);
		redeemPrize1.setFocusable(false);
		redeemPrize1.addActionListener(this);
		
		redeemPrize2.setBounds(100, 200, 380, 30);
		redeemPrize2.setFocusable(false);
		redeemPrize2.addActionListener(this);
		
		redeemPrize3.setBounds(100, 250, 380, 30);
		redeemPrize3.setFocusable(false);
		redeemPrize3.addActionListener(this);
		
		redeemPrize4.setBounds(100, 300, 380, 30);
		redeemPrize4.setFocusable(false);
		redeemPrize4.addActionListener(this);
		

		goBack.setBounds(200, 400, 180, 30);
		goBack.setFocusable(false);
		goBack.addActionListener(this);
		
		frame.add(panel);
		frame.add(title);
		frame.add(redeemPrize1);
		frame.add(redeemPrize2);
		frame.add(redeemPrize3);
		frame.add(redeemPrize4);
		frame.add(goBack);
		
		frame.setTitle("Track Your Trash!");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(600,650);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
		
		
	}
	
	public boolean checkPurchase(int userCoins, int price) {
		boolean canPay = false;
		if(userCoins >= price) {
			canPay = true;
		}
		
		return canPay;
	}
	
	public static boolean isValidEmail(String email){
		if(!email.contains("@")) {
			return false;
		}
		if(!email.contains(".com") && !email.contains(".org")){
			return false;
        }
		return true;
	}
	
	public void confirmRedemption(int price) {
		if(checkPurchase(currentCoins, price)) {
			String email = JOptionPane.showInputDialog("Please enter your email. We will respond to you in time.");
			
			while(!isValidEmail(email)) {
				JOptionPane.showMessageDialog(null, "The email " + email + " is not valid. Please reenter.", "Invalid email.", 1);
				try{
					email = JOptionPane.showInputDialog("Please enter your email. We will respond to you in time.");
				}catch(NullPointerException e) {
				}
			}
			
			JOptionPane.showMessageDialog(null, "We will reach out to you at " + email, "Confirmation", 1);
			currentCoins = currentCoins - price;
		}
		else {
			JOptionPane.showMessageDialog(null, "You do not have enough points for this purchase", "Invalid Purchase", 1);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int price = 0;
		
		//The following Prize Redemption code was adapted from Cutter Williams' initial switch case rewards system.

		if (e.getSource() == redeemPrize1) {
			price = 100;
			confirmRedemption(price);
			title.setText("Welcome " + currentUsername + "! You have " + currentCoins + " coins.");
		}		
		else if(e.getSource() == redeemPrize2) {
			price = 200;
			confirmRedemption(price);
			title.setText("Welcome " + currentUsername + "! You have " + currentCoins + " coins.");
		}
		else if(e.getSource() == redeemPrize3) {
			price = 500;
			confirmRedemption(price);
			title.setText("Welcome " + currentUsername + "! You have " + currentCoins + " coins.");

		}	
		else if(e.getSource() == redeemPrize4) {
			price = 1000;
			confirmRedemption(price);
			title.setText("Welcome " + currentUsername + "! You have " + currentCoins + " coins.");
			
		}	
		else if(e.getSource() == goBack) {
			//Stores updated user data in file
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			File userFile = u.getUserFile();
			ArrayList <String> stringArray = u.getUserInfo();
			u.updateUserInfo(stringArray,  currentUsername, currentUser.getPassword(), currentCoins, currentUser.getRecycle(), userFile);
			
			frame.dispose();
			new UserWindow(currentUser);
		}
		
		
	}

}

package javaTrashTracker;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;


public class CheckCollectionDayWindow implements ActionListener {
	
	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;

	private JPanel panel = new JPanel();
	private JLabel response1 = new JLabel("Placeholder text");
	private JLabel response2 = new JLabel("Placeholder text");
	private JFrame frame = new JFrame();
	private JButton trashCollected = new JButton("Yes");
	private JButton notCollected = new JButton("No");
	private JButton accept = new JButton("Okay");

	
	
	private boolean collectedTrash = false;
	
	public CheckCollectionDayWindow(String username, String password, int coins, boolean recycler) {
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
		
		int cDayCheck = 0;
		
		panel.setLayout(null);
		trashCollected.setBounds(75, 150, 65, 30);
		trashCollected.setFocusable(false);
		trashCollected.addActionListener(this);
		notCollected.setBounds(175, 150, 65, 30);
		notCollected.setFocusable(false);
		notCollected.addActionListener(this);
		accept.setBounds(155, 150, 65, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);
		response1.setBounds(100, 50, 280, 25);
		response2.setBounds(100, 100, 280, 25);
		
		frame.add(panel);
		frame.add(response1);
		frame.add(response2);
		frame.setTitle("Track Your Trash!");
		frame.setSize(400,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
	
		CollectionDay c = new CollectionDay();
		cDayCheck = c.checkCollectionDay();
		
		
		if(cDayCheck == 1) {
			response1.setText("Trash is being collected today!");
			response2.setText("Have you taken out your trash today?");
			frame.add(trashCollected);
			frame.add(notCollected);
		}
		else if(cDayCheck == 2) {
			response1.setText("Trash is being collected tomorrow!");
			response2.setText("Don't forget to take out your trash!");
			frame.add(accept);
		}
		else if (cDayCheck == 3) {
			response1.setText("Trash is being collected on " + c.getPrintableCollectionDay() + ".");
			response2.setText("");
			frame.add(accept);

		}
		else {
			response1.setText("Trash is no longer being collected.");
			response2.setText("");
			frame.add(accept);
		}
		

			
	}
	

	
	public int getPaid() {
		int payment = 0;
		if(collectedTrash) {
			payment = payment +5;
		}
		
		return payment;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == trashCollected) {
			frame.dispose();
			collectedTrash = true;
			currentCoins = currentCoins + getPaid();
			
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			File userFile = u.getUserFile();
			ArrayList <String> stringArray = u.getUserInfo();
			u.updateUserInfo(stringArray, currentUser, userPassword, currentCoins, recycleInterest, userFile);
			
			
			if(recycleInterest) {
				new CheckRecycleDayWindow(currentUser, userPassword, currentCoins, recycleInterest);
			}
			else {
				new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
			}
		}
		
		else if (e.getSource() == notCollected || e.getSource() == accept) {
			frame.dispose();	
			if(recycleInterest) {
				new CheckRecycleDayWindow(currentUser, userPassword, currentCoins, recycleInterest);
			}
			else {
				new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
			}

		}
	}
	
	
	public boolean getCollectedTrash() {
		return collectedTrash;
	}
	
	

}

package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CheckRecycleDayWindow implements ActionListener {

	
	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;

	private JButton reyclingCollected = new JButton("Yes");
	private JButton notCollected = new JButton("No");
	private JButton accept = new JButton("Okay");
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel response1 = new JLabel();
	private JLabel response2 = new JLabel();
	
	private boolean collectedRecycling = false;
	
	public CheckRecycleDayWindow(String username, String password, int coins, boolean recycler) {
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
	
		int rDayCheck = 0;
		
		
		panel.setLayout(null);
		reyclingCollected.setBounds(75, 150, 65, 30);
		reyclingCollected.setFocusable(false);
		reyclingCollected.addActionListener(this);
		notCollected.setBounds(175, 150, 65, 30);
		notCollected.setFocusable(false);
		notCollected.addActionListener(this);
		accept.setBounds(155, 150, 65, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);
		response1.setBounds(100, 50, 280, 25);
		response2.setBounds(100, 100, 280, 25);
		

	
		CollectionDay c = new CollectionDay();
		rDayCheck = c.checkRecycleDay();
		

		frame.add(panel);
		frame.add(response1);
		frame.add(response2);
		frame.setTitle("Track Your Trash!");
		frame.setSize(400,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
		
		
		if(rDayCheck == 1) {
			response1.setText("Recyling is being collected today!");
			response2.setText("Have you taken out your recyclables today?");
			frame.add(reyclingCollected);
			frame.add(notCollected);
		}
		else if (rDayCheck == 2) {
			response1.setText("Recyling is being collected tomorrow!");
			response2.setText("Don't forget to take out your recyclables!");
			frame.add(accept);
		}
		else if(rDayCheck ==3) {
			response1.setText("Recyling is being collected on " + c.getPrintableRecycleDay() + ".");
			response2.setText("");
			frame.add(accept);
		}
		else {
			response1.setText("Recyling is no longer being collected.");
			response2.setText("");
			frame.add(accept);
		}
		
	
		
	}
	

	
	public int getPaid() {
		int payment = 0;
		if(collectedRecycling) {
			payment = payment +5;
		}
		
		return payment;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == reyclingCollected) {
			frame.dispose();
			collectedRecycling = true;
			currentCoins = currentCoins + getPaid();
			new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
		else if (e.getSource() == notCollected || e.getSource() == accept) {
			frame.dispose();	
			new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
		
	}
	
	
	public boolean getCollectedRecycling() {
		return collectedRecycling;
	}
	
	

}


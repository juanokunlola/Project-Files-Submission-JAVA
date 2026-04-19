package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The LaunchWindow.java class creates the GUI window for users initializing the program, allowing them to choose between logging in as a individual user,
 * 	a organization in charge of collection trash and/or recycling, and exiting the program entirely
 * Originates: TrashTrackerMain, OrgWindow, UserWindow
 * Directs to: UserLogin
 * Contains: LaunchWindow
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchWindow implements ActionListener {

	private JFrame frame = new JFrame();
	private JLabel lable = new JLabel("Welcome to Trash Tracker!");
	private JLabel subLable = new JLabel("Are you using this program as yourself, or on behalf of an organization?");
	private JButton userButton = new JButton("Individual");
	private JButton orgButton = new JButton("Organization");
	private JButton exitProgram = new JButton("Exit Program");
	private ImageIcon logo = new ImageIcon("TrashTrackerLogo.png");
	
	public LaunchWindow() {
		
		userButton.setBounds(125, 300, 150, 75);
		userButton.setFocusable(false);
		userButton.addActionListener(this);
		orgButton.setBounds(325, 300, 150, 75);
		orgButton.setFocusable(false);
		orgButton.addActionListener(this);
		exitProgram.setBounds(200, 500, 180, 30);
		exitProgram.setFocusable(false);
		exitProgram.addActionListener(this);
		
		lable.setBounds(215, 100, 600, 50);
		subLable.setBounds(85, 125, 600, 50);
		
		frame.add(lable);
		frame.add(subLable);
		frame.add(userButton);
		frame.add(orgButton);
		frame.add(exitProgram);
		
		frame.setTitle("Track Your Trash!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,750);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(new Color(215,238,237));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == userButton) {
			 
			 frame.dispose();
			 new UserLogin(true);
			 
	        } 
		 else if (e.getSource() == orgButton) {
			 frame.dispose();
			 new UserLogin(false);
	        }
		 
		 else if (e.getSource() == exitProgram) {
			 frame.dispose();
		 }

	}
		

	
}

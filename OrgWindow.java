package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrgWindow implements ActionListener{

	JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel();
	private JButton updateCollectionDay = new JButton("Update Trash Collection Day");
	private JButton updateRecycleDay = new JButton("Update Recycling Collection Day");
	private JButton logOut = new JButton("Logout");
	
	private String orgUser;
	private String orgPassword;
	
	public OrgWindow(String currentOrg, String currentPassword) {
		this.orgUser = currentOrg;
		this.orgPassword = currentPassword;
		
		
		panel.setLayout(null);
		title.setBounds(235, 80, 250, 30);
		title.setText("Welcome, " + currentOrg + "!");
		
		updateCollectionDay.setBounds(150, 150, 280, 30);
		updateCollectionDay.setFocusable(false);
		updateCollectionDay.addActionListener(this);
		
		updateRecycleDay.setBounds(150, 200, 280, 30);
		updateRecycleDay.setFocusable(false);
		updateRecycleDay.addActionListener(this);
		
		logOut.setBounds(200, 250, 180, 30);
		logOut.setFocusable(false);
		logOut.addActionListener(this);
		
		frame.add(title);
		frame.add(updateCollectionDay);
		frame.add(updateRecycleDay);
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
		if (e.getSource() == updateCollectionDay) {
			frame.dispose();
			new OrgInProgress(orgUser, orgPassword);
		}
		
		else if(e.getSource() == updateRecycleDay) {
			frame.dispose();
			new OrgInProgress(orgUser, orgPassword);
			
		}
		
		else if(e.getSource() == logOut) {
			//would update info
			
			frame.dispose();
			new LaunchWindow();
		}
		
	}

}

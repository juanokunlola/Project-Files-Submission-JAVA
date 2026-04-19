package javaTrashTracker;

/*
 * Author: Rachel Eddleman
 * Purpose: The OrgInProgress.java stands in for the methods that were unable to be implemented in time for the deadline, allowing the users to know of the delay
 *  in functionality, and future plans from the developer.
 * Originates: OrgWindow (updateCollectionDay), OrgWindow (updateRecycleDay)
 * Directs to: OrgWindow
 * Contains: OrgInProgress
 * */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrgInProgress implements ActionListener{

	private JButton accept = new JButton("Okay");
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel inProgressMessage1 = new JLabel("This utility for Organizations is still under construction.");
	private JLabel inProgressMessage2 = new JLabel("Please stay tuned for updates!");
	
	private Organization org;
	
	public OrgInProgress(Organization org) {
		this.org = org;
		
		panel.setLayout(null);
		accept.setBounds(155, 150, 65, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);
		inProgressMessage1.setBounds(30, 100, 350, 25);
		inProgressMessage2.setBounds(110, 120, 280, 25);
		
		frame.add(accept);
		frame.add(panel);
		frame.add(inProgressMessage1);
		frame.add(inProgressMessage2);
		frame.setTitle("Track Your Trash!");
		frame.setSize(400,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == accept) {
			frame.dispose();	
			new OrgWindow(org);
		}
	}
}

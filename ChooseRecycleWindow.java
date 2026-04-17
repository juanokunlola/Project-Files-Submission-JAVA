package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ChooseRecycleWindow implements ActionListener {

	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;
	
	private JButton accept = new JButton("Okay");
	private JCheckBox recycleCheck = new JCheckBox("I am interested!");
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Are you interested in recieving information about recycling days?");
	
	public ChooseRecycleWindow(String username, String password, int coins, boolean recycler) {
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
		
		panel.setLayout(null);
		accept.setBounds(205, 225, 65, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);
		label.setBounds(50, 75, 400, 25);
		recycleCheck.setBounds(150, 150, 200,30);
		recycleCheck.setFocusable(false);
		recycleCheck.setSelected(recycleInterest);
		recycleCheck.addActionListener(this);
		
		frame.add(recycleCheck);
		frame.add(panel);
		frame.add(accept);
		frame.add(label);
		frame.setTitle("Track Your Trash!");
		frame.setSize(500,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
		//
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == accept) {
			if(recycleCheck.isSelected()) {
				recycleInterest = true;
			}
			else {
				recycleInterest = false;
			}
			
			frame.dispose();	
			new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
	}

}

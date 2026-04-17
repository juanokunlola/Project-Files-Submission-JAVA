package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipsWindow implements ActionListener {
	
	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;
	
	private JPanel panel = new JPanel();
	private JLabel text = new JLabel("---Tips On Reducing Waste---");
	private JLabel tip1 = new JLabel("1. Use reusable shopping bags, water bottles, and travel mugs to avoid single-use plastics.");
	private JLabel tip2 = new JLabel("2. Buy in bulk, choose products with minimal packaging, and select items with recycled content.");
	private JLabel tip3 = new JLabel("3. Switch to paperless billing and digital receipts to reduce paper waste.");
	private JFrame frame = new JFrame();
	private JButton accept = new JButton("Return");

	TipsWindow(String username, String password, int coins, boolean recycler){
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
		
		panel.setLayout(null);
		text.setBounds(275, 50, 200, 25);
		tip1.setBounds(50, 100, 650, 25);
		tip2.setBounds(50, 125, 650, 25);
		tip3.setBounds(50, 150, 650, 25);
		
		
		accept.setBounds(305, 285, 80, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);

		
		frame.add(panel);
		frame.add(text);
		frame.add(text);
		frame.add(tip1);
		frame.add(tip2);
		frame.add(tip3);
		frame.add(accept);
		frame.setTitle("Track Your Trash!");
		frame.setSize(700,450);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(215,238,237));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == accept) {
			frame.dispose();
			new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
		
	}

}

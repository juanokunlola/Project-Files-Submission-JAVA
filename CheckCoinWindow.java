package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckCoinWindow implements ActionListener{
	
	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;
	
	private JButton accept = new JButton("Okay");
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel coinMessage = new JLabel("");
	
	public CheckCoinWindow(String username, String password, int coins, boolean recycler) {
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
		
		
		panel.setLayout(null);
		accept.setBounds(155, 150, 65, 30);
		accept.setFocusable(false);
		accept.addActionListener(this);
		coinMessage.setBounds(100, 100, 280, 25);
		coinMessage.setText("You have " + currentCoins + " coins!");
		
		frame.add(panel);
		frame.add(coinMessage);
		frame.add(accept);
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
			new UserWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
		
	}

}

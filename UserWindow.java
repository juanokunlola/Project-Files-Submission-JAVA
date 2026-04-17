package javaTrashTracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class UserWindow implements ActionListener{

	private String currentUser;
	private String userPassword;
	private int currentCoins;
	private boolean recycleInterest;
	private Person currentPerson;
	
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JLabel title = new JLabel();
	private JButton dayCheckButton = new JButton("Check Day!");
	private JButton coinCheckButton = new JButton("Check Coins!");
	private JButton gardenCheckButton = new JButton("Check Garden!");
	private JButton buyPlantButton = new JButton("Buy Plant!");
	private JButton recycleButton = new JButton("Recycle Settings");
	private JButton logOut = new JButton("Logout");
	

	
	public UserWindow(String username, String password, int coins, boolean recycler) {
		
		this.currentCoins = coins;
		this.recycleInterest = recycler;
		this.currentUser = username;
		this.userPassword = password;
		
		
		ArrayList <Plant> currentGarden = new ArrayList<>();
		currentPerson = new Person(username, password, coins, currentGarden, recycler);
		
		panel.setLayout(null);
		title.setBounds(235, 80, 250, 30);
		title.setText("Welcome, " + currentUser + "!");
		
		dayCheckButton.setBounds(200, 150, 180, 30);
		dayCheckButton.setFocusable(false);
		dayCheckButton.addActionListener(this);
		
		coinCheckButton.setBounds(200, 200, 180, 30);
		coinCheckButton.setFocusable(false);
		coinCheckButton.addActionListener(this);
		
		gardenCheckButton.setBounds(200, 250, 180, 30);
		gardenCheckButton.setFocusable(false);
		gardenCheckButton.addActionListener(this);
		
		buyPlantButton.setBounds(200, 300, 180, 30);
		buyPlantButton.setFocusable(false);
		buyPlantButton.addActionListener(this);
		
		recycleButton.setBounds(200, 350, 180, 30);
		recycleButton.setFocusable(false);
		recycleButton.addActionListener(this);
		
		logOut.setBounds(200, 400, 180, 30);
		logOut.setFocusable(false);
		logOut.addActionListener(this);
		
		frame.add(title);
		frame.add(dayCheckButton);
		frame.add(coinCheckButton);
		frame.add(gardenCheckButton);
		frame.add(buyPlantButton);
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
			new CheckCollectionDayWindow(currentUser, userPassword, currentCoins, recycleInterest);
			//System.out.println("coins: " + currentCoins);
			
		}
		
		else if(e.getSource() == coinCheckButton) {
			frame.dispose();
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			ArrayList <String> stringArray = u.getUserInfo();
			currentCoins = UserLogin.fetchReturnerCoins(stringArray, currentUser, userPassword, currentCoins, recycleInterest);
			//System.out.println("coincheckButton coins: " + currentCoins);
			new CheckCoinWindow(currentUser, userPassword, currentCoins, recycleInterest);
		}
		
		else if(e.getSource() == gardenCheckButton) {
			//
		}
				
		else if(e.getSource() == buyPlantButton) {
			//
		}
		
		else if (e.getSource() == recycleButton) {
			frame.dispose();
			new ChooseRecycleWindow(currentUser, userPassword, currentCoins, recycleInterest);
			
		}
				
		else if(e.getSource() == logOut) {
			//since gardens cannot be maintained, progress is converted back into coins
			currentPerson.setCoins(currentPerson.getCoins() + currentPerson.countPlantType("Tree") + currentPerson.countPlantType("Flower"));
			currentCoins = currentPerson.getCoins();
			
			//store updated user data in file
			UserLogin u = new UserLogin(true);
			u.getFrame().dispose();
			File userFile = u.getUserFile();
			ArrayList <String> stringArray = u.getUserInfo();
			u.updateUserInfo(stringArray, currentUser, userPassword, currentCoins, recycleInterest, userFile);
			
			frame.dispose();
			new LaunchWindow();
		}
			
				
		//String gardenName = JOptionPane.showInputDialog("What would you like to name your garden?");
	}

	
	public void buyPlant(int coins, ArrayList <Plant> garden) { 
		//
	}
	
	public void recycleTip() {
		//
	}

	public boolean getRecycleInterest() {
		return recycleInterest;
	}
}

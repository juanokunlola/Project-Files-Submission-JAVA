package javaTrashTracker;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserSignUp implements ActionListener {

	private JPanel panel = new JPanel();
	private JLabel signUp = new JLabel("Sign up with a username and password!");
	private JLabel userLable = new JLabel("Enter Username");
	private JLabel passLable = new JLabel("Enter Password");
	private JLabel successMessage = new JLabel();
	private JLabel failureMessage1 = new JLabel();
	private JLabel failureMessage2 = new JLabel();
	private Frame frame = new JFrame();
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton backButton = new JButton("Return");
	private JButton userEnter = new JButton("Submit");
	
	private boolean userType;
	
	public UserSignUp(boolean userType) {
		this.userType = userType;
		
		panel.setLayout(null);
		signUp.setBounds(65, 65, 275, 25);
		userLable.setBounds(10, 100, 180, 25);
		passLable.setBounds(10, 150, 180, 25);
		username.setBounds(150, 100, 195, 25);
		password.setBounds(150, 150, 195, 25);
		userEnter.setBounds(150, 235, 80, 30);
		userEnter.setFocusable(false);
		userEnter.addActionListener(this);
		backButton.setBounds(5, 20, 80, 25);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		successMessage.setBounds(100, 215, 200, 25);
		failureMessage1.setBounds(50, 175, 275, 25);
		failureMessage2.setBounds(25, 190, 355, 25);
		frame.add(successMessage);
		frame.add(failureMessage1);
		frame.add(failureMessage2);

		
		frame.add(panel);
		frame.add(backButton);
		frame.add(userLable);
		frame.add(passLable);
		frame.add(signUp);
		frame.add(username);
		frame.add(password);
		frame.add(userEnter);
		frame.setTitle("Track Your Trash!");
		((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,350);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		((JFrame) frame).getContentPane().setBackground(new Color(215,238,237));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == userEnter) {
			String newUser = username.getText();
			String newPassword = new String(password.getPassword());
			
			if(isPasswordStrong(newPassword)) {
				successMessage.setText("Welcome to Trash Tracker!");
				failureMessage1.setText("");
				failureMessage2.setText("");
				
				UserLogin u = new UserLogin(userType);
				u.getFrame().dispose();
				ArrayList <String> logIns = u.getLoginInfo();
				System.out.println("out of class gotten:" +logIns);
				File logInFile = u.getLoginFile();
				u.newLogIn(logIns, newUser, newPassword, userType, logInFile);
				System.out.println(logIns);
			}
			else {
				successMessage.setText("");
				failureMessage1.setText("Your password is not strong enough.");
				failureMessage2.setText("Please include a symbol, number, and uppercase letter.");
			}
			
		}
		else if (e.getSource() == backButton) {
			frame.dispose();
			new LaunchWindow();
		}
		
	}
	
	public static boolean isPasswordStrong(String password){
		boolean symbol = false;
		boolean cap = false;
		boolean digit = false;
		
		if(password.length() < 8) {
			return false;
		}
		for(int i = 0; i < password.length(); i++) {
			if(!Character.isLetterOrDigit(password.charAt(i))) {
				symbol = true;
			}
			if(Character.isUpperCase(password.charAt(i))) {
				cap = true;
			}
			if(Character.isDigit(password.charAt(i))) {
				digit = true;
			}
		}
		if(symbol == true && cap == true && digit == true) {
			return true;
		}
		else
			return false;
	}

}

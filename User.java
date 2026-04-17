package javaTrashTracker;

public class User {

	private String userName;
	private String password;
	
	public User(String user, String password) {
		this.userName = user;
		this.password = password;
	}
	
	public String getUsername() {
		return this.userName;
	}
	
	public void setUsername(String user) {
		this.userName = user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

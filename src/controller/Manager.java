package controller;

public class Manager {
	private static final Manager INSTANCE = new Manager();
	
	private Manager() {
		
	}
	
	public static Manager getInstance() {
		return INSTANCE;
	}
	
	
	public void registerPlayer(String pUser, String pPassword) throws Exception {
		if (pUser.length() > 60) {
			throw new Exception("User length is greater than 60 characters");
		}
		if (pPassword.length() > 8) {
			throw new Exception("Password can't be greater than 8 characters");
		}
		char []user = pUser.toCharArray();
		char []password = pPassword.toCharArray();
	}
	
	public void loginPlayer(String pUser, String pPassword) throws Exception {
		if (pUser.length() > 60) {
			throw new Exception("User length is greater than 60 characters");
		}
		if (pPassword.length() > 8) {
			throw new Exception("Password can't be greater than 8 characters");
		}
		char []user = pUser.toCharArray();
		char []password = pPassword.toCharArray();
	}
}

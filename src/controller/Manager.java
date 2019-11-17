package controller;

public class Manager {
	private static final Manager INSTANCE = new Manager();
	
	private Manager() {
		
	}
	
	public static Manager getInstance() {
		return INSTANCE;
	}
}

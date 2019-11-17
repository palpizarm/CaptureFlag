package controller;

import java.util.ArrayList;

import model.Obstacle;

public class Manager {
	private static final Manager INSTANCE = new Manager();
	private JsonLoader jsonHandler;
	
	private Manager() {
		jsonHandler = new JsonLoader();
		createMap();
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
	
	private void createMap() {
		try {
			//ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>(jsonHandler.getObstacles("mapa1.json"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
	}
}

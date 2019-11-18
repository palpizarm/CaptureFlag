package controller;

import java.util.ArrayList;
import java.util.Observable;

import commons.IContants;
import model.Obstacle;

@SuppressWarnings("deprecation")
public class Manager extends Observable implements IContants {
	private static final Manager INSTANCE = new Manager();
	private JsonLoader jsonHandler;
	private int [][] map = null;
	
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
	
	@SuppressWarnings("null")
	private void createMap() {
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		int raw = (int)Math.floor(WIDTH_APP/RADIO_POINT);
		int column = (int)Math.floor(HEIGHT_APP/RADIO_POINT);
		try {
			//obstacles = jsonHandler.getObstacles("mapa1.json");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		startMap(raw, column);
		raw = 0;
		column = 0;
		for (int obsIndex = 0; obsIndex < obstacles.size(); obsIndex++) {
			Obstacle obs = obstacles.get(obsIndex);
			// Get the raw to start and raw where stop
			int firstRaw = Math.round(obs.getX()/RADIO_POINT);
			int lastRaw = firstRaw + (int)Math.ceil(obs.getWidth()/RADIO_POINT); 
			for (raw = firstRaw; raw < lastRaw; raw++) {
				// Get the column to start and where stop
				int firstColumn = Math.round(obs.getY()/RADIO_POINT);
				int lastColumn = firstColumn + Math.round(obs.getHeight()/RADIO_POINT);
				for (column = firstColumn; column < lastColumn; column++) {
					map[raw][column] = OBSTACLE;
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	private void startMap(int pRaw, int pColumn) {
		map = new int[pRaw][pColumn];
		// to set all cell like a EMPTY
		// Default value
		for (int raw = 0; raw < pRaw; raw++) {
			for (int column = 0; column < pColumn; column++) {
				map[raw][column] = EMPTY;
			}
		}
	}
}

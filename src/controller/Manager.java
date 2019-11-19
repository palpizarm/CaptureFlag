package controller;

import java.util.ArrayList;
import java.util.Observable;

import commons.IContants;
import model.Obstacle;

@SuppressWarnings("deprecation")
public class Manager extends Observable implements IContants {
	private static final Manager INSTANCE = new Manager();
	private JsonLoader jsonHandler = null;
	private BinaryFileHandler binFileHandler = null;
	
	private int [][] map = null;
	
	private Manager() {
		jsonHandler = new JsonLoader();
		try {
			binFileHandler = new BinaryFileHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		createMap();
	}
	
	public static Manager getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Register the new user
	 * @param pUser
	 * @param pPassword
	 * @throws Exception
	 */
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
	
	/**
	 * To login exist player
	 * @param pUser
	 * @param pPassword
	 * @throws Exception
	 */
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
	
	/**
	 * Create the game map from obstacle 
	 */
	private void createMap() {
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		try {
			obstacles = jsonHandler.getObstacles("mapa1.json");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		startMap(MAP_ROW, MAP_COLUMN);
		for (int obsIndex = 0; obsIndex < obstacles.size(); obsIndex++) {
			Obstacle obs = obstacles.get(obsIndex);
			// Get the raw to start and raw where stop
			int firstRow = Math.round(obs.getX()/RADIO_POINT);
			int lastRow = firstRow + (int)Math.ceil(obs.getWidth()/RADIO_POINT); 
			for (int raw = firstRow; raw < lastRow; raw++) {
				// Get the column to start and where stop
				int firstColumn = Math.round(obs.getY()/RADIO_POINT);
				int lastColumn = firstColumn + Math.round(obs.getHeight()/RADIO_POINT);
				for (int column = firstColumn; column < lastColumn; column++) {
					map[raw][column] = OBSTACLE;
				}
			}
		}
		this.setChanged();
		this.notifyObservers(map);
	}
	
	private void startMap(int pRow, int pColumn) {
		map = new int[pRow][pColumn];
		// to set all cell like a EMPTY
		// Default value
		for (int raw = 0; raw < pRow; raw++) {
			for (int column = 0; column < pColumn; column++) {
				map[raw][column] = EMPTY;
			}
		}
	}
}

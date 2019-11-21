package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commons.IContants;
import model.Obstacle;
import model.Player;

@SuppressWarnings("deprecation")
public class Manager extends Observable implements IContants {
	private static final Manager INSTANCE = new Manager();
	private JsonLoader jsonHandler = null;
	private BinaryFileHandler binFileHandler = null;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	
	private int [][] map = null;
	
	private Manager() {
		jsonHandler = new JsonLoader();
		try {
			binFileHandler = new BinaryFileHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		createMap();
		binFileHandler.sort();
	}
	
	public static Manager getInstance() {
		return INSTANCE;
	}
	
	
	public void addObserver(Observer object) {
		super.addObserver(object);
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
		if (pPassword.length() != 8) {
			throw new Exception("Password should be of 8 characters");
		}
		char []user = pUser.toCharArray();
		char []password = pPassword.toCharArray();
		Player player = new Player(user, password);
		if (binFileHandler.search(user) == null) {
			binFileHandler.write(player);
		} else {
			throw new Exception("User unvaliad(try again)");
		}
	}
	
	/**
	 * Validate Email
	 * @param pMail
	 * @return boolean
	 */
	public boolean validateEmail(String pMail){
		// Patrón para validar el email
	    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    // El email a validar
	    String mail = pMail;
	
	    Matcher mather = pattern.matcher(mail);
	
	    if (mather.find() == true) {
	    	//El email ingresado es válido.
	    	return true;
	        
	    } else {
	    	//El email ingresado es inválido.
	    	return false;
	       
	    }
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
		if (pPassword.length() == 8) {
			throw new Exception("Password can't be greater than 8 characters");
		}
		Player player = null;
		char []user = pUser.toCharArray();
		char []password = pPassword.toCharArray();
		if ((player = binFileHandler.search(user)) != null) {
			
		}
		throw new Exception("Don't find the user");
	}
	
	/**
	 * Create the game map from obstacle 
	 */
	private void createMap() {
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
			for (int row = firstRow; row <= lastRow; row++) {
				// Get the column to start and where stop
				int firstColumn = Math.round(obs.getY()/RADIO_POINT);
				int lastColumn = firstColumn + Math.round(obs.getHeight()/RADIO_POINT);
				for (int column = firstColumn; column <= lastColumn; column++) {
					if (row < MAP_ROW && column < MAP_COLUMN)
						map[row][column] = OBSTACLE;
				}
			}
		}
	}
	
	public void updateMap() {
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
	
	public static void main(String[] args) {
		Manager manager = Manager.getInstance();
		try {
			manager.registerPlayer("pabloalpizar99@gmail.com", "12345678");
			manager.registerPlayer("pmonge1999@hotmail.com", "87654321");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

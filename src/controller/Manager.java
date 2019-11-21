package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commons.IContants;
import model.Graph;
import model.Obstacle;
import model.Player;
import model.Point;
import model.Node;

@SuppressWarnings("deprecation")
public class Manager extends Observable implements IContants {
	private static final Manager INSTANCE = new Manager();
	private JsonLoader jsonHandler = null;
	private BinaryFileHandler binFileHandler = null;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Graph<Point> graphLeftToRigth = null;
	private Graph<Point> graphRigthToLeft = null;
	private boolean userLogin = false;
	
	private int [][] map = null;
	
	private Manager() {
		jsonHandler = new JsonLoader();
		graphLeftToRigth = new Graph<Point>();
		graphRigthToLeft = new Graph<Point>();
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
	
	
	public void addObserver(Observer object) {
		super.addObserver(object);
	}

	
	public boolean getUserLogin() {
		return userLogin;
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
		this.setChanged();
		this.notifyObservers(1); // 1 is to know if a user is login
		userLogin = true;
		binFileHandler.sort();
	}
	
	/**
	 * Validate Email
	 * @param pMail
	 * @return boolean
	 */
	public boolean validateEmail(String pMail){
		// To validate email
	    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    String mail = pMail;
	    Matcher mather = pattern.matcher(mail);
	    if (mather.find() == true)
	    	return true;
	    return false;
	}
	
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
		if (pPassword.length() != 8) {
			throw new Exception("Password can't be greater than 8 characters");
		}
		Player player = null;

		char []user = pUser.toCharArray();
		char []password = pPassword.toCharArray();
		if ((player = binFileHandler.search(user)) != null) {
			userLogin = true;
			this.setChanged();
			this.notifyObservers(1);

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
	
	private ArrayList<ArrayList<Node<Point>>> getVertex() {
		ArrayList<ArrayList<Node<Point>>> vertex = new ArrayList<ArrayList<Node<Point>>>();
		for (int row = 0; row < MAP_ROW; row++) {
			for (int column = 0; column < MAP_COLUMN; column++) {
				Point point = new Point(row*RADIO_POINT, column*RADIO_POINT,RADIO_POINT); 
				Node<Point> current = graphLeftToRigth.addNode(point);
				graphRigthToLeft.addNode(point);
				vertex.get(row).add(current);
				}
			}
		return vertex;
	}
	
	/**
	 * To create the both graph, left to right and right to left  
	 */
	private void addEdgeToGraphs() {
		ArrayList<ArrayList<Node<Point>>> mapVertex = getVertex();
		for (int indexRow = 0; indexRow < MAP_ROW; indexRow++) {
			for (int indexColumn = 0; indexColumn < MAP_ROW; indexColumn++) {
				// GrpahLeftToRight
				graphLeftToRigth.addArc(mapVertex.get(indexRow).get(indexColumn),mapVertex.get(indexRow).get(indexColumn+1), 1);
				if (indexRow != 0 && map[indexRow-1][indexColumn] != OBSTACLE) {	
					graphLeftToRigth.addArc(mapVertex.get(indexRow).get(indexColumn),mapVertex.get(indexRow-1).get(indexColumn), 1);
				}
				if (indexRow != MAP_ROW-1 && map[indexRow+1][indexColumn] != OBSTACLE) {
					graphLeftToRigth.addArc(mapVertex.get(indexRow).get(indexColumn),mapVertex.get(indexRow+1).get(indexColumn), 1);
				}
				//GraphRigthToLeft
				graphRigthToLeft.addArc(mapVertex.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1),mapVertex.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-2), 1);
				if (indexRow != 0 && map[indexRow-1][indexColumn] != OBSTACLE) {	
					graphRigthToLeft.addArc(mapVertex.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1),mapVertex.get(MAP_ROW-indexRow-2).get(MAP_COLUMN-indexColumn-1), 1);
				}
				if (indexRow != MAP_ROW-1 && map[indexRow+1][indexColumn] != OBSTACLE) {
					graphRigthToLeft.addArc(mapVertex.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1),mapVertex.get(MAP_ROW - indexRow).get(MAP_COLUMN-indexColumn-1), 1);
				}
			}
		}
	}
	
	
	public void getGameAdjusments() {
		
	}
}

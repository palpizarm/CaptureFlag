package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import commons.IContants;
import model.Dijkstra;
import model.Floyd;
import model.Graph;
import model.MinimunSpanningTree;
import model.Obstacle;
import model.Player;
import model.Point;
import model.algorithmPath;
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
	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<ArrayList<Node<Point>>> vertexLeftToRight = null;
	private ArrayList<ArrayList<Node<Point>>> vertexRightToLeft = null;	
	private int [][] map = null;
	private algorithmPath<Point> floyd = null;
	private algorithmPath<Point> MST = null;
	private algorithmPath<Point> dijkstra = null;
	
	private Manager() {
		jsonHandler = new JsonLoader();
		graphLeftToRigth = new Graph<Point>();
		graphRigthToLeft = new Graph<Point>();
		floyd = new Floyd<Point>();
		MST = new MinimunSpanningTree<Point>();
		dijkstra = new Dijkstra<Point>();
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
			vertex.add(new ArrayList<Node<Point>>());
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
		vertexLeftToRight = getVertex();
		vertexRightToLeft = getVertex();
		for (int indexRow = 0; indexRow < MAP_ROW; indexRow++) {
			for (int indexColumn = 0; indexColumn < MAP_COLUMN; indexColumn++) {
				// GrpahLeftToRight
				if (indexColumn != MAP_COLUMN -1)
					graphLeftToRigth.addArc(vertexLeftToRight.get(indexRow).get(indexColumn),vertexLeftToRight.get(indexRow).get(indexColumn+1), 1);
				if (indexRow != 0 && map[indexRow-1][indexColumn] != OBSTACLE) {	
					graphLeftToRigth.addArc(vertexLeftToRight.get(indexRow).get(indexColumn),vertexLeftToRight.get(indexRow-1).get(indexColumn), 1);
				}
				if (indexRow != MAP_ROW-1 && map[indexRow+1][indexColumn] != OBSTACLE) {
					graphLeftToRigth.addArc(vertexLeftToRight.get(indexRow).get(indexColumn),vertexLeftToRight.get(indexRow+1).get(indexColumn), 1);
				}
				//GraphRigthToLeft
				if (indexColumn != MAP_COLUMN-1)
					graphRigthToLeft.addArc(vertexRightToLeft.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1),vertexRightToLeft.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-2), 1);
				if (indexRow != 0 && map[indexRow-1][indexColumn] != OBSTACLE) {	
					graphRigthToLeft.addArc(vertexRightToLeft.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1),vertexRightToLeft.get(MAP_ROW-indexRow-1).get(MAP_COLUMN-indexColumn-1), 1);
				}
				if (indexRow != MAP_ROW-1 && map[indexRow+1][indexColumn] != OBSTACLE) {
					graphRigthToLeft.addArc(vertexRightToLeft.get((MAP_ROW-1) - indexRow).get((MAP_COLUMN-1)-indexColumn),vertexRightToLeft.get(MAP_ROW - indexRow-1).get(MAP_COLUMN-indexColumn-1), 1);
				}
			}
		}
	}


	public void getGameAdjusments(Team pTeam1,Team pTeam2, Team pTeam3, ArrayList<Integer> destinys) {
		addEdgeToGraphs();
		Node<Point> origin = vertexLeftToRight.get(MAP_ROW/2).get(0);  
		ArrayList<Node<Point>> dest = new ArrayList<Node<Point>>();
		for(int destTeam = 0 ; destTeam < destinys.size(); destTeam++) {
			if(destinys.get(destTeam) == UPPERCORNER) {
				dest.add(vertexLeftToRight.get(0).get(MAP_COLUMN-1));
			}else if(destinys.get(destTeam) == CENTER) {
				dest.add(vertexLeftToRight.get(MAP_ROW/2).get(MAP_COLUMN/2));
			}else if(destinys.get(destTeam) == LOWERCORNER) {
				dest.add(vertexLeftToRight.get(MAP_ROW-1).get(MAP_COLUMN-1));
			}
		}
		try {
			floyd.setOrigin(origin);
			dijkstra.setOrigin(origin);
			MST.setOrigin(origin);
			floyd.findPath(graphLeftToRigth);
			dijkstra.findPath(graphLeftToRigth);
			MST.findPath(graphLeftToRigth);
			pTeam1.setPath(floyd.getPathTo(dest.get(0)));
			pTeam2.setPath(dijkstra.getPathTo(dest.get(1)));
			pTeam3.setPath(MST.getPathTo(dest.get(2)));
		} catch (Exception e) {						// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teams.add(pTeam1);
		teams.add(pTeam2);
		teams.add(pTeam3);
		this.setChanged();
		this.notifyObservers(2);
		this.setChanged();
		this.notifyObservers(teams);
	}
}

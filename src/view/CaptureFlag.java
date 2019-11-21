package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.Team;
import commons.IContants;
import controller.Manager;

@SuppressWarnings("deprecation")
public class CaptureFlag extends JFrame implements IContants, Observer{
	private static final long serialVersionUID = 1L;

	private Manager manager = null;
	private BufferedImage bg_image = null;
	private BufferedImage obstacle_image = null;
	private BufferedImage marine_image = null;
	private BufferedImage walloper_image = null;
	private BufferedImage archer_image = null;
	private JMenuBar menu = null;
	

	public CaptureFlag() {
		super("Capture Flag(Application)");
		manager = Manager.getInstance();
		manager.addObserver(this);
		loadImage();
		
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setLocation(X_APP, Y_APP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		initComponents();
	}
	
	public CaptureFlag(Team pTeam1,Team pTeam2, Team pTeam3, int destTeam1, int destTeam2, int destTeam3) {
		super("Capture Flag(Application)");
		manager = Manager.getInstance();
		manager.addObserver(this);
		loadImage();
		
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setLocation(X_APP, Y_APP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		initComponents();
	}
	
	private void initComponents() {
		this.menu = new JMenuBar();
		JMenuItem item1 = new JMenuItem("Show stats");
		this.menu.add(item1);
		this.setJMenuBar(this.menu);
		
	}
	
	
	private void loadImage() {
		try {
			bg_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("images\\background.bmp"));
			obstacle_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("\\images\\obstacle.png"));
			archer_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("\\images\\archer.png"));
			marine_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("images\\marine.png"));
			walloper_image = ImageIO.read(CaptureFlag.class.getResourceAsStream("images\\walloper.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int chooseX(int pX) {
		return new Random().nextInt(((pX + RADIO_POINT) - pX) + 1) + pX;
	}
	
	private int chooseY(int pY) {
		return new Random().nextInt(((pY + RADIO_POINT) - pY) + 1) + pY;
	}
	
	public void setVisible(boolean pVisible) {
		super.setVisible(pVisible);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bg_image,X_BG_MAP,Y_BG_MAP,WIDTH_APP,HEIGHT_APP,null);
		manager.updateMap();
	}

	@Override
	public void update(Observable caller, Object update) {
		if (update instanceof int[][]) {
			int map[][] = (int[][]) update;			
			Graphics g = (Graphics)super.getGraphics();
			//g.drawImage(bg_image,X_BG_MAP,Y_BG_MAP,WIDTH_APP,HEIGHT_APP,null);
			for (int row = 0; row < MAP_ROW; row++) {
				for (int column = 0; column < MAP_COLUMN; column++) {
					if (map[row][column] == OBSTACLE) {
						g.drawImage(obstacle_image, row*RADIO_POINT, column*RADIO_POINT,RADIO_POINT,RADIO_POINT,null);
					} else {
						//g.drawImage(walloper_image, chooseX(row*RADIO_POINT), chooseY(column*RADIO_POINT),RADIO_WARRIOR,RADIO_WARRIOR,null);
					}
				}
			}
			
		}
	}
}

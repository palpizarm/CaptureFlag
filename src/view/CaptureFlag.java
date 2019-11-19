package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

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
	

	public CaptureFlag() {
		super("Capture Flag(Application)");
		manager = Manager.getInstance();
		manager.addObserver(this);
		loadImage();
		
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setLocation(X_APP, Y_APP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
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
	
	public void setVisible(boolean pVisible) {
		super.setVisible(pVisible);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bg_image,X_APP,Y_APP,WIDTH_APP,HEIGHT_APP,null);
	}

	@Override
	public void update(Observable caller, Object update) {
		if (update instanceof int[][]) {
			int map[][] = (int[][]) update;
			Graphics g = this.getGraphics();
			for (int row = 0; row < MAP_ROW; row++) {
				for (int column = 0; column < MAP_COLUMN; column++) {
					if (map[row][column] == OBSTACLE) {
						g.drawImage(obstacle_image, row*RADIO_POINT, column*RADIO_POINT,RADIO_POINT,RADIO_POINT,null);
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		CaptureFlag application = new CaptureFlag();
		application.setVisible(true);
	}

}

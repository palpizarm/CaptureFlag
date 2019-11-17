package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import commons.IContants;
import controller.Manager;


public class CaptureFlag extends JFrame implements IContants{
	private static final long serialVersionUID = 1L;

	private Manager manger = null;
	private BufferedImage bg_image = null;
	private BufferedImage obstacle_image = null;
	private BufferedImage marine_image = null;
	private BufferedImage walloper_image = null;
	private BufferedImage archer_image = null;
	
	public CaptureFlag() {
		super("Capture Flag(Application)");
		manger = Manager.getInstance();
		loadImage();
		
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setLocation(X_APP, Y_APP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	
	private void loadImage() {
		try {
			bg_image = ImageIO.read(new File("C:\\Users\\sande\\Documents\\GitHub\\CaptureFlag\\images\\background.bmp"));
			obstacle_image = ImageIO.read(new File("C:\\Users\\sande\\Documents\\GitHub\\CaptureFlag\\images\\obstacle.png"));
			archer_image = ImageIO.read(new File("C:\\Users\\sande\\Documents\\GitHub\\CaptureFlag\\images\\archer.png"));
			marine_image = ImageIO.read(new File("C:\\Users\\sande\\Documents\\GitHub\\CaptureFlag\\images\\marine.png"));
			walloper_image = ImageIO.read(new File("C:\\Users\\sande\\Documents\\GitHub\\CaptureFlag\\images\\walloper.png"));
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
	
	public static void main(String[] args) {
		CaptureFlag application = new CaptureFlag();
		application.setVisible(true);
	}

}

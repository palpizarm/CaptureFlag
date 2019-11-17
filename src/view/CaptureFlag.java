package view;

import javax.swing.JFrame;

import commons.IContants;
import controller.Manager;


public class CaptureFlag extends JFrame implements IContants{
	private static final long serialVersionUID = 1L;

	private Manager manger = null;
	
	public CaptureFlag() {
		super("Capture Flag(Application)");
		manger = Manager.getInstance();
		
		this.setSize(WIDTH_APP, HEIGHT_APP);
		this.setLocation(X_APP, Y_APP);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	
	public void setVisible(boolean pVisible) {
		super.setVisible(pVisible);
	}
	
	public static void main(String[] args) {
		CaptureFlag application = new CaptureFlag();
		application.setVisible(true);
	}

}

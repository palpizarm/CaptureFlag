package commons;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface IContants {
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int WIDTH_APP = (int)screenSize.getWidth();
	public int HEIGHT_APP = (int)screenSize.getHeight()-20;
	public int X_APP = 0;
	public int Y_APP = 0;
	
	public int AUX_FILES = 6;
	
	public int ENERGEY = 100;
	
	public int WALLOPER_ATTACK = 80;
	public int ARCHER_ATTACK = 20;
	public int MARINE_ATTACK = 40;
	
	public float WALLOPER_ATTACK_DELAY = (float)2;
	public float ARCHER_ATTACK_DELAY = (float)1;
	public float MARINE_ATTACK_DELAY =  (float)1.5;
	
	
	public int RADIO_POINT = 30;
}

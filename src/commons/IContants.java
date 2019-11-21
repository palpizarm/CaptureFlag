package commons;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface IContants {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int WIDTH_APP = 1080;
	public int HEIGHT_APP = 710;
	public int X_APP = (int)(screenSize.getWidth()*0.5 - (WIDTH_APP*0.5));
	public int Y_APP = 0;
	public int X_BG_MAP = 0;
	public int Y_BG_MAP = 0;
	
	public int WIDTH_SETTING = 720;
	public int HEIGHT_SETTING = 720;
	public int X_SETTING = (int)(screenSize.getWidth()*0.5 - (WIDTH_SETTING*0.5));
	public int Y_SETTING = 0;
	
	public int AUX_FILES = 4;
	
	public int ENERGEY = 100;
	
	public int WALLOPER_ATTACK = 80;
	public int ARCHER_ATTACK = 20;
	public int MARINE_ATTACK = 40;
	
	public float WALLOPER_ATTACK_DELAY = (float)2;
	public float ARCHER_ATTACK_DELAY = (float)1;
	public float MARINE_ATTACK_DELAY =  (float)1.5;
	

	public int RADIO_POINT = 40;
	public int RADIO_WARRIOR = 20;
	public int OBSTACLE = 0;
	public int EMPTY = 1;
	public final static int PASSWORD_LENGTH = 8;
	public final static int EMAIL_LENGTH = 60;
	
	
	public int MAP_ROW = (int)Math.floor(WIDTH_APP/(RADIO_POINT));
	public int MAP_COLUMN = (int)Math.floor(HEIGHT_APP/(RADIO_POINT));
	
	
	public int ARCHER_SETTING_X = (int)(WIDTH_SETTING*0.3);
	public int WARRIOR_SETTING_Y = 100;
	public int MARINE_SETTING_X = (int)(WIDTH_SETTING*0.5);
	public int WALLOPER_SETTING_X = (int)(WIDTH_SETTING*0.7);

	
	public int BTREADY_SETTING_X = (int)(WIDTH_SETTING*0.7);
	public int BTREADY_SETTING_Y = (int)(HEIGHT_SETTING*0.8);
	public int BT_WIDTH = 100;
	public int BT_HEIGHT = 50;
	
	public int TEXTFIELD_WIDTH = 100;
	public int TEXTFIELD_HEIGHT = 50;
	
	public int USER_SIZE = 60;
	public int PASSW_SIZE = 8;
	
	public int TEAM1 = 1;
	public int TEAM2 = 2;
	public int TEAM3 = 3;
	
	public String OPTIONS_TEAM[] = {"TEAM 1", "TEAM 2", "TEAM 3"};
}

package test;


import controller.Manager;
import view.CaptureFlag;
import view.Login;
import view.StartGame;

public class Test {
	

	
	public static void main(String[] args) {
		Manager manager = Manager.getInstance();
		
		Login login = new Login();
		CaptureFlag gameView = new CaptureFlag();
		StartGame settingGame = new StartGame();
		
		login.setVisible(true);;
		
		}		
}

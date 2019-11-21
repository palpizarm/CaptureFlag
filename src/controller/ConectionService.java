package controller;

import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ConectionService implements Observer{
	Server server = null;
	
	public ConectionService() {
		try {
			server = new Server(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	public static void main(String[] args) {
		ConectionService service = new ConectionService();
	}
}

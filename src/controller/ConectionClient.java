package controller;

public class ConectionClient {
	SocketPlayer player = null;
	String ipServer = "192.168.100.4";
	
	public ConectionClient() {
		player = new SocketPlayer(ipServer);
	}
	
	public static void main(String[] args) {
		ConectionClient client = new ConectionClient();
	}
}

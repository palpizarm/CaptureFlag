package model;

<<<<<<< HEAD
public class Player {
	private char user[];
	private char password[];
	private int score;
=======
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable, Comparable<Player>{
	private static final long serialVersionUID = 1L;
	char user[]= null;
	char password[] = null;
	int score = 0;
>>>>>>> externalSort
	
	public Player (char[] pUser, char[] Ppassword) {
		user = pUser;
		password = Ppassword;
	}
	
	public char[]  getUser() {
		return this.user;
	}
	
	public char[] getPassword() {
		return this.password;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int pScore) {
		this.score = pScore;
	}
	
	public static void main(String args[]) {
		Player p = new Player("hola555".toCharArray(), "hola".toCharArray());
		Player p2 = new Player("hola555".toCharArray(), "hola".toCharArray());
		Player p3 = new Player("hola666".toCharArray(), "hola".toCharArray());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
		  out = new ObjectOutputStream(bos);   
		  //out.writeObject(null);
		  out.flush();
		  
		  
		  bos.reset();
		  out.writeObject(p);
		  out.flush();
		  System.out.println(bos.toByteArray().length);

		  bos.reset();
		  out.writeObject(p2);
		  out.flush();
		  System.out.println(bos.toByteArray().length);
		  
		  bos.reset();
		  out.writeObject(p3);
		  out.flush();
		  System.out.println(bos.toByteArray().length);

		  
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public int compareTo(Player pPlayer) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.user);
		String user1 = stringBuilder.toString();
		stringBuilder.delete(0,stringBuilder.length()-1);
		stringBuilder.append(pPlayer.getUser());
		String user2 = stringBuilder.toString();
		return user1.compareTo(user2);
	}
}

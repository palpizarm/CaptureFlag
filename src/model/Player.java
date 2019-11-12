package model;

public class Player {
	char user[];
	char password[];
	int score;
	
	public Player (char[] pUser, char[] Ppassword) {
		user = new char[60];
		password = new char[8];
		user = pUser;
		password = Ppassword;
		score = 0;
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
}

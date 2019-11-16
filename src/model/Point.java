package model;

public class Point {
	private int x = 0;
	private int y = 0;
	private int radio = 0;

	
	public Point(int pX, int pY, int pRadio) {
		x = pX;
		y = pY;
		radio = pRadio;
	}
	
	public int getX() {
		return x;
	}
	
	
	public int getY() {
		return y;
	}
	
	public int getRadio() {
		return radio;
	}
}

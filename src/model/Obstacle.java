package model;

public class Obstacle {
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	
	public Obstacle(int pX, int pY, int pWidth, int pHeight) {
		x = pX;
		y = pY;
		width = pWidth;
		height = pHeight;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	

}

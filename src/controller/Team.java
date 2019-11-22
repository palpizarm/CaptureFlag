package controller;

import java.util.ArrayList;

import model.Node;
import model.Point;
import model.Warrior;

public class Team {
	private ArrayList<Warrior> warriors = new ArrayList<Warrior>();
	private ArrayList<Node<Point>> path = new ArrayList<Node<Point>>();
	private Node<Point> current = null;
	
	public Team(ArrayList<Warrior> pWarrios, ArrayList<Node<Point>> pPath ) {
		warriors = pWarrios;
		path = pPath;
	}
	
	public Team(ArrayList<Warrior> pWarrios ) {
		warriors = pWarrios;
		path = null;
	}
	
	public void setPath(ArrayList<Node<Point>> pPath) {
		path = pPath;
	}
	public ArrayList<Warrior> getWarrior() {
		return warriors;
	}
	
	public void move() {
		Node<Point> nextNode = path.get(0);
		path.remove(0);
		current = nextNode;
	}
	
	public int getX() {
		return current.getValue().getX();
	}
	
	public int getY() {
		return current.getValue().getY();
	}
}

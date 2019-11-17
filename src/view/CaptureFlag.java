package view;


import java.util.Stack;

import javax.swing.JFrame;

import model.Floyd;
import model.Graph;
import model.Node;


public class CaptureFlag extends JFrame{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Graph<Integer> test = new Graph<Integer>();
		Node<Integer> vertex1 = test.addNode(1);
		Node<Integer> vertex2 = test.addNode(2);
		Node<Integer> vertex3 = test.addNode(3);
		Node<Integer> vertex4 = test.addNode(4);
		Node<Integer> vertex5 = test.addNode(5);
		Node<Integer> vertex6 = test.addNode(6);
		test.addArc(vertex1, vertex2, 4);
		test.addArc(vertex2, vertex3, 4);
		test.addArc(vertex3, vertex4, 5);
		test.addArc(vertex4, vertex5, 2);
		test.addArc(vertex5, vertex6, 8);
		test.addArc(vertex6, vertex1, 6);
		Floyd<Integer> floydTest = new Floyd<Integer>(test);

		floydTest.getMinimumPath(vertex6, vertex1);

		Stack<Node<Integer>> nodos = floydTest.getMinimumPath(vertex6, vertex5);
		new Login().setVisible(true);
	}

}

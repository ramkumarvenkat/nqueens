package com.nqueens.solver;

public class Application {

	public static void main(String[] args) {
		int n = 4;
		Board b = new Board(n);
		if(b.solve()) b.print();
		else System.out.println("No possible solution for n = " + n);
	}
}

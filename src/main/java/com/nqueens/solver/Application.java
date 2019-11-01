package com.nqueens.solver;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {

		if(args.length < 1) {
			System.err.println("boardDimension argument is missing. \nUsage gradlew run -PboardDimension=<a number>");
			System.exit(1);
		}

		try {
			int n = Integer.valueOf(args[0]);
			Board b = new Board(n);
			if(b.solve(Arrays.asList(Constraint.NO_THREE_QUEENS_SAME_LINE))) b.print();
			else System.err.println("No possible solution for boardDimension = " + n);
		} catch(NumberFormatException e) {
			System.err.println("boardDimension argument is not an integer. \nUsage gradlew run -PboardDimension=<a number>");
			System.exit(1);
		}
	}
}

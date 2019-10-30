package com.nqueens.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	private final int[][] board;

	public Board(int n) {
		board = new int[n][n];
	}

	public boolean isEqualTo(List<List<Integer>> other) {
		for (int i = 0; i < board.length; i++) {
			if(!other.get(i).containsAll(Arrays.asList(board[i]))) return false;
		}
		return true;
	}

	public boolean solve() {
		int n = board.length;
		List<int[]> queens = new ArrayList<>();
		int[] rowMarkers = new int[n];
		int[] differenceMarkers = new int[2 * n - 1]; //leftBottomToRightTopDiagonal, we do row - column and add n - 1, to shift everything to start from 0
		int[] sumMarkers = new int[2 * n - 1]; //leftTopToRightBottomDiagonal
		return solveRecurse(0, queens, rowMarkers, differenceMarkers, sumMarkers);
	}

	public void print() {
		// Printing from the last row in the array to coincide with the chess notation
		for (int i = board.length - 1; i >= 0; i--) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean solveRecurse(int column, List<int[]> queens, int[] rowMarkers, int[] differenceMarkers, int[] sumMarkers) {
		if (column >= board.length) return true;

		for (int i = 0; i < board.length; i++) {
			if (canPlaceQueenAt(i, column, queens, rowMarkers, differenceMarkers, sumMarkers)) {
				placeQueenAt(i, column, queens, rowMarkers, differenceMarkers, sumMarkers);
				if (solveRecurse(column + 1, queens, rowMarkers, differenceMarkers, sumMarkers)) {
					return true;
				}
				removeQueenAt(i, column, queens, rowMarkers, differenceMarkers, sumMarkers);
			}
		}

		return false;
	}

	private boolean canPlaceQueenAt(int row, int column, List<int[]> queens, int[] rowMarkers, int[] differenceMarkers, int[] sumMarkers) {
		if (rowMarkers[row] == 1 || differenceMarkers[getDifferenceMarkerIndex(row, column)] == 1 || sumMarkers[row + column] == 1) {
			return false;
		}
		return true;
	}

	private void placeQueenAt(int row, int column, List<int[]> queens, int[] rowMarkers, int[] differenceMarkers, int[] sumMarkers) {
		assertCoordinates(row, column);
		board[row][column] = 1;
		queens.add(new int[]{row, column});
		rowMarkers[row] = 1;
		differenceMarkers[getDifferenceMarkerIndex(row, column)] = 1;
		sumMarkers[row + column] = 1;
	}

	private void removeQueenAt(int row, int column, List<int[]> queens, int[] rowMarkers, int[] differenceMarkers, int[] sumMarkers) {
		assertCoordinates(row, column);
		board[row][column] = 0;
		queens.removeIf(coordinate -> coordinate[0] == row && coordinate[1] == column);
		rowMarkers[row] = 0;
		differenceMarkers[getDifferenceMarkerIndex(row, column)] = 0;
		sumMarkers[row + column] = 0;
	}

	private void assertCoordinates(int row, int column) {
		assert row <= board.length;
		assert column <= board.length;
	}

	private int getDifferenceMarkerIndex(int row, int column) {
		return (board.length - 1) + (row - column);
	}
}

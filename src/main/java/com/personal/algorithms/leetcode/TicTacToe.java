package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

class TicTacToe {

	char[][] arr;

	int num_of_plays;

	int board_size;

	public TicTacToe(int n) {

		this.arr = new char[n][n];
		this.num_of_plays = 0;
		this.board_size = n;
	}

	public int move(int row, int col, int player) {
		char c = player == 1 ? 'X' : 'O';

		arr[row][col] = c;
		num_of_plays++;

		System.out.println(checkForWin(row, col, c));
		if (num_of_plays > 2 && checkForWin(row, col, c)) {
			return player;
		}
		return 0;
	}

	private boolean checkForWin(int row, int col, char player) {

		// check for row

		boolean row_match = true;
		for (int i = 0; i < board_size; i++) {

			if (arr[row][i] != player) {
				row_match = false;
				break;

			}
		}

		if (row_match) {
			return true;
		}

		// check for column
		boolean column_match = true;

		for (int i = 0; i < board_size; i++) {

			if (arr[i][col] != player) {
				column_match = false;
				break;
			}
		}

		if (column_match) {
			return true;
		}

		// check for left _diagonal


		if (row == col) {
			boolean left_diagonal_is_match = true;


			for (int i = 0; i < board_size; i++) {

				if (arr[i][i] != player) {
					left_diagonal_is_match = false;
					break;

				}
			}
			
			if (left_diagonal_is_match) {
				System.out.println("**3**");
				return true;
			}
		}

	
		// check for right _diagonal


		if (row + col == board_size - 1) {
			
			boolean right_diagonal_is_match = true;


			int i = 0;
			int j = board_size - 1;

			while (i < board_size) {

				if (arr[i][j] != player) {
					right_diagonal_is_match = false;
					break;

				}
				i++;
				j--;
			}
			
			return right_diagonal_is_match;


		}

		return false;
	}
	
	
    public int minDeletionSize(String[] A) {
    	
    	int num_of_deletions = 0;
    	
    	
    	for(int i = 0; i < A[0].length(); i++) {
    		
    		char prev = A[0].charAt(i);
    		
    	 	for(int j = 1; j < A.length; j++) {
        		
        		char current = A[0].charAt(j);

        		if(prev > current) {

        			num_of_deletions++;
        			break;
        		}
    	 		current = prev;
        	}
    	}
    	
		return num_of_deletions;
    }
    
    
	public int numRookCaptures(char[][] board) {

		// find R;

		int row = 0;
		int col = 0;
		
		int captures = 0;
		
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board.length; j++) {

				if(board[i][j] == 'R') {
					row = i;
					col = j;
					break;
				}
			}
		}
		
		// right;

		
		int j = col;

		while (j < board.length) {

			if(board[row][j] == 'B') {
				break;
			}
			

			else if(board[row][j] == 'p') {
				captures++;
			}
			j++;
		}
		
		// left
		 j = col;
		while (j  >= 0 ) {

			if(board[row][j] == 'B') {
				break;
			}
			

			else if(board[row][j] == 'p') {
				captures++;
			}
			j--;
		}
		
		// down
		int i = row;
		
		while (i  < board.length) {

			if(board[i][col] == 'B') {
				break;
			}
			

			else if(board[i][col] == 'p') {
				captures++;
			}
			i++;
		}
		
		
		// up
		 i = row;
		
		while (i  > 0) {

			if(board[i][col] == 'B') {
				break;
			}
			

			else if(board[i][col] == 'p') {
				captures++;
			}
			i--;
		}
		
		
		return captures;

	}


}
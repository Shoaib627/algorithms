package com.personal.algorithms.backtracking;

public class PrintAllDecimal {

	public static int count = 0;

	public static void main(String[] args) {
		printAllBinaryNumbers(5, "");
	}

	public static void printAllBinaryNumbers(int n) {
		printAllBinaryNumbers(n, "");
	}

	public static void printAllBinaryNumbers(int n, String output) {
		if (n == 0) {
			System.out.println(output);
		} else {

			for (int i = 0; i < 10; i++) {
				printAllBinaryNumbers(n - 1, output + String.valueOf(i));
			}
		}
	}
}
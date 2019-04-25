package com.personal.algorithms.backtracking;

public class PrintAllBinary {
	
	public static int count = 0;

	public static void main(String[] args) {
		printAllBinaryNumbers(100, "");
		System.out.println(count);
	}

	public static void printAllBinaryNumbers(int n) {
		printAllBinaryNumbers(n, "");
	}

	public static void printAllBinaryNumbers(int n, String output) {
		count++;
		if (n == 0) {
			System.out.println(output);
		} else {
			printAllBinaryNumbers(n - 1, output + "0");
			printAllBinaryNumbers(n - 1, output + "1");
		}
	}
}
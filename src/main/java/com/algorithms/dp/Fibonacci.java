package com.algorithms.dp;

public class Fibonacci {

	public static void main(String[] args) {

	}

	// plain recursion function
	public static int NthFibonacciRecursive(int n) {

		if (n < 0) {
			return -1;
		}

		else if (n <= 1) {
			return 1;
		}

		return NthFibonacciRecursive(n - 1) + NthFibonacciRecursive(n - 2);
	}

	public static int[] fib_arr = new int[1000];

	// Bottomup Approach
	public static int NthFibonacciBottomUp(int n) {

		if (n < 0) {
			return -1;
		}

		fib_arr[0] = 1;
		fib_arr[1] = 1;

		for (int i = 2; i < n; i++) {
			fib_arr[i] = fib_arr[i - 1] + fib_arr[i - 2];
		}

		return fib_arr[n - 1];
	}
}
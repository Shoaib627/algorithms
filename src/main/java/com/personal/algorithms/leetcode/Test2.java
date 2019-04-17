package com.personal.algorithms.leetcode;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int prev = sc.nextInt();
		int result = prev;

		System.out.println(prev);

		int current = sc.nextInt();
		if (prev == 0 & current != 0) {
			result = current;
		}

		prev = current;
		System.out.println(result);

		while (true) {

			current = sc.nextInt();

			if (prev == 0 & current != 0) {
				result = current;
			}

			prev = current;

			System.out.println(result);
		}

	}

}

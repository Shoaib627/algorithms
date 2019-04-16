package com.personal.algorithms.leetcode;

import java.util.Scanner;

public class Source {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int Q = sc.nextInt();

		String[] choclates = new String[N];

		for (int i = 0; i < N; i++) {
			choclates[i] = sc.next();
		}

		int number_of_choclates_eaten_so_far = K * (Q - 1);
		int start_index = number_of_choclates_eaten_so_far % 4;

		if (start_index + K > N) {

			int j = K - (N - start_index);

			for (int i = 0; i < j; i++) {

				System.out.println(choclates[i]);
			}
			
			for (int i = start_index; i < N; i++) {

				System.out.println(choclates[i]);
			}

		} else {

			for (int i = start_index; i < start_index + K; i++) {

				System.out.println(choclates[i]);
			}
		}
	}

}

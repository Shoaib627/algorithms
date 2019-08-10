package com.personal.algorithms.hr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StairCase {

	public static void main(String[] args) {

		System.out.print(timeConversion("04:59:59AM"));
	}

	static void staircase(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {

				System.out.print(" ");
			}

			for (int j = n - i; j < n; j++) {

				System.out.print("#");
			}

			System.out.print("\n");

		}
	}

	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);

		System.out.print((BigInteger.valueOf(arr[0]).add(BigInteger.valueOf(arr[1])).add(BigInteger.valueOf(arr[2]))
				.add(BigInteger.valueOf(arr[3]))) + " "
				+ (BigInteger.valueOf(arr[4]).add(BigInteger.valueOf(arr[1])).add(BigInteger.valueOf(arr[2]))
						.add(BigInteger.valueOf(arr[3]))));
	}
	
	
	static int birthdayCakeCandles(int[] ar) {
		Arrays.sort(ar);

		int x = ar[ar.length - 1];
		int count = 0;
		for (int i = 0; i < ar.length; i++) {

			if (x == ar[i]) {
				count++;
			}
		}

		return count;
	}

	static String timeConversion(String s) {

		String[] arr = s.split(":");

		if (arr[2].substring(2, 4).equals("PM")) {

			String k = String.valueOf(Integer.parseInt(arr[0]) == 12 ? 12 : Integer.parseInt(arr[0]) + 12) + ":" + arr[1]
					+ ":" + arr[2].substring(0, 2);
			return k.substring(0, 8);
		}
		
		else if(arr[2].substring(2, 4).equals("AM")) {
			String k = String.valueOf(Integer.parseInt(arr[0]) == 12 ? "00" : "0" + Integer.parseInt(arr[0])) + ":" + arr[1]
					+ ":" + arr[2].substring(0, 2);
			return k.substring(0, 8);
		}

		return s.substring(0, 8);
	}
	
	
	static int simpleArraySum(int[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {

			count += ar[i];

		}
		return count;
	}
	
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> l = new ArrayList<Integer>();

		int x = 0;
		int y = 0;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) > b.get(i)) {
				x++;
			}

			else if (a.get(i) < b.get(i)) {
				y++;
			}

		}

		l.add(x);
		l.add(y);

		return l;

	}

	public static int diagonalDifference(List<List<Integer>> arr) {

		int[][] r = new int[arr.size()][arr.size()];

		for (int i = 0; i < arr.size(); i++) {

			List<Integer> list = arr.get(i);

			for (int j = 0; j < list.size(); j++) {

				r[i][j] = list.get(j);
			}
		}

		int x = 0;
		int y = 0;
		for (int i = 0; i < r.length; i++) {

			x += r[i][i];
			y += r[i][r.length - i];
		}

		return Math.abs(x - y);
	}
	
	
	
	static void plusMinus(int[] arr) {
		float x = 0;
		float y = 0;
		float z = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0)
				x++;
			else if (arr[i] < 0)
				y++;
			else
				z++;

		}

		System.out.println(x / (float) arr.length);
		System.out.println(y / (float) arr.length);
		System.out.println(z / (float) arr.length);

	}
	
	static int findDigits(int n) {

		int count = 0;
		int org = n;
		while (n > 0) {
			int d = n % 10;
			if (d != 0 && org % d == 0) {
				count++;
			}
			n = n / 10;
		}
		return count;
	}
	
	static void extraLongFactorials(int n) {

		BigInteger b = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			b.multiply(BigInteger.valueOf(i));

		}

		System.out.println(b.toString());
	}


}
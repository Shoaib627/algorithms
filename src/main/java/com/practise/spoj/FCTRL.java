package com.practise.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FCTRL {

	public static void main(String[] args) {
		FastReader s = new FastReader();
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			System.out.println(countTrailingZeros(s.nextLong()));
		}
	}

	public static Integer countTrailingZeros(Long n) {

		Integer result = 0;

		int index = 1;
		while (true) {
			int c = (int) (n / Math.pow(5, index));
			if (c == 0)
				break;
			result = result + c;
			index++;
		}
		return result;

	}

	static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
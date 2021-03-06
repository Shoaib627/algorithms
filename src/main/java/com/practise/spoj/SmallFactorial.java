package com.practise.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SmallFactorial {

	public static void main(String[] args) {

		FastReader s = new FastReader();
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			System.out.println(factorial(s.nextInt()));
		}
	}

	public static BigInteger factorial(int n) {
		BigInteger r = new BigInteger("1");
		for (int i = 2; i <= n; i++)
			r = r.multiply(BigInteger.valueOf(i));
		return r;
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
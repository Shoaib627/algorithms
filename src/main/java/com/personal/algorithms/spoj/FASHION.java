package com.personal.algorithms.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FASHION {

	public static void main(String[] args) {

		FastReader s = new FastReader();
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {

			int n = s.nextInt();
			List<Integer> men = new ArrayList<>();
			List<Integer> women = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				men.add(s.nextInt());
			}

			for (int j = 0; j < n; j++) {
				women.add(s.nextInt());
			}
			
			System.out.println(hotnessCal(men, women));
		}

	}

	public static int hotnessCal(List<Integer> men, List<Integer> women) {

		Collections.sort(men);
		Collections.sort(women);

		int hotness = 0;

		for (int i = 0; i < men.size(); i++) {
			hotness += men.get(i) * women.get(i);
		}
		return hotness;
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

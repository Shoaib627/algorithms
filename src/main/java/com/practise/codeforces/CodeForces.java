package com.practise.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeForces {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		solve(in, out);

		out.close();
	}

	public static void solve(InputReader in, PrintWriter out) {
		Integer n = in.nextInt();
		Integer m = in.nextInt();

		int sum = 0;
		
		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		
		Arrays.sort(A);
		
		for (int p : A) {

			if (p < 0 && m > 0) {
				sum += p;
				m--;
			}
		}

		out.print(-sum);

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
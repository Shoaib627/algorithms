package com.algorithms.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		System.out.println(longestCommonSubsequence("axbc", "abc"));
	}

	// recursion

	public static int longestCommonSubsequence(String a, String b) {

		if (a.isEmpty() || b.isEmpty()) {
			return 0;
		} else {
			if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
				return 1 + longestCommonSubsequence(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
			}

			else {
				return Math.max(longestCommonSubsequence(a, b.substring(0, b.length() - 1)), longestCommonSubsequence(a.substring(0, a.length() - 1), b));
			}
		}
	}
}

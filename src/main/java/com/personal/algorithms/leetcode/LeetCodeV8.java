package com.personal.algorithms.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCodeV8 {

	public static void main(String[] args) {


		asteroidCollision(new int[] {10,2,-5});
	}

	public static int[] exclusiveTime(int n, List<String> logs) {

		int[] time_arr = new int[n];

		Stack<Log> stack = new Stack<>();

		for (int i = 0; i < logs.size(); i++) {

			Log log = new Log(logs.get(i));

			if (log.isStart) {
				stack.push(log);
			} else {
				Log top = stack.peek();
				time_arr[log.id] += log.time - top.time + 1 - top.subDuration;

				if (!stack.isEmpty()) {
					stack.peek().subDuration += log.time - top.time + 1;
				}
			}

		}
		return time_arr;
	}

	public static class Log {

		public int id;

		public boolean isStart;

		public int time;

		public int subDuration;

		public Log(String content) {

			String[] arr = content.split(":");

			this.id = Integer.parseInt(arr[0]);
			this.isStart = arr[1].equals("start");
			this.time = Integer.parseInt(arr[2]);
			this.subDuration = 0;
		}

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int p = 0;
		int i = 0;

		if ((flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)
				|| (flowerbed.length == 2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1)) {
			return true;
		}

		while (i <= flowerbed.length - 3) {
			if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
				p++;
				i++;
				i++;
				i++;

			}

			else if (i < flowerbed.length - 3 && flowerbed[i] == 1 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0
					&& flowerbed[i + 3] == 0
					|| i < flowerbed.length - 3 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 1
							&& flowerbed[i + 3] == 0) {
				p++;
				i++;
				i++;
				i++;

			}

			else {
				i++;
			}
		}

		return p >= n;
	}

	public static int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < asteroids.length; i++) {

			if (stack.isEmpty()) {
				stack.push(asteroids[i]);
			}

			else {

				if (stack.peek() > 0 && asteroids[i] < 0) {

					if (Math.abs(stack.peek()) == Math.abs(asteroids[i]))
						stack.pop();

					else if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
						stack.pop();
						stack.push(asteroids[i]);
					}

					while (stack.size() > 1) {

						int top = stack.pop();

						if (stack.peek() > 0 && top < 0) {

							if (Math.abs(stack.peek()) == Math.abs(top))
								stack.pop();

							else if (Math.abs(stack.peek()) < Math.abs(top)) {
								stack.pop();
								stack.push(top);
							}
						}

						else {
							stack.push(top);
							break;
						}
					}
				}

				else {
					stack.push(asteroids[i]);
				}
			}
		}

		int[] result = new int[stack.size()];
		int j = stack.size() - 1;
		while (!stack.isEmpty()) {
			result[j] = stack.pop();
			j--;
		}
		return result;
	}
	
	public String parseTernary(String expression) {

		char[] arr = expression.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		while (stack.size() > 1) {

			Character f = stack.pop();
			stack.pop();
			Character t = stack.pop();

			Character b = stack.pop();

			if (b == 'T')
				stack.push(t);
			else
				stack.push(f);

		}

		return stack.pop().toString();

	}
	
	public int[] numSmallerByFrequency(String[] queries, String[] words) {

		int[] result = new int[queries.length];
		
		
		int[] words_count = new int[words.length];
		
		
		for (int j = 0; j < words.length; j++) {
			words_count[j] = getMinCharFrequeny(words[j]);
		}


		for (int i = 0; i < queries.length; i++) {
			
			int q = getMinCharFrequeny(queries[i]);
			
			int c =0;

			for (int j = 0; j < words.length; j++) {

				if(q < words_count[j]) {
					c++;
				}
			}
			
			result[i] = c;
		}
		return result;
	}
	
	public int getMinCharFrequeny(String word) {

		char[] arr = word.toCharArray();

		int[] count_arr = new int[26];
		for (int i = 0; i < arr.length; i++) {
			count_arr[arr[i] - 'a']++;
		}

		for (int i = 0; i < count_arr.length; i++) {

			if (count_arr[i] != 0) {
				return count_arr[i];
			}
		}
		return 0;
	}
	
	
	public boolean isBoomerang(int[][] p) {
		return (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]) != (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]);
	}

	public double slope(int[] A, int[] B) {
		double slope;
		if (B[0] == A[0]) {
			slope = 9999;
		}
		else
		slope = ((double) B[1] - (double) A[1]) / ((double) B[0] - (double) A[0]);
		
		System.out.println(slope);
		return slope;
	}
	
	
 	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		double p1p2 = distance(p1, p2);
		double p2p3 = distance(p2, p3);
		double p3p4 = distance(p3, p4);
		double p1p4 = distance(p1, p4);
        double p1p3 = distance(p1, p3);
        double p2p4 = distance(p2, p4);
        
        double[] arr = new double[6];
        
        arr[0] = p1p2;
        arr[1] = p2p3;

        arr[2] = p3p4;
        arr[3] = p1p4;
        arr[4] = p1p3;
        arr[5] = p2p4;
        
        Arrays.sort(arr);



		return arr[0] == arr[3];

	}

	public double distance(int[] p1, int[] p2) {
		double s = Math.sqrt((p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]));
		System.out.println(s);
		return s;
	}
	
	
	public int[] distributeCandies(int candies, int num_people) {

		int[] people = new int[num_people];
		int people_index = 0, candies_to_be_given = 1;
		candies--;

		while (true) {

			people[people_index] = candies_to_be_given;
			people_index++;

			if (people_index == num_people) {
				people_index = 0;
			}
			candies_to_be_given++;

			if (candies_to_be_given > candies) {
				people[people_index] = candies;
				return people;
			} else {
				candies -= candies_to_be_given;
			}
		}
	}
}

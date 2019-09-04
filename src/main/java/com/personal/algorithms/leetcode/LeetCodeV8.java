package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LeetCodeV8 {

	public static void main(String[] args) {


		merge(new int[] { 1,2,3,4,0,0,0 }, 4, new int[] { 2,5,6 }, 3);
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
	
	
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

		int r = 0;

		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += calories[i];
		}

		if (sum > upper) {
			r++;
		}

		if (sum < lower) {
			r--;
		}

		for (int i = k; i < calories.length; i++) {

			sum += calories[i] - calories[i - k];

			if (sum > upper) {
				r++;
			}

			if (sum < lower) {
				r--;
			}
		}

		return r;
	}

	public boolean isCompleteTree(TreeNode root) {

		List<TreeNode> list = new ArrayList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		list.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			list.add(node.left);
			list.add(node.right);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}

		boolean num_found = false;
		for (int i = list.size()-1; i >= 0; i--) {

			if (!num_found && list.get(i) != null) {
				num_found = true;
			}

			if (num_found && list.get(i) == null) {
				return false;
			}
		}

		return true;
	}
	
	
	public int largestSumAfterKNegations(int[] A, int K) {

		int negations = 0;
		int min_element = Integer.MAX_VALUE;
		int min_index = 0;
		
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {

			if (negations > K) {

				int sum = 0;
				for (int j = 0; j < A.length; j++) {

					sum += A[j];
				}
				return sum;
			}

			if (min_element < Math.abs(A[i])) {
				min_element = Math.abs(A[i]);
				min_index = i;
			}

			if (A[i] < 0) {
				A[i] = -A[i];
				negations++;
			}
		}

		System.out.println(negations);
		int r = 0;
		if (A[min_index] < 0 && (K - negations) % 2 == 1) {
			A[min_index] = -A[min_index];
		}
		
		else if (A[min_index] > 0 && (K - negations) % 2 == 1) {
			A[min_index] = -A[min_index];
		}

		for (int j = 0; j < A.length; j++) {

			r += A[j];
		}
		return r;
	}
	
	
	public int[] corpFlightBookings(int[][] bookings, int n) {

		int[] result = new int[n + 1];

		for (int j = 0; j < bookings.length; j++) {
			
			int[] booking = bookings[j];

			for (int i = booking[1]; i <= booking[2]; i++) {

				result[i] += booking[0];
			}
		}
		return result;
	}
	
	public int maxDistToClosest(int[] seats) {

		int zeros = 0;

		int zeros_so_far = 0;

		boolean last_zero_th_index = false;

		int c = 0;
		for (int i = 0; i < seats.length; i++) {

			if (seats[i] == 1) {

				if (zeros_so_far > zeros) {
					zeros = zeros_so_far;
					c++;
				}
				zeros_so_far = 0;
			}

			else {
				zeros_so_far++;
			}
		}

		if (zeros_so_far > zeros) {
			last_zero_th_index = true;
			zeros = zeros_so_far;
			c++;
		}

		return (c == 1 && seats[0] == 0) ? zeros
				: (last_zero_th_index ? zeros : (int) Math.ceil(((double) zeros / 2.0)));
	}
	
	
	
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				return true;
			}
		}

		int prev = 0;
		int next = 0;
		int p = 0;

		for (int i = 0; i < flowerbed.length; i++) {
			if (i + 1 < flowerbed.length) {
				next = flowerbed[i + 1];
			} else {
				next = 0;
			}
			if (prev == 0 && next == 0 && flowerbed[i] == 0) {
				p++;
				prev = 1;
			} else {
				prev = flowerbed[i];
			}
		}
		return p >= n;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int p = i + 1;
			int q = nums.length - 1;

			while (p < q) {

				if (nums[i] + nums[p] + nums[q] == 0) {

					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[p]);
					list.add(nums[q]);
					
					result.add(list);
					
					while (p + 1 < nums.length && nums[p] == nums[p + 1]) {
						p++;
					}
					

					while (q > 0 && nums[q] == nums[q - 1]) {
						q--;
					}

					p++;
					q--;

					
				}  else if (nums[i] + nums[p] + nums[q] > 0) {
					q--;
				}  else if (nums[i] + nums[p] + nums[q] < 0) {
					p++;
				}
			}
		}
		
		System.out.println(result);
		return result;
	}
	
	

	
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int closest = 0;

		for (int i = 0; i < nums.length; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int p = i + 1;
			int q = nums.length - 1;

			while (p < q) {

				int sum = nums[i] + nums[p] + nums[q];

				if (sum == target) {
					return sum;
				}

				if (Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					closest = sum;

					while (p + 1 < nums.length && nums[p] == nums[p + 1]) {
						p++;
					}

					while (q > 0 && nums[q] == nums[q - 1]) {
						q--;
					}

				
				}

			 if (sum > target) {
					q--;
				}

				else if(sum < target){
					p++;
				}

			}
		}

		return closest;
	}
	
	
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length; j++) {

				if (nums[j] == nums[j - 1]) {
					continue;
				}

				int p = i + 1;
				int q = nums.length - 1;

				while (p < q) {

					if (nums[i] + nums[j] + nums[p] + nums[q] == target) {

						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[p]);
						list.add(nums[q]);

						result.add(list);

						while (p + 1 < nums.length && nums[p] == nums[p + 1]) {
							p++;
						}

						while (q > 0 && nums[q] == nums[q - 1]) {
							q--;
						}

						p++;
						q--;

					} else if (nums[i] + nums[j] + nums[p] + nums[q] > target) {
						q--;
					} else if (nums[i] + nums[j] + nums[p] + nums[q] < target) {
						p++;
					}
				}
			}
		}
		return result;
	}
	
	   public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        if (A == null || B == null || C == null || D == null) {
	            return 0;
	        }
	        int count = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < A.length; i++) {
	            for (int j = 0; j < B.length; j++) {
	            	
	                map.merge(A[i] + B[j], 1, Integer::sum);
	            }
	        }

	        for (int k = 0; k < C.length; k++) {
	            for (int l = 0; l < D.length; l++) {
	                int desiredSum = -(C[k] + D[l]);
	                if (map.containsKey(desiredSum)) {
	                    count += map.get(desiredSum);
	                }
	            }
	        }
	        return count;
	    }
	   
	public void mergev2(int[] nums1, int m, int[] nums2, int n) {

		int index = n;

		for (int i = nums2.length - 1; i >= 0; i--) {

			nums1[index] = nums2[i];
			int j = index - 1;

			while (j >= 0 && nums1[j] > nums1[j + 1]) {
				int temp = nums1[j];
				nums1[j] = nums2[i];
				nums1[j + 1] = temp;
				j--;
			}
			index++;
		}
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = 0;
		int j = 0;

		while (i < m && j < n) {

			if (nums1[i] > nums2[j]) {
				int temp = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = temp;
				j++;
			} else {
				i++;
			}
		}

		for (int x = 0; x < n; x++) {
			nums1[m] = nums2[x];
			m++;
		}
	}
}
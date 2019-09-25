package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCodeV11 {



	public static int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);
		

		int start = 0;
		int end = people.length - 1;

		int boats = 0;

		while (start <= end) {

			int left = limit - people[end];

			while (start < end && left > 0) {
				left = left - people[start];
				if (left < 0) {
					break;
				}
				start++;
				break;
			}
			boats++;
			end--;
		}

		return boats;
	}
	
	public double[] sampleStats(int[] count) {
		double[] result = new double[5];

		int start_index = 0;
		int end_index = count.length - 1;

		int min = Integer.MAX_VALUE;
		int max = -1;

		int mode = 0;

		int sum = 0;
		int c = 0;
		double median = 0;

		while (start_index <= end_index) {

			if (count[start_index] > 0 && min > start_index) {
				min = start_index;
			}
			if (count[end_index] > 0 && min > end_index) {
				min = end_index;
			}

			if (count[start_index] > 0 && max < start_index) {
				max = start_index;
			}

			if (count[end_index] > 0 && max < end_index) {
				max = end_index;
			}

			if (count[start_index] > count[mode]) {
				mode = start_index;
			}

			if (count[end_index] > count[mode]) {
				mode = end_index;
			}

			c = c + count[start_index];
			sum = sum + start_index * count[start_index];

			if (start_index != end_index) {
				c = c + count[end_index];
				sum = sum + end_index * count[end_index];
			}

			start_index++;
			end_index--;
		}
		result[0] = (double) min;
		result[1] = (double) max;

		result[2] = (double) sum / (double) c;

		result[4] = (double) mode;

		if (c == 1)
			median = sum; // single element.
		int m1 = (c + 1) / 2, m2 = c / 2 + 1; // m1-th and m2-th items are medians.
		for (int i = 0, cnt = 0; sum > 1 && i < 256; ++i) { // more than 1 elements.
			if (cnt < m1 && cnt + count[i] >= m1) // find m1-th item.
				median += i / 2.0d; // add its half.
			if (cnt < m2 && cnt + count[i] >= m2) // find m2-th item.
				median += i / 2.0d; // add its half.
			cnt += count[i];
		}
		result[3] = median;
		return result;
	}
	
	public int minSubArrayLen(int s, int[] nums) {
		int right = 0, left = 0, sum = 0, len = Integer.MAX_VALUE;
		while (right < nums.length) {
			sum += nums[right++];
			while (sum < s) {
				len = Math.max(right - left, len);
				sum = sum - nums[left++];
			}
		}
		return (len == Integer.MAX_VALUE) ? 0 : len;
	}
	
	
	public int connectSticks(int[] sticks) {

		int minimum = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < sticks.length; i++) {
			queue.add(sticks[i]);
		}

		while (queue.size() > 1) {

			int temp = queue.poll() + queue.poll();
			minimum += temp;
			queue.add(temp);
		}
		return minimum;
	}

	public int bagOfTokensScore(int[] tokens, int P) {

		int points = 0;
		Arrays.sort(tokens);
		
		int start = 0;
		int end = tokens.length - 1;
        int max = 0;

		while(start <= end) {

			if (tokens[start] <= P) {
				points++;
				P -= tokens[start++];
			}

			else if (points > 0) {
				P += tokens[end--];

				points--;
			}
            max = Math.max(points, max);

		}

		return points;
	}

	public int maxCount(int m, int n, int[][] ops) {
		
		
		if(ops.length == 0) {
			return m*n;
		}

		int min_row_so_far = Integer.MAX_VALUE, min_col_so_far = Integer.MAX_VALUE;
		

		for (int[] op : ops) {

			min_row_so_far = Math.min(min_row_so_far, op[0]);
			min_col_so_far = Math.min(min_col_so_far, op[1]);

		}



		return min_col_so_far * min_row_so_far;
	}
	public double findMaxAverage(int[] nums, int k) {

		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}

		double max_avg = (double) sum / (double) k;

		int start = 1;
		int end = k + 1;
		
		System.out.println(sum);

		while (end < nums.length) {

			sum -= nums[start - 1];
			sum +=  nums[end];

			max_avg = Math.max(max_avg, (double) sum / (double) k);
			start++;
			end++;

		}
		return max_avg;
	}

	public int[] findPermutation(String s) {

		int[] arr = new int[s.length() + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		int[] result = new int[s.length() + 1];
		int start = 0, end = arr.length - 1;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'D') {
				result[i] = arr[end--];
			} else {
				result[i] = arr[start++];
			}
		}
		result[s.length()] = arr[start];
		return result;
	}
	
	
	public int[] singleNumber3(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int[] result = new int[2];

		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1) {
				result[index] = entry.getKey();
				index++;
				if (index > 1) {
					break;
				}
			}
		}
		return nums;
	}
	
	
    public int singleNumber(int[] nums) {
       
    	Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return 0;
    }
    
	public int maxScoreSightseeingPair(int[] A) {

		int start = 0, end = A.length - 1;
		int max = 0;

		while (start < end) {

			max = Math.max(max, A[start] + A[end] + start - end);
			if (A[start] > A[end]) {
				end--;
			} else if (A[start] < A[end]) {
				start++;
			} else {

				if(A[start + 1] > A[end -1]) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		return max;
	}
	
	public int maxNumberOfApples(int[] arr) {

		Arrays.sort(arr);

		int apples = 0;

		int capacity = 5000;

		for (int i = 0; i < arr.length; i++) {

			if (capacity >= arr[i]) {
				apples++;
				capacity -= arr[i];
				
				if(capacity <= 0) {
					break;
				}
			}
		}
		return apples;
	}
	
	

	public static int maxNumberOfApplesV2(int[] arr) {

		Arrays.sort(arr);

		int apples = 0;

		int capacity = 5000;

		for (int i = 0; i < arr.length; i++) {

			if (capacity >= arr[i]) {
				apples++;
				capacity -= arr[i];
				
				if(capacity <= 0) {
					break;
				}
			}
		}
		return apples;
	}
	
	
	
	public int smallestCommonElement(int[][] mat) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < mat.length; i++) {
			map.put(mat[i][0], map.getOrDefault(mat[i][0], 0) + 1);
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][j] != mat[i][j - 1]) {
					map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
				}
			}
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == mat.length)
				return e.getKey();
		}
		return -1;
	}
	
	

	
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);

		int min_diff = arr[1] - arr[0];

		for (int i = 1; i < arr.length - 1; i++) {
			min_diff = Math.min(arr[i + 1] - arr[i], min_diff);
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] == min_diff) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				list.add(arr[i + 1]);
				result.add(list);
			}
		}
		return result;

	}

	
	static int nthUglyNumber(int n, int a, int b, int c) {
		long arr[] = new long[n];
		int x = 0, y = 0, z = 0;
		int p = a, q = b, r = c;
		long next = arr[0] = 1;
		for (int i = 1; i < n; i++) {

			long prev = arr[i - 1];

			while (arr[x] * p <= prev) {
				++x;
			}
			while (arr[y] * q <= prev) {
				++y;
			}
			while (arr[z] * r <= prev) {
				++z;
			}

			long c1 = arr[x] * p;
			long c2 = arr[y] * q;
			long c3 = arr[z] * r;

			arr[i] = Math.min(c1, Math.min(c2, c3));
		}
		System.out.println(Arrays.toString(arr));
		return (int) next;
	}

	static int getNthUglyNo(int n) 
	    { 
	        int ugly[] = new int[n];  // To store ugly numbers 
	        int i2 = 0, i3 = 0, i5 = 0; 
	        int next_multiple_of_2 = 2; 
	        int next_multiple_of_3 = 11; 
	        int next_multiple_of_5 = 13; 
	        int next_ugly_no = 1; 
	          
	        ugly[0] = 1; 
	          
	        for(int i = 1; i < n; i++) 
	        { 
	            next_ugly_no = Math.min(next_multiple_of_2, 
	                                  Math.min(next_multiple_of_3, 
	                                        next_multiple_of_5)); 
	              
	            ugly[i] = next_ugly_no; 
	            if (next_ugly_no == next_multiple_of_2) 
	            { 
	               i2 = i2+1; 
	               next_multiple_of_2 = ugly[i2]*2; 
	            } 
	            if (next_ugly_no == next_multiple_of_3) 
	            { 
	               i3 = i3+1; 
	               next_multiple_of_3 = ugly[i3]*11; 
	            } 
	            if (next_ugly_no == next_multiple_of_5) 
	            { 
	               i5 = i5+1; 
	               next_multiple_of_5 = ugly[i5]*13; 
	            } 
	        } /*End of for loop (i=1; i<n; i++) */
	        System.out.println(Arrays.toString(ugly));
	        return next_ugly_no; 
	    } 
	
	
	
	public int subarraySum(int[] nums, int k) {

		int sum = 0;
		int count = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {

		System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));

	}
	
	public static int subarraysDivByK(int[] A, int K) {
		int sum = 0;
		int count = 0;

		int[] arr = new int[K];
		arr[0] = 1;

		for (int i = 0; i < A.length; i++) {

			sum = (sum + A[i]) % K;

			if (sum < 0)
				sum = sum + K;

			count += arr[sum];

			arr[sum]++;
		}
		return count;
	}
	
	public int maxSubArrayLen(int[] nums, int k) {

		int sum = 0;
		int max = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {

			sum = sum + nums[i];

			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - k + 1);
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return max;

	}

	public int maxDistance(List<List<Integer>> arrays) {

		int max = arrays.get(0).get(arrays.get(0).size() - 1);
		int min = arrays.get(0).get(0);

		int result = 0;

		for (int i = 1; i < arrays.size(); i++) {

			result = Math.max(Math.abs(max - arrays.get(i).get(0)),
					Math.max(result, Math.abs(min - arrays.get(i).get(arrays.get(0).size() - 1))));
			min = Math.min(min, arrays.get(i).get(0));
			max = Math.max(max, arrays.get(i).get(arrays.get(0).size() - 1));

		}
		return result;
	}
}
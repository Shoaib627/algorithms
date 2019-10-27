package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

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
	
	


	public static int numMatchingSubseq(String S, String[] words) {

		int count = 0;

		for (String word : words) {
			if (isSubsequence(S, word)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isSubsequence(String S, String word) {

		int i = 0;
		int j = 0;

		while (j < word.length()) {

			while (i < S.length() && S.charAt(i) != word.charAt(j)) {
				i++;
			}

			if (i >= S.length()) {
				break;
			}

			j++;
			i++;

		}

		return j == word.length();
	}
	
	
	public int[] advantageCount(int[] A, int[] B) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i : A) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int[] C = new int[A.length];

		int index = 0;

		for (int i : B) {

			Entry<Integer, Integer> entry = map.higherEntry(i);

			if (entry == null) {
				entry = map.firstEntry();
			}

			C[index] = entry.getKey();

			if (entry.getValue() == 1) {
				map.remove(entry.getKey());
			}

			else {
				int e = entry.getValue() - 1;
				map.put(entry.getKey(), e);
			}
			index++;
		}
		return C;
	}

	// 0,0,1,1,1,1,2,3,3



	public static int removeDuplicates(int[] nums) {
		int slowPtr = 0;
		boolean can_move = true;
		for (int fastPtr = 1; fastPtr < nums.length; fastPtr++) {

			if (nums[fastPtr] != nums[slowPtr]) {
				nums[slowPtr++] = nums[fastPtr];
				can_move = true;
			}

			else if (slowPtr > 0 && nums[slowPtr] == nums[slowPtr - 1] && can_move) {
				slowPtr++;
				can_move = false;
			}

			else if (slowPtr == 0 && nums[slowPtr] == nums[slowPtr + 1] && can_move) {
				slowPtr++;
				can_move = false;
			}
		}
		System.out.println(Arrays.toString(nums));
		return slowPtr + 1;
	}
	

	public boolean uniqueOccurrences(int[] arr) {

		int[] A = new int[2001];

		for (int i = 0; i < arr.length; i++) {
			A[arr[i] + 1000]++;
		}

		int[] B = new int[2001];

		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				B[A[i]]++;
				if (B[A[i]] > 1) {
					return false;

				}
			}
		}
		return true;
	}
	
	

	
	public List<Integer> powerfulIntegers(int x, int y, int bound) {

		Set<Integer> set = new HashSet<>();

		int x_index = 0;

		int result = 0;

		while (bound >= result) {

			result = (int) (Math.pow(x, x_index) + Math.pow(y, 0));
			if (result > bound) {
				break;
			} else {
				set.add(result);
			}
			if (x == 1) {
				break;
			}
			x_index++;
		}

		int y_index = 0;

		result = 0;

		while (bound >= result) {

			result = (int) (Math.pow(x, 0) + Math.pow(y, y_index));
			if (result > bound) {
				break;
			} else {
				set.add(result);
			}

			if (y == 1) {
				break;
			}
			y_index++;
		}

		for (int i = 1; i <= y_index; i++) {

			for (int j = 1; j <= x_index; j++) {
				result = (int) (Math.pow(x, j) + Math.pow(y, i));

				if (result <= bound) {
					set.add(result);
				} else {
					break;
				}

			}
		}

		return new ArrayList<>(set);
	}
	
	

	
	public static int compress(char[] chars) {

		int index = 0;
		int count = 0;

		while (index < chars.length) {

			int begin = index;
			while (index < chars.length && chars[index] == chars[begin]) {
				index++;
				count++;
			}

			if (count > 1) {

				int i = begin + 1;
				String str = String.valueOf(count);

				for (int j = 0; j < str.length(); j++) {

					chars[i] = str.charAt(j);
					i++;
				}

				for (int k = i; k < index; k++) {
					chars[k] = '!';
				}

			}
			count = 0;
		}

		// move zeros to end
		
		int zero_index = -1;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '!') {
				zero_index = i;
				break;
			}
		}
		
		if (zero_index == -1) {
			return chars.length;
		}

		for (int i = 0; i < chars.length; i++) {

			if (zero_index < i && i < chars.length && chars[i] != '!') {

				chars[zero_index] = chars[i];
				chars[i] = '!';
				while(chars[zero_index] != '!') {
					zero_index++;
				}
			}

		}

		return zero_index;
	}
	
	public int numberOfBoomerangs(int[][] points) {

		int count = 0;
		for (int i = 0; i < points.length; i++) {

			for (int j = i + 1; j  < points.length; j++) {

				for (int k = j + 1; k < points.length; k++) {

					double d1 = Math.sqrt((points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]));

					double d2 = Math.sqrt((points[k][0] - points[i][0]) * (points[k][0] - points[i][0]) + (points[k][1] - points[i][1]) * (points[k][1] - points[i][1]));

					if (d1 == d2) {
						System.out.println(Arrays.toString(points[i]) + "  " + Arrays.toString(points[j]) + "  " + Arrays.toString(points[k]));
						count++;
					}
				}
			}
		}
		return count;
	}
	
	// "(u(love)i)"

	public static String reverseParentheses(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ')') {
				stack.push(s.charAt(i));
			}

			else {

				if (s.lastIndexOf(")") != i) {
					Queue<Character> temp = new LinkedList<>();

					while (!stack.isEmpty() && stack.peek() != '(') {
						temp.add(stack.pop());
					}

					if (stack.peek() == '(') {
						stack.pop();
					}

					while (!temp.isEmpty()) {
						stack.add(temp.poll());
					}

				}
				else {
					System.out.println(stack);
				}
			}

		}
		StringBuffer b = new StringBuffer();

		while (!stack.isEmpty() && stack.peek() != '(') {
			b.append(stack.pop());
		}

		return b.toString();

	}
	
	public static String addBoldTag(String S, String[] words) {

		List<int[]> intervalList = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();
		SortedSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

		for (String word : words) {
			List<String> list = map.get(word.length());
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(word);
			map.put(word.length(), list);

			set.add(word.length());
		}

		for (int i = 0; i < S.length(); i++) {
			Iterator<Integer> iterator = set.iterator();

			while (iterator.hasNext()) {

				int l = iterator.next();

				List<String> list = map.get(l);

				if ((i + l - 1) < S.length() && list.contains(S.substring(i, i + l))) {
					intervalList.add(new int[] { i, i + l - 1 });
					break;
				}
			}
		}

		if (intervalList.isEmpty()) {
			return S;
		}

		List<int[]> mergedList = new ArrayList<>();

		for (int[] interval : intervalList) {

			if (mergedList.isEmpty() || mergedList.get(mergedList.size() - 1)[1] + 1 < interval[0]) {
				mergedList.add(interval);
			}

			else {
				mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1],
						interval[1]);
			}
		}

		StringBuffer s = new StringBuffer();
		Integer prev_index = -1;

		if (mergedList.get(0)[0] != 0) {
			prev_index = 0;
		}

		for (int[] ilist : mergedList) {
			if (prev_index > -1) {
				s.append(S.substring(prev_index, ilist[0]));
			}
			if (ilist[0] != -1) {
				s.append("<b>").append(S.substring(ilist[0], ilist[1] + 1)).append("</b>");
				prev_index = ilist[1] + 1;
			}
		}
		if (prev_index < S.length()) {
			s.append(S.substring(prev_index, S.length()));
		}
		return s.toString();
	}

	public String validIPAddress(String IP) {

		if (isValidIPv4(IP)) {
			return "IPv4";
		}

		if (isValidIPv6(IP)) {
			return "IPv6";
		}

		return "Neither";
	}

	boolean isValidIPv4(String IP) {

		if (IP.length() > 15 && IP.length() < 7) {
			return false;
		}

		String[] A = IP.split("\\.", -1);

		if (A.length != 4) {
			return false;
		}

		for (String s : A) {

			if (s.startsWith("0")) {
				return false;
			}

			try {
				int num = Integer.parseInt(s);

				if (num < 0 || num > 255) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;

	}

	boolean isValidIPv6(String IP) {

		if (IP.length() > 39 && IP.length() < 15) {
			return false;
		}

		String[] A = IP.split(":", -1);

		if (A.length != 8) {
			return false;
		}

		for (String s : A) {

			if (s.length() > 4 || s.length() < 1) {
				return false;
			}

			try {
				Integer.parseInt(s, 16);

			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;

	}

	public String countAndSay(int n) {

		String str = "1";

		for (int i = 2; i <= n; i++) {

			System.out.println(str);
			char[] A = str.toCharArray();
			StringBuffer b = new StringBuffer();

			char c = A[0];
			int count = 1, index = 1;

			while (index < A.length) {
System.out.println(A[index]);
				if (A[index] == c) {
					index++;
					count++;
				} else {
					b.append(String.valueOf(count)).append(c);
					c = A[index];
					count = 1;
				}
			}
			
			if(count == 1) {
				b.append(String.valueOf(count)).append(c);
			}

			str = b.toString();
		}
		return str;
	}
	
	
	public String getHint(String secret, String guess) {

		int[] A = new int[10];
		int[] B = new int[10];

		int cows = 0, bulls = 0;
		for (int i = 0; i < secret.length(); i++) {

			if (secret.charAt(i) == guess.charAt(i)) {
				cows++;
			} else {
				A[Character.getNumericValue(secret.charAt(i))]++;
				B[Character.getNumericValue(guess.charAt(i))]++;
			}
		}

		for (int i = 0; i <= 9; i++) {
			bulls += Math.min(A[i], B[i]);
		}

		StringBuffer s = new StringBuffer();
		s.append(cows).append('A').append(bulls).append('B');
		return s.toString();
	}
	
	
	
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

		int min = Math.min(Math.min(arr1.length, arr2.length), arr3.length);
		int a = 0, b = 0, c = 0;

		List<Integer> list = new ArrayList<>();

		while (a < min && b < min & c < min) {

			if (arr1[a] == arr2[b] && arr1[a] == arr3[c]) {
				list.add(arr1[a]);
				a++;
				b++;
				c++;
			} else {

				if (arr1[a] > arr2[b]) {

					if (arr2[b] > arr3[c])
						c++;
					else
						b++;
				}

				else {

					if (arr1[a] > arr3[c])
						c++;
					else
						a++;
				}

			}
		}
		return list;
	}
	
	

	
	static class SortComparator implements Comparator<Character> {
		private final Map<Character, Integer> freqMap;

		// can pass values to comparator via constructor
		SortComparator(Map<Character, Integer> tFreqMap) {
			this.freqMap = tFreqMap;
		}

		@Override
		public int compare(Character k1, Character k2) {

			int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

			int valueCompare = k1.compareTo(k2);

			if (freqCompare == 0)
				return valueCompare;
			else
				return freqCompare;
		}
	}

	public static int leastInterval(char[] tasks, int n) {

		int[] A = new int[26];

		Map<Character, Integer> map = new HashMap<>();
		List<Character> outputArray = new ArrayList<>();

		for (Character current : tasks) {
			int count = map.getOrDefault(current, 0);
			map.put(current, count + 1);
			outputArray.add(current);
		}

		SortComparator comp = new SortComparator(map);

		Collections.sort(outputArray, comp);

		Queue<Character> queue = new LinkedList<>();
		int interval = 0;

		char prev = outputArray.get(0);
		queue.add(prev);
		A[prev - 'A']++;

		for (int i = 1; i < outputArray.size(); i++) {
			char curr = outputArray.get(i);
			if (curr != prev) {
				queue.add(curr);
			}
			A[curr - 'A']++;
			prev = curr;
		}

		int[] B = new int[26];
		while (!queue.isEmpty()) {

			Character task = queue.poll();
			
			System.out.println(task);
			interval++;

			int gap = interval - B[task - 'A'] - 1;

			if (B[task - 'A'] != 0 && gap < n) {
				interval += n - gap;
			}

			B[task - 'A'] = interval;

			A[task - 'A']--;
			if (A[task - 'A'] > 0) {
				queue.add(task);
			}
		}

		return interval;
	}
	
	

	public static List<Integer> firstTwoRepeatedElements(List<Integer> A) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int num : A) {

			Integer val = map.get(num);
			if (val == null) {
				val = 0;
			}
			map.put(num, val + 1);
		}

		ArrayList<Integer> B = new ArrayList<>();

		int index = 0;
		for (int num : A) {

			if (map.get(num) == 1) {
				B.add(index, num);
				index++;
			}

			if (index > 1) {
				break;
			}
		}
		return B;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(sortDates(Arrays.asList("05 Apr 2019", "01 Apr 2019")));
	}
	
	
	public static List<String> sortDates(List<String> dates) {

		Map<String, Integer> map = new HashMap<>();

		map.put("Jan", 1);
		map.put("Feb", 2);
		map.put("Mar", 3);
		map.put("Apr", 4);
		map.put("May", 5);
		map.put("Jun", 6);
		map.put("Jul", 7);
		map.put("Aug", 8);
		map.put("Sep", 9);
		map.put("Oct", 10);
		map.put("Nov", 11);
		map.put("Dec", 12);

		Collections.sort(dates, new DateComparator(map));

		return dates;
	}

	static class DateComparator implements Comparator<String> {

		Map<String, Integer> map;

		DateComparator(Map<String, Integer> map) {
			this.map = map;
		}

		@Override
		public int compare(String o1, String o2) {

			String[] A = o1.split(" ");
			String[] B = o2.split(" ");

			if (Integer.parseInt(A[2]) > Integer.parseInt(B[2])) {
				return 1;
			}

			else if (Integer.parseInt(A[2]) < Integer.parseInt(B[2])) {
				return -1;
			}

			else {

				if (map.get(A[1]) > map.get(B[1])) {
					return 1;
				}

				else if (map.get(A[1]) < map.get(B[1])) {
					return -1;
				}

				else {

					return Integer.compare(Integer.parseInt(A[0]), Integer.parseInt(B[0]));

				}

			}

		}
	}

}
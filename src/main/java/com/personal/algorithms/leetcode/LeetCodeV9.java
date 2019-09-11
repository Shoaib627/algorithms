package com.personal.algorithms.leetcode;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import com.personal.algorithms.lists.ListNode;

public class LeetCodeV9 {



	public static boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		ListNode slowPtr = head;
		ListNode fasrPtr = head;

		while (slowPtr.next != null && fasrPtr.next != null && fasrPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fasrPtr = fasrPtr.next.next;
		}

		ListNode rev;

		if (fasrPtr.next == null) {
			rev = slowPtr.next;
		} else {
			rev = slowPtr;
		}

		ListNode list = reverse(rev);

		ListNode current = head;
		ListNode s_current = list;

		while (s_current != null && current != null) {

			if (current.val != s_current.val) {
				return false;
			}
			current = current.next;
			s_current = s_current.next;
		}
		return true;
	}
	
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || m == n) {
			return head;
		}
		
		int i = 1;
		ListNode current = head;
		ListNode prev = null;
		while(i < m) {
			prev = current;
			current = current.next;
			i++;
		}
		
		
		i = 1;
		ListNode result = null;

		while (current != null && i < n) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
			i++;
		}

		prev.next = result;
				
		return head;
	}
	
	
	public static ListNode reverse(ListNode head, int k) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;
		ListNode result = null;

		int i = 1;
		while (current != null && k <= i) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
		}
		return result;
	}

	public static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;
		ListNode result = null;

		while (current != null) {

			ListNode temp = current.next;
			current.next = result;
			result = current;
			current = temp;
		}
		return result;
	}

	public static void reorderList(ListNode head) {

		if (head == null) {
			return;
		}

		ListNode slowPtr = head;
		ListNode fasrPtr = head;

		while (slowPtr.next != null && fasrPtr.next != null && fasrPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fasrPtr = fasrPtr.next.next;
		}

		ListNode rev;

		if (fasrPtr.next == null) {
			rev = slowPtr.next;
			slowPtr.next = null;
		} else {
			rev = slowPtr;
			slowPtr = null;
		}

		ListNode list = reverse(rev);

		ListNode current = head;
		ListNode s_current = list;

		while (s_current != null && current != null) {

			ListNode temp = current.next;
			ListNode temp2 = s_current.next;

			current.next = s_current;
			s_current.next = temp;

			s_current = temp2;
			current = temp;
		}
	}

	public static int largestValsFromLabelsV2(int[] values, int[] labels, int num_wanted, int use_limit) {

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < labels.length; i++) {
			map.merge(labels[i], new ArrayList<>(Arrays.asList(values[i])), (old, current) -> {
				old.addAll(current);
				return old;
			});
		}

		System.out.println(map);

		return use_limit;
	}

	public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i = 0; i < labels.length; i++) {

			if(map.containsKey(labels[i])) {
				PriorityQueue<Integer> list = map.get(labels[i]);	
				list.add(values[i]);
				map.put(labels[i], list);
				
			}
			
			else {
				PriorityQueue<Integer> q =  new PriorityQueue<>(Collections.reverseOrder());
				q.add(values[i]);
				map.put(labels[i], q);

			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			int index = 0;
			while (index < use_limit && !entry.getValue().isEmpty()) {
				queue.add(entry.getValue().poll());
				index++;
			}
		}

		int sum = 0;
		int index = 0;

		while (index < num_wanted && !queue.isEmpty()) {
			sum += queue.poll();
			index++;
		}
		return sum;
	}

	public int twoCitySchedCost(int[][] costs) {
		int minimum_cost = 0;

		int city_a = 0;
		int city_b = 0;

		for (int[] cost : costs) {
			if (city_a >= costs.length / 2) {
				minimum_cost += cost[1];
			} else if (city_b >= costs.length / 2) {
				minimum_cost += cost[0];
			} else {
				minimum_cost += Math.min(cost[0], cost[1]);
				if (cost[0] > cost[1]) {
					city_b++;
				} else {
					city_a++;
				}
			}
		}
		return minimum_cost;
	}
	
	public boolean hasGroupsSizeX(int[] deck) {

		int[] count = new int[10000];

		for (int card : deck) {
			count[card]++;
		}

		return findGCD(count, count.length) >= 2;
	}

	int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	int findGCD(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i < n; i++)
			result = gcd(arr[i], result);

		return result;
	}

	public String dayOfTheWeek(int day, int month, int year) {
		String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
		return weeks[weekOfDay];
	}
	



	public static int[][] intervalIntersection(int[][] A, int[][] B) {

		int i = 0;
		int j = 0;

		List<int[]> list = new ArrayList<>();

		while (i < A.length && j < B.length) {

			int[] a = A[i];

			int[] b = B[i];

			if (a[1] < b[0]) {
				i++;
			}

			else if (b[1] < a[0]) {
				j++;
			}

			else {

				int[] it = new int[2];

				it[0] = Math.max(a[0], b[0]);
				it[1] = Math.min(a[1], b[1]);

				if (a[1] < b[1]) {
					i++;
				}

				else {
					j++;
				}

				list.add(it);
			}

		}

		int[][] r = new int[list.size()][2];

		int index = 0;

		for (int[] it : list) {
			r[index++] = it;
		}

		return r;
	}
	
	
	
	public int minMoves(int[] nums) {

		int min = nums[0];
		int moves = 0;
		for (int i = 1; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			moves += nums[i] - min;
		}
		return moves;
	}
	
	

	
	public static int calculate(String s) {

		Stack<Character> stackA = new Stack<>();

		for (Character c : s.toCharArray()) {
			stackA.push(c);
		}

		return 0;
	}
	
	public double largestTriangleArea(int[][] p) {
		double res = 0;
		for (int[] i : p)
			for (int[] j : p)
				for (int[] k : p)
					res = Math.max(res, 0.5 * Math
							.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
		return res;
	}
	
	


	
	public boolean validMountainArray(int[] A) {

		int start = 0;
		int end = A.length - 1;

		while (start < A.length - 1 && (A[start] < A[start + 1])) {
			start++;
		}

		while (end > 0 && A[end] < A[end - 1]) {
			end--;
		}

		return start == end && start != A.length - 1 && end != 0;
	}
	

	
	public static int thirdMax(int[] nums) {

		Integer first_max = nums[0];
		Integer second_max = null;
		Integer third_max = null;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] >= first_max) {
				Integer temp = first_max;

				if (nums[i] > first_max) {
					Integer temp2 = second_max;
					second_max = temp;

					if (temp2 != null) {
						third_max = temp2;
					}
				}
				first_max = nums[i];

			} else {

				if (second_max == null) {
					second_max = nums[i];
				}

				else {

					if (nums[i] >= second_max) {

						Integer temp3 = second_max;

						if (nums[i] > second_max) {
							third_max = temp3;
						}
						second_max = nums[i];

					}

					else {

						if (third_max == null) {
							third_max = nums[i];
						}

						else {
							if (nums[i] > third_max) {
								third_max = nums[i];
							}
						}
					}
				}
			}
		}
		return third_max == null ? first_max : third_max;
	}
	
 	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

 		
 		System.out.println(Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]));
 		System.out.println(Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]));

 		
		if (Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])
				|| Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3])) {
			return true;
		}

		return false;
	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

		int area_1 = Math.abs(A - C) * Math.abs(B - D);

		System.out.println(area_1);
		int area_2 = Math.abs(E - G) * Math.abs(F - H);
		
		
		int overlap_area = 0;
		
        // We need to check if there is an overlap

		if (Math.max(A, E) < Math.min(C, G)
				&& Math.max(B, F) < Math.min(D, H)) {

			int a = Math.max(A, E);
			int b = Math.max(B, F);

			int c = Math.min(C, G);
			int d = Math.max(D, H);

			 overlap_area = Math.abs(a - c) * Math.abs(b - d);
		}



		return area_1 + area_2 - overlap_area;
	}
	
	
	public int triangleNumberV2(int[] nums) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				for (int k = j + 1; k < nums.length; k++) {

					int a = nums[i];
					int b = nums[j];
					int c = nums[k];

					if (a + b > c && b + c > a && c + a > b) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	
	
	public int triangleNumber(int[] nums) {

		Arrays.sort(nums);
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {

			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {

				int b = nums[j];
				for (int k = j + 1; k < nums.length; k++) {

					
					
					int c = nums[k];
					
					if(c > a+ b) {
						break;
					}

					if (a + b > c && b + c > a && c + a > b) {
						count++;
					}
					
				
				}
			}
		}
		return count;
	}
	
	
	
	


	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			result.add(getRangeString(lower, upper));
			return result;
		}

		Integer local_lower = lower;
		Integer last_digit = nums[0];

		if (nums[0] > lower) {
			result.add(getRangeString(local_lower, nums[0] - 1));
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= local_lower + 1 && last_digit != upper) {
				result.add(getRangeString(local_lower + 1, nums[i] - 1));
			}

			local_lower = nums[i];
			last_digit = nums[i];
		}

		if (last_digit != upper) {

			result.add(getRangeString(last_digit + 1, upper));
		}
		return result;
	}

	public static String getRangeString(Integer start, Integer end) {
		if (start == end) {
			return String.valueOf(start);
		}
		return String.valueOf(start) + "->" + String.valueOf(end);
	}

	public void rotate(int[][] matrix) {

		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {

				
				System.out.println(matrix[i][j]);
				
				System.out.println(matrix[j][i]);

				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {

			int start = 0;
			int end = n - 1;

			while (start < end) {

				int temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;

				start++;
				end--;
			}
		}
	}
	
	
    public int minFlipsMonoIncr(String S) {
        
    	String str;
		try {
			str = S.substring(S.indexOf('1'));
		} catch (Exception e) {
			return 0;
		}
    	int zero_count = 0;
    	int one_count = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == '0') {
    			zero_count++;
    		}
    		else {
    			one_count++;	
    		}
    	}

    	return Math.min(zero_count, one_count);
    }


    
	static class  IntervalComparatorV5 implements Comparator<int[]> {
		public int compare(int[] c1, int[] c2) {
			
			if(c1[0] < c2[0]) {
				return -1 ;
			}
			
			else if(c1[0] > c2[0]) {
				return 1 ;
			}
			
			else {
				return Integer.compare(c1[1], c2[1]);
			}
		}
	}

	static public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new IntervalComparatorV5());

		int[] prev = intervals[0];
		int count = 0;
		int index = 1;

		while (index < intervals.length) {
			int[] current = intervals[index];
			if (Math.max(current[0], prev[0]) < Math.min(current[1], prev[1])) {
				count++;
				
				if((current[1] < prev[1])){
					prev = current;
				}
				
			} else {
				prev = current;
			}
			index++;
		}
		return count;
	}
	
	


	public static boolean isLongPressedName(String name, String typed) {

		if (name.length() == 0 && typed.length() == 0) {
			return true;
		}

		if (name.length() == 0 || typed.length() == 0) {
			return false;
		}

		if (name.length() > typed.length()) {
			return false;
		}

		int name_index = 0;
		int typed_index = 0;

		while (typed_index < typed.length() && name_index < name.length()) {

			int c = name_index;
			while (c + 1 < name.length() && name.charAt(c) == name.charAt(c + 1)) {
				c++;
			}

			int d = typed_index;
			while (d + 1 < typed.length() && typed.charAt(d) == typed.charAt(d + 1)) {
				d++;
			}

			if (name.charAt(name_index) == typed.charAt(typed_index) && (c - name_index ) <= (d - typed_index ) ) {
				
				
				name_index = c   + 1;
				typed_index = d + 1;
			}

			else {
				return false;
			}
		}
		return name_index == name.length() && typed_index == typed.length()
				|| name_index == name.length() + 1 && typed_index == typed.length() + 1;
	}
	

	
	
	

	public  int countUnivalSubtrees(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int count = 0;
		isUnivalTree(root, count);

		return count;
	}

	public  boolean isUnivalTree(TreeNode root, int count) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			count++;
			return true;
		}

		boolean left = true, right = true;

		if (root.left != null) {
			left = isUnivalTree(root.left, count);
		}

		if (root.right != null) {
			right = isUnivalTree(root.right, count);
		}

		if (left && right && root.right != null && root.left != null && root.val == root.right.val
				&& root.right.val == root.left.val) {
			count++;
			System.out.println("*1**");

			return true;
		}

		else if (root.left  == null && root.right != null && right && root.val == root.right.val) {
			count++;
			return true;

		}

		else if (root.right  == null && root.left != null && left && root.val == root.left.val) {
			count++;
			return true;

		}

		return false;
	}
	

	
	public static int countLetters(String S) {

		int count = 0;
		int prev_index = 0;
		int index = 1;

		while (prev_index < S.length() && index < S.length()) {

			

			while (index  < S.length() && S.charAt(prev_index) == S.charAt(index)) {
				index++;
			}
			
			int c = index - prev_index;
			System.out.println(c);

			count += sum(c);
			prev_index = index;
			index = prev_index  + 1;
			
			
			if(prev_index == S.length() - 1) {
				count += 1;
			}

		}
		return count;
	}

	static int sum(int n) {
		return n*(n+1)/2;
	} 
	
	


	static int[][] mat ;
	
	static int r ;
	static int c ;

	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		
		r  = r0;
		c = c0;

		int[][] mat = new int[R * C][2];

		int index = 0;

		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {

				int[] a = new int[2];

				a[0] = i;
				a[1] = j;

				mat[index] = a;
				index++;
			}
		}

		Arrays.sort(mat, new MatComparator());

		return mat;
	}
	
	static class MatComparator implements Comparator<int[]> {
		public int compare(int[] c1, int[] c2) {

			int d1 = Math.abs(c1[0] - r) + Math.abs(c1[1] - c);
			int d2 = Math.abs(c2[0] - r) + Math.abs(c2[1] - c);

			return Integer.compare(d1, d2);

		}
	}
	
	
	
	public int[] relativeSortArray(int[] arr1, int[] arr2) {

		int[] arr_map = new int[1001];
		
		for (int i = 0; i < arr2.length; i++) {
			arr_map[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < arr2.length; i++) {
			arr_map[arr2[i]] = i;
		}

		System.out.println(Arrays.toString(arr_map));
		Integer[] a = new Integer[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			a[i] = arr1[i];
		}

		Arrays.sort(a, (x, y) -> {
			int diff = arr_map[x] - arr_map[y];
			return diff == 0 ? x - y : diff;
		});

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = a[i];
		}

		return arr1;
	}
    
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {

		if (start > destination) {

			int temp = start;
			start = destination;
			destination = temp;

		}

		System.out.println(start);
		System.out.println(destination);

		int a = 0;
		for (int i = start; i < destination; i++) {
			a = a + distance[start];
		}

		int temp = start;
		start = destination;
		destination = temp;

		int b = 0;

		for (int i = destination; i < distance.length; i++) {
			b = b + distance[start];
		}

		for (int i = 0; i < start; i++) {
			b = b + distance[start];
		}

		return Math.min(a, b);
	}
	



	public  int[][] generateMatrix(int n) {

		int[][] mat = new int[n][n];
		int size = n;
		
		int start = 0;
		
		int index = 1;
		
		while (size > 0) {
			index = fillupMatrix(mat, size, start, n - start, index);
			size = size - 2;
			start++;
		}
		
		
		return mat;
	}
	
	
	public  int fillupMatrix(int[][] mat, int n, int start, int end, int index) {
		
		System.out.println("start  " + start);
		System.out.println( "  n  " + n);

		
		if(n < 1) {
			return 0;
		}
		
		if(n == 1) {
			mat[start][start] = index;
			return 0; 
		}

		// right
		
		for(int i = start; i < end; i++) {
			mat[start][i] = index;
			index++;
		}
		
		// down
		for (int i = start + 1; i < end; i++) {
			mat[i][end - 1] = index;
			index++;
		}
		
		//left	
		for (int i = end - 2; i >= start; i--) {
			mat[end - 1][i] = index;
			index++;
		}
		
		// up
		for (int i = end - 2; i >= start + 1; i--) {
			mat[i][start] = index;
			index++;
		}
		
		return index;
	}

	public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>();
		
		if(matrix.length == 0) {
			return result;
		}

		int start = 0;
		int end = matrix[0].length;
		int height = matrix.length;

		while (start < end && height > 0) {
			result = fillupMatrix(matrix, start, end, height, result);
			start++;
			end--;
			height = height - 2;
		}

		return result;
	}


	public List<Integer> fillupMatrix(int[][] mat, int start, int end, int height, List<Integer> result) {

		System.out.println("start  " + start);
		System.out.println("  end  " + end);
		System.out.println("  height  " + height);

		// right

		for (int i = start; i <= end; i++) {
			result.add(mat[start][i]);
		}

		System.out.println("*** rihht*** . " + result);

		if (height > 0) {
			// down
			for (int i = start + 1; i <= start + height; i++) {
				result.add(mat[i][end]);
			}

			System.out.println("*** down*** . " + result);

			// left
			for (int i = end - 1; i >= start; i--) {
				result.add(mat[height + start][i]);

			}

			System.out.println("*** left*** . " + result);

			// up
			for (int i = start + height - 1; i >= start + 1; i--) {
				result.add(mat[i][start]);
			}
		}
		System.out.println(result);

		return result;
	}

}
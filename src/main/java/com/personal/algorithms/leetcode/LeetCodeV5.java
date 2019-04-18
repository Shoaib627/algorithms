package com.personal.algorithms.leetcode;

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

import com.personal.algorithms.lists.ListNode;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class LeetCodeV5 {

	public static void main(String[] args) {
		
	
		
		System.out.println(groupStrings(new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" }));

	}

	public static int romanToInt(String s) {

		char[] arr = s.toCharArray();
		int sum = 0;
		Character prev_c = null;

		for (int i = arr.length - 1; i >= 0; i--) {

			char c = arr[i];

			switch (c) {

			case 'I':
				if (prev_c != null && (prev_c == 'V' || prev_c == 'X')) {
					sum = sum - 1;

				} else {
					sum = sum + 1;
				}
				break;

			case 'V':

				sum = sum + 5;
				break;

			case 'X':
				if (prev_c != null && (prev_c == 'L' || prev_c == 'C')) {
					sum = sum - 10;

				} else {
					sum = sum + 10;
				}
				break;

			case 'L':
				sum = sum + 50;
				break;

			case 'C':
				if (prev_c != null && (prev_c == 'D' || prev_c == 'M')) {
					sum = sum - 100;

				} else {
					sum = sum + 100;
				}
				break;

			case 'D':
				sum = sum + 500;
				break;

			case 'M':
				sum = sum + 1000;
				break;

			}

			prev_c = c;

		}

		return sum;

	}

	public static String intToRoman(int num) {

		int arr[] = new int[4];

		int i = 3;
		while (num > 0 && i >= 0) {

			int r = num % 10;
			num = num / 10;

			arr[i] = r;
			i--;
		}

		StringBuffer b = new StringBuffer();

		for (int j = 0; j < arr.length; j++) {

			switch (j) {
			case 0:
				for (int k = 0; k < arr[j]; k++)
					b.append("M");
				break;

			case 1:

				if (arr[j] == 9) {
					b.append("CM");
				}

				else if (arr[j] == 8) {
					b.append("DCCC");
				}

				else if (arr[j] == 7) {
					b.append("DCC");
				}

				else if (arr[j] == 6) {
					b.append("DC");
				}

				else if (arr[j] == 5) {
					b.append("D");
				}

				else if (arr[j] == 4) {
					b.append("CD");
				}

				else if (arr[j] == 3) {
					b.append("CCC");
				}

				else if (arr[j] == 2) {
					b.append("CC");
				}

				else if (arr[j] == 1) {
					b.append("C");
				}

				break;

			case 2:

				if (arr[j] == 9) {
					b.append("XC");
				}

				else if (arr[j] == 8) {
					b.append("LXXX");
				}

				else if (arr[j] == 7) {
					b.append("LXX");
				}

				else if (arr[j] == 6) {
					b.append("LX");
				}

				else if (arr[j] == 5) {
					b.append("L");
				}

				else if (arr[j] == 4) {
					b.append("XL");
				}

				else if (arr[j] == 3) {
					b.append("XXX");
				}

				else if (arr[j] == 2) {
					b.append("XX");
				}

				else if (arr[j] == 1) {
					b.append("X");
				}

				break;

			case 3:

				if (arr[j] == 9) {
					b.append("IX");
				}

				else if (arr[j] == 8) {
					b.append("VIII");
				}

				else if (arr[j] == 7) {
					b.append("VII");
				}

				else if (arr[j] == 6) {
					b.append("VI");
				}

				else if (arr[j] == 5) {
					b.append("V");
				}

				else if (arr[j] == 4) {
					b.append("IV");
				}

				else if (arr[j] == 3) {
					b.append("III");
				}

				else if (arr[j] == 2) {
					b.append("II");
				}

				else if (arr[j] == 1) {
					b.append("I");
				}

				break;

			default:
				break;
			}

		}

		return b.toString();
	}

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();

		Map<Character, Integer> map2 = getFrequencyMap(p);

		for (int i = 0; i <= s.length() - p.length(); i++) {

			Map<Character, Integer> map1 = getFrequencyMap(s.substring(i, i + p.length()));

			if (map1.equals(map2)) {
				result.add(i);
			}
		}
		return result;
	}

	public static Map<Character, Integer> getFrequencyMap(String str) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		return map;
	}

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode middle_node = getMiddleElement(head);

		TreeNode root = new TreeNode(middle_node.val);

		root.left = sortedListToBST(head);

		root.right = sortedListToBST(middle_node.next);

		return root;

	}

	public ListNode getMiddleElement(ListNode headNode) {
		ListNode prevPtr = null;

		ListNode slowPtr = headNode;
		ListNode fastPtr = headNode;

		while (fastPtr != null && fastPtr.getNext() != null) {
			prevPtr = slowPtr;

			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}

		if (prevPtr != null) {
			prevPtr.next = null;
		}

		return slowPtr;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums.length == 0) {
			return null;
		}

		int i = nums.length / 2;

		TreeNode root = new TreeNode(nums[i]);

		if(i > 0)
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, i));
		
		if(i < nums.length - 1)
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, i + 1, nums.length));
        
		return root;

	}
	
	public int findTilt(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 0;

		}

		return 0;

	}
	
	
    public int dominantIndex(int[] nums) {
   	int max = Integer.MIN_VALUE;
		int max_index = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > max) {
				max = nums[i];
				max_index = i;
			}
		}

		
		System.out.println(max_index);
		for (int i = 0; i < nums.length; i++) {

			if (i != max_index && nums[i] < 2 * max) {
				return -1;
			}

		}

		return max_index;
    }
    
    
	public int searchInsert(int[] nums, int target) {

		return binarySearch(nums, 0, nums.length - 1, target);
	}

	public int binarySearch(int[] arr, int start, int end, int target) {
		if (start <= end) {

			int mid = start + ((end - start) / 2);

			if (arr[mid] == target) {
				return mid;
			}

			else if (arr[mid] > target) {
				return binarySearch(arr, start, mid - 1, target);
			}
			return binarySearch(arr, mid + 1, end, target);
		}
		return start;
	}
	
	public int removeDuplicates(int[] nums) {
		int slowPtr = 0;
		boolean can_move = true;
		for (int fastPtr = 1; fastPtr < nums.length; fastPtr++) {

			if (nums[fastPtr] != nums[slowPtr]) {
				nums[slowPtr++] = nums[fastPtr];
				can_move = true;
			}
			
		
			else if(slowPtr == 0 && nums [slowPtr] == nums [slowPtr+1] && can_move ) {
				slowPtr++;
				can_move = false;
			}

		}
		return slowPtr + 1;
	}
	
	
	public List<Boolean> prefixesDivBy5(int[] A) {
		String str = "";
		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {

			str += String.valueOf(A[i]);

			Integer r = Integer.parseInt(str, 2);

			if (r%5 == 0)
				result.add(true);
			else
				result.add(false);
		}
		return result;
	}
	

	
	public List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> mergedList = new LinkedList<>();
		Collections.sort(intervals, new IntervalComparator());

		for (Interval interval : intervals) {

			if (mergedList.isEmpty() || mergedList.getLast().end < interval.start) {
				mergedList.add(interval);
			}

			else {
				mergedList.getLast().end = Math.min(mergedList.getLast().end, interval.end);
			}
		}
		return mergedList;
	}

	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval c1, Interval c2) {
			return Integer.compare(c1.start, c2.start);
		}
	}
	
	class IntervalComparatorV2 implements Comparator<Interval> {
		public int compare(Interval c1, Interval c2) {
			return -Integer.compare(c1.end, c2.end);
		}
	}
	
	public int minMeetingRoomsV2(Interval[] intervals) {
        
        	if(intervals.length == 0) {
			return 0;
		}
        
		Arrays.sort(intervals, new IntervalComparator());
		LinkedList<Interval> rooms = new LinkedList<>();
	
		for (Interval interval : intervals) {

			if (rooms.isEmpty() || rooms.getLast().end > interval.start) {
				rooms.add(interval);

			}
			else {
				rooms.getLast().start = interval.start;
				rooms.getLast().end = interval.end;

			}
			// Instead of sorting after every iteration u a min heap
            Collections.sort(rooms, new IntervalComparatorV2());

		}
		return rooms.size();
	}
	
	
	public int minMeetingRooms(Interval[] intervals) {

		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new IntervalComparator());

		PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

		for (Interval interval : intervals) {

			if (minHeap.isEmpty() || minHeap.peek().end > interval.start) {
				minHeap.add(interval);

			} else {
				Interval room = minHeap.poll();
				room.start = interval.start;
				room.end = interval.end;

				minHeap.add(room);

			}

		}
		return minHeap.size();
	}
	
	public static List<Integer> partitionLabels(String S) {

		LinkedList<Integer> result = new LinkedList<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}

		int cur_partition = map.get(S.charAt(0));
		int start_index = 0;

		for (int i = 0; i < S.length(); i++) {
			
			if (cur_partition <= map.get(S.charAt(i))) {
				cur_partition = map.get(S.charAt(i));
			}
			
			if (i == cur_partition) {
				result.add(cur_partition - start_index + 1);
				start_index = i + 1;
			}  
		}
		return result;
	}
	
	public static int maxArea(int[] height) {

		int start = 0;
		int end = height.length - 1;

		int max_area = Integer.MIN_VALUE;

		while (start <= end) {

			int area = Math.min(height[start], height[end]) * (end - start);

			if (area > max_area) {
				max_area = area;
			}

			if (height[start] < height[end]) {
				start++;
			} else {
				end--;
			}
		}
		return max_area;
	}
	
	
	static class  IntervalComparatorV3 implements Comparator<Interval> {
		public int compare(Interval c1, Interval c2) {
			return Integer.compare(c1.end, c2.end);
		}
	}
	
	public static int findMinArrowShots(int[][] points) {

		ArrayList<Interval> list = new ArrayList<>();

		for (int i = 0; i < points.length; i++) {
			list.add(new Interval(points[i][0], points[i][1]));
		}
		Collections.sort(list, new IntervalComparatorV3());

		int count = 1;

		int last_arrow = list.get(0).end;

		for (int i = 1; i < list.size(); i++) {

			Interval current = list.get(i);

			if (last_arrow < current.start) {
				last_arrow = current.end;
				count++;
			}

		}

		return count;

	}
	
	static class  IntervalComparatorV5 implements Comparator<Interval> {
		public int compare(Interval c1, Interval c2) {
			
			if(c1.start < c2.start) {
				return -1 ;
			}
			
			else if(c1.start > c2.start) {
				return 1 ;
			}
			
			else {
				return Integer.compare(c1.end, c2.end);
			}
		}
	}

	static public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new IntervalComparatorV5());
		
		Interval prev = intervals[0];
		int count = 0;
		for (int i = 1; i < intervals.length; i++) {

			Interval current = intervals[i];
			if(prev.start == current.start && prev.end == current.end) {
				count ++;
			}
			
			
			else if(prev.end > current.start && prev.end < current.end) {
				count ++;
				
			}
			else {
				prev = current;
			}
			
		}
		return count;
	}
	
	
	static Map<Integer, Double> map = new HashMap<>();

	public static double myPow(double x, int p) {
		
		if (map.containsKey(p)) {
			return map.get(p);
		}

		if (p == 0) {
			return 1;
		}

		else if (p == 1) {
			return x;
		}
		
		else if (p == -1) {
			return 1 / x;
		}

		double a;
		if (p % 2 == 0) {
			a = myPow(x, p / 2) * myPow(x, p / 2);
		}

		else {
			a = myPow(x, p / 2) * myPow(x, p > 0 ? ((p / 2) + 1) : ((p / 2) - 1));

		}
		map.put(p, a);
		return a;
	}


	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {

			String s = tokens[i];

			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

				Integer second = stack.pop();
				Integer first = stack.pop();

				if (s.equals("+"))
					stack.push(first + second);

				if (s.equals("-"))
					stack.push(first - second);

				if (s.equals("*"))
					stack.push(first * second);

				if (s.equals("/"))
					stack.push(first / second);

			}

			else {

				stack.push(Integer.parseInt(s));
			}

		}

		return stack.pop();

	}
	
	
    public String[] findRelativeRanks(int[] nums) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		
    		map.put(nums[i], i);
    	}
    	
    	System.out.println(map);
    	String[] result = new String[nums.length];
    	
    	Arrays.sort(nums);
    	
    	int count = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			
			if(count == 1) {
				result[map.get(nums[i])] = "Gold Medal";
				
			}
			
			else if(count == 2) {
				result[map.get(nums[i])] = "Silver Medal";
				
			}
			
			else if(count == 3) {
				result[map.get(nums[i])] = "Bronze Medal";
				
			}
			
			else {
				result[map.get(nums[i])] = String.valueOf(count);
				
			}
			count++;

		}
		
		return result;
        
    }
    
    
	public static int myAtoi(String str) {

		if (str.length() == 0) {
			return 0;
		}

		StringBuffer b = new StringBuffer();

		int i = 0;

		boolean isNegative = false;
		boolean hasDigits = false;

		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}

		if (i < str.length()) {
			if (str.charAt(i) != '+' && str.charAt(i) != '-' && !isCharacterDigit(str.charAt(i))) {
				return 0;
			}

			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				if (str.charAt(i) == '-') {
					isNegative = true;
					b.append(str.charAt(i));
				}
				i++;
			}

			while (i < str.length() && isCharacterDigit(str.charAt(i))) {
				hasDigits = true;
				b.append(str.charAt(i));
				i++;
			}
		}

		if (!hasDigits) {
			return 0;
		}

		int a;
		try {
			a = Integer.parseInt(b.toString());
		} catch (NumberFormatException e) {

			if (isNegative) {
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}

		return a;
	}

	public static boolean isCharacterDigit(Character c) {
		return (c >= '0' && c <= '9');
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> dups = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				int sum = nums[i] + nums[j];

				if (dups.contains(-sum)) {

					List<Integer> local = new ArrayList<>();

					local.add(nums[i]);
					local.add(nums[j]);
					local.add(-sum);

					result.add(local);

				} else {
					dups.add(nums[j]);
				}
			}
		}
		return result;
	}
	
	
	
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    
	public static boolean checkPossibility(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {

				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
				count++;
			}
		}
		return count == 1;
	}



	public boolean queryString(String S, int N) {
		for (int i = 1; i <= N; i++) {
			if (!S.contains(Integer.toString(i, 2))) {
				return false;
			}
		}
		return false;
	}
	
	

	
	
	
	public static boolean isValid(String S) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {

			char c = S.charAt(i);

			if (c == 'a' || c == 'b')
				stack.push(c);

			else {

				if (!stack.isEmpty() && stack.peek() == 'b') {
					stack.pop();
					if (!stack.isEmpty() && stack.peek() == 'a') {
						stack.pop();
					} else {
						return false;

					}
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();

	}

	public static void processStack(Stack<Character> stack) {

		if (!stack.isEmpty() && stack.peek() == 'c') {
			stack.pop();
			if (!stack.isEmpty() && stack.peek() == 'b') {
				stack.pop();
				if (!stack.isEmpty() && stack.peek() == 'a') {
					stack.pop();
				} else {
					stack.push('b');
					return;

				}
			} else {
				stack.push('c');
				return;
			}
		}

		if (!stack.isEmpty() && stack.peek() == 'c') {
			processStack(stack);
		} else {
			return;
		}
	}

	public static String reverseStr(String s, int k) {

		boolean rev = true;
		char[] arr = s.toCharArray();


		for (int i = 0; i < s.length(); i++) {

			if (i % k == 0 && rev ) {
				if (i + k - 1 < s.length()) {
					reverseString(arr, i, i + k - 1);
				}
				else {
					reverseString(arr, i, s.length() -1);
				}
			}

			if (i % k == 0) {
				rev = !rev;
			}
		}

		return new String(arr);
	}

	public static void reverseString(char[] s, int start_index, int end_index) {

		int j = end_index;
		for (int i = start_index; i <= (start_index + end_index) / 2; i++) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			j--;
		}
	}
	
	
	
	public static int compareVersion(String version1, String version2) {
		int max = Math.max(version1.length(), version2.length());

		int[] arr_1 = new int[max];
		int[] arr_2 = new int[max];

		String[] A = version1.split(".");
		String[] B = version2.split(".");

		for (int i = 0; i < A.length; i++) {
			arr_1[i] = Integer.parseInt(removeZero(A[i]));
		}

		for (int i = 0; i < B.length; i++) {
			arr_2[i] = Integer.parseInt(removeZero(B[i]));
		}
		
		System.out.println(Arrays.toString(arr_1));
		System.out.println(Arrays.toString(arr_2));


		int i = 0;
		while (i < max) {

			if (arr_1[i] > arr_2[i])
				return 1;

			if (arr_1[i] < arr_2[i])
				return -1;

			else
				i++;
		}

		return 0;

	}

	public static String removeZero(String str) {
		if (str.length() == 1) {
			return str;
		}

		int i = 0;
		while (str.charAt(i) == '0')
			i++;

		StringBuffer sb = new StringBuffer(str);

		sb.replace(0, i, "");

		return sb.toString();
	}
	
	
	public static String[] reorderLogFiles(String[] logs) {

		System.out.println(Arrays.toString(logs));

		Arrays.sort(logs, new StringComparator());

		System.out.println(Arrays.toString(logs));

		return logs;
	}

	static class StringComparator implements Comparator<String> {
		public int compare(String c1, String c2) {

			String[] A = c1.split(" ");
			String[] B = c2.split(" ");

			boolean isADigit = Character.isDigit(A[1].charAt(0));
			boolean isBDigit = Character.isDigit(B[1].charAt(0));

			if (isADigit && isBDigit) {
				return 0;
			}

			else if (!isADigit && !isBDigit) {
				return c1.substring(A[0].length() + 1, c1.length())
						.compareTo(c2.substring(B[0].length() + 1, c2.length()));
			}
			return isADigit ? 1 : -1;
		}
	}

	public int repeatedStringMatch(String A, String B) {

		Set<Character> a_set = new HashSet<>();

		for (int i = 0; i < A.length(); i++) {
			a_set.add(A.charAt(i));

		}

		for (int i = 0; i < B.length(); i++) {

			if (!a_set.contains(B.charAt(i))) {
				return -1;
			}
		}

		StringBuffer a = new StringBuffer(A);

		int count = 1;
		while (!a.toString().contains(B)) {
			if (a.length() > Integer.MAX_VALUE) {
				return -1;
			}

			a.append(A);

			count++;
		}

		return count;
	}
	
	
	public static String findContestMatch(int n) {

		int count = -1;

		while (n > 0) {
			n = n / 2;
			count++;
		}

		System.out.println(count);
		return "0";
	}

	public static int smallestFactorization(int a) {

		StringBuffer b = new StringBuffer();
		int temp = a;

		while (temp > 9) {
			int r = getHighestSingleDigitFactor(temp);
			if (r != 0) {
				b.append(r);
				temp = temp / r;
			} else {
				return 0;
			}

		}

		b.append(temp);
		char[] arr = b.toString().toCharArray();
		Arrays.sort(arr);
		try {
			return Integer.parseInt(new String(arr));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int getHighestSingleDigitFactor(int a) {

		if (a < 9) {
			return 9;
		}
		for (int i = 9; i > 1; i--) {

			if (a % i == 0) {
				return i;
			}
		}
		return 0;
	}
	
	public static List<String> findStrobogrammatic(int n) {

		StringBuffer start = new StringBuffer();

		start.append(1);
		for (int i = 1; i < n; i++) {
			start.append(0);
		}

		StringBuffer end = new StringBuffer();

		for (int i = 0; i < n; i++) {
			end.append(9);
		}

		String cur = start.toString();
		List<String> result = new ArrayList<>();

		while (!cur.equals(end.toString())) {

			if (isStrobogrammatic(cur)) {
				result.add(cur);
			}

			cur = addStrings(cur, "1");
		}

		return result;
	}

	public static String addStrings(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();

		StringBuffer result = new StringBuffer();

		int i = a.length - 1;
		int j = b.length - 1;

		int carry_over = 0;

		while (i >= 0 || j >= 0) {
			int i_digit = i < 0 ? 0 : Character.getNumericValue(a[i]);
			int j_digit = j < 0 ? 0 : Character.getNumericValue(b[j]);

			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if (digit >= 10) {

				digit = digit % 10;
				carry_over = 1;
			}
			i--;
			j--;
			result.append(String.valueOf(digit));
		}

		if (carry_over == 1) {
			result.append(String.valueOf(carry_over));
		}

		return result.reverse().toString();

	}

	public static boolean isStrobogrammatic(String num) {
		char[] arr = num.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {

			if (!((arr[i] == '6' && arr[j] == '9') || (arr[i] == '9' && arr[j] == '6')
					|| (arr[i] == '8' && arr[j] == '8') || (arr[i] == '1' && arr[j] == '1')
					|| (arr[i] == '0' && arr[j] == '0'))) {
				return false;
			}
			if (i == j && (arr[i] != '6' && arr[i] != '9' && arr[i] != '0' && arr[i] != '1' && arr[i] != '8')) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static int num(int num) {

		List<Integer> list = new ArrayList<>();

		int temp = num;
		while (temp > 0) {

			int r = temp % 10;
			list.add(r);
			temp = temp / 10;

		}

		Collections.reverse(list);

		System.out.println(list);

		StringBuffer b = new StringBuffer();

		int prev_dgit = 0;
		for (int i = 0; i < list.size(); i++) {

			Integer digit = list.get(i);
			if (digit % 2 == 0) {
				b.append(digit);
			} else {

				if (i == list.size() - 1) {
					if (prev_dgit % 2 == 0) {
						b.append((digit + 1) % 10);
					}
				} else {

					Integer next_digit = list.get(i + 1);
					prev_dgit = digit;
					digit = (next_digit > 5 ? digit + 1 : digit - 1) % 10;
					b.append(digit);

				}
			}
		}

		System.out.println(b.toString());
		return 0;
	}
	
	public static String reorganizeString(String S) {

		Map<Character, Integer> fmap = getFrequencyMapV2(S);
		PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<Map.Entry<Character, Integer>>(new CC());

		for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
			q.add(entry);
		}

		char[] arr = new char[S.length()];

		for (int i = 0; i < S.length(); i++) {
			arr[i] = '0';
		}

		int i = 0;

		
		while (i < S.length() && !q.isEmpty()) {
			Entry<Character, Integer> entry = q.poll();

			int count = 0;
			int started_from = i;

			while (count < entry.getValue() && i < S.length()) {

				arr[i] = entry.getKey();
				count++;
				if (count < entry.getValue()) {
					i = i + 2;
				}
			}

			if (count < entry.getValue()) {
				return "";
			}

			if (((started_from + 1) < S.length()) && arr[started_from + 1] == '0') {
				i = (started_from + 1);
			}

			else {

				while (i < S.length() && S.charAt(i) != '0') {
					i = i + 1;
				}
			}

		}

		return q.isEmpty() ? new String(arr) : "";
	}

	static class CC implements Comparator<Map.Entry<Character, Integer>> {
		@Override
		public int compare(Entry<Character, Integer> s1, Entry<Character, Integer> s2) {
			if (s1.getValue() < s2.getValue())
				return 1;
			else if (s1.getValue() > s2.getValue())
				return -1;
			return 0;
		}
	}

	static public Map<Character, Integer> getFrequencyMapV2(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		return map;
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] arr = new int[nums1.length + nums2.length];

		int i = 0;
		int j = 0;

		int k = 0;

		while (i < nums1.length && j < nums2.length) {

			if (nums1[i] > nums2[j]) {
				arr[k] = nums2[j];
				k++;
				j++;
			}

			else if (nums2[j] > nums1[i]) {
				arr[k] = nums1[i];
				k++;
				i++;

			} else {
				arr[k] = nums1[i];
				k++;
				i++;

				arr[k] = nums2[j];
				k++;
				j++;
			}
		}

		while (j < nums2.length) {
			arr[k] = nums2[j];
			k++;
			j++;
		}

		while (i < nums1.length) {
			arr[k] = nums1[i];
			k++;
			i++;
		}
		
		if ((nums1.length + nums2.length) % 2 == 1) {
			return arr[(nums1.length + nums2.length) / 2];
		}
		
		else {
			int len = nums1.length + nums2.length;
			return (arr[len/2] + arr[(len/2) - 1])/2.0;
		}
	
	}
	
	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max_so_far = Integer.MIN_VALUE;
		int cur_sum = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (cur_sum < 0 && nums[i] >= 0) {
				cur_sum = nums[i];
			}

			else {
				cur_sum = cur_sum + nums[i];
			}

			if (cur_sum > max_so_far) {
				max_so_far = cur_sum;
			}

		}
		return max_so_far;
	}
	
	
    public static int maxProduct(int[] nums) {
        
    	if (nums == null || nums.length == 0) {
			return 0;
		}
    	
		int max_pos_so_far = Integer.MIN_VALUE;
		int max_obsolute_so_far = 0;
		
		int cur_pos_product = 1;
		int cur_obsolute_product = 1;
		int local_obsolute_product = 1;
		
		for (int i = 0; i < nums.length; i++) { 
			
			if (nums[i] == 0) {
				cur_pos_product = 1;
				cur_obsolute_product = 1;
				local_obsolute_product = 1;
			}
			
	

			else if (nums[i] > 0) {
				cur_pos_product = cur_pos_product * nums[i];
				cur_obsolute_product = cur_obsolute_product * nums[i];
				local_obsolute_product = local_obsolute_product * nums[i];
			}

			else {
				cur_pos_product = 1;
				cur_obsolute_product = cur_obsolute_product * nums[i];
				local_obsolute_product = local_obsolute_product * nums[i];

			}

			if (cur_pos_product > max_pos_so_far) {
				local_obsolute_product = 1;
				max_pos_so_far = cur_pos_product;
			}
			
			if (Math.abs(cur_obsolute_product) > max_obsolute_so_far) {
				max_obsolute_so_far = cur_obsolute_product;
			}
		}
 
		return Math.max(cur_obsolute_product, cur_pos_product);	
    }
    
    
	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		
		
		int[] b = { 1 };
		
		
	 
		while(!A.isEmpty()) {
		
			if(A.get(0) == 0) {
				A.remove(0);
			}
			
			else {
				break;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		int i = A.size() - 1;
		int j = b.length - 1;

		int carry_over = 0;

		while (i >= 0 || j >= 0) {
			int i_digit = i < 0 ? 0 : A.get(i);
			int j_digit = j < 0 ? 0 : Character.getNumericValue(b[j]);

			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if (digit >= 10) {

				digit = digit % 10;
				carry_over = 1;
			}
			i--;
			j--;
			list.add(digit);
		}

		if (carry_over == 1) {
			list.add(carry_over);
		}

		Collections.reverse(list);
		
		
		 
		while(!list.isEmpty()) {
		
			if(list.get(0) == 0) {
				list.remove(0);
			}
			
			else {
				break;
			}
		}

		return list;
	}
	
	public String removeDuplicateLetters(String s) {

		SortedSet<Character> set = new TreeSet<>();

		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		StringBuffer b = new StringBuffer();
		Iterator<Character> it = set.iterator();

		while (it.hasNext()) {
			b.append(it.next());
		}

		return b.toString();

	}
	   
		public static Map<Character, Integer> getFrequencyMapV3(String str) {

			Map<Character, Integer> map = new HashMap<Character, Integer>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			return map;
		}

	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> s = new Stack<>();

		int j = 0;

		for (int i = 0; i < popped.length; i++) {

			if (!s.isEmpty() && s.peek() == popped[i]) {
				s.pop();
			} else {

				if (j >= pushed.length) {
					return false;
				}

				while (j < pushed.length && pushed[j] != popped[i]) {
					s.push(pushed[j]);
					j++;
				}

				if (j < pushed.length && pushed[j] == popped[i]) {
					s.push(pushed[j]);
					j++;
				}

				else if (j < pushed.length && pushed[j] != popped[i]) {
					return false;
				}

				if (s.pop() != popped[i]) {
					return false;
				}

			}
		}
		return true;
	}
	
	
	public static int scoreOfParentheses(String S) {

		Stack<String> s = new Stack<>();

		for (int i = 0; i < S.length(); i++) {

			Character c = S.charAt(i);

			if (c.equals('(')) {
				s.push(c.toString());
			}

			else {
				int local_score = 0;

				while (!s.isEmpty()) {

					String x = s.pop();

					if (!x.equals("(")) {

						if (s.isEmpty()) {
							return Integer.parseInt(x);
						}
						local_score = local_score + Integer.parseInt(x);
					}

					else {

						int y = local_score == 0 ? 1 : (2 * local_score);
						s.push(String.valueOf(y));
						break;

					}

				}

			}
		}
		int score = 0;

		while (!s.isEmpty())
			score += Integer.parseInt(s.pop());
		return score;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	public int sum = 0;

	public TreeNode convertBST(TreeNode root) {

		if (root == null) {
			return null;
		}

		inOrder(root);
		System.out.println(sum);
		preOrder(root);

		return root;

	}

	public void inOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);
		sum = sum + root.val;
		inOrder(root.right);
	}

	public void preOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);
		int temp = root.val;
		root.val = sum;
		sum = sum - temp;
		inOrder(root.right);
	}
	
	
	static public List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {

			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String s = new String(arr);
			List<String> list = map.getOrDefault(s, new ArrayList<>());
			list.add(strs[i]);

			map.put(s, list);
		}

		List<List<String>> f = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			f.add(entry.getValue());
		}

		return f;

	}

    static public Map<Character, Integer> getFrequencyMapV4(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		System.out.println(map);

		return map;
	}
	
	
	static public String getStringFromMap(Map<Character, Integer> map) {

		StringBuffer b = new StringBuffer();

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			b.append(entry.getKey() + "_" + entry.getValue());
		}

		return b.toString();
	}
	
	public static List<List<String>> groupStrings(String[] strings) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		Map<String, String> lookupMap = new HashMap<>();

		for (int i = 0; i < strings.length; i++) {

			if (lookupMap.containsKey(strings[i])) {

				String val = lookupMap.get(strings[i]);

				List<String> res = map.get(val);

				res.add(strings[i]);

				map.put(val, res);
			}

			else {

				List<String> seqList = getAllSequences(strings[i]);

				for (int j = 0; j < seqList.size(); j++) {
					lookupMap.put(seqList.get(j), strings[i]);
				}

				List<String> list = map.getOrDefault(strings[i], new ArrayList<>());
				list.add(strings[i]);

				map.put(strings[i], list);

			}
		}

		List<List<String>> result = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			result.add(entry.getValue());
		}
		return result;
	}

	public static List<String> getAllSequences(String str) {
		List<String> result = new ArrayList<>();

		String cur = str;
		do {
			result.add(cur);
			cur = getNextSequence(cur);
		} while (!cur.equals(str));
		return result;
	}

	public static String getNextSequence(String str) {

		char[] arr = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			int temp = (arr[i] + 1);

			if (temp > 122) {
				temp = temp - 26;
			}

			arr[i] = (char) (temp);

		}

		return new String(arr);

	}
	
	public boolean isIsomorphic(String s, String t) {
		
		if(s.length()!=t.length())
			return false;
		
		Map<Character, Integer> map = new HashMap<>();
		int count = 1;
		
		int[] arr_1 = new int[s.length()];
		int[] arr_2 = new int[t.length()];

		
		for(int i = 0; i < s.length(); i++) {
			
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), count);
				arr_1[i] = count;
				count ++;
				
			}
			else {
				arr_1[i] = map.get(s.charAt(i));
			}
		}

		map = new HashMap<>();
		count = 1;
		for (int i = 0; i < t.length(); i++) {

			if (!map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), count);
				arr_2[i] = count;
				count++;

			} else {
				arr_2[i] = map.get(t.charAt(i));
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			if(arr_1[i] != arr_2[i]) {
				return false;
			}
		}
	
		return true;

	}
	
	   public int getMinimumDifference(TreeNode root) {
		   ArrayList<Integer> list = new ArrayList<>();
		   inOrderV5(root, list);
		   System.out.println(list);
		   
		   int diff = Integer.MAX_VALUE;
		   for(int i = 0; i < list.size() - 1; i++) {
			   if(list.get(i+1) - list.get(i ) < diff) {
				   diff = list.get(i+1) - list.get(i );
			   }
		   }
		   return diff;
	    }
	   

		public void inOrderV5(TreeNode root, ArrayList<Integer> list ) {

			if (root == null) {
				return;
			}

			inOrderV5(root.left, list);
			list.add(root.val);
			inOrderV5(root.right, list);
		}

}
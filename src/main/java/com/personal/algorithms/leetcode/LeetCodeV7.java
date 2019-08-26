package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LeetCodeV7 {

	public static void main(String[] args) {

		duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });		
		
	}
	
	
	public int expressiveWords(String S, String[] words) {
		return 1;
	}

	public static boolean canBeStretchy(String S, String word) {

		int current_word_index = 0;
		int current_string_index = 0;

		int start_word_index = 0;
		int start_string_index = 0;

		boolean is_strechy = false;
		while (start_string_index < word.length()) {

			if (word.charAt(start_word_index) != S.charAt(start_string_index)) {
				return false;
			}

			System.out.println(word.charAt(start_word_index));
			System.out.println(word.charAt(current_word_index));

			while (current_word_index < word.length()
					&& word.charAt(start_word_index) != word.charAt(current_word_index)) {
				current_word_index++;
			}


			while (current_string_index < word.length()
					&& word.charAt(start_string_index) != word.charAt(current_string_index)) {
				current_string_index++;
			}


			if ((current_word_index - start_word_index) <= (current_string_index - start_string_index)
					&& current_string_index - start_string_index + 1 >= 3) {
				is_strechy = true;
			}
			start_string_index = current_string_index;
			start_word_index = current_word_index;

		}

		return is_strechy;

	}

	public static boolean repeatedSubstringPattern(String s) {

		int length = s.length();
		
		

		for (int i = length / 2; i >= 1; i--) {
			if (length % i == 0) {

				int k = i;
				


				String str = s.substring(0, k);
				


				StringBuffer b = new StringBuffer();

				for (int j = 0; j < length/i; j++) {
					b.append(str);
				}

				if (b.toString().equals(s)) {
					return true;
				}

			}
		}

		return false;
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
			if (a.length() > 2*B.length()) {
				return -1;
			}

			a.append(A);

			count++;
		}

		return count;
	}
	
	
	public class NestedIterator implements Iterator<Integer> {

		List<Integer> list;
		Iterator<Integer> itr;

		public NestedIterator(List<NestedInteger> nestedList) {

			list = new ArrayList<Integer>();

			helper(nestedList);

			this.itr = list.iterator();
		}

		public void helper(List<NestedInteger> nestedList) {

			nestedList.forEach(l -> {

				if (l.isInteger()) {
					list.add(l.getInteger());
				}

				else {
					helper(l.getList());
				}
			});
		}

		@Override
		public Integer next() {
			return itr.next();

		}

		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}
	}
	

	
	
	public int findLHS(int[] nums) {

		int lhs = 0;

		Map<Integer, Integer> map = getCharFrequencyMap(nums);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (map.containsKey(entry.getKey() + 1)) {

				int r = map.get(entry.getKey() + 1);
				if (lhs < r + entry.getValue()) {
					lhs = r + entry.getValue();
				}

			}

			if (map.containsKey(entry.getKey() - 1)) {

				int k = map.get(entry.getKey() - 1);
				if (lhs < k + entry.getValue()) {
					lhs = k + entry.getValue();

				}
			}
		}

		return lhs;
	}
    
	public Map<Integer, Integer> getCharFrequencyMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		return map;
	}

	public String toHex(int num) {
		return Integer.toHexString(num);
	}
	
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {

		if (nums.length == 0 || nums[0].length * nums.length != r * c) {
			return nums;
		}

		int[][] result = new int[r][c];

		int x = 0;
		int y = 0;

		for (int i = 0; i < nums.length; i++) {

			for (int j = 0; j < nums[i].length; j++) {

				result[x][y] = nums[i][j];

				y++;

				if (y == c) {
					y = 0;
					x = x + 1;
				}
			}
		}
		return result;
	}

	public String removeDuplicates(String S) {

		if (S.length() == 1) {
			return S;
		}

		Stack<Character> stack = new Stack<>();

		stack.push(S.charAt(0));

		char[] arr = S.toCharArray();

		for (int i = 1; i < arr.length; i++) {

			if (!stack.isEmpty() && stack.peek() == arr[i]) {
				do {
					stack.pop();
				} while (!stack.isEmpty() && stack.peek() == arr[i]);
			}

			else {
				stack.push(arr[i]);
			}
		}

		StringBuffer b = new StringBuffer();
		while (!stack.isEmpty()) {
			b.append(stack.pop());
		}

		return b.reverse().toString();
	}
	
	
	public static void duplicateZeros(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0 && i + 1 < arr.length) {

				int temp = arr[i + 1];
				for (int j = i + 1; j < arr.length - 1; j++) {

					int c = arr[j + 1];
					arr[j + 1] = temp;
					temp = c;
				}

				arr[i + 1] = 0;
				i++;
			}
		}
	}
	
	
	   public String baseNeg2(int N) {
	      return  Integer.toUnsignedString(N, -2);
	    }

	public int findLUSlength(String a, String b) {
		return Math.min(a.length(), b.length());
	}
	
	public int findLUSlength(String[] strs) {

		String str = strs[0];
		boolean is_same = true;
		int max = 0;

		for (int i = 1; i < strs.length; i++) {

			if (!str.equals(strs[i])) {
				is_same = false;

			}

			if (strs[i].length() > max) {
				max = strs[i].length();
			}
		}

		if (is_same) {
			return -1;
		}

		return max;
	}
	
	
	public static int titleToNumber(String s) {

		char[] arr = s.toCharArray();

		int r = 1;
		int sum = 0;
		
		for (int i = 0; i < arr.length - 1; i++) {

			int j = arr[i] - 'A' + 1;
			
			r *= j*26;
		}
		
		System.out.println("8888 " + r);
		
		if(s.length() <= 1) {
			r = 0;
		}

		sum = r + arr[arr.length - 1] - 'A' + 1;
		return sum;
	}
	
	public int leastBricks(List<List<Integer>> wall) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < wall.size(); i++) {

			List<Integer> list = wall.get(i);

			int sum = 0;
			for (int j = 0; j < list.size(); j++) {

				int k = list.get(j);

				sum += k;

				map.put(sum, map.getOrDefault(sum, 0) + 1);

			}
		}

		System.out.println(map);
		
		if(map.isEmpty()) {
			return wall.size();
		}
		
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() > max) {
				max = entry.getValue();
			}

		}

		int c = 0;
		for (int i = 0; i < wall.get(0).size(); i++) {
			c += wall.get(0).get(i);
		}
		System.out.println(c);

		return c - max;
	}
}

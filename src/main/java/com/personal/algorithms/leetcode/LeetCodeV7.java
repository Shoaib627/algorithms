package com.personal.algorithms.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.personal.algorithms.lists.ListNode;

public class LeetCodeV7 {

	public static void main(String[] args) {

		System.out.println(numPrimeArrangements(100));
		

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

				for (int j = 0; j < length / i; j++) {
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
			if (a.length() > 2 * B.length()) {
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
		return Integer.toUnsignedString(N, -2);
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

			r *= j * 26;
		}

		System.out.println("8888 " + r);

		if (s.length() <= 1) {
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

		if (map.isEmpty()) {
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

	public int climbStairs(int n) {

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		int a = 1;
		int b = 2;
		int c = 0;
		for (int i = 3; i <= n; i++) {

			c = a + b;
			a = b;
			b = c;
		}

		return c;
	}

	public int calculateTime(String keyboard, String word) {

		Map<Character, Integer> map = new HashMap<>();

		char[] arr = keyboard.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			map.put(arr[i], i);
		}

		char[] word_arr = word.toCharArray();

		int time = map.get(word_arr[0]);

		int prev = time;

		for (int i = 1; i < word_arr.length; i++) {

			Integer x = map.get(word_arr[i]);

			time = time + Math.abs(x - prev);
			prev = x;
		}

		return time;
	}

	public int numEquivDominoPairs(int[][] dominoes) {

		int res = 0;

		int[] count_arr = new int[100];

		for (int i = 0; i < dominoes.length; i++) {

			int[] domino = dominoes[i];
			int num = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);

			int currCount = count_arr[num];
			res += currCount;
			count_arr[num]++;
		}
		return res;
	}
	
	
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			String str = s.substring(i, i + p.length());
			if (areAnagram(str.toCharArray(), p.toCharArray())) {
				list.add(i);
			}
		}
		return list;
	}

	static boolean areAnagram(char str1[], char str2[]) {

		int NO_OF_CHARS = 26;

		int count1[] = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);
		int count2[] = new int[NO_OF_CHARS];
		Arrays.fill(count2, 0);
		int i;

		for (i = 0; i < str1.length && i < str2.length; i++) {
			
			System.out.println('a' - str1[i]);
			count1['a' - str1[i]]++;
			count2['a' - str2[i]]++;
		}

		if (str1.length != str2.length)
			return false;

		for (i = 0; i < NO_OF_CHARS; i++)
			if (count1[i] != count2[i])
				return false;

		return true;
	}
	
	
	
	public String addBinary(String a, String b) {
		return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
	}
	
	public String multiply(String num1, String num2) {
		return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
	}
	
	public int findPeakElement(int[] nums) {

		if (nums.length == 1) {
			return 0;
		}

		if (nums.length == 2) {
			return nums[0] > nums[1] ? 0 : 1;
		}

		for (int i = 1; i < nums.length - 1; i++) {

			System.out.println(i);
			if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
				return i;
			}
		}
		return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
	}
	
	
	public List<Boolean> prefixesDivBy5(int[] A) {
		String str = "";
		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {

			str += String.valueOf(A[i]);

			BigInteger r = new BigInteger(str, 2);

			if (r.remainder(new BigInteger("5")).intValue() == 0)
				result.add(true);
			else
				result.add(false);
		}
		return result;
	}
	
	public int twoSumLessThanK(int[] A, int K) {

		Arrays.sort(A);

		int a = 0;
		int b = A.length - 1;

		int max = -1;

		while (a < b) {

			if (A[a] + A[b] >= K) {
				b--;
			}

			else {
				if (A[a] + A[b] > max) {
					max = A[a] + A[b];
				}
				a++;
			}
		}
		return max;

	}
	
	
	
	public boolean validWordSquare(List<String> words) {

		if (words.isEmpty())
			return true;
        
		
		int max = -1;
		
		for (int i = 1; i < words.size(); i++) {
			if (words.get(i).length() > max) {
				max =  words.get(i).length();
			}
		}
   
		int length = max;


	

		char[][] arr = new char[length][length];
		for (int i = 0; i < words.size(); i++) {
			char[] wr = words.get(i).toCharArray();
			for (int j = 0; j < wr.length; j++) {
				arr[i][j] = wr[j];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[j][i] != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static ListNode deleteDuplicatesV2(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;

		Integer lastDeleteVal = null;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {

				if (previous != null) {
					previous.next = current.next;
					current = current.next;

				} else {
					head = head.next;
					current = head;
				}
				lastDeleteVal = current.val;
			}

			else {
				if (lastDeleteVal != null && lastDeleteVal == current.val) {
					if (previous != null) {
						previous.next = current.next;
						current = current.next;

					} else {
						head = head.next;
						current = head;
					}
					
				} else {
					previous = current;
					current = current.next;
				}
			}
		}

		if (lastDeleteVal != null && lastDeleteVal == head.val) {
			head = head.next;
		}

		return head;
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;

		while (current != null && current.next != null) {

			boolean is_same = false;

			while (current.next!=null && current.val == current.next.val) {
				current = current.next;
				is_same = true;
			}

			if (is_same) {

				if (previous != null) {
					previous.next = current.next;
					current = current.next;

				} else {
					
					System.out.println("Yooooo");
					head = head.next;
					current = head;
				}
			}
			
			else {
				previous = current;
				current = current.next;
			}
		}
		return head;
	}
	
	public int numFriendRequestsV2(int[] ages) {

		int count = 0;

		for (int a = 0; a < ages.length; a++) {

			for (int b = 0; b < ages.length; b++) {

				if (a != b) {

					if (!(ages[b] <= 0.5 * ages[a] + 7 || ages[b] > ages[a] || (ages[b] > 100 && ages[a] < 100))) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	
	
	public int numFriendRequests(int[] ages) {
		int[] count_arr = new int[121];
		for (int i = 0; i < ages.length; i++) {
			count_arr[ages[i]]++;
		}

		int count = 0;

		for (int i = 0; i < ages.length; i++) {
			int A = ages[i];
			for (int b = 1; b <= 120; b++) {

				if (!(b <= 0.5 * A + 7 || b > A)) {
					count = count + count_arr[b];
					
					if (A == b) {
						count--;
					}
				}
			}
		}
		return count - ages.length;
	}
	
	
	
	public int numRabbits(int[] answers) {

		int count[] = new int[1000];

		for (int i = 0; i < answers.length; i++) {
			count[answers[i]]++;
		}

		int sum = count[0];
		for (int i = 1; i < count.length; i++) {
			sum += Math.ceil((double) count[i] / (double) (i + 1)) * (i + 1);
		}

		return sum;
	}
	
	
	
	public static String alphabetBoardPathV2(String target) {

		Map<Character, Integer> column_map = new HashMap<>();

		column_map.put('a', 0);
		column_map.put('f', 0);
		column_map.put('k', 0);
		column_map.put('p', 0);
		column_map.put('u', 0);
		column_map.put('z', 0);

		column_map.put('b', 1);
		column_map.put('g', 1);
		column_map.put('l', 1);
		column_map.put('q', 1);
		column_map.put('v', 1);

		column_map.put('c', 2);
		column_map.put('h', 2);
		column_map.put('m', 2);
		column_map.put('r', 2);
		column_map.put('w', 2);

		column_map.put('d', 3);
		column_map.put('i', 3);
		column_map.put('n', 3);
		column_map.put('s', 3);
		column_map.put('x', 3);

		column_map.put('e', 4);
		column_map.put('j', 4);
		column_map.put('o', 4);
		column_map.put('t', 4);
		column_map.put('y', 4);

		Map<Character, Integer> row_map = new HashMap<>();

		row_map.put('a', 0);
		row_map.put('b', 0);
		row_map.put('c', 0);
		row_map.put('d', 0);
		row_map.put('e', 0);

		row_map.put('f', 1);
		row_map.put('g', 1);
		row_map.put('h', 1);
		row_map.put('i', 1);
		row_map.put('j', 1);

		row_map.put('k', 2);
		row_map.put('l', 2);
		row_map.put('m', 2);
		row_map.put('n', 2);
		row_map.put('o', 2);

		row_map.put('p', 3);
		row_map.put('q', 3);
		row_map.put('r', 3);
		row_map.put('s', 3);
		row_map.put('t', 3);

		row_map.put('u', 4);
		row_map.put('v', 4);
		row_map.put('w', 4);
		row_map.put('x', 4);
		row_map.put('y', 4);

		row_map.put('z', 5);

		char[] arr = target.toCharArray();

		StringBuilder builder = new StringBuilder();

		int start_column = 0;
		int start_row = 0;

		for (int i = 0; i < arr.length; i++) {

			char c = arr[i];

			int move_column = column_map.get(c);
			int move_row = row_map.get(c);

			while (move_column != start_column || start_row != move_row) {
				if (start_row > move_row) {
					while (start_row > move_row) {
						builder.append("U");
						start_row--;
					}
				}

				else if (start_row < move_row) {
					while (start_row < move_row) {

						if (start_column != 0 && start_row >= 4) {
							break;
						}

						builder.append("D");
						start_row++;

					}
				}

				if (start_column > move_column) {
					while (start_column > move_column) {
						builder.append("L");
						start_column--;
					}
				}

				else if (start_column < move_column) {
					while (start_column < move_column) {
						builder.append("R");
						start_column++;
					}
				}
			}

			builder.append("!");

			start_column = move_column;
			start_row = move_row;
		}

		return builder.toString();
	}
	
	
	public static String alphabetBoardPath(String target) {

		
		
		int[] column_arr = new int[26];
		
		column_arr['a' - 'a'] = 0;
		column_arr['f' - 'a'] = 0;
		column_arr['k' - 'a'] = 0;
		column_arr['p' - 'a'] = 0;
		column_arr['u' - 'a'] = 0;
		column_arr['z' - 'a'] = 0;


		
		column_arr['b' - 'a'] = 1;
		column_arr['g' - 'a'] = 1;
		column_arr['l' - 'a'] = 1;
		column_arr['q' - 'a'] = 1;
		column_arr['v' - 'a'] = 1;

		
		column_arr['c' - 'a'] = 2;
		column_arr['h' - 'a'] = 2;
		column_arr['m' - 'a'] = 2;
		column_arr['r' - 'a'] = 2;
		column_arr['w' - 'a'] = 2;
		
		
		column_arr['d' - 'a'] = 3;
		column_arr['i' - 'a'] = 3;
		column_arr['n' - 'a'] = 3;
		column_arr['s' - 'a'] = 3;
		column_arr['x' - 'a'] = 3;
	

		
		column_arr['e' - 'a'] = 4;
		column_arr['j' - 'a'] = 4;
		column_arr['o' - 'a'] = 4;
		column_arr['t' - 'a'] = 4;
		column_arr['y' - 'a'] = 4;
		
		int[] row_arr = new int[26];

		
		row_arr['a' - 'a'] = 0;
		row_arr['b' - 'a'] = 0;
		row_arr['c' - 'a'] = 0;
		row_arr['d' - 'a'] = 0;
		row_arr['e' - 'a'] = 0;

		
		row_arr['f' - 'a'] = 1;
		row_arr['g' - 'a'] = 1;
		row_arr['h' - 'a'] = 1;
		row_arr['i' - 'a'] = 1;
		row_arr['j' - 'a'] = 1;


		row_arr['k' - 'a'] = 2;
		row_arr['l' - 'a'] = 2;
		row_arr['m' - 'a'] = 2;
		row_arr['n' - 'a'] = 2;
		row_arr['o' - 'a'] = 2;


		row_arr['p' - 'a'] = 3;
		row_arr['q' - 'a'] = 3;
		row_arr['r' - 'a'] = 3;
		row_arr['s' - 'a'] = 3;
		row_arr['t' - 'a'] = 3;

		
		row_arr['u' - 'a'] = 4;
		row_arr['v' - 'a'] = 4;
		row_arr['w' - 'a'] = 4;
		row_arr['x' - 'a'] = 4;
		row_arr['y' - 'a'] = 4;

		row_arr['z' - 'a'] = 5;

		char[] arr = target.toCharArray();

		StringBuilder builder = new StringBuilder();

		int start_column = 0;
		int start_row = 0;

		for (int i = 0; i < arr.length; i++) {

			char c = arr[i];

			int move_column = column_arr[c-'a'];
			int move_row = row_arr[c-'a'];

			while (move_column != start_column || start_row != move_row) {
				if (start_row > move_row) {
					while (start_row > move_row) {
						builder.append("U");
						start_row--;
					}
				}

				else if (start_row < move_row) {
					while (start_row < move_row) {

						if (start_column != 0 && start_row >= 4) {
							break;
						}

						builder.append("D");
						start_row++;

					}
				}

				if (start_column > move_column) {
					while (start_column > move_column) {
						builder.append("L");
						start_column--;
					}
				}

				else if (start_column < move_column) {
					while (start_column < move_column) {
						builder.append("R");
						start_column++;
					}
				}
			}

			builder.append("!");

			start_column = move_column;
			start_row = move_row;
		}

		return builder.toString();
	}
	
	
	public int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		Integer max_sum = Integer.MIN_VALUE;
		Integer level_sum = 0;
		int level = 0;
		int max_level = -1;
		
		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {
				level++;

				if (level_sum > max_sum) {
					max_sum = level_sum;

					if (level > max_level) {
						max_level = level;
					}
				}

				if (q.isEmpty()) {
					return max_level;
				} else {
					q.add(null);
				}
				level_sum = 0;

			} else {

				level_sum = level_sum + node.val;

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
		}

		return max_level;
	}
	
	
	public static String[] spellchecker(String[] wordlist, String[] queries) {

		String[] w_list = new String[wordlist.length];

		Set<String> set = new HashSet<>();

		for (int i = 0; i < wordlist.length; i++) {

			set.add(wordlist[i]);

			StringBuffer q = new StringBuffer();

			char[] arr = wordlist[i].toCharArray();
			
			
			for (int j = 0; j < arr.length; j++) {

				if (arr[j] == 'a' || arr[j] == 'e' || arr[j] == 'i' || arr[j] == 'o' || arr[j] == 'u' || arr[j] == 'A'
						|| arr[j] == 'E' || arr[j] == 'I' || arr[j] == 'O' || arr[j] == 'U') {
					q.append("_");
				} else {
					q.append(arr[j]);
				}
			}
			w_list[i] = q.toString();
		}

		System.out.println(set);

		String[] r = new String[queries.length];

		for (int i = 0; i < queries.length; i++) {

			r[i] = "";

			for (int j = 0; j < w_list.length; j++) {

				String e = spellchecker(wordlist[j], queries[i], w_list[j], set);
				if (e.length() != 0) {
					r[i] = e;
					break;
				}
			}

		}

		return r;

	}

	public static String spellchecker(String word, String query, String w, Set<String> set) {

		if (set.contains(query)) {
			return query;
		}
		if (word.toLowerCase().equals(query.toLowerCase())) {
			return word;
		}

		char[] arr = query.toCharArray();

		StringBuffer q = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'A'
					|| arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {

				q.append("_");
			} else {
				q.append(arr[i]);
			}
		}

		if (q.toString().toLowerCase().equals(w.toLowerCase())) {
			return word;
		}

		return "";
	}

	public int partitionDisjoint(int[] A) {

		int max = -1;
		int second_max = -1;

		for (int i = 0; i < A.length; i++) {

			if (A[i] == max) {
				return i;
			}

			if (A[i] > max) {

				if (max != -1) {
					return i;
				}
				second_max = max;
				max = A[i];
			}

			else if (A[i] > second_max) {
				second_max = A[i];
			}
		}
		return -1;
	}
	
	
	public boolean canJump(int[] nums) {

		int start_index = 0;
		int k = 0;

		while (start_index < nums.length && k < nums.length) {

			int x = nums[start_index];

			int sum = 0;
			k = start_index + 1;
			boolean temp = false;

			while (x > k) {

				if (sum > x) {
					start_index = k;
					temp = true;
					break;
				}

				sum = sum + nums[k];
				k++;
				start_index = k;

			}

			if (!temp) {
				start_index = start_index + x;
			}

		}
		return k >= nums.length;
	}
	
	
	public static List<Integer> sieveOfEratosthenes(int n) {
	    boolean prime[] = new boolean[n + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= n; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= n; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	
	
	public static Integer numberOfPrimesLessThan(int n) {
		boolean prime[] = new boolean[n + 1];
		Arrays.fill(prime, true);
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int i = p * 2; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				count++;
			}
		}

		
		return count;
	}
	
	public static int numPrimeArrangements(int n) {

		int[] prime = new int[] { 0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9,
				10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16,
				16, 16, 16, 16, 17, 17, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22,
				22, 22, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25 };

		int m = prime[n], M = 1000000007;
		long count = 1;
		for (int i = m; i > 0; i--) {
			count = (count * i) % M;
		}
		for (int i = n - m; i > 0; i--) {
			count = (count * i) % M;
		}
		return (int) count;
	}

	public static BigInteger factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact;
	}
	
	public List<String> generatePossibleNextMoves(String s) {

		List<String> result = new ArrayList<>();
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] && arr[i] == '+') {
				StringBuffer b = new StringBuffer();

				if (i - 1 >= 0) {
					b.append(s.substring(0, i));
				}

				b.append("--");

				if (i + 2 < arr.length)
					b.append(s.substring(i + 2));

				result.add(b.toString());
			}
		}
		return result;
	}
	
	
	public int[] fairCandySwap(int[] A, int[] B) {

		int total_sum = 0;
		int a_sum = 0;
		int b_sum = 0;

		for (int i = 0; i < A.length; i++) {
			total_sum += A[i];
			a_sum += A[i];
		}

		for (int i = 0; i < B.length; i++) {
			total_sum += B[i];
			b_sum += B[i];
		}

		int[] r = new int[2];

		r[0] = Math.abs(total_sum - a_sum);
		r[1] = Math.abs(total_sum  - b_sum);

		return r;

	}
}
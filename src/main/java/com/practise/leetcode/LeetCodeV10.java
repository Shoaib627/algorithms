package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LeetCodeV10 {

	public static String reorganizeString(String S) {

		char[] barcodes = S.toCharArray();

		Map<Character, Integer> map = getFrequencyMap(barcodes);
		System.out.println(map);

		PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new intComparator());

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			q.add(entry);
		}

		char[] r = new char[barcodes.length];

		Arrays.fill(r, '0');

		boolean start_from_begin = true;

		while (!q.isEmpty()) {

			Entry<Character, Integer> entry = q.poll();
			Integer value = entry.getValue();
			int c = 0;

			int i;
			if (start_from_begin) {

				i = 0;

				while (i < r.length && r[i] != '0') {
					i++;
				}

				while (c < value && i < r.length) {
					r[i] = entry.getKey();
					i = i + 2;
					c++;
				}

			}

			else {
				i = r.length - 1;

				while (i >= 0 && r[i] != '0') {
					i--;
				}

				while (c < value && i >= 0) {
					r[i] = entry.getKey();
					i = i - 2;
					c++;
				}
			}

			start_from_begin = !start_from_begin;

			if (c != value) {
				return "";
			}

		}
		Map<Character, Integer> map2 = getFrequencyMap(new String(r).toCharArray());

		System.out.println(map2);
		return new String(r);
	}

	public static Map<Character, Integer> getFrequencyMap(char[] barcodes) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < barcodes.length; i++) {
			map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
		}
		return map;
	}

	public static class intComparator implements Comparator<Map.Entry<Character, Integer>> {
		@Override
		public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
			return -Integer.compare(o1.getValue(), o2.getValue());
		}
	}

	public static int rand7() {
		return (int) (Math.random() * 10) + 1;
	}

	public static int rand10() {
		int x = rand7();
		return x + (x % 4);
	}

	public int findJudge(int N, int[][] trust) {

		int[] arr = new int[N + 1];

		for (int[] a : trust) {

			arr[a[0]] = -1;
		}

		int count = 0;
		int judge = -1;

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				judge = i;
				count++;

				if (count > 1) {
					break;
				}
			}
		}

		if (count == 1) {

			for (int i = 1; i <= N; i++) {
				if (arr[judge] == -1) {
					return -1;
				}
			}

			int[] arrV2 = new int[N + 1];

			for (int[] a : trust) {

				if (a[1] == judge) {
					arrV2[a[0]] = -1;
				}
			}

			for (int i = 1; i <= N; i++) {
				if (i != judge && arrV2[i] == 0) {
					return -1;
				}
			}
			return judge;
		} else {
			return -1;
		}
	}

	public boolean knows(int a, int b) {
		return false;
	}

	public int findCelebrity(int n) {

		int[] friend = new int[n];

// if there is friend, fill friend array with -1;
		int c = 0;
		int celebrity = -1;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (i != j) {

					if (friend[i] != -1 && knows(i, j)) {
						friend[i] = -1;
						break;
					}
				}
			}
			if (friend[i] == 0) {
				c++;
				if (c > 1) {
					System.out.println(c);
					return -1;
				}
			}
		}
		if (celebrity != -1) {

			for (int i = 0; i < n; i++) {
				if (i != celebrity && knows(celebrity, i)) {
					return -1;
				}
			}

			for (int i = 0; i < n; i++) {

				if (celebrity != i && !knows(i, celebrity)) {
					return -1;
				}
			}
		}
		return celebrity;
	}

	// 2 2 2 - 2,3,4
	//
	public int minIncrementForUnique(int[] A) {
		int[] count_arr = new int[40001];

		for (int i = 0; i < A.length; i++) {
			count_arr[A[i]]++;
		}

		int count = 0;

		for (int i = 0; i < count_arr.length - 1; i++) {

			if (count_arr[i] > 1) {
				count = count + count_arr[i] - 1;
				count_arr[i + 1] = count_arr[i + 1] + count_arr[i] - 1;
			}
		}

		if (count_arr[40000] > 1) {

			count += (count_arr[40000] - 1) * (count_arr[40000]) / 2;
		}

		return count;

	}

	public void setZeroes(int[][] matrix) {

		List<Integer> marked_rows = new ArrayList<>();
		List<Integer> marked_columns = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					marked_rows.add(i);
					marked_columns.add(j);
				}
			}

		}

		Iterator<Integer> row_it = marked_rows.iterator();
		while (row_it.hasNext()) {
			int i = row_it.next();

			for (int x = 0; x < matrix.length; x++) {
				matrix[i][x] = 0;
			}
		}

		Iterator<Integer> col_it = marked_columns.iterator();
		while (col_it.hasNext()) {
			int i = col_it.next();

			for (int x = 0; x < matrix[0].length; x++) {
				matrix[x][i] = 0;
			}
		}

	}


	public static int[] fairCandySwap(int[] A, int[] B) {

		int total_sum = 0;
		int a_sum = 0;
		int b_sum = 0;

		int[] count_arr_a = new int[100001];
		int[] count_arr_b = new int[100001];

		for (int i = 0; i < A.length; i++) {
			total_sum += A[i];
			a_sum += A[i];
			count_arr_a[A[i]]++;
		}

		for (int i = 0; i < B.length; i++) {
			total_sum += B[i];
			b_sum += B[i];
			count_arr_b[B[i]]++;

		}

		if (a_sum > b_sum) {

			int a_loose = a_sum - total_sum / 2;
			// int b_gain = total_sum / 2 - b_sum;

			for (int i = 0; i < A.length; i++) {

				if (count_arr_b[(A[i] - a_loose)] > 0) {
					return new int[] { A[i], (A[i] - a_loose) };
				}
			}

		} else {

			// int a_gain = total_sum / 2 - a_sum;
			int b_loose = b_sum - total_sum / 2;

			for (int i = 0; i < B.length; i++) {

				if (count_arr_a[(B[i] - b_loose)] > 0) {
					return new int[] { (B[i] - b_loose), B[i] };
				}
			}
		}

		int[] r = new int[2];

		return r;

	}

	public int minMoves2(int[] nums) {

		Arrays.sort(nums);

		int m = nums[nums.length / 2];
		int mid = nums.length / 2;

		int moves = 0;

		int start = 0;
		while (start < mid) {
			moves += m - nums[start++];
		}

		int k = mid + 1;
		while (k < nums.length) {
			moves += nums[k++] - m;
		}

		return moves;
	}

	public boolean buddyStrings(String A, String B) {

		if (A.length() != B.length() || A.isEmpty() || B.isEmpty()) {
			return false;
		}

		if (A.equals(B)) {

			int[] count_arr_a = new int[26];

			for (int i = 0; i < A.length(); i++) {
				count_arr_a[A.charAt(i) - 'a']++;
			}

			int c = 0;

			for (int i = 0; i < count_arr_a.length; i++) {

				if (count_arr_a[i] > 1) {
					c++;
				}
			}

			System.out.println(c);

			return c > 1;
		}

		int mismatches = 0;

		int mismatch_index_one = -1;
		int mismatch_index_two = -1;

		for (int i = 0; i < A.length(); i++) {

			if (A.charAt(i) != B.charAt(i)) {
				mismatches++;

				if (mismatches > 2) {
					return false;
				}
				if (mismatches == 1) {
					mismatch_index_one = i;
				}

				else if (mismatches == 2) {
					mismatch_index_two = i;
				}
			}
		}

		if (mismatches != 2) {
			return false;
		}

		return A.charAt(mismatch_index_one) == B.charAt(mismatch_index_two)
				&& A.charAt(mismatch_index_two) == B.charAt(mismatch_index_one);

	}

	public int[] constructRectangle(int area) {

		int min_diff = area - 1;

		int l = area;
		int b = 1;

		double sq = Math.sqrt(area);
		double f = Math.floor(sq);

		if ((sq - f) == 0) {
			return new int[] { (int) f, (int) f };
		}

		for (int i = 2; i <= sq; i++) {

			if (area % i == 0) {

				int diff = Math.abs(area / i - i);
				if (min_diff > diff) {
					l = area / i;
					b = i;
					min_diff = diff;
				}
			}
		}

		return new int[] { l > b ? l : b, l > b ? b : l };
	}
	
	
	public String largestTimeFromDigits(int[] A) {

		int[] count = new int[10];

		for (int i = 0; i < A.length; i++) {
			count[A[i]]++;
		}
		
		StringBuffer b = new StringBuffer();

		int x = 0;
		
		
		int z = count[2] == 1 && (count[2] + count[1] + count[0] + count[3] >= 2
				&& count[2] + count[1] + count[0] + count[3] >= 3 || count[4] + count[5] >= 1)

						? 2:1;
		

					
 		boolean append = false;
		for (int i = z; i >= 0; i--) {

			if (count[i] > 0) {
				b.append(i);
				x = i;
				count[i]--;
				append = true;
				break;
			}
		}
		
		if(!append) {
			
		}
		
		int j = x == 2 ? 3 : 9;

		for (int i = j; i >= 0; i--) {

			if (count[i] > 0) {
				b.append(i);
				count[i]--;
				break;
			}
		}
		b.append(":");
		for (int i = 5; i >= 0; i--) {

			if (count[i] > 0) {
				b.append(i);
				count[i]--;
				break;
			}
		}
		for (int i = 9; i >= 0; i--) {

			if (count[i] > 0) {
				b.append(i);
				count[i]--;
				break;
			}
		}
		return b.toString();

	}
	
	public int maxNumberOfBalloons(String text) {

		int[] count = new int[26];

		int ballons = 0;
		for (int i = 0; i < text.length(); i++) {
			count[text.charAt(i) - 'a']++;
		}

		while (true) {

			if (count['b' - 'a'] >= 1 && count['a' - 'a'] >= 1 && count['l' - 'a'] >= 2 && count['o' - 'a'] >= 2
					&& count['n' - 'a'] >= 1) {
				ballons++;
				count['b' - 'a']--;
				count['a' - 'a']--;
				count['l' - 'a']--;
				count['l' - 'a']--;
				count['o' - 'a']--;
				count['o' - 'a']--;
				count['n' - 'a']--;
			} else {
				break;
			}
		}

		return ballons;
	}

	
	public static int titleToNumber(String s) {

		if (s.length() == 1) {
			return (s.charAt(0) - 'A') + 1;
		}

		char[] arr = s.toCharArray();

		int r = arr[0] - 'A' + 1;

		for (int i = 1; i < arr.length; i++) {

			r *= 26;
			r = r + arr[i] - 'A' + 1;
		}

		return r;
	}
	
	public static String convertToTitle(int n) {

		StringBuffer b = new StringBuffer();
		while (n > 0) {
			int r = n % 26;
			if(r ==0) {
				r = 26;
			}
			char c = (char) (65 + r - 1);
			b.append(c);
			n = n - r;
			n = n / 26;
		}
		
		return b.reverse().toString();
	}
	
	

	public static int findPairs(int[] nums, int k) {

		Map<Integer, Integer> f_map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			f_map.put(nums[i], f_map.getOrDefault(nums[i], 0) + 1);
		}

		int pairs = 0;
		if (k == 0) {
			for (Map.Entry<Integer, Integer> entry : f_map.entrySet()) {
				if (entry.getValue() >= 2) {
					pairs++;
				}
			}
		} else {

			for (Map.Entry<Integer, Integer> entry : f_map.entrySet()) {
				if (f_map.containsKey(entry.getKey() + k)) {
					pairs++;
				}
			}

		}

		return pairs;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {

				Integer last = map.get(nums[i]);
				if (i - last <= k) {
					return true;
				}
			}
			map.put(nums[i], i);

		}
		return false;
	}
	
	public String nextClosestTime(String time) {


		int[] count = new int[10];

		count[Character.digit(time.charAt(0), 10)]++;
		count[Character.digit(time.charAt(1), 10)]++;
		count[Character.digit(time.charAt(3), 10)]++;
		count[Character.digit(time.charAt(4), 10)]++;

		StringBuffer result = new StringBuffer(time);

		for (int i = Character.digit(time.charAt(4), 10) + 1; i <= 9; i++) {

			if (count[i] > 0) {
				// int to char
				result.setCharAt(4, (char) (i + '0'));
				return result.toString();
			}
		}

		for (int i = Character.digit(time.charAt(3), 10) + 1; i <= 5; i++) {

			if (count[i] > 0) {
				result.setCharAt(3, (char) (i + '0'));
				return result.toString();
			}
		}

		
		for (int i = Character.digit(time.charAt(1), 10) + 1; i <= 9; i++) {

			if (count[i] > 0) {
				result.setCharAt(1, (char) (i + '0'));
				 break;
			}
		}

		for (int i = Character.digit(time.charAt(0), 10) + 1; i <= 2; i++) {

			if (count[i] > 0) {
				if( i == 2 && Character.digit(result.charAt(1), 10) > 3) {
					return "22:22";
				}
				result.setCharAt(0, (char) (i + '0'));
				return result.toString();
			}
		}
		return "22:22";
	}

	public TreeNode bstToGst(TreeNode root) {

		recurse(root, 0);
		return root;
	}

	public int recurse(TreeNode root, int s) {

		if (root == null) {
			return 0;
		}

		int sum = recurse(root.right, s) + root.val;
		root.val = sum + s;

		sum = sum + recurse(root.left, root.val);
		return sum;
	}
	

	
	public static int[] deckRevealedIncreasing(int[] deck) {

		Arrays.sort(deck);

		int[] arr = new int[deck.length];

		int i = 0;
		int j = 0;
		while (i < deck.length) {

			arr[i] = deck[j];
			i++;
			i++;
			j++;
		}

		int a = 1;

		while (a < deck.length) {

			arr[a] = deck[j];
			a = a + 4;
			j++;
		}

		a = 3;

		while (a < deck.length) {

			arr[a] = deck[j];
			a = a + 4;
			j++;
		}

		return arr;
	}
	
	public String minWindowV2(String s, String t) {

		int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
		String minWindow = "";

		for (int left = 0; left <= s.length() - t.length(); left++) {

			for (int right = left + t.length(); right < s.length(); right++) {

				String searchString = s.substring(left, right + 1);
				
				if(stringContainsAllCharacters(searchString, t) && searchString.length() < minWindowLengthSeenSoFar) {
					minWindowLengthSeenSoFar = searchString.length();
					minWindow = searchString;
				}
			}

		}
		return minWindow;
	}
	
	

	private boolean stringContainsAllCharacters(String searchString, String t) {

		Map<Character, Integer> requiredCharacters = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {

			int occurrencesOfCharacter = requiredCharacters.getOrDefault(t.charAt(i), 0);

			requiredCharacters.put(t.charAt(i), occurrencesOfCharacter + 1);

		}

		for (int i = 0; i < searchString.length(); i++) {

			char curChar = searchString.charAt(i);

			if (requiredCharacters.containsKey(curChar)) {

				int newOccurrenceCount = requiredCharacters.get(curChar) - 1;

				if (newOccurrenceCount == 0) {
					requiredCharacters.remove(curChar);
				} else {
					requiredCharacters.put(curChar, newOccurrenceCount);
				}

			}

		}

		return requiredCharacters.isEmpty();
	}
	
	
	public static String minWindow(String s, String t) {

		if (t.length() > s.length()) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		int left = 0;
		int right = 0;
		int len = Integer.MAX_VALUE;
		int head = 0;

		int counter = map.size();

		while (right < s.length()) {

			char charAtRight = s.charAt(right);

			if (map.containsKey(charAtRight)) {
				map.put(charAtRight, map.get(charAtRight) - 1);
				// It means all characters have been covered
				if (map.get(charAtRight) == 0) {
					counter--;
				}
			}

			while (counter == 0) {

				char charAtLeft = s.charAt(left);
				if (map.containsKey(charAtLeft)) { 
					map.put(charAtLeft, map.get(charAtLeft) + 1);
					// It means it window is violated
					// This check is needed instead of plain counter ++
					// is because map can have negative keys and left pointer 
					// can still contract
					if (map.get(charAtLeft) > 0) {
						counter++;
					}
				}

				// This need to checked only when left is getting contracted
				if (right - left + 1 < len) {
					len = right - left + 1;
					head = left;
				}

				left++;
			}
			
			right++;
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
	}

	// cbaebabacd
	public List<Integer> findAnagrams(String s, String t) {

		if (t.length() > s.length()) {
			return new ArrayList<>();
		}

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		List<Integer> result = new ArrayList<>();

		int left = 0;
		int right = 0;

		int counter = map.size();

		while (right < s.length()) {

			char charAtRight = s.charAt(right);

			if (map.containsKey(charAtRight)) {
				map.put(charAtRight, map.get(charAtRight) - 1);
				// It means all characters have been covered
				if (map.get(charAtRight) == 0) {
					counter--;
				}
			}

			while (counter == 0) {

				char charAtLeft = s.charAt(left);
				if (map.containsKey(charAtLeft)) {
					map.put(charAtLeft, map.get(charAtLeft) + 1);
					// It means it window is violated
					// This check is needed instead of plain counter ++
					// is because map can have negative keys and left pointer
					// can still contract
					if (map.get(charAtLeft) > 0) {
						counter++;
					}
				}

				if (right - left + 1 == t.length()) {
					result.add(left);
				}

				left++;
			}

			right++;
		}

		return result;
	}
	
	


	public static int lengthOfLongestSubstring(String s) {
		int right = 0, left = 0, len = 0, counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			char charAtRight = s.charAt(right);
			map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);
			if (map.get(charAtRight) > 1) {
				counter++;
			}
			right++;
			while (counter > 0) {
				char charAtLeft = s.charAt(left);

				if (map.get(charAtLeft) > 1) {
					counter--;
				}
				map.put(charAtLeft, map.get(charAtLeft) - 1);
				left++;

			}
			len = Math.max(right - left, len);

		}
		return len;
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {

		int right = 0, left = 0, len = 0, counter = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < s.length()) {
			
			char charAtRight = s.charAt(right);
			map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);
			if (map.get(charAtRight) == 1) { // new char
				counter++;
			}
			right++;
			
			while (counter > 2) {
				
				char charAtLeft = s.charAt(left);

				if (map.get(charAtLeft) == 1) {
					counter--;
				}
				map.put(charAtLeft, map.get(charAtLeft) - 1);
				left++;
			}
			len = Math.max(right - left, len);

		}
		return len;
	}
	
	
	   public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
			int right = 0, left = 0, len = 0, counter = 0;
			Map<Character, Integer> map = new HashMap<>();
			while (right < s.length()) {
				
				char charAtRight = s.charAt(right);
				map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);
				if (map.get(charAtRight) == 1) { // new char
					counter++;
				}
				right++;
				
				while (counter > k) {
					
					char charAtLeft = s.charAt(left);

					if (map.get(charAtLeft) == 1) {
						counter--;
					}
					map.put(charAtLeft, map.get(charAtLeft) - 1);
					left++;
				}
				len = Math.max(right - left, len);

			}
			return len;
	    }

	   
	   
	

	public static boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}

		int left = 0;
		int right = 0;

		int counter = map.size();

		while (right < s2.length()) {

			char charAtRight = s2.charAt(right);

			if (map.containsKey(charAtRight)) {
				map.put(charAtRight, map.get(charAtRight) - 1);
				if (0 == map.get(charAtRight)) {
					counter--;
				}
			}

			right++;

			while (counter == 0) {
				char charAtLeft = s2.charAt(left);

				if (map.containsKey(charAtLeft)) {

					map.put(charAtLeft, map.get(charAtLeft) + 1);
					if (map.get(charAtLeft) > 0)
						counter++;

				}

				if (right - left == s1.length()) {
					return true;
				}

				left++;
			}
		}
		return false;
	}

	public int maxDistToClosestV2(int[] seats) {

		List<Integer> arr_list = new ArrayList<>();

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				arr_list.add(i);
			}
		}

		int max = arr_list.get(0);

		for (int i = 0; i < arr_list.size() - 1; i++) {

			int temp = (arr_list.get(i + 1) - arr_list.get(i)) / 2;
			max = Math.max(max, temp);
		}

		int temp = seats.length - arr_list.get(arr_list.size() - 1) - 1;
		max = Math.max(max, temp);

		return max;
	}
	
	
	public int maxDistToClosest(int[] seats) {

		int last = -1;
		int max = 0;
		for (int i = 0; i < seats.length; i++) {

			if (seats[i] == 1) {
				max = last < 0 ? i : Math.max(max, (i - last) / 2);
				last = i;
			}

			max = Math.max(max, seats.length - last - 1);

		}

		return max;
	}

	static public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int p = i + 1;
			int q = nums.length - 1;

			while (p < q) {

				if (nums[i] + nums[p] + nums[q] == target) {

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

				} else if (nums[i] + nums[p] + nums[q] > target) {
					q--;
				} else if (nums[i] + nums[p] + nums[q] < target) {
					p++;
				}
			}
		}

		return result;
	}
	
	
	public static void main(String[] args) {

		System.err.println(threeSumMulti(new int[] { 0, 0, 0, 0, 0 }, 0));
		nCr(3000, 3);
		return;

	}

	static public int threeSumMulti(int[] A, int target) {

		int[] count = new int[101];

		for (int i = 0; i < A.length; i++) {
			count[A[i]]++;
		}

		List<List<Integer>> result = threeSum(A, target);

		// System.out.println(result);

		long r = 0;

		for (List<Integer> set : result) {

			Map<Integer, Integer> map = new HashMap<>();

			for (Integer i : set) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}

			int ways = 1;

			for (Integer i : map.keySet()) {
				ways = nCr(count[i], map.get(i)) * ways;
			}

			r = r + ways;
		}
		return (int) (r % 1000000007);
	}

	static int nCr(int n, int r) {
		System.out.println(n + "  " + r);
		
		int p = 13; 
		    System.out.println("Value of nCr % p is "+nCrModpLucas(n, r, p)); 

		//return fact(n) / (fact(r) * fact(n - r));
		    return 0;
	}

// Returns factorial of n 
	static int fact(int n) {
		System.out.println(n);

		if (n == 0)
			return 1;
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		
		return res;
	} 
	
	static int nCrModpDP(int n, int r, int p) 
	{ 
	    // The array C is going to store last row of 
	    // pascal triangle at the end. And last entry 
	    // of last row is nCr 
	    int[] C=new int[r+1]; 
	  
	    C[0] = 1; // Top row of Pascal Triangle 
	  
	    // One by constructs remaining rows of Pascal 
	    // Triangle from top to bottom 
	    for (int i = 1; i <= n; i++) 
	    { 
	        // Fill entries of current row using previous 
	        // row values 
	        for (int j = Math.min(i, r); j > 0; j--) 
	  
	            // nCj = (n-1)Cj + (n-1)C(j-1); 
	            C[j] = (C[j] + C[j-1])%p; 
	    } 
	    return C[r]; 
	} 
	  
	// Lucas Theorem based function that returns nCr % p 
	// This function works like decimal to binary conversion 
	// recursive function. First we compute last digits of 
	// n and r in base p, then recur for remaining digits 
	static int nCrModpLucas(int n, int r, int p) 
	{ 
	// Base case 
	if (r==0) 
	    return 1; 
	  
	// Compute last digits of n and r in base p 
	int ni = n%p; 
	int ri = r%p; 
	  
	// Compute result for last digits computed above, and 
	// for remaining digits. Multiply the two results and 
	// compute the result of multiplication in modulo p. 
	return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r 
	        nCrModpDP(ni, ri, p)) % p; // Remaining digits 
	} 
	  
	
	
	
  

}
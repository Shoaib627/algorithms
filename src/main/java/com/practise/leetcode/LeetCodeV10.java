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
	
	public static void main(String[] args) {
		
		int c = 9;
		
		System.out.println((char)c);

		//System.out.println(Character.digit(c, 10));
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

}
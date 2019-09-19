package com.practise.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.algorithms.lists.ListNode;



public class LeetcodeV4 {

	public static void main(String[] args) {

// [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
		
		
		
		//System.out.println(3^5);
		
		
		System.out.println(isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		
	}
	

    
	public static int strStr(String haystack, String needle) {

		if (haystack.length() == 0 && needle.length() == 0)
			return 0;
		if (haystack.length() == 0)
			return -1;

		if (needle.length() > haystack.length()) {
			return -1;
		}

		return search(needle, haystack, 101);

	}

	static int search(String pat, String txt, int q) {
		int d = 256;
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for txt
		int h = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++) {

			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (p == t) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == M)
					return i;
			}

			// Calculate hash value for next window of text: Remove
			// leading digit, add trailing digit
			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

				// We might get negative value of t, converting it
				// to positive
				if (t < 0)
					t = (t + q);
			}
		}
		return -1;

	}
	
	public static int[][] kClosest(int[][] points, int K) {

		PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> -Double.compare(a.distance, b.distance));

		for (int i = 0; i < K; i++) {
			maxHeap.add(new Point(points[i][0], points[i][1], Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))));
		}
		
		for (int j = K; j < points.length; j++) {
			double d = Math.sqrt(Math.pow(points[j][0], 2) + Math.pow(points[j][1], 2));
			if( d < maxHeap.peek().distance) {
				maxHeap.poll();
				maxHeap.offer(new Point(points[j][0], points[j][1], d));
			}
		}
		
		int[][] r = new int[K][2];

		int x = 0;
		while (!maxHeap.isEmpty()) {

			Point p = maxHeap.poll();

			r[x][0] = p.a;
			r[x][1] = p.b;
			x++;
		}

 		return r;
	}
	
	
	public static class Point {

		int a;

		int b;

		Double distance;

		public Point(int a, int b, Double distance) {
			super();
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

	}
	
	public static String addBinary(String a, String b) {
		int A = 0;
		int B = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			A = (int) (A + Character.getNumericValue(a.charAt(i)) * Math.pow(2, a.length()-1 - i));
		}

		for (int i = b.length() - 1; i >= 0; i--) {
			B = (int) (B + Character.getNumericValue(b.charAt(i)) * Math.pow(2, b.length() - 1 - i));

		}

		int c = A + B;
		
		if (c == 0) {
			return "0";
		}

		StringBuffer r = new StringBuffer();

		while (c > 0) {
			r.append(c % 2);
			c = c / 2;
		}
		return r.reverse().toString();

	}
	
	public void sortColors(int[] nums) {

		int reader = 0;
		int low = 0;
		int high = nums.length - 1;

		while (reader <= high) {

			if (nums[reader] == 0) {

				swap(nums, low, reader);

				low++;
				reader++;
			}

			else if (nums[reader] == 1) {
				reader++;
			}

			else {

				swap(nums, high, reader);

				high--;
			}

		}

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	public static List<Integer> majorityElement(int[] nums) {

		List<Integer> result = new ArrayList<>();

		Integer a = majorityElementV2(nums, null);

		if (a != null) {
			result.add(a);
			Integer b = majorityElementV2(nums, a);
			if (b != a && b!=null) {
				result.add(b);
			}
		}
		return result;
	}

	public static Integer majorityElementV2(int[] nums, Integer skip) {

		if (nums.length == 0)
			return null;

		int majority_element = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {

			if (skip != null && skip == nums[i]) {
				continue;
			} else {

				if (nums[i] == majority_element) {
					count++;
				}

				else {

					count--;

					if (count == 0) {
						majority_element = nums[i];
						count++;
					}
				}
			}

		}

		int c = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == majority_element) {
				c++;
			}
		}

		return c > nums.length / 3 ? majority_element : null;
	}

	
	public int[] shortestToChar(String S, char C) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == C) {
				list.add(i);
			}
		}

		int size = list.size();

		int[] arr = new int[S.length()];

		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == C) {
				arr[i] = 0;
			}

			else if (i < list.get(0)) {
				arr[i] = list.get(0) - i;
			}

			else if (i > list.get(size - 1)) {
				arr[i] = i - size;
			}

			else {

				for (int j = 0; j < list.size() - 1; j++) {

					if (i > list.get(j) && i < list.get(j + 1)) {

						arr[i] = Math.min(i - list.get(j),list.get(j + 1) - i);
					}
				}
			}
		}
		return arr;
	}
	
	 public int  guess(int num) {
		return 0;
	}
    public int guessNumber(int n) {
        
    	return binarySearch(1, n, n);
    	
    	
    }
    
	int binarySearch(int start, int end, int n) {
		if (start >= end) {
			int mid = start + (end - start) / 2;

			if (guess(mid) == 0)
				return mid;

			if (guess(mid) < 0)
				return binarySearch(start, mid - 1, n);

			return binarySearch(mid + 1, end, n);
		}

		return -1;
	}
    
	
	public static boolean isBadVersion(int n) {

		if (n < 4)
			return false;
		else
			return true;
	}

	public static int firstBadVersion(int n) {
		return binarySearchV2(1, n);
	}

	static int  binarySearchV2(int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (isBadVersion(mid) && !isBadVersion(mid - 1))
				return mid;

			if (isBadVersion(mid - 1)) {
				return binarySearchV2(start, mid - 1);
			}
				return binarySearchV2(mid + 1, end);
			
		}

		return -1;
	}
	
	public static int[] searchRange(int[] nums, int target) {

		int[] r = new int[2];

		int length = nums.length;
		r[0] = firstOccurence(nums, 0, length-1, target);
		r[1] = lastOccurence(nums, 0, length-1, target);

		return r;
	}

	public static int firstOccurence(int[] nums, int start, int end, int target) {

		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target))
				return mid;

			else if (nums[mid] < target) {
				return firstOccurence(nums, mid + 1, end, target);
			}
			
			return firstOccurence(nums, start, mid - 1, target);
		}
		return -1;
	}

	public static int lastOccurence(int[] nums, int start, int end, int target) {

		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target))
				return mid;

			else if (nums[mid] > target) {
				return lastOccurence(nums, start, mid - 1, target);
			}
			return lastOccurence(nums, mid + 1, end, target);

		}
		return -1;
	}

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

		for (int i = 0; i < nums.length; i++) {
			nums[i] = transform(nums[i], a, b, c);
		}

		Arrays.sort(nums);
		return nums;
	}

	public int transform(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}

	public int numPairsDivisibleBy60V2(int[] time) {

		Map<Integer, Integer> map = new HashMap<>();

		int pairs = 0;

		for (int i = 0; i < time.length; i++) {

			int r = time[i] % 60;

			Integer count = map.getOrDefault(r, 0);
			map.put(r, count + 1);

		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getKey() == 0 || entry.getKey() == 30) {
				pairs = pairs + (entry.getValue() * (entry.getValue() - 1)) / 2;
			}

			else {

				if (entry.getKey() < 30) {
					pairs = pairs + map.getOrDefault(60 - entry.getKey(), 0) * entry.getValue();

				}
			}
		}

		return pairs;

	}
	
	
	public int numPairsDivisibleBy60(int[] time) {

		int pairs = 0;

		int[] arr = new int[60];

		for (int i = 0; i < time.length; i++) {

			int r = time[i] % 60;

			arr[r] = arr[r]++;

		}

		pairs = pairs + ((arr[0] * (arr[0] - 1)) / 2) + ((arr[30] * (arr[30] - 1)) / 2);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(pairs);

		for (int i = 1; i < 30; i++) {
			pairs = pairs + (arr[60 - i] * arr[i]);
		}

		return pairs;

	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		int max_count_with_flip = 0;
		int max_count_with_out_flip = 0;
		int zeros_occured = 0;

		int max_so_far = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				max_count_with_flip = max_count_with_flip + 1;
				max_count_with_out_flip = max_count_with_out_flip + 1;
			}

			else {
				zeros_occured = zeros_occured + 1;
				if (zeros_occured > 1) {
					max_count_with_flip = max_count_with_out_flip + 1;
				} else {
					max_count_with_flip = max_count_with_flip + 1;

				}
				max_count_with_out_flip = 0;
			}

			max_so_far = max_count_with_flip > max_so_far ? max_count_with_flip : max_so_far;
		}

		return max_so_far;
	}
	
	
	  public int longestOnes(int[] nums, int K) {
	        
			int max_count_with_flip = 0;
			int max_count_with_out_flip = 0;
			int zeros_occured = 0;

			int max_so_far = 0;

			for (int i = 0; i < nums.length; i++) {

				if (nums[i] == 1) {
					max_count_with_flip = max_count_with_flip + 1;
					max_count_with_out_flip = max_count_with_out_flip + 1;
				}

				else {
					zeros_occured = zeros_occured + 1;
					if (zeros_occured > K) {
						max_count_with_flip = max_count_with_out_flip + 1;
					} else {
						max_count_with_flip = max_count_with_flip + 1;

					}
					max_count_with_out_flip = 0;
				}

				max_so_far = max_count_with_flip > max_so_far ? max_count_with_flip : max_so_far;
			}

			return max_so_far;
	    }
	
	
	public static int findMinArrowShots(int[][] points) {

		Arrays.sort(points, new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return -Integer.compare(a[1] - a[0], b[1] - b[0]);
			}
		});

		int arr[] = new int[points.length];

		int number_of_arrows = 0;

		for (int i = 0; i < points.length; i++) {
			if (arr[i] != -1) {
				arr[i] = -1;
				number_of_arrows = number_of_arrows + 1;

				for (int j = i + 1; j < points.length; j++) {
					if (arr[j] != -1 && (points[j][0] >= points[i][0] && points[j][0] <= points[i][1])
							|| (points[j][1] >= points[i][0] && points[j][1] <= points[i][1])) {
						arr[j] = -1;
					}
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				number_of_arrows = number_of_arrows + 1;
			}
		}

		return number_of_arrows;
	}
	
	
	public static String reverseWordsV2(String s) {
		String[] test = s.trim().split(" ");
		StringBuffer result = new StringBuffer();
		for (int i = test.length - 1; i >= 0; i--) {

			s = test[i].trim();

			if (s.length() > 0) {
				result.append(s);
				result.append(" ");
			}
		}
		return result.toString().trim();
	}
	
	
	public static void reverseWords(char[] str) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < str.length; i++) {

			result.append(str[i]);
		}
		
		String lol = reverseWordsV2(result.toString());
		
		System.out.println(lol);

		str = lol.toCharArray();
		
		System.out.println(Arrays.toString(str));

	}
	
	
	public static String addStrings(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();

		StringBuffer result = new StringBuffer();

		int i = a.length - 1;
		int j = b.length - 1;
		
		
		int carry_over = 0;
		
		while (i >= 0 || j >= 0) {
			int i_digit =  i < 0 ? 0 : Character.getNumericValue(a[i]);
			int j_digit =  j < 0 ? 0 : Character.getNumericValue( b[j]);
			
			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if(digit >= 10) {
				
				digit = digit%10;
				carry_over  = 1;
			}
			i--;
			j--;
			result.append(String.valueOf(digit));
		}
		
		if(carry_over == 1) {
			result.append(String.valueOf(carry_over));
		}

		return result.reverse().toString();

	}

	public static int singleNonDuplicate(int[] nums) {
		int r = nums[0];
		for (int i = 1; i < nums.length; i++) {
			r = r ^ nums[i];
		}
		return r;
	}
	
	
	public static int peakIndexInMountainArray(int[] A) {
		return peakIndexInMountainArrayV2(A, 0, A.length - 1);
	}

	public static int peakIndexInMountainArrayV2(int[] nums, int start, int end) {
		
		if(start == end) {
			return start;
		}

		else if (start < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;

			else if (nums[mid] < nums[mid + 1]) {
				return peakIndexInMountainArrayV2(nums, mid + 1, end);
			}
			return peakIndexInMountainArrayV2(nums, start, mid - 1);
		}
		return -1;
	}
	
    public int findPeakElement(int[] nums) {
        
    	return findPeakElementV2(nums, 0, nums.length - 1);
    }
    
	public static Integer findPeakElementV2(int[] nums, int start, int end) {
		
	

		if (start < end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;
			
			else {
				Integer temp = findPeakElementV2(nums, mid + 1, end);
				if(temp != null) {
					return temp;
				}
				else {
					return peakIndexInMountainArrayV2(nums, start, mid - 1);
				}
			}


		}
		return null;
	}
	
	
	public String baseNeg2(int N) {
		return null;

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		else if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		return root;

	}
	
	
	
	public static String largestNumber(int[] nums) {

		List<String> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++)
			result.add(String.valueOf(nums[i]));

		Collections.sort(result, new Sortbyroll());
		StringBuffer str = new StringBuffer("");

		for (int i = 0; i < result.size(); i++)
			str.append(result.get(i));

		return str.toString();
	}
	  
	public static class Sortbyroll implements Comparator<String> {
		public int compare(String a, String b) {

			BigInteger x = new BigInteger(a + b);
			BigInteger y = new BigInteger(b + a);

			return -x.compareTo(y);
		}
	}
	
	
	
	
	public static boolean isAlienSorted(String[] words, String order) {

		Map<Character, Integer> map = new HashMap<>();

		char[] s = order.toCharArray();

		for (int i = 0; i < s.length; i++)
			map.put(s[i], i);

		boolean isSorted = true;

		for (int i = 0; i < words.length - 1; i++) {

			char[] a = words[i].toCharArray();
			char[] b = words[i + 1].toCharArray();

			int min_len = a.length > b.length ? b.length : a.length;

			int j = 0;

			while (j < min_len && isSorted) {

				if (map.get(a[j]) < map.get(b[j])) {
					break;
				}

				else if (map.get(a[j]) == map.get(b[j])) {
					j++;
					continue;
				} else {
					return false;
				}

			}
		}
		return isSorted;
	}
	
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		verticalTraversalV2(root, map, 0);

		List<List<Integer>> result = new ArrayList<>();
		
		
		for (List<Integer> list : map.values()) {
			result.add(list);
		}

		return result;

	}

	void verticalTraversalV2(TreeNode root, Map<Integer, List<Integer>> map, int level) {

		if (root == null) {
			return;
		}

		List<Integer> list = map.getOrDefault(level, new ArrayList<>());
		list.add(root.val);

		map.put(level, list);

		verticalTraversalV2(root.left, map, level - 1);
		verticalTraversalV2(root.right, map, level + 1);

	}
	
	public int kthSmallest(TreeNode root, int k) {
		return kthSmallestV2(root, k, 0);
	}

	public Integer kthSmallestV2(TreeNode root, int k, int c) {
		if (root == null)
			return null;
		Integer temp = kthSmallestV2(root.left, k, c);
		if (temp != null)
			return temp;
		c++;
		if (k == c) {
			return root.val;
		}
		return kthSmallestV2(root.right, k, c);
	}
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		Integer size = getLinkedListLength(head);
		
		size = size - n + 1;
		
		
		int current = 1;
		
		ListNode cur = head;
		ListNode prev = null;
	
		
		while (current < size && cur != null) {

			prev = cur;
			cur = cur.next;
		}
		
		
		prev.next = cur.next;
		
		return head;

	}
	
	public  Integer getLinkedListLength(ListNode headNode) {
		ListNode currentNode = headNode;
		Integer length = 0;

		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}

		return length;
	}
	
	public void moveZeroes(int[] nums) {


		int j = 0;
		int i = 0;
		
		while (i < nums.length) {

			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}
		
		while( j < nums.length) {
			nums[j]  = 0;
			j++;
		}
		
	}
	
	
	public boolean canThreePartsEqualSum(int[] A) {

		int sum = 0;
		for (int i = 0; i < A.length; i++)
			sum += A[i];

		if (sum % 3 != 0)
			return false;

		int current_sum = 0;
		int i = 0;
		int partition = 0;

		while (i < A.length && partition <= 3) {

			current_sum += A[i];

			if (current_sum == sum / 3) {
				partition++;
				current_sum = 0;
			}
		}

		if (partition != 3 || current_sum != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public List<Boolean> prefixesDivBy5(int[] A) {
		String str = "";
		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {

			str += String.valueOf(A[i]);

			int r = binaryToInteger(str);

			if (r == 0)
				result.add(true);
			else
				result.add(false);
		}
		return result;
	}
	
	public Integer binaryToInteger(String binary){
	    char[] numbers = binary.toCharArray();
	    Integer result = 0;
	    int count = 0;
	    for(int i=numbers.length-1;i>=0;i--){
	         if(numbers[i]=='1')result+=(int)Math.pow(2, count);
	         count++;
	    }
	    return result;
	}
	
	public boolean validWordSquare(List<String> words) {

		if (words.isEmpty())
			return true;

		int length = words.get(0).length();

		if (words.size() != length) {
			return false;
		}

		for (int i = 1; i < words.size(); i++) {
			if (words.get(i).length() != length) {
				return false;
			}
		}

		char[][] arr = new char[length][length];
		for (int i = 0; i < words.size(); i++) {
			char[] wr = words.get(i).toCharArray();
			for (int j = 0; j < wr.length; j++) {
				arr[i][j] = wr[j];
			}
		}

		for (int i = 0; i < Math.ceil(arr.length/2); i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(i + "  "  + j);
				if (arr[j][i] != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void wiggleSort(int[] nums) {

		boolean less = true;
		for (int i = 0; i < nums.length; i++) {

			if (less) {

				if (nums[i] > nums[i + 1]) {

					int temp = nums[i];

					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}

			else {

				if (nums[i] < nums[i + 1]) {

					int temp = nums[i];

					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}

			less = !less;
		}
	
	}
	
	
	public static int tilt = 0;
	

    
    int findTilt(TreeNode root )  
    {  
        if (root == null)  
            return 0;  
      
        int left = findTilt(root.left);  
        int right = findTilt(root.right);  
      
        tilt += Math.abs(left - right);  
      
        return left + right + root.val;  
    }  
    
    
    
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		subTreeSum(root, map);

		Integer freq = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() > freq) {
				freq = entry.getValue();
			}

		}

		ArrayList<Integer> arr = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == freq) {
				arr.add(entry.getKey());
			}

		}
		int[] r = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			r[i] = arr.get(i);
		}

		return r;

	}

	public int subTreeSum(TreeNode root, Map<Integer, Integer> map) {

		if (root == null) {
			return 0;
		}

		int left = subTreeSum(root.left, map);
		int right = subTreeSum(root.right, map);

		int tc = left + right + root.val;
		

		Integer rootc = map.getOrDefault(tc, 0);
		map.put(tc, rootc + 1);

		return tc;
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null)
			return true;

		else if (t == null)
			return false;

		if (checkIfTwoTreesAreSame(s, t)) {
			return true;
		}

		return isSubtree(s, t.left) || (isSubtree(s, t.right));
	}

	public boolean checkIfTwoTreesAreSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;

		else if (s == null || t == null)
			return false;

		return (s.val == t.val && checkIfTwoTreesAreSame(s.left, t.left) && checkIfTwoTreesAreSame(s.right, t.right));
	}

	public int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		if (isLeaf(root.left)) {
			sum = sum + root.left.val;
		}
		else {
			sumOfLeftLeaves(root.left);
		}
		sumOfLeftLeaves(root.right);
		return sum;
	}
	



	public boolean isLeaf(TreeNode node) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return false;
	}
	
	
	 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	        
			List<Integer> r1 = new ArrayList<>();
			List<Integer> r2 = new ArrayList<>();
			
			collectLeafNodes(root1, r1);
			collectLeafNodes(root1, r2);
			
			System.out.println(r1);
			System.out.println(r2);

			
			if(r1.size() !=r2.size()) {
				return false;
			}
			
			for(int i = 0; i < r1.size(); i++) {
				if(r1.get(i) != r2.get(i)) {
					return false;
				}
			}

			return true;
	    }
	 	 
	public List<Integer> collectLeafNodes(TreeNode root, List<Integer> r) {

		if (root == null) {
			return r;
		}

		if (isLeaf(root)) {
			r.add(root.val);
		} else {
			collectLeafNodes(root.left, r);
			collectLeafNodes(root.right, r);

		}
		return r;
	}
	
	 
	public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {

		if (r1 == null && r2 == null) {
			return null;
		}

		if (r1 == null) {
			return r2;
		}

		if (r2 == null) {
			return r1;
		}

		r1.val = r1.val + r2.val;

		r1.left = mergeTrees(r1.left, r2.left);
		r1.right = mergeTrees(r1.right, r2.right);

		return r1;
	}
	
	 List<Integer> list = new ArrayList<>();

	public TreeNode increasingBST(TreeNode root) {

		preOrder(root);
		
		Collections.sort(list);

		TreeNode r  = null;
		if (!list.isEmpty()) {
			 r = new TreeNode(list.get(0));
		}
		TreeNode current = r;
		for(int i = 1; i < list.size(); i++) {
			current.right = new TreeNode(list.get(i));
			current = current.right;
		}
		
		return current;
	}
	
	
	public void preOrder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		System.out.println();
		list.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		
		System.out.println(Arrays.toString(nums));

		if (nums.length == 0) {
			return null;
		}
		
		int i = findMax(nums);
		TreeNode root = new TreeNode(nums[i]);
		
		
		
		if(i > 0)
		root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, i -1));
		
		if(i < nums.length - 1)
		root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, i + 1, nums.length - 1));

		return root;
	}
	 
	 public int findMax(int[] nums) {
		 Integer max = Integer.MIN_VALUE;
		 int index = 0;
		 for(int i = 0; i < nums.length; i++) {
			 if(max < nums[i] ) {
				 max = nums[i];
				 index = i;
			 }
		 }	
		 return index;
	 }
	 
	 
	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums.length == 0) {
			return null;
		}

		int i = nums.length / 2;

		TreeNode root = new TreeNode(nums[i]);

		if (i > 0)
			root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, i - 1));

		if (i < nums.length - 1)
			root.right = sortedArrayToBST(Arrays.copyOfRange(nums, i + 1, nums.length - 1));

		return root;

	}
	
	public String r = "";

	public String tree2str(TreeNode t) {

		if (t == null) {
			r = r + "()";

			return r;
		}

		r = r + t.val;

		r = r + "(";

		tree2str(t.left);

		r = r + ")";

		r = r + "(";

		tree2str(t.right);

		r = r + ")";

		return r;
	}
	
	Double min_diff = Double.MAX_VALUE;
	Integer close = null;

	public int closestValue(TreeNode root, double target) {

		if (root == null) {
			return min_diff.intValue();
		}

		double diff = Math.abs(root.val - target);
		if (diff < min_diff) {
			min_diff = diff;
			close = root.val;
		}

		if (root.val > target)
			closestValue(root.left, target);
		else
			closestValue(root.right, target);

		return close;

	}
	
	
	List<Integer>  res = new ArrayList<>();
	int max_index = 0;

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		
		
		if (root == null) {
			return res;
		}

		double diff = Math.abs(root.val - target);
		if (diff < min_diff) {
			min_diff = diff;
			close = root.val;
			
			if(res.size() < k) {
				res.add(root.val);
			}
			
			else {
				
				
				
			}
		}

		if (root.val > target)
			closestKValues(root.left, target, k);
		else
			closestKValues(root.right, target, k);

		return res;

	}
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int[] findMode(TreeNode root) {

		inorder(root);
		Integer max = Integer.MIN_VALUE;
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (max < entry.getValue()) {
				max = entry.getValue();
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (max == entry.getValue()) {
				count++;
			}
		}

		int[] arr = new int[count];

		int i = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (max == entry.getValue()) {
				arr[i] = entry.getKey();
				i++;
			}
		}
		return arr;
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		Integer i = map.getOrDefault(root.val, 0);
		map.put(root.val, i + 1);

		inorder(root.right);
	}
	
	public int count = 0;

	public int countUnivalSubtrees(TreeNode root) {

		if (root == null) {
			return 0;
		}

		 countUnivalSubtreesV2(root);
		 return count;

	}

	public Integer countUnivalSubtreesV2(TreeNode root) {

		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			count++;
			System.out.println("****1********");
			return root.val;
		}

		Integer left = null;
		if (root.left != null) {
			left = countUnivalSubtreesV2(root.left);
		}

		Integer right = null;
		if (root.right != null) {
			right = countUnivalSubtreesV2(root.right);
		}

		if (left != null) {
			count++;
		}

		if (right != null) {
			count++;
		}

		if (left != null && right != null && left == right && left == root.val) {
			count++;
		}
		return root.val;
	}
	
	class Solution {
		public int count = 0;

		public int countUnivalSubtrees(TreeNode root) {

			if (root == null) {
				return 0;
			}

			countUnivalSubtreesV2(root);
			return count;

		}

		public Integer countUnivalSubtreesV2(TreeNode root) {

			if (root == null) {
				return null;
			}

			if (root.left == null && root.right == null) {
				count++;
				return root.val;
			}

			Integer left = null;
			if (root.left != null) {
				left = countUnivalSubtreesV2(root.left);
			}

			Integer right = null;
			if (root.right != null) {
				right = countUnivalSubtreesV2(root.right);
			}

			if (left != null && right != null && root.val == right && left == root.val) {
				count++;
			}
			if (left != null && right == null && left == root.val) {
				count++;
			}

			else if (right != null && left == null && right == root.val) {
				count++;
			}

			return root.val;
		}
	}
	
	private ArrayList<Integer> set = new ArrayList<Integer>();

	public boolean findTarget(TreeNode root, int k) {

		inorderV2(root);

		for (Integer i : set) {

			int temp = k - i;

			if (temp != i && binarySearch(set, 0, set.size() - 1, temp)) {
				return true;
			}
		}
		return false;
	}

	public void inorderV2(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderV2(root.left);
		set.add(root.val);
		inorderV2(root.right);
	}

	public boolean binarySearch(ArrayList<Integer> arr, int start, int end, int target) {
		if (start <= end) {

			int mid = start + ((end - start) / 2);

			if (arr.get(mid) == target) {
				return true;
			}

			else if (arr.get(mid) > target) {
				return binarySearch(arr, start, mid - 1, target);
			}
			return binarySearch(arr, mid + 1, end, target);
		}
		return false;
	}
	
}
package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.algorithms.lists.ListNode;

import java.util.PriorityQueue;
import java.util.Set;

public class LeetCodeV6 {

	public static void main(String[] args) {
		

	
	//System.out.println(compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));

	
	
	String str  = 				"thestoryofleetcodeandme";
	
	
	System.out.println(str.substring(6, 5));
	
		//Solution obj = new Solution(new int[] { 1, 3 });
		//	 int param_1 = obj.pickIndex();
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		
		if(preorder == null|| preorder.length == 0) {
			return null;
		}

		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
		
		if(start > end ) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[start]);
		
		if(start == end) {
			return root;
		}
		
		int index = start;
		
		for (int i = start; i <= end; i++) {
			if (preorder[start] < preorder[i]) {
				break;
			}
			index = i;
		}
		
		root.left = bstFromPreorder(preorder, start + 1, index);
		root.right = bstFromPreorder(preorder, index + 1, end);
		
		return root;

	}
	
    public static boolean verifyPreorder(int[] preorder) {
        
    	if(preorder == null|| preorder.length == 0) {
			return true;
		}

		return verifyPreorder(preorder, 0, preorder.length - 1);
    }


	private static boolean verifyPreorder(int[] preorder, int start, int end) {

		if (start < end) {

			int i = start + 1;
			for (i = start + 1; i <= end; i++) {
				if (preorder[start] < preorder[i]) {
					break;
				}

			}

			for (int j = i; j <= end; j++) {
				if (preorder[start] > preorder[j]) {
					return false;
				}

			}

			return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);

		}

		return true;
	}
	

	 
	  public static boolean verifyPreorderV2(int[] preorder) {
	        return helper(preorder,0,preorder.length-1);
	    }
	    
	    public static boolean helper(int arr[],int start,int end){
	        if(start>end)
	            return true;
	        
	        int root = arr[start];
	        int i = start+1;
	        for(i=start+1;i<=end;i++){
	            if(root<arr[i])
	                break;
	        }
	        for(int j=i;j<=end;j++)
	            if(root>arr[j])
	                return false;
	        
	        return helper(arr,start+1,i-1) && helper(arr,i,end);
	        
	    }
	    
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

			if (l1 == null && l2 == null) {
				return null;
			}

			ListNode l1ptr = l1;
			ListNode l2ptr = l2;
			ListNode head = new ListNode(0);

			ListNode cur = head;
			while (l1ptr != null && l2ptr != null) {

				if (l1ptr.val > l2ptr.val) {
					cur.next = l2ptr;
					l2ptr = l2ptr.next;
				}

				else {
					cur.next = l1ptr;
					l1ptr = l1ptr.next;
				}

				cur = cur.next;
			}

			if (l1ptr != null) {
				cur.next = l1ptr;

			}

			if (l2ptr != null) {
				cur.next = l2ptr;
			}

			return head.next;
		}
		
		
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> q = new PriorityQueue<>(new mergeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				q.add(lists[i]);
			}
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (!q.isEmpty()) {
			ListNode entry = q.poll();
			cur.next = entry;
			if (entry.next != null) {
				q.add(entry.next);
			}
			cur = cur.next;
		}
		return head.next;
	}

	public class mergeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return Integer.compare(o1.val, o2.val);
		}
	}
	
	
	public static ListNode oddEvenList(ListNode head) {
		
		if(head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode even_current = dummy;
		ListNode current = head;
		ListNode prev = null;
		int count = 1;
		while (current != null) {

			if (count % 2 == 0) {
				prev.next = current.next;
				current.next = null;
				even_current.next = current;
				even_current = even_current.next;
				current = prev.next;
			}

			else {
				prev = current;
				current = current.next;
			}

			count++;

		}

		prev.next = dummy.next;
		return head;
	}
	
	// [9,9,9,9,9,9,9,9,8]
	public ListNode plusOne(ListNode head) {

		ListNode rev = reverseList(head);
		ListNode currentNode = rev;
		ListNode previousNode = null;

		int carry_over = 1;
		while (currentNode != null) {

			int sum = currentNode.val + carry_over;

			if (sum <= 9) {
				currentNode.val = sum;
				carry_over = 0;
				break;
			}

			else {
				currentNode.val = sum % 10;
				carry_over = 1;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		if (carry_over == 1) {
			previousNode.next = new ListNode(1);
		}
		return reverseList(rev);
	}

	public static ListNode reverseList(ListNode head) {

		ListNode currentNode = head;
		ListNode previous = null;

		while (currentNode != null) {

			ListNode next = currentNode.next;

			currentNode.next = previous;

			previous = currentNode;

			currentNode = next;
		}

		return previous;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}

		if (l1 == null && l2 != null) {
			return l2;
		}

		ListNode rl1 = reverseList(l1);
		ListNode rl2 = reverseList(l2);

		int carry_over = 0;

		ListNode cur1 = rl1;
		ListNode cur2 = rl2;

		ListNode res = new ListNode(0);

		ListNode dummy = res;

		while (cur1 != null || cur2 != null) {

			int sum = (cur1 != null ? cur1.val : 0) + (cur2 != null ? cur2.val : 0) + carry_over;

			if (sum <= 9) {
				carry_over = 0;
				dummy.next = new ListNode(sum);
			}

			else {
				carry_over = 1;
				dummy.next = new ListNode(sum % 10);
			}

			dummy = dummy.next;

			if (cur1 != null)
				cur1 = cur1.next;

			if (cur2 != null)
				cur2 = cur2.next;

		}

		if (carry_over == 1) {

			dummy.next = new ListNode(1);
		}

		return reverseList(res.next);
	}
	
	// 1, 4, 3, 2, 5, 2
	public static ListNode partition(ListNode head, int x) {
		
		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode previous = null;
		
		ListNode dummy = new ListNode(0);
		ListNode dummyPtr = dummy;

		while (current != null) {

			if (current.val >= x) {

		
				dummyPtr.next = current;

				if (previous != null) {
					previous.next = current.next;
					current = current.next;
				}

				else {
					head = current.next;
					current = head;
				}
				
				dummyPtr = dummyPtr.next;
				dummyPtr.next = null;
			}

			else {
				previous = current;
				current = current.next;
			}
		}
		
		if (previous != null)
			previous.next = dummy.next;
		
		return head;
		
	}
	
	Map<Character, Integer> map = new HashMap<>();

	public String customSortStringV2(String S, String T) {

		for (int i = 0; i < S.length(); i++) {

			map.put(S.charAt(i), i);
		}

		Character[] ch = new Character[T.length()];
		for (int i = 0; i < T.length(); i++) {
			ch[i] = T.charAt(i);
		}

		Arrays.sort(ch, new strComparator());
		
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < ch.length; i++) {
			b.append(ch[i]);
		}

		return b.toString();

	}

	
	public String customSortString(String S, String T) {

		for (int i = 0; i < S.length(); i++) {

			map.put(S.charAt(i), i);
		}
		
		Map<Character, Integer> fmap = new HashMap<>();


	
		for (int i = 0; i < T.length(); i++) {
			Integer count = fmap.getOrDefault(T.charAt(i), 0);
			fmap.put(T.charAt(i), count + 1);
		}

	
		StringBuffer b = new StringBuffer();
		
		for (int k = 0; k < S.length(); k++) {
			
			int i  = fmap.getOrDefault(S.charAt(k), 0);
			
			for (int j = 1; j <= i; j++) {
				b.append(S.charAt(k));
			}
		}
		
		for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {

			if (!map.containsKey(entry.getKey())) {

				int i = fmap.getOrDefault(entry.getKey(), 0);

				for (int j = 1; j <= i; j++) {
					b.append(entry.getKey());
				}
			}
		}


		return b.toString();

	}
	
	
	public class strComparator implements Comparator<Character> {

		@Override
		public int compare(Character o1, Character o2) {
			return Integer.compare(map.getOrDefault(o1, 0), map.getOrDefault(o2, 0));
		}
	}
	
	
	
	
	public List<String> wordSubsets(String[] A, String[] B) {

		Map<Character, Integer> Bmap = getFrequencyMapV2(B);

		List<String> result = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			Map<Character, Integer> word_map = getFrequencyMap(A[i]);

			if (isMapSubSet(Bmap, word_map))
				result.add(A[i]);
		}

		return result;
	}

	public boolean isMapSubSet(Map<Character, Integer> Bmap, Map<Character, Integer> word_map) {
		for (Map.Entry<Character, Integer> entry : Bmap.entrySet()) {
			if (word_map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	
	public Map<Character, Integer> getFrequencyMapV2(String[] B) {
		Map<Character, Integer> Bmap  = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			
			Map<Character, Integer> word_map = getFrequencyMap(B[i]);
			
			for (Map.Entry<Character, Integer> entry : word_map.entrySet()) { 
				Integer cur_count = Bmap.getOrDefault(entry.getKey(), 0);		
				if(entry.getValue() > cur_count) {
					Bmap.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return Bmap;
	}


	public Map<Character, Integer> getFrequencyMap(String T) {
		Map<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			Integer count = fmap.getOrDefault(T.charAt(i), 0);
			fmap.put(T.charAt(i), count + 1);
		}
		return fmap;
	}
	
	
	public  String reverseWordsV2(String s) {
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
	
	
	public void reverseWords(char[] str) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < str.length; i++) {

			result.append(str[i]);
		}

		String res = reverseWordsV2(result.toString());

		for (int i = 0; i < res.length(); i++) {

			str[i] = res.charAt(i);
		}
	}
	
	

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		String str = getPattern(pattern);
		List<String> result = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			if (str.equals(getPattern(words[i])))
				result.add(words[i]);
		}
		return result;
	}

	public String getPattern(String str) {

		int count = 0;
		StringBuffer b = new StringBuffer();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			Integer c = map.get(str.charAt(i));
			if (c == null) {
				c = count;
				map.put(str.charAt(i), c);
				count++;
			}
			b.append(c);

		}
		return b.toString();
	}

	public String findContestMatch(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			res.add(String.valueOf(i));
		}

		while (res.size() > 1) {
			System.out.println(res);

			res = group(res);
			
		}

		return res.get(0);
	}

	public List<String> group(List<String> res) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < res.size() / 2; i++) {
			String s = "(" + res.get(i) + "," + res.get(res.size() - 1 - i) + ")";
			result.add(s);
		}
		return res;
	}
	
	
	public static String shiftingLetters(String S, int[] shifts) {
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < shifts.length; i++) {
			for (int j = 0; j <= i; j++) {
				
				char x;
				if(b.length() > j ) {
					x = b.charAt(j);
				}
				
				else {
					x = S.charAt(j);
				}
				if (j < i)
					b.setCharAt(j, shift(x, shifts[i]));
				else {
					b.append(shift(x, shifts[i]));
				}
			}
			System.out.println(b.toString());
		}
		return b.toString();
	}
	
	
	public static char shift(char c, int times) {
		if (times > 25) {
			times = times % 26;
		}
		int k = c + times;
		if (k > 122) {
			k = k - 26;
		}
		return (char) (k);
	}
	
	
  	public int firstMissingPositive(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)

			map.put(nums[i], 0);
		}

		for (int i = 1; i <= Integer.MAX_VALUE; i++) {

			if (!map.containsKey(i)) {
				return i;
			}
		}
		return 0;
	}
  	

   

	
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long start = lower;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                start++;
                continue;
            }
            
            if (nums[i] > start) {
                res.add(start + (nums[i] - 1 == start ? "" : ("->" + (nums[i] - 1))));
                start = (long)nums[i] + 1;
            }
        }
                
        if (start <= upper) {
            res.add(start +  (upper == start ? "" : "->" + upper));
        }
        
        return res;
    }
    
	public int minFlipsMonoIncr(String S) {

		int first_occurence_of_one = S.indexOf('1');

		int last_occurence_of_zero = S.lastIndexOf('0');

		if (last_occurence_of_zero == -1 || first_occurence_of_one == S.length() - 1 || first_occurence_of_one == -1) {
			return 0;
		}

		int zero_count = 0;
		int one_count = 0;
		
		for (int i = first_occurence_of_one; i <= last_occurence_of_zero; i++) {

			if (S.charAt(i) == '1') {
				one_count++;
			} else {
				zero_count++;
			}
		}

		return Math.min(zero_count, one_count);
	}
	
	
	public int threeSumSmaller(int[] nums, int target) {
		
		int count = 0;
		
		for(int i = 0;  i < nums.length; i++) {
			
			for(int j = i + 1;  j < nums.length; j++) {
				
				for(int k = j + 1;  k < nums.length; k++) {
					
					if(nums[i]  + nums[j] + nums[k] < target) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	
	public static int shipWithinDays(int[] weights, int D) {

		int max_weight = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < weights.length; i++) {
			sum = sum + weights[i];
			if (weights[i] > max_weight) {
				max_weight = weights[i];
			}
		}

		int high = sum;
		int low = max_weight;

		while (low <= high) {
			int mid = (low + high) / 2;
			boolean can = isCapacityEnough(weights, D, mid);
			if (can) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;

	}

	public static int binarySearch(int[] weights, int D, int min, int max) {
		if (min <= max) {

			int mid = min + ((max - min) / 2);

			if (isCapacityEnough(weights, D, mid) && !isCapacityEnough(weights, D, mid - 1)) {
				return mid;
			}

			else if (isCapacityEnough(weights, D, mid)) {
				return binarySearch(weights, D, min, mid - 1);
			}
			return binarySearch(weights, D, mid + 1, max);
		}
		return min;
	}

	public static boolean isCapacityEnough(int[] weights, int D, int capacity) {
		int days = D;
		int weight_per_day = 0;
		for (int i = 0; i < weights.length; i++) {

			if (weights[i] > capacity) {
				return false;
			} else {

				if (weight_per_day + weights[i] > capacity) {
					weight_per_day = weights[i];
					days--;
				} else {
					weight_per_day = weight_per_day + weights[i];
				}
			}
		}
		return days > 0;
	}

	public int numRabbits(int[] answers) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < answers.length; i++) {
			Integer c = map.getOrDefault(answers[i], 0);
			map.put(answers[i], c + 1);
		}

		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == 0)
				sum = sum + entry.getValue();
			else

				sum += entry.getKey() + 1;
		}

		return sum;
	}
	
	

	public String licenseKeyFormatting(String S, int K) {

		StringBuffer b = new StringBuffer();
		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c != '-') {
				b.append(Character.isLetter(c) ? Character.toUpperCase(c) : c);
				count++;
			}
		}

		if (count == 0) {
			return "";
		}

		int r = count % K;

		if (r == 0) {
			r = K;
		}

		StringBuffer res = new StringBuffer();
		res = res.append(b.substring(0, r));

		if (r < b.length())
			res.append("-");
		
		int temp = 0;
		for (int i = r; i < b.length(); i++) {
			temp++;
			res.append(b.charAt(i));

			if (temp % K == 0 && i != b.length() - 1) {
				res.append("-");
				temp = 0;
			}
		}
		return res.toString();
	}
	
	
	
	public int numIslands(char[][] grid) {

		// Search for one
		// increment counter
		// Sink the surroundings

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == '1') {
					count++;
					changeLandToWater(grid, i, j);
				}
			}
		}
		return count;
	}
	
	private void changeLandToWater(char[][] grid, int i, int j) {

		if (i > (grid.length - 1) || i < 0 || j > grid[i].length - 1 || j < 0 || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';

		changeLandToWater(grid, i + 1, j);
		changeLandToWater(grid, i - 1, j);
		changeLandToWater(grid, i, j + 1);
		changeLandToWater(grid, i, j - 1);
	}
	
	
	
	public int maxAreaOfIsland(int[][] grid) {

		int max_area = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == 1) {

					max_area = Math.max(max_area, changeLandToWaterAndGetArea(grid, i, j));
				}
			}
		}
		return max_area;
	}

	private int changeLandToWaterAndGetArea(int[][] grid, int i, int j) {

		if (i > (grid.length - 1) || i < 0 || j > grid[i].length - 1 || j < 0 || grid[i][j] == 0) {
			return 0;
		}

		grid[i][j] = 0;

		int count = 1;

		count += changeLandToWaterAndGetArea(grid, i + 1, j);
		count += changeLandToWaterAndGetArea(grid, i - 1, j);
		count += changeLandToWaterAndGetArea(grid, i, j + 1);
		count += changeLandToWaterAndGetArea(grid, i, j - 1);

		return count;
	}

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += countPerimeter(grid, i, j);
				}
			}
		}
		return perimeter;
	}
	
	public int countPerimeter(int[][] grid, int i, int j) {
		// For element check if all sides i.e up, down, left, right.
		// if boundary or 0 increment 1;

		int count = 0;
		if (i - 1 < 0 || grid[i - 1][j] == 0) {
			count++;
		}

		if (i + 1 > grid[i].length || grid[i + 1][j] == 0) {
			count++;
		}

		if (j - 1 < 0 || grid[i][j - 1] == 0) {
			count++;
		}

		if (j + 1 > grid[i].length || grid[i][j + 1] == 0) {
			count++;
		}

		return count;
	}
	
	public int[] productExceptSelf(int[] nums) {

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;

		for (int i = 1; i < nums.length; i++) {

			left[i] = nums[i - 1] * left[i - 1];
		}

		right[nums.length - 1] = 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = nums[i + 1] * right[i + 1];

		}

		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {

			result[i] = left[i] * right[i];
		}

		return result;
	}
	
	public int getImportance(List<Employee> employees, int id) {
		
		Map<Integer,Employee> map = new HashMap<>();
		
		for (int i = 0; i < employees.size(); i++) {
			map.put(employees.get(i).id , employees.get(i));
		}


		return getImportance(map, id);
	}
	
	public int getImportance(Map<Integer, Employee> map, int id) {

		Employee employee = map.get(id);
		int importance = 0;
		if (employee != null) {
			
			importance = employee.importance;
			
			if (employee.subordinates != null && employee.subordinates.isEmpty()) {
				for (int i = 0; i < employee.subordinates.size(); i++) {
					importance += getImportance(map, employee.subordinates.get(i));
				}
			}
		}
		return importance;
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		System.out.println(getDepth(nestedList));
		return depthSum(nestedList, getDepth(nestedList));
	}

	public int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				sum = sum + n.getInteger() * depth;
			} else {
				sum = sum + depthSum(n.getList(), depth - 1);
			}
		}
		return sum;
	}
	
	public int getDepth(List<NestedInteger> nestedList) {
		
		int max = 0;
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				return 1;
			} else {
				max = Math.max(max, getDepth(n.getList()) + 1);
			}
		}
		return max;
	}

	public int[] sortArray(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}
	
	// Time O(n), Space O(n)
	public String removeVowels(String S) {

		char[] arr = S.toCharArray();

		StringBuffer b = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {

			if (!(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')) {
				b.append(arr[i]);
			}
		}

		return b.toString();
	}
	
	
	// Time O(n), Space O(n)
	public String defangIPaddr(String address) {

		char[] arr = address.toCharArray();

		StringBuffer b = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '.') {
				b.append("[.]");
			} else {
				b.append(arr[i]);
			}

		}

		return b.toString();
	}
	
	public boolean isArmstrong(int N) {

		int k = String.valueOf(N).length();

		int n = N;

		int sum = 0;

		while (n > 0) {

			int d = n % 10;
			n = n / 10;

			sum += Math.pow(d, k);

		}

		return N == sum;
	}
	
	
	public int fixedPoint(int[] A) {

		for (int i = 0; i < A.length; i++) {

			if (i == A[i]) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	public int sumOfDigits(int[] A) {

		int min = A[0];

		for (int i = 1; i < A.length; i++) {

			if (min > A[i]) {
				min = A[i];
			}
		}
		int sum = 0;
		System.out.println(min);
		while (min > 0) {
			int r = min % 10;
			min = min / 10;

			sum = sum + r;
		}

		return sum % 2 == 0 ? 0 : 1;
	}
	
	
	public int largestUniqueNumber(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		Integer max = -1;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1 && entry.getKey() > max) {
				max = entry.getKey();
			}
		}

		return max;

	}
	
	public class intComparator implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {

			if (o1.getValue() < o2.getValue()) {
				return -1;
			}

			else if (o1.getValue() > o2.getValue()) {
				return 1;
			}

			return -Integer.compare(o1.getKey(), o2.getKey());
		}
	}
	
	public String[] findOcurrences(String text, String first, String second) {

		String[] words = text.split(" ");

		List<String> list = new ArrayList<>();

		for (int i = 0; i < words.length - 2; i++) {

			if (words[i].equals(first) && words[i + 1].equals(second)) {
				list.add(words[i + 2]);
			}
		}

		return list.toArray(new String[list.size()]);
	}
	
	//[34,23,1,24,75,33,54,8]
	// 1, 8, 23, 24, 33, 34, 54, 75
	
	public int twoSumLessThanK(int[] A, int K) {

		int x = -1;
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {

			if (A[i] > K) {
				x = i - 1;
				break;
			}
		}

		if (x == -1) {
			return -1;
		}

		else {
			int a = 0;
			int b = x;
			
			int max = -1;

			while (a < b) {

				if (A[a] + A[b] >= 60) {
					b--;
				}

				else {
					if(A[a] + A[b] > max) {
						max = A[a] + A[b];
					}
					a++;
				}
			}
			return max;

		}

	}
	
	public int tribonacci(int n) {

		if (n == 0)
			return 0;

		if (n == 1)
			return 1;

		if (n == 2)
			return 1;

		int a = 0;
		int b = 1, c = 1;

		int d = 0;
		for (int i = 3; i <= n; i++) {

			d = a + b + c;
			a = b;
			b = c;
			c = d;
		}

		return d;
	}
	
	
	public int numberOfDays(int Y, int M) {

		if (M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12) {
			return 30;
		}

		else if (M == 4 || M == 6 || M == 9 || M == 11) {
			return 31;
		}

		else {

			boolean leap = false;
			if (Y % 4 == 0) {
				if (Y % 100 == 0) {
					if (Y % 400 == 0)
						leap = true;
					else
						leap = false;
				} else
					leap = true;
			} else
				leap = false;

			return leap ? 29 : 28;
		}

	}
	
	public boolean divisorGame(int N) {

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				return true;
			}
		}
		return false;
	}

	public boolean confusingNumber(int N) {

		char[] arr = String.valueOf(N).toCharArray();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '2' || arr[i] == '3' || arr[i] == '4' || arr[i] == '5' || arr[i] == '7') {
				return false;
			}
		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '6') {
				arr[i] = '9';
			}

			else if (arr[i] == '9') {
				arr[i] = '6';
			}
		}

		StringBuilder input1 = new StringBuilder();
		input1.append(arr);
		input1.reverse();

		return !input1.toString().equals(String.valueOf(N));
	}
	
	
	public boolean rotateString(String A, String B) {

		int x = A.length();
		int y = B.length();

		if (x != y) {
			return false;
		}

		if (x == 0 && y == 0) {
			return true;
		}

		int l = x;

		StringBuilder input1 = new StringBuilder(A);

		while (l > 0) {

			String str = input1.substring(0, 1);
			input1.replace(0, 1, "");
			input1.append(str);
			l--;

			if (input1.toString().equals(B)) {
				return true;
			}

		}
		return false;
	}
	
	public int heightChecker(int[] heights) {

		int[] copy = Arrays.copyOf(heights, heights.length);
		Arrays.sort(heights);

		int x = 0;
		for (int i = 0; i < copy.length; i++) {

			if (copy[i] != heights[i]) {
				x++;
			}
		}

		return x;

	}
	
	public int[] distributeCandies(int candies, int num_people) {

		int[] arr = new int[num_people];

		int c = 1;
		int i = 0;
		while (candies > 0) {

			arr[i] += c;
			c += 1;

			i++;
			candies--;

			if (i == num_people)
				i = 0;

		}
		
		return arr;
	}
	
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length - 3];
	}
	
	public int countCharacters(String[] words, String chars) {

		int sum = 0;

		Map<Character, Integer> map = getCharFrequencyMap(chars);

		for (int i = 0; i < words.length; i++) {

			if (canBeformed(words[i], map))
				sum += words[i].length();
		}
		return sum;
	}

	public boolean canBeformed(String word, Map<Character, Integer> chars) {

		Map<Character, Integer> map = getCharFrequencyMap(word);

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {

			if (entry.getValue() > chars.getOrDefault(entry.getKey(),0)) {
				return false;
			}
		}

		return true;

	}

	public Map<Character, Integer> getCharFrequencyMap(String str) {
		Map<Character, Integer> map = new HashMap<>();

		char[] arr = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		return map;
	}
	
	
	public int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < stones.length; i++) {
			q.add(stones[i]);
		}

		int y = 0;
		int x = 0;

		while (!q.isEmpty()) {

			y = q.poll();

			if (!q.isEmpty()) {
				x = q.poll();
			} else {
				x = 0;
			}

			if (q.size() <= 1) {
				break;
			} else {
				if (y - x > 0) {
					q.add(y - x);
				}
			}
		}

		return q.isEmpty() ? 0 : q.peek();

	}
	
	public int[][] highFive(int[][] items) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i = 0; i < items.length; i++) {

			PriorityQueue<Integer> list = map.getOrDefault(items[i][0], new PriorityQueue<>(Collections.reverseOrder()));
			list.add(items[i][1]);
			map.put(items[i][0], list);
		}

		int[][] result = new int[map.size()][2];

		int i = 0;

		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {

			PriorityQueue<Integer> list = entry.getValue();

			int[] a = new int[2];

			a[0] = entry.getKey();
			a[1] = (list.poll() + list.poll() + list.poll() + list.poll() + list.poll()) / 5;

			result[i] = a;

			i++;
		}

		return result;
	}
	
	
	
	public static int compress(char[] chars) {

		char current = chars[0];
		int count = 1;

		StringBuffer b = new StringBuffer();

		for (int i = 1; i < chars.length; i++) {

			if (chars[i] != (char) current) {
				b.append(current);

				if (count > 1) {
					b.append(count);

				}

				count = 1;
				current = chars[i];
			}

			else {
				count++;
			}

		}

		b.append(current);

		if (count > 1) {
			b.append(count);

		}
		chars = b.toString().toCharArray();		
		System.out.println(Arrays.toString(chars));

		return chars.length;

	}
	
	public int dayOfYear(String date) {

		String[] arr = date.split("-");
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);

		boolean isleap = isLeapYear(year);

		int[] days = new int[12];

		days[1] = 31;
		days[2] = isleap ? 29 : 28;
		days[3] = 31;
		days[4] = 30;
		days[5] = 31;
		days[6] = 30;
		days[7] = 31;
		days[8] = 31;
		days[9] = 30;
		days[10] = 31;
		days[11] = 30;
		days[12] = 31;

		int count = 0;

		for (int i = 1; i < month; i++) {
			count += days[i];
		}

		count += day;
		return count;
	}

	public boolean isLeapYear(int Y) {
		boolean leap = false;
		if (Y % 4 == 0) {
			if (Y % 100 == 0) {
				if (Y % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;

		return leap;
	}

	       
	public int[][] indexPairs(String text, String[] words) {

		List<List<Integer>> list = new ArrayList<>();
		
		Arrays.sort(words, new java.util.Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        // TODO: Argument validation (nullity, length)
		        return s1.length() - s2.length();// comparision
		    }
		});

		for (int i = 0; i < text.length(); i++) {

			for (String word : words) {

				if (text.length() > i + word.length() && text.substring(i, i + word.length()).equals(word)) {
					List<Integer> l = new ArrayList<>();
					l.add(i);
					l.add(i + word.length() - 1);
					list.add(l);
				}
			}
		}

		int[][] r = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			r[i][0] = list.get(i).get(0);
			r[i][1] = list.get(i).get(1);
		}

		return r;
	}
	
	public int numKLenSubstrNoRepeats(String S, int K) {

		int count = 0;
		for (int i = 0; i < S.length(); i++) {

			if (S.length() > i + 5 && checkIfStringHasDuplicateCharacters(S.substring(i, i + 5))) {
				count++;
			}
		}

		return count;

	}
	
	public boolean checkIfStringHasDuplicateCharacters(String str) {

		Map<Character, Integer> map3 = getCharFrequencyMap(str);

		for (Map.Entry<Character, Integer> entry : map3.entrySet()) {

			if (entry.getValue() > 1) {
				return false;
			}
		}

		return true;
	}
	
	public int maxCount(int m, int n, int[][] ops) {

		int[][] arr = new int[m - 1][n - 1];

		for (int i = 0; i < ops.length; i++) {

			int x = ops[i][0];
			int y = ops[i][1];
			
			System.out.println(x);
			System.out.println(y);


			for (int j = 0; j < x; j++) {

				for (int k = 0; k < y; k++) {

					arr[j][k] += 1;

				}
			}

		}

		int max = 0;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		int c = 0;
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (arr[i][j] == max) {
					c++;
				}
			}
		}

		return c;
	}
	
	// abcdef
	
 	public List<String> findRepeatedDnaSequences(String s) {

		Map<String, Integer> map = new HashMap<>();
		Set<String> list = new HashSet<>();

		for (int i = 0; i <= s.length() - 10; i++) {

            String lol = s.substring(i, 10 + i);
			Integer c = map.getOrDefault(lol, 0);
            
            if(c > 0){
                list.add(lol);
            }
            else {
    			map.put(lol, c + 1);

            }
            
		}



		return new ArrayList<>(list);
	}
 	
 	
 	
 	
	public int lengthOfLongestSubstring(String s) {

		int max = 0;

		for (int i = 1; i < s.length(); i++) {

		}

		return max;

	}

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				q.add(matrix[i][j]);
			}
		}

		int c = 0;

		while (c >= k) {
			q.poll();
		}

		return q.peek();

	}
	
	

    
    public String reorganizeString(String S) {
    	
    	char[] barcodes = S.toCharArray();
    	

		Map<Character, Integer> map4 = getFrequencyMapV3(barcodes);

		PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new intComparatorV3());

		for (Map.Entry<Character, Integer> entry : map4.entrySet()) {
			q.add(entry);
		}

		char[] r = new char[barcodes.length];
		
		int even = 0;
		int odd = 1;

		while (!q.isEmpty()) {

			Entry<Character, Integer> entry = q.poll();
			int c = entry.getValue();
			int i = 1;
			
			while (even < barcodes.length && i <= c) {
				r[even] = entry.getKey();
				even = even + 2;
				i++;
			}
			
			while (odd < barcodes.length && i <= c) {
				r[odd] = entry.getKey();
				odd = odd + 2;
				i++;
			}
			
			if(i < c) {
				return "";
			}
			
		}
		return new String(r);
	}
    
	public Map<Character, Integer> getFrequencyMapV3(char[] barcodes) {
		Map<Character, Integer> map = new HashMap<>();


		for (int i = 0; i < barcodes.length; i++) {
			map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
		}

		return map;
	}
	
	
	
	public int[] rearrangeBarcodes(int[] barcodes) {

		Map<Integer, Integer> map4 = getFrequencyMapV3(barcodes);

		PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(new intComparatorV2());

		for (Map.Entry<Integer, Integer> entry : map4.entrySet()) {

			q.add(entry);
		}

		int[] r = new int[barcodes.length];
		
		int even = 0;
		int odd = 1;

		while (!q.isEmpty()) {

			Entry<Integer, Integer> entry = q.poll();
			
			int c = entry.getValue();
			
			int i = 1;
			
			while (even < barcodes.length && i <= c) {
				r[even] = entry.getKey();
				even = even + 2;
				i++;
			}
			
			System.out.println(i);
			
			while (odd < barcodes.length && i <= c) {
				r[odd] = entry.getKey();
				odd = odd + 2;
				i++;
			}
			
		}
		return r;
	}
	
	public class intComparatorV2 implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {

	

			return -Integer.compare(o1.getValue(), o2.getValue());
		}
	}
	
	public class intComparatorV3 implements Comparator<Map.Entry<Character, Integer>> {

		@Override
		public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {

	

			return -Integer.compare(o1.getValue(), o2.getValue());
		}
	}
    
    
	public Map<Integer, Integer> getFrequencyMapV3(int[] barcodes) {
		Map<Integer, Integer> map = new HashMap<>();


		for (int i = 0; i < barcodes.length; i++) {
			map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
		}

		return map;
	}
	

	

}
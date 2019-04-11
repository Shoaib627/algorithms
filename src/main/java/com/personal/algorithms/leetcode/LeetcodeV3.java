package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import com.personal.algorithms.trees.Node;
import com.personal.algorithms.trees.TreeNode;

public class LeetcodeV3 {

	public static void main(String[] args) {

	}

	public static int numPairsDivisibleBy60(int[] time) {

		int pairs = 0;
		for (int i = 0; i < time.length - 1; i++) {

			for (int j = i + 1; j < time.length; j++) {

				if ((time[i] + time[j]) % 60 == 0) {
					pairs++;
				}

			}
		}
		return pairs;
	}

	public boolean wordPattern(String pattern, String str) {

		char[] A = pattern.toCharArray();
		String[] B = str.split(" ");

		if (A.length != B.length) {
			return false;
		}

		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			String temp = map.get(A[i]);
			if (temp != null && !temp.equals(B[i])) {
				return false;
			}

			map.put(A[i], B[i]);
		}
		
		if (map.values().size() != map.values().stream().collect(Collectors.toSet()).size()) {
			return false;
		}

		return true;

	}
	
	
	public boolean checkRecord(String s) {
		char[] A = s.toCharArray();
		int a_count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 'A') {
				a_count++;
			}
			if (a_count > 1) {
				return false;
			}

			if (i != A.length - 2 && A[i] == 'L' && A[i + 1] == 'L' && A[i + 2] == 'L') {
				return false;
			}
		}
		return true;
	}

	public static int minMoves(int[] A) {

		int minMoves = 0;
	
		while (true) {

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			int max_index = 0;

			for (int i = 0; i < A.length; i++) {
				if (A[i] > max) {
					max = A[i];
					max_index = i;
				}

				if (A[i] < min) {
					min = A[i];
				}
			}
			
			minMoves = minMoves + (max - min);

			if (min == max) {
				break;
			}

			for (int i = 0; i < A.length; i++) {
				if (i != max_index) {
					A[i] = A[i] + (max - min);
				}
			}
		}
		return minMoves;
	}
	
	public static int findContentChildren(int[] g, int[] s) {

		int children = 0;
		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0;
		int j = 0;

		while (i < g.length && j < s.length) {
			while (j < s.length) {
				if (g[i] <= s[j]) {
					children++;
					i++;
				}
				j++;
			}
		}
		return children;
	}
	
	public TreeNode searchBST(TreeNode root, int val) {

		if (root == null) {
			return null;
		}

		if (root.val == val) {
			return root;
		} else if (root.val > val) {
			return searchBST(root.right, val);
		}

		else {
			return searchBST(root.left, val);
		}
	}
	

	
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}

		if (p != null && q != null) {
			return false;
		}

		return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}
	
	
	class Solution {
		
		Integer min = Integer.MAX_VALUE;
		
		Integer second_min = Integer.MAX_VALUE;
		
		public int findSecondMinimumValue(TreeNode root) {

			if (root == null) {
				return second_min;
			}

			if (root.val != min) {
				if (root.val < min) {
					int temp = min;
					min = root.val;
					second_min = temp;
				}
				
				else if(root.val < second_min) {
					second_min = root.val;
				}
			}
			
			 findSecondMinimumValue(root.left);
			 findSecondMinimumValue(root.right);
			 
			 return second_min;

		}
	}
	
	class Solution2 {

		List<Integer> r = new ArrayList<>();

		public List<Integer> inorderTraversal(TreeNode root) {
			if (root == null) {
				return r;
			}

			inorderTraversal(root.left);
			r.add(root.val);
			inorderTraversal(root.right);

			return r;
		}

		public boolean isValidBST(TreeNode root) {
			
			List<Integer> arr = inorderTraversal(root);
			
			for(int i = 0; i < arr.size() - 1; i ++) {
				if(arr.get(i) > arr.get(i + 1)) {
					return false;
				}
			}
			return true;
		}

	}

	
	
	
	class Solution3 {

		List<Integer> r = new ArrayList<>();

		public List<Integer> postorder(Node root) {

			if (root == null) {
				return r;
			}

			if (root.children != null) {
				root.children.forEach(c -> postorder(c));
			}
			r.add(root.val);
			return r;

		}
	}
	
	
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if (root == null) {
			return new TreeNode(val);
		}

		if (val > root.val) {

			root.right = insertIntoBST(root.right, val);

		}

		else {

			root.left = insertIntoBST(root.left, val);

		}
		return root;
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

	}
	
	class SolutionV4 {

		List<List<Integer>> r = new ArrayList<>();

		List<Integer> local = new ArrayList<>();

		public Integer findBottomLeftValue(TreeNode root) {

			Queue<TreeNode> queue = new LinkedList<>();

			if (root != null) {
				queue.add(root);
				queue.add(null);
			}

			Integer re = root != null ? root.val : null;

			boolean new_level = true;
			while (!queue.isEmpty()) {

				TreeNode node = queue.poll();

				if (node == null) {
					r.add(local);
					local = new ArrayList<>();

					if (!queue.isEmpty()) {
						queue.add(null);
					}

					new_level = true;
				}

				else {

					local.add(node.val);

					if (node.left != null) {
						if (new_level) {
							re = node.left.val;
							new_level = false;
						}
						queue.add(node.left);
					}

					if (node.right != null) {
						if (new_level) {
							re = node.right.val;
							new_level = false;
						}
						queue.add(node.right);
					}
				}

			}

			return re;

		}
	}
	
	
	
	class SolutionV5 {

		List<Integer> local = new ArrayList<>();

		public List<Integer> rightSideView(TreeNode root) {

			Queue<TreeNode> queue = new LinkedList<>();

			if (root != null) {
				local.add(root.val);
				queue.add(root);
				queue.add(null);
			}
			
			boolean new_level = true;
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node == null) {
					if (!queue.isEmpty())
						queue.add(null);
					new_level = true;
				}

				else {
					if (node.right != null) {
						if (new_level) {
							local.add(node.right.val);
							new_level = false;
						}
						queue.add(node.right);
					}

					if (node.left != null) {
						if (new_level) {
							local.add(node.left.val);
							new_level = false;
						}
						queue.add(node.left);
					}
				}
			}
			return local;
		}
	}
	
	class SolutionV7 {

		Integer min = Integer.MAX_VALUE;

		Integer second_min = Integer.MAX_VALUE;
		
		boolean is_second_min = false;

		public int findSecondMinimumValue(TreeNode root) {

			if (root == null) {
				return -1;
			}
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while(!queue.isEmpty()) {
				
				TreeNode node = queue.poll();
				
				if (node.val != min) {
					if (node.val < min) {
						int temp = min;
						min = node.val;
						second_min = temp;
					}
					
					else if(node.val < second_min) {
						second_min = node.val;
						is_second_min = true;
					}
				}
				
				if(node.left!=null)
					queue.add(node.left);
				
				if(node.right!=null)
					queue.add(node.right);
			}
			return is_second_min ? second_min: -1;
		}
	}
	
	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		int depth = 0;
		boolean new_level = true;

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node == null) {
				new_level = true;
				if (!queue.isEmpty()) {
					queue.add(null);
				}
			}

			else {
				if (node.left != null) {
					if(new_level) {
						depth++;
						new_level = false;
					}
					queue.add(node.left);
				}

				else if (node.right != null) {
					if(new_level) {
						depth++;
						new_level = false;
					}
					queue.add(node.right);
				}
			}
		}
		return depth;
	}
	
	public int maxDepth2(Node root) {

		if (root == null)
			return 0;
		return 1 + (root.children != null ? root.children.stream().mapToInt(n -> maxDepth(n)).max().orElse(0) : 0);
	}
	
	public int maxDepth(Node root) {

		if (root == null)
			return 0;

		int maxChild = 0;

		if (root.children != null) {
			for (int i = 0; i < root.children.size(); i++) {
				int temp = maxDepth(root.children.get(i));

				if (temp > maxChild) {
					maxChild = temp;
				}
			}
		}

		return 1 + maxChild;
	}

	class SolutionV8 {

		List<List<Integer>> r = new ArrayList<>();

		List<Integer> local = new ArrayList<>();

		public List<List<Integer>> levelOrder(Node root) {

			if (root == null) {
				return r;
			}

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {

				Node node = q.poll();

				if (node == null) {

					r.add(local);
					local = new ArrayList<>();

					if (!q.isEmpty()) {
						q.add(null);
					}

				}

				else {

					local.add(node.val);
					if (node.children != null) {
						
						for(int i = 0; i < node.children.size(); i++) {
							q.add(node.children.get(i));
						}
				
					}
				}
			}

			return r;
		}
	}
	
	
	class SolutionV112 {

		List<List<Integer>> r = new ArrayList<>();

		List<Integer> local = new ArrayList<>();
		
		Integer max = Integer.MIN_VALUE;

		public int levelOrder(TreeNode root) {

			if (root == null) {
				return 0;
			}

			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {

				TreeNode node = q.poll();

				if (node == null) {

					r.add(local);
					
					if(local.size()> max) {
						max = local.size();
					};
					local = new ArrayList<>();

					if (!q.isEmpty()) {
						q.add(null);
					}

				}

				else {

					local.add(node.val);
					
					if (node.left != null) {
					
						q.add(node.left);
					}

					else if (node.right != null) {
					
						q.add(node.right);
					}
				
				}
			}

			return max;
		}
	}
	
	
	class SolutionV11 {
		
		
		public List<Integer> largestValues(TreeNode root) {

			List<Integer> result = new ArrayList<>();
			List<Integer> row_list = new ArrayList<>();

			Queue<TreeNode> q = new LinkedList<>();

			if (root != null) {
				q.add(root);
				q.add(null);
				row_list.add(root.val);
			}

			while (!q.isEmpty()) {

				TreeNode node = q.poll();

				if (node == null) {

					int temp = Integer.MIN_VALUE;

					for (int i = 0; i < row_list.size(); i++) {

						Integer a = row_list.get(i);
						if (a > temp) {
							temp = a;
						}
					}

					result.add(temp);
					row_list = new ArrayList<>();

					if (!q.isEmpty())
						q.add(null);
				}

				else {
					row_list.add(node.val);

					if (node.left != null)
						q.add(node.left);

					if (node.right != null)
						q.add(node.right);

				}
			}
			return result;
		}
	}
	
	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		return Math.abs(maxDepthV3(root.left) - maxDepthV3(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);

	}

	public int maxDepthV3(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(maxDepthV3(root.left), maxDepthV3(root.right));
	}
	
	public int rangeSumBST(TreeNode root, int L, int R) {

		int sum = 0;

		Queue<TreeNode> q = new LinkedList<>();

		if (root != null) {
			q.add(root);
			q.add(null);
			
		}

		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {

			

				if (!q.isEmpty())
					q.add(null);
			}

			else {
				
				if (node.val >= L && node.val <= R) {
					sum = sum + node.val;
				}

				if (node.left != null)
					q.add(node.left);

				if (node.right != null)
					q.add(node.right);

			}
		}
		return sum;
	}
	
	public String complexNumberMultiply(String x, String y) {

		String[] arr = x.split("\\+");

		Integer a = Integer.parseInt(arr[0]);
		Integer b = Integer.parseInt(arr[1].substring(0, arr[1].length() - 1));

		String[] arr2 = y.split("+");

		Integer c = Integer.parseInt(arr2[0]);
		Integer d = Integer.parseInt(arr2[1].substring(0, arr2[1].length() - 1));

		StringBuffer r = new StringBuffer((a * c - b * d));

		r.append("+");
		r.append(b * c + a * d);
		r.append("i");

		return r.toString();

	}
	
	public String convertToBase7(int num) {
		
		if(num == 0) {
			return "0";
		}

		boolean isNegative = num < 0;

		if (isNegative) {
			num = -num;
		}

		StringBuffer b = new StringBuffer("");

		while (num > 0) {
			b.append(num % 7);
			num = num / 7;
		}

		if (isNegative) {
			b.append("-");
		}
		return b.reverse().toString();
	}
	
	
	public static List<List<String>> findDuplicate(String[] paths) {

		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < paths.length; i++) {

			String[] arr = paths[i].split(" ");
			
			String path = arr[0];
			
			for (int j = 1; j < arr.length; j++) {
				
				String file = arr[j].substring(0, arr[j].indexOf('('));
				String key = arr[j].substring(arr[j].indexOf('(') + 1, arr[j].length() - 1);

				String full_path = new StringBuffer(path + "/" + file).toString();

				List<String> full_path_list = map.get(key);

				if (full_path_list == null) {
					full_path_list = new ArrayList<>();
					full_path_list.add(full_path);
					map.put(key, full_path_list);
				}

				else {
					full_path_list.add(full_path);
					map.put(key, full_path_list);
				}
			}
		}

		List<List<String>> result = new ArrayList<>();

		for (Entry<String, List<String>> entry : map.entrySet()) {

			if (entry.getValue().size() > 1) {
				result.add(entry.getValue());
			}
		}

		return result;
	}
	
	public int findComplement(int num) {

		StringBuffer b = new StringBuffer("");

		while (num > 0) {
			b.append(num % 2);
			num = num / 2;
		}

		b = b.reverse();

		String str = b.toString();

		if (str.startsWith("0")) {
			str = str.substring(str.indexOf('1'), str.length());
		}

		char[] arr = str.toCharArray();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			char t = arr[i] == '0' ? '1' : '0';
			sum = (int) (sum + Character.getNumericValue(t) * Math.pow(2, arr.length - 1 - i));
		}

		return sum;
	}
	
	
	public int[] productExceptSelf(int[] nums) {

		int product = 1;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != 0)
				product = product * nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = product;
			} else {
				nums[i] = product / nums[i];
			}
		}

		return nums;
	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		invertTree(root.right);
		invertTree(root.left);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;

	}
	
	

	
	class KthLargest {

		PriorityQueue<Integer> minHeap = null;
		int kthValue = 0;

		public KthLargest(int k, int[] nums) {

			this.minHeap = new PriorityQueue<Integer>(k);
			this.kthValue = k;

			for (int i : nums) {
				add(nums[i]);
			}
		}

		public int add(int val) {

			minHeap.add(val);
			if (minHeap.size() > kthValue) {
				minHeap.poll();
			}

			return minHeap.peek();

		}
	}
	
	
	public int findKthLargestV2(int[] nums, int k) {

		Arrays.sort(nums);

		return nums[nums.length - k];

	}

	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i : nums) {
			minHeap.add((nums[i]));
		}

		while (minHeap.size() > k) {
			minHeap.poll();
		}

		return minHeap.peek();

	}
	
	class FrequeuncyComparator implements Comparator<Map.Entry<Integer, Integer>> {

		public int compare(Map.Entry<Integer, Integer> s1, Map.Entry<Integer, Integer> s2) {
			if (s1.getValue() < s2.getValue())
				return 1;
			else if (s1.getValue() > s2.getValue())
				return -1;
			return 0;
		}
	}


	
	
	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer c = map.get(nums[i]);
			map.put(nums[i], c == null ? 1 : c + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(a, b) -> Integer.compare(a.getValue(), b.getValue()));

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (minHeap.size() < k)
				minHeap.offer(e);
			else {
				if (e.getValue() > minHeap.peek().getValue()) {
					minHeap.poll();
					minHeap.offer(e);
				}
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().getKey());
		}
		return result;
	}
	
	public static List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			Integer c = map.get(words[i]);
			map.put(words[i], c == null ? 1 : c + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						if (o1.getValue() != o2.getValue())
							return o1.getValue() - o2.getValue();
						else
							return o2.getKey().compareTo(o1.getKey());
					}
				});

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (minHeap.size() < k)
				minHeap.offer(e);
			else {
				if (e.getValue() > minHeap.peek().getValue()) {
					minHeap.poll();
					minHeap.offer(e);
				}
			}
		}

		List<String> result = new ArrayList<>();

		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().getKey());
		}

        Collections.reverse(result);
        //System.out.println(result);
		return result;
	}

	public int singleNonDuplicate(int[] nums) {
		return 0;
	}
}
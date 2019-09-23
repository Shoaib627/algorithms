package com.practise.trees.summation;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class LargestSubTreeSum {

	private Integer max_sum_so_far = Integer.MIN_VALUE;

	// Time Complexity: O(n), where n is number of nodes.
	// Auxiliary Space: O(n), function call stack size.
	
	// Approach is max subtree sum is basically max of (tree_sum, left_sum, right_sum)
	// Post order traversal
	public Integer largestSum(TreeNode node) {

		if (node == null) {
			return 0;
		}

		Integer left_sum = largestSum(node.left);
		Integer right_sum = largestSum(node.right);

		int tree_sum = node.val + left_sum + right_sum;

		max_sum_so_far = Math.max(max_sum_so_far, Math.max(tree_sum, Math.min(left_sum, right_sum)));

		return tree_sum;

	}

	public static void main(String[] args) {

		LargestSubTreeSum ll = new LargestSubTreeSum();

		System.out.println(ll.largestSum(TreeGenerator.getTree()));

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(-2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(2);

		System.out.println(ll.largestSum(root));

	}

}

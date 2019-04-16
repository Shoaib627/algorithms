package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class SumOfRightLeavesRecursive {

	// check if the right subtree is a leaf or not, If it is, then add it to the
	// result.
	// root is neither left or right

	public int sum(TreeNode root) {
		int c = 0;
		if (root == null) {
			return 0;
		}

		if (isLeaf(root.right)) {
			c += root.right.val;
		} else {
			c += sum(root.right);
		}

		c += sum(root.left);

		return c;
	}

	public boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		SumOfRightLeavesRecursive s = new SumOfRightLeavesRecursive();
		System.out.println(s.sum(TreeGenerator.getTree()));

	}
}
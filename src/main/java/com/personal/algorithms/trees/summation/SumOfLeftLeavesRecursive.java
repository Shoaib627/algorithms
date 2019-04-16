package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class SumOfLeftLeavesRecursive {

	// check if the left subtree is a leaf or not, If it is, then add it to the
	// result.
	// root is neither left or right

	public int sum(TreeNode root) {
		int c = 0;
		if (root == null) {
			return 0;
		}

		if (isLeaf(root.left)) {
			c += root.left.val;
		} else {
			c += sum(root.left);
		}

		c += sum(root.right);

		return c;
	}

	public boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		SumOfLeftLeavesRecursive s = new SumOfLeftLeavesRecursive();
		System.out.println(s.sum(TreeGenerator.getTree()));

	}
}
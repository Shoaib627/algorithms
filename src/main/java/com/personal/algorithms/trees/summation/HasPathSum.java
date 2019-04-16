package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		return isLeaf(root) && root.val == sum || hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);

	}

	public boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		HasPathSum h = new HasPathSum();

		System.out.println(h.hasPathSum(TreeGenerator.getTree(), 14));
	}
}

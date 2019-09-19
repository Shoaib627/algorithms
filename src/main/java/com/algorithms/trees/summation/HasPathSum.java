package com.algorithms.trees.summation;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

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

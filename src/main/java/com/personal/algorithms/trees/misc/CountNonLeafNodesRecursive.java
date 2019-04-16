package com.personal.algorithms.trees.misc;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class CountNonLeafNodesRecursive {

	public int nonLeavesCount(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (isLeaf(root)) {
			return 0;
		}

		return 1 + nonLeavesCount(root.left) + nonLeavesCount(root.right);
	}

	public boolean isLeaf(TreeNode root) {
		return root != null && (root.left == null && root.right == null);
	}

	public static void main(String[] args) {
		CountNonLeafNodesRecursive c = new CountNonLeafNodesRecursive();
		System.out.println(c.nonLeavesCount(TreeGenerator.getTree()));

	}
}
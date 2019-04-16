package com.personal.algorithms.trees.misc;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

// Height of tree is basically 1 + max( height(left_subtree), height(right_subtree))
public class HeightOrMaxDepthOfTreeRecursive {

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {

		HeightOrMaxDepthOfTreeRecursive s = new HeightOrMaxDepthOfTreeRecursive();
		System.out.println(s.height(TreeGenerator.getTree()));

	}
}
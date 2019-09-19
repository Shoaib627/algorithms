package com.algorithms.trees.summation;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class SumOfLeafNodesRecursive {

	int sum = 0;

	public void recurse(TreeNode root) {

		if (root == null) {
			return;
		}

		if (isLeaf(root))
			sum = sum + root.val;

		recurse(root.left);
		recurse(root.right);
	}

	public boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		SumOfLeafNodesRecursive s = new SumOfLeafNodesRecursive();
		s.recurse(TreeGenerator.getTree());
		System.out.println(s.sum);
	}
}

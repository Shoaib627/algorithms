package com.practise.trees.summation;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class SumOfAllNodesRecursive {

	public int sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val + sum(root.left) + sum(root.right);
	}

	public static void main(String[] args) {

		SumOfAllNodesRecursive s = new SumOfAllNodesRecursive();
		System.out.println(s.sum(TreeGenerator.getTree()));
	}
}
package com.personal.algorithms.trees.summation;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class SumOfParentNodesWithChildXRecursive {

	public int sum(TreeNode root, int x) {

		if (root == null) {
			return 0;
		}

		return (isChildWithXPresent(root, x) ? root.val : 0) + sum(root.left, x) + sum(root.right, x);
	}

	public boolean isChildWithXPresent(TreeNode root, int x) {

		if (root.left != null && root.left.val == x) {
			return true;
		}

		if (root.right != null && root.right.val == x) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		SumOfParentNodesWithChildXRecursive ll = new SumOfParentNodesWithChildXRecursive();
		System.out.println(ll.sum(TreeGenerator.getTree(), 7));
	}
}
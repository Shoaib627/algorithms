package com.practise.trees.misc;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class SizeOfTreeRecursive {

	public int size(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + size(root.left) + size(root.right);
	}

	public static void main(String[] args) {

		SizeOfTreeRecursive ss = new SizeOfTreeRecursive();

		System.out.println(ss.size(TreeGenerator.getTree()));

	}
}

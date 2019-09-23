package com.practise.trees.misc;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class DeleteLeafWithValueXRecursive {

	public static void delete(TreeNode root, int x) {

		if (root == null) {
			return;
		}

		delete(root.left, x);
		delete(root.right, x);

		if (isLeaf(root) && root.val == x) {
			root = null;
		}

	}

	private static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {

		TreeNode root = TreeGenerator.getTree();
		inorder(root);

		delete(root, 4);
		System.out.println();
		inorder(root);

	}
}
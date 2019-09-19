package com.algorithms.trees;

import com.practise.leetcode.TreeNode;

public class RecursiveTraversals {

	public static void preorder(TreeNode node) {

		if (node != null) {
			System.out.print(node.val);
			System.out.print(" ");

			preorder(node.left);
			preorder(node.right);
		}

	}

	public static void postorder(TreeNode node) {

		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.val);
			System.out.print(" ");

		}

	}

	public static void inorder(TreeNode node) {

		if (node != null) {
			inorder(node.left);
			System.out.print(node.val);
			System.out.print(" ");

			inorder(node.right);
		}
		
	}
	
	
	



	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		inorder(root);
		System.out.println();

		preorder(root);
		System.out.println();

		postorder(root);
	}
}

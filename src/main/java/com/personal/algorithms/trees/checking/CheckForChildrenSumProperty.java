package com.personal.algorithms.trees.checking;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;


// Traverse the given binary tree. For each node check (recursively) 
//if the node and both its children satisfy the Children Sum Property, 
// if so then return true else return false.
		
public class CheckForChildrenSumProperty {

	public boolean check(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isNodeHasSumProperty(root) && check(root.left) && check(root.right);
	}

	private boolean isNodeHasSumProperty(TreeNode root) {
		if (!isLeaf(root)) {
			int left = root.left != null ? root.left.val : 0;
			int right = root.right != null ? root.right.val : 0;
			return root.val == left + right;
		}
		return true;
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		CheckForChildrenSumProperty cc = new CheckForChildrenSumProperty();

		System.out.println(cc.isNodeHasSumProperty(TreeGenerator.getTree()));

		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(8);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);

		root.right.left = new TreeNode(2);

		System.out.println(cc.isNodeHasSumProperty(root));

	}

}
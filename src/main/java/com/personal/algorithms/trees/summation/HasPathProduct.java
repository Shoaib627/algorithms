package com.personal.algorithms.trees.summation;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class HasPathProduct {

	public boolean hasPathProduct(TreeNode root, int product) {

		if (root == null)
			return false;

		return isLeaf(root) && root.val == product || hasPathProduct(root.left, product/ root.val)
				|| hasPathProduct(root.right, product/root.val);

	}

	public boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static void main(String[] args) {

		HasPathProduct h = new HasPathProduct();

		System.out.println(h.hasPathProduct(TreeGenerator.getTree(), 21));
	}
}

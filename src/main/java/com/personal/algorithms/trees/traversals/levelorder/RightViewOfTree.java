package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class RightViewOfTree {

	public void printLeftViewOfTree(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		// At every level we need a marker to pick up the right most element the array
		boolean isFirst = true;
		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			if (node == null) {

				// At every new level isFirst is set to true
				isFirst = true;

				if (q.isEmpty()) {
					return;

				} else {

					q.add(null);

				}
			} else {

				if (isFirst) {
					System.out.println(node.val);
					// Once we see the left most element we isFirst is set to false
					isFirst = !isFirst;
				}

				// Incase of right view we need to see the right elements first
				// hence first right child are pushed first to the queue
				if (node.right != null) {
					q.add(node.right);
				}

				if (node.left != null) {
					q.add(node.left);
				}
			}
		}
	}

	public static void main(String[] args) {

		RightViewOfTree ll = new RightViewOfTree();
		ll.printLeftViewOfTree(TreeGenerator.getTree());
	}
}
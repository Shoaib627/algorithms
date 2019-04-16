package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class LeftViewOfTree {

	public void printLeftViewOfTree(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		// At every level we need a marker to pick up the left most element the array
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

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}

			}
		}
	}

	public static void main(String[] args) {

		LeftViewOfTree ll = new LeftViewOfTree();
		ll.printLeftViewOfTree(TreeGenerator.getTree());
	}
}

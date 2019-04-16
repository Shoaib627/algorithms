package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

// Time Complexity =  O(n) since we are traversing through all the nodes
// Space Complexity = O(n/2) ~ O(n) since queue size at max can have all the leaf nodes, max leaf nodes is n/2

public class LevelOrderTraversalSingleLine {

	void printTreeInLevelOrderTraversal(TreeNode root) {

		// Base case: If root is null don't do anything
		if (root == null) {
			return;
		}

		// Initialise the queue by adding the root node to the queue.
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			System.out.print(node.val + " ");

			// If the node has left child add to queue
			if (node.left != null) {
				q.add(node.left);
			}

			// If the node has right child add to queue
			if (node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static void main(String[] args) {

		LevelOrderTraversalSingleLine l = new LevelOrderTraversalSingleLine();
		l.printTreeInLevelOrderTraversal(TreeGenerator.getTree());
	}
}
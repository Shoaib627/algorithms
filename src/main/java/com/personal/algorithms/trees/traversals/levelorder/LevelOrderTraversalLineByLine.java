package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

//Time Complexity =  O(n) since we are traversing through all the nodes
//Space Complexity = O(n/2) ~ O(n) since queue size at max can have all the leaf nodes, max leaf nodes is n/2

public class LevelOrderTraversalLineByLine {

	public void printLevelOrderTraversalLineByLine(TreeNode root) {

		// Base case: If root is null don't do anything

		if (root == null) {
			return;
		}

		// Initialise the queue by adding the root node to the queue.
		// Also add null indicating the end of level

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			TreeNode node = q.poll();

			// If node is level is null, it means end of a particular level in the tree
			if (node == null) {

				// If node is level is null and queue is empty it means, end of tree or no more levels left 
				if (q.isEmpty()) {
					return;
				}

				// If node is level is null and queue is not empty it means, more levels left to traverse

				else {
					// Here we can do what ever processing we want to do, at the end of each level
					System.out.println();
					q.add(null);
				}

			} else {

				// Here we access to node 
				System.out.print(node.val + " ");
				
				// push the left element if present to queue
				if (node.left != null) {
					q.add(node.left);
				}

				// push the right element if present to queue
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversalLineByLine ll = new LevelOrderTraversalLineByLine();
		ll.printLevelOrderTraversalLineByLine(TreeGenerator.getTree());
	}
}
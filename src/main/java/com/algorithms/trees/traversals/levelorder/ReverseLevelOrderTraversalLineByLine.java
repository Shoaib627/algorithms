package com.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class ReverseLevelOrderTraversalLineByLine {

	public void printTreeInReverseLevelOrderTraversalLineByLine(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<Integer> stack = new Stack<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == null) {

				if (q.isEmpty()) {
					break;
				}

				else {
					stack.push(null);
					q.add(null);
				}
			}

			// To make sure the level elements are popped in the right way,
			// we need to push first right child to the queue

			else {

				stack.push(node.val);

				if (node.right != null) {
					q.add(node.right);
				}

				if (node.left != null) {
					q.add(node.left);
				}
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == null) {
				stack.pop();
				System.out.println();
			} else {
				System.out.print(stack.pop() + " ");
			}

		}
	}

	public static void main(String[] args) {

		ReverseLevelOrderTraversalLineByLine ll = new ReverseLevelOrderTraversalLineByLine();
		ll.printTreeInReverseLevelOrderTraversalLineByLine(TreeGenerator.getTree());
	}
}

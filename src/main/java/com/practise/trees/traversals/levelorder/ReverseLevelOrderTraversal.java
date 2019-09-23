package com.practise.trees.traversals.levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class ReverseLevelOrderTraversal {

	public void printTreeInReverseLevelOrderTraversal(TreeNode root) {

		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<Integer> stack = new Stack<>();
		q.add(root);

		List<Integer> list = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			stack.push(node.val);
			list.add(node.val);

			// To make sure the level elements are popped in the right way,
			// we need to push first right child to the queue

			if (node.right != null) {
				q.add(node.right);
			}

			if (node.left != null) {
				q.add(node.left);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {

		ReverseLevelOrderTraversal ll = new ReverseLevelOrderTraversal();
		ll.printTreeInReverseLevelOrderTraversal(TreeGenerator.getTree());
	}
}

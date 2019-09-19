package com.practise.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

class BSTIterator {

	ArrayList<Integer> list;
	Iterator<Integer> it;

	public BSTIterator(TreeNode root) {

		list = new ArrayList<>();

		inOrder(root);

		it = list.iterator();
	}

	public void inOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		return it.next();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return it.hasNext();
	}
}
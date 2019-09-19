package com.algorithms.trees.traversals.vertical;

import java.util.TreeMap;

import com.algorithms.trees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class BottomViewOfTreeRecursive {

	// Keys are sorted in natural order
	public TreeMap<Integer, Integer> map;

	BottomViewOfTreeRecursive() {
		this.map = new TreeMap<>();
	}

	public void topViewOfTree(TreeNode root) {

		recurse(root, 0);
		
		System.out.println(map.values());

	}

	public void recurse(TreeNode root, int level) {

		if (root == null) {
			return;
		}

		map.put(level, root.val);

		recurse(root.left, level - 1);
		recurse(root.right, level + 1);

	}

	public static void main(String[] args) {

		BottomViewOfTreeRecursive tp = new BottomViewOfTreeRecursive();
		tp.topViewOfTree(TreeGenerator.getTree());
	}
}

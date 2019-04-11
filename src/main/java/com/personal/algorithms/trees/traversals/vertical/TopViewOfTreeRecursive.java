package com.personal.algorithms.trees.traversals.vertical;

import java.util.TreeMap;

import com.personal.algorithms.trees.TreeGenerator;
import com.personal.algorithms.trees.TreeNode;

public class TopViewOfTreeRecursive {

	// Keys are sorted in natural order
	public TreeMap<Integer, Integer> map;

	TopViewOfTreeRecursive() {
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

		map.putIfAbsent(level, root.val);

		recurse(root.left, level - 1);
		recurse(root.right, level + 1);

	}

	public static void main(String[] args) {

		TopViewOfTreeRecursive tp = new TopViewOfTreeRecursive();
		tp.topViewOfTree(TreeGenerator.getTree());
	}
}

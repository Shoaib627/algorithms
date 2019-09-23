package com.practise.trees.traversals.vertical;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.fundamentals.binarytrees.TreeGenerator;
import com.practise.leetcode.TreeNode;

public class DiagonalTraversalOfTreeRecursive {

	
	// Keys are sorted in natural order
	public TreeMap<Integer, List<Integer>> map;

	DiagonalTraversalOfTreeRecursive() {
		this.map = new TreeMap<>();
	}

	public void diagonalTraversalOfTree(TreeNode root) {

		recurse(root, 0);
		
		System.out.println(map.values());

	}

	public void recurse(TreeNode root, int level) {

		if (root == null) {
			return;
		}
		
		List<Integer> list = map.getOrDefault(level, new ArrayList<>());
		
		list.add(root.val);

		map.put(level, list);

		recurse(root.left, level + 1);
		recurse(root.right, level);

	}

	public static void main(String[] args) {

		DiagonalTraversalOfTreeRecursive tp = new DiagonalTraversalOfTreeRecursive();
		tp.diagonalTraversalOfTree(TreeGenerator.getTree());
	}
}
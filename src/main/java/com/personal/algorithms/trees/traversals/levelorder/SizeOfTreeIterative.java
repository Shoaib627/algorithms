package com.personal.algorithms.trees.traversals.levelorder;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.leetcode.TreeNode;
import com.personal.algorithms.trees.TreeGenerator;

public class SizeOfTreeIterative {


	public int size(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int size = 0;
		
		while(!q.isEmpty()) {
			
			TreeNode node = q.poll();
			
			if(node == null) {
				
				if(q.isEmpty()) {
					return size;
				}
				
				else {
					q.add(null);
				}	
			}
			else {
				size ++;
				if(node.left !=null) {
					q.add(node.left);
				}
				
				if(node.right !=null) {
					q.add(node.right);
				}
			}
		}

		return size;
	}

	public static void main(String[] args) {
		
		SizeOfTreeIterative s = new SizeOfTreeIterative();
		System.out.println(s.size(TreeGenerator.getTree()));

	}


}

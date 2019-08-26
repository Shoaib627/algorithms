package com.personal.algorithms.graphs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.personal.algorithms.graphs.Vertex;

public class IterativeDFS {

	public static void main(String[] args) {

		IterativeDFS depthFirstSearch = new IterativeDFS();

		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex3);
		vertex3.addNeighbour(vertex4);
		vertex4.addNeighbour(vertex5);

		List<Vertex> list = new ArrayList<Vertex>();

		list.add(vertex1);
		list.add(vertex2);
		list.add(vertex3);
		list.add(vertex4);
		list.add(vertex5);

		depthFirstSearch.dfs(list);
	}

	public void dfs(List<Vertex> vertexList) {

		for (Vertex v : vertexList) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfs(v);
			}
		}
	}

	public void dfs(Vertex root) {

		if (root == null) {
			return;
		}

		Stack<Vertex> stack = new Stack<>();

		root.setVisited(true);
		stack.add(root);

		while (!stack.isEmpty()) {

			Vertex current = stack.pop();
			System.out.println("Node visited.... " + current.getData());

			for (Vertex neighbour : current.getNeighbourList()) {
				if (!neighbour.isVisited()) {
					neighbour.setVisited(true);
					stack.add(neighbour);
				}
			}

		}
	}
}

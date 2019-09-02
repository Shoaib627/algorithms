package com.personal.algorithms.graphs.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.personal.algorithms.graphs.Vertex;

public class TopologicalSort {

	public static void main(String[] args) {

		TopologicalSort topologicalSort = new TopologicalSort();

		Vertex vertex0 = new Vertex(0);
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		vertex2.addNeighbour(vertex3);
		vertex3.addNeighbour(vertex1);
		vertex2.addNeighbour(vertex0);
		vertex2.addNeighbour(vertex1);
		vertex5.addNeighbour(vertex0);
		vertex5.addNeighbour(vertex2);

		// if there graph has more than one component, this list kind of implementation
		// is needed
		List<Vertex> graph = new ArrayList<Vertex>();

		graph.add(vertex0);
		graph.add(vertex1);
		graph.add(vertex3);
		graph.add(vertex2);
		graph.add(vertex4);
		graph.add(vertex5);

		topologicalSort.dfs(graph);

		while (!topologicalSort.stack.isEmpty()) {
			System.out.println(topologicalSort.stack.pop().getData());
		}
	}

	private Stack<Vertex> stack;

	public TopologicalSort() {
		super();
		this.stack = new Stack<>();
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

		root.setVisited(true);

		for (Vertex neighbour : root.getNeighbourList()) {
			if (!neighbour.isVisited())
				dfs(neighbour);
		}

		stack.push(root);
	}

	public Stack<Vertex> getStack() {
		return stack;
	}

}

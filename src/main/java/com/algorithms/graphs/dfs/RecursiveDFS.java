package com.algorithms.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.graphs.Vertex;

public class RecursiveDFS {

	public static void main(String[] args) {

		RecursiveDFS depthFirstSearch = new RecursiveDFS();

		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex4);
		vertex4.addNeighbour(vertex5);
		vertex2.addNeighbour(vertex3);

		// if there graph has more than one component, this list kind of implementation is needed
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

		root.setVisited(true);
		System.out.println("Node visited.... " + root.getData());

		for (Vertex neighbour : root.getNeighbourList()) {
			if (!neighbour.isVisited())
				dfs(neighbour);
		}
	}
}
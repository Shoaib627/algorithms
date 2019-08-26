package com.personal.algorithms.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.personal.algorithms.graphs.Vertex;

public class BFS {

	public static void main(String[] args) {

		BFS breadthFirstSearch = new BFS();

		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);

		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex4);
		vertex4.addNeighbour(vertex5);
		vertex2.addNeighbour(vertex3);

		breadthFirstSearch.bfs(vertex1);

	}

	public void bfs(Vertex root) {

		if (root == null) {
			return;
		}

		Queue<Vertex> queue = new LinkedList<Vertex>();
		root.setVisited(true);
		queue.add(root);

		while (!queue.isEmpty()) {

			Vertex current = queue.poll();

			System.out.println("Node visited.... " + current.getData());

			for (Vertex neighbour : current.getNeighbourList()) {

				if (!neighbour.isVisited()) {
					current.setVisited(true);
					queue.add(neighbour);
				}
			}
		}

	}
}
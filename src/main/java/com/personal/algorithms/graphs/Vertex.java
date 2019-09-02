package com.personal.algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int data;

	private boolean visited;

	private boolean beingVisited;

	private List<Vertex> neighbourList;

	public Vertex(int data) {
		super();
		this.data = data;
		this.neighbourList = new ArrayList<Vertex>();

	}

	public Vertex(int data, List<Vertex> neighbourList) {
		super();
		this.data = data;
		this.neighbourList = neighbourList;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighbourList() {
		return neighbourList != null ? neighbourList : new ArrayList<Vertex>();
	}

	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
	}

	public void addNeighbour(Vertex neighbour) {
		this.neighbourList.add(neighbour);
	}

	public boolean isBeingVisited() {
		return beingVisited;
	}

	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}

}
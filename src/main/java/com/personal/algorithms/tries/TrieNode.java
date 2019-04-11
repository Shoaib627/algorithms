package com.personal.algorithms.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	public Map<Character, TrieNode> children;

	boolean endOfWord;

	public TrieNode() {

		this.children = new HashMap<>();
		endOfWord = false;
	}

}
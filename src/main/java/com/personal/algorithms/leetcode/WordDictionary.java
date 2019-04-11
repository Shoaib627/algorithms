package com.personal.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

	public class TrieNode {

		public Map<Character, TrieNode> children;

		boolean endOfWord;

		public TrieNode() {

			this.children = new HashMap<>();
			endOfWord = false;
		}

	}

	TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();

	}

	public void addWord(String word) {

		insert(root, word);

	}

	private void insert(TrieNode current, String word) {

		for (int i = 0; i < word.length(); i++) {

			Character ch = word.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}

			current = node;

		}
		current.endOfWord = true;
	}

	public boolean search(String word) {
		return searchRecursive(root, word, 0);

	}

	private boolean searchRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			return current.endOfWord;
		}
		char ch = word.charAt(index);
		if (ch == '.') {
			Map<Character, TrieNode> map = current.children;
			for (Character key : map.keySet()) {
				TrieNode currNode = map.get(key);
				if (searchRecursive(currNode, word, index + 1)) {
					return true;
				}
			}
			return false;
		} else {
			TrieNode node = current.children.get(ch);

			if (node == null) {
				return false;
			}
			return searchRecursive(node, word, index + 1);
		}
	}

}

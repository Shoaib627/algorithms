package com.fundamentals.tries;

public class Trie {

	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {

		TrieNode current = root;

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

	/** Returns if the word is in the trie. */
	public boolean search(String word) {

		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {

			Character ch = word.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				return false;
			}

			current = node;

		}
		return current.endOfWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

		TrieNode current = root;

		for (int i = 0; i < prefix.length(); i++) {

			Character ch = prefix.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				return false;
			}

			current = node;

		}
		return true;
	}

}

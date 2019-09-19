package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MagicDictionary {

	public class TrieNode {

		public Map<Character, TrieNode> children;

		boolean endOfWord;

		public TrieNode() {

			this.children = new HashMap<>();
			endOfWord = false;
		}

	}

	TrieNode root;

	public MagicDictionary() {
		this.root = new TrieNode();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {

		for (int i = 0; i < dict.length; i++) {
			insert(dict[i]);
		}

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

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		TrieNode current = root;
		boolean isOnceChange = false;

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			TrieNode node = current.children.get(ch);

			
			 if (node == null && !isOnceChange) {
				isOnceChange = true;
				return search(current.children.get(word.charAt(i+1)), word.substring(i + 1));
			} 
			current = node;
		}
		if(!isOnceChange) {
			return false;
		}
		return current.endOfWord;
	}
	
	private boolean search(TrieNode current, String word) {
		
		if(current == null) {
			return false;
		}
		

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
}

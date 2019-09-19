package com.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

	public class TrieNode {

		public Map<Character, TrieNode> children;

		boolean endOfWord;
		
		int score;

		public TrieNode() {

			this.children = new HashMap<>();
			endOfWord = false;
		}

	}
	
	TrieNode root;
	Map<String, Integer> map;

    public MapSum() {
		this.root = new TrieNode();
		this.map = new HashMap<>();

    }
    
    public void insert(String key, int val) {
    	
    	map.put(key, val);
        
    	insert(key);
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
    
    
    public int sum(String prefix) {
        
		TrieNode current = root;

		for (int i = 0; i < prefix.length(); i++) {

			Character ch = prefix.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				return 0;
			}

			current = node;

		}
		
		return current.score;

    }
}

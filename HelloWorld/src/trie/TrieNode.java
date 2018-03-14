package trie;

import java.util.HashMap;

public class TrieNode {
	char data;
	boolean isTerminating;
	HashMap<Character, TrieNode> children;
    
	public TrieNode(char data) {
		// TODO Auto-generated constructor stub
	this.data = data;
	children = new HashMap<>();
	}
}

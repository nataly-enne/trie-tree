import java.util.*;

public class Trie{

	private TrieNode current;

	public Trie() {
		current = new TrieNode();
	}

	public void insert(String word) {
		
		HashMap <Character, TrieNode> children = current.getChildren();
		
		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			
			TrieNode node;
			
			if(children.containsKey(character)) {
				node = children.get(character);
			} 
			else{ 
				node = new TrieNode(character);
				children.put(character, node);
			}
			children = node.getChildren();

			if(i == word.length() - 1) {
				node.setWord(true);
			}
		}
	}

	public boolean find(String word) {
		
		HashMap<Character, TrieNode> children = current.getChildren();

		TrieNode node = null;
		
		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			
			if(children.containsKey(character)) {
				node = children.get(character);
				children = node.getChildren();
			} 
			else{ 
				node = null;
				break;
			}
		}

		if(node != null && node.isWord()) {
			return true;
		} 
		else{
			return false;
		}
	}

}

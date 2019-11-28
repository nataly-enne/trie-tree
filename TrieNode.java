import java.util.*;

public class TrieNode{
	// caracter que contém o caracter corrente do nó
	private char character;
	// um hashmap que contém todos os filhos
	private HashMAp<Character, TrieNode> children = new HashMap();
	// variável booleana pra saber se o nó ou caracter representa o fim de uma palavra
	private boolean isWord;

	public TrieNode() {}

	public TrieNode(char character){
		this.character = character;
	}

	public HashMap<Character, TrieNode> getChildren(){
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children){
		this.children = children;
	}

	public boolean isWord(){
		return isWord;
	}

	public void setWord(boolean isWord){
		this.isWord = isWord;
	}
}
import java.util.*;

public class TrieNode{
	// caracter que contém o caracter atual do nó
	private char character;
	// um hashmap que contém todos os filhos
	private HashMap<Character, TrieNode> children = new HashMap();
	// variável booleana pra saber se o nó ou caracter representa o fim de uma palavra
	private boolean isWord;
	// variável pea setar a palavra
	private String text;


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

	public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
public class TrieNode{
	// caracter que contém o caracter corrente do nó
	private char c;
	// um hashmap que contém todos os filhos
	private HashMAp<Character, TrieNode> children = new HashMap();
	// variável booleana pra saber se o nó ou caracter representa o fim de uma palavra
	private boolean isLeaf;

	public TrieNode() {}

	public TrieNode(char c){
		this.c = c;
	}

	public HashMap<Character, TrieNode> getChildren(){
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children){
		this.children = children;
	}

	public boolean isLeaf(){
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf){
		this.isLeaf = isLeaf;
	}
}
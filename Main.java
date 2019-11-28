public class Main {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.insert("aaa");
		trie.insert("boi");
		trie.insert("esud");
		trie.insert("teste");
		trie.insert("nataly");
		
		boolean search = trie.find("teste");
		
		System.out.println(search);
	}

}
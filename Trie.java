import java.util.*;

public class Trie{

	private TrieNode root;
	private List<String> wordList = new ArrayList<>();


	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		
		HashMap <Character, TrieNode> children = root.getChildren();
		
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
				node.setText(word);

			}
		}
	}
	public void insert(String[] wordList) {
        for (String word : wordList) {
            this.insert(word);
        }
    }
	public boolean search(String word) {
		
		HashMap<Character, TrieNode> children = root.getChildren();

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

	// checagem da existencia para poder deletar.
 	public boolean find(String word) {
        
        TrieNode node = this.root;
        boolean itFound = true;

        for (char character: word.toCharArray()) {
            if (!node.getChildren().containsKey(character)) {
                itFound = false;
                break;
            }
            node = node.getChildren().get(character);
        }
        return node != null && node.isWord() && itFound;
    }

    public void remove(String word) {
        
        TrieNode node = this.root;
        
        if (this.find(word)) {
            for (char character: word.toCharArray()) {
                node = node.getChildren().get(character);
            }
            node.setWord(false);
        }
    }

    public List<String> autocomplete(String word) {
        TrieNode suggestNode = findNode(word);
        List<String> out;

        out = getWords(suggestNode);
        System.out.println(out);

        return out;
    }

    public List<String> autocomplete(String word, int maxSuggestions) {
        TrieNode suggestNode = findNode(word);
        List<String> out;

        out = getWords(suggestNode);

        for (int i = maxSuggestions; i < out.size(); i++) {
            out.remove(i);
        }
        return out;
    }

    public TrieNode findNode(String string) {
        TrieNode currentNode = root;

        for (int i = 0; i < string.length(); i++) {
            Character currentCharacter = string.charAt(i);
            TrieNode currentCharacterNode = currentNode.getChildren().get(currentCharacter);

            if (currentCharacterNode == null) {
                return null;
            }
            currentNode = currentCharacterNode;
        }
        return currentNode;
    }

    public List<String> getWords(TrieNode node) {
        List<String> results = new ArrayList<>();

        if (node.isWord()) {
            results.add(node.getText());
        }

        if (!node.getChildren().isEmpty()) {
            for (TrieNode child: node.getChildren().values()) {
                results.addAll(getWords(child));
            }
        }
    	return results;
    }
}


   
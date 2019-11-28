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
				node.setText(word);

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


	public boolean remove(String word) {
    
        if (find(word)) {
    
            TrieNode removeBeneath = root;
            TrieNode current = root; // nó atual
            TrieNode wordNode = findNode(word);
            
            int deleteCharacter = 0; // variável para indicar caracter inicial. 

            wordNode.setWord(false);
            wordNode.setText("");

            if (wordNode.getChildren().isEmpty()) { // verifica se está vazio
                for (int i = 0; i < word.length(); i++) {
                    char currenCharacter = word.charAt(i);

                    if (currentNode.isWord()) {
                        removeBeneath = currentNode;
                        deleteCharacter = (i);
                    }

                    currentNode = currentNode.getChildren().get(currenCharacter);
                }

                removeNodes(removeBeneath, word, deleteCharacter);

                return true;
            }
            return true;
        }
        return false;
    }

    // Deleta os nós, passando por parâmetro -> 1. nó inicial; 2. palavra; 3. caracter inicial
    public void removeNodes(TrieNode node, String word, int character) {
        
        Stack <TrieNode> nodeStack = new Stack<>(); // criando o nó pilha
        
        TrieNode currentNode = node; // iguala ao nó inicial
        
        int nodeToDeletePosition = (word.length() - 1);

        for (int i = character; i < (word.length() - 1); i++) { // i = ao caracter inicial
            char currenCharacter = word.charAt(i);
            nodeStack.push(currentNode);
            currentNode = currentNode.getChildren().get(currenCharacter);
        }

        while (!nodeStack.empty()) {
            currentNode = nodeStack.pop();
            currentNode.getChildren().remove(word.charAt(nodeToDeletePosition));
            nodeToDeletePosition--;
        }
    }

    public List<String> suggestions(String prefix) {
        TrieNode prefixNode = findNode(prefix);
        List<String> results;

        results = getWords(prefixNode);

        return results;
    }

    public List<String> suggestions(String prefix, int maxSuggestions) {
        TrieNode prefixNode = findNode(prefix);
        List<String> results;

        results = getWords(prefixNode);

        for (int i = maxSuggestions; i < results.size(); i++) {
            results.remove(i);
        }

        return results;
    }

    public TrieNode findNode(String string) {
        TrieNode currentNode = root;

        for (int i = 0; i < string.length(); i++) {
            Character currenCharacter = string.charAt(i);
            TrieNode currenCharacterNode = currentNode.getChildren().get(currenCharacter);

            if (currenCharacterNode == null) {
                return null;
            }

            currentNode = currenCharacterNode;
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

        sortWords(results);

        return results;
    }

    public void sortWords(List<String> words) {
        for (int i = 0; i < (words.size() - 1); i++) {
            if (words.get(i).length() > words.get(i + 1).length()) {
                Collections.swap(words, i, (i + 1));
            }
        }
    }
}

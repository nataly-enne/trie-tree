import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Trie trie = new Trie();

        try {
            Scanner scanner = new Scanner(new File(args[0]));

            while (scanner.hasNextLine()) {
                trie.insert(scanner.nextLine());
            }
            scanner.close();
        
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        if (args.length == 3) {
            trie.autocomplete(args[1], Integer.parseInt(args[2]));
        } 
        else{
            trie.autocomplete(args[1]);
        }
    }

}
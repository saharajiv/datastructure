package dynamic.linkedList.tree;

import java.util.List;


/**
 * 
 * @author rajib
 * uses of Tries:
 * 	1. prefix-search,auto-suggestion,auto-completion
 *  2. spell-check
 *  3. dictionary
 *  4. phone-book
 *  5. pattern-matching
 */
public class TrieTest {
	
	public static void main(String []args){
		Trie trie = new Trie();
		trie.insert("ra");
		trie.insert("rajib");
		trie.insert("rajiv");
		
		trie.insert("rakesh");
		trie.insert("rajeev");
		trie.insert("rajesh");
		
		trie.insert("sanjay");
		trie.insert("sanjib");
		trie.insert("suraj");
		System.out.println("List of all words entered");
		for(String word:trie.list()){
			System.out.println(word);
		}
		System.out.println("No. of items "+trie.count());
		List<String> words = trie.prefixSearch("ra");
		System.out.println("List of words starting with ra");
		for(String word:words){
			System.out.println(word);
		}
		
		List<String> wordsABC = trie.prefixSearch("rajib");
		System.out.println("List of words starting with rajib");
		for(String word:wordsABC){
			System.out.println(word);
		}
		if(trie.deleteWord("rajiv")){
			System.out.println("List of words after deleting rajiv");
			System.out.println(trie);
		}
		if(trie.deleteWord("ra")){
			System.out.println("List of words after deleting ra");
			System.out.println(trie);
		}
		if(trie.deleteWord("sanjay")){
			System.out.println("List of words after deleting sanjay");
			System.out.println(trie);
		}
		
	}
	
}

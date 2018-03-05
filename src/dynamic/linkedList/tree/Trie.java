package dynamic.linkedList.tree;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	TrieNode root = new TrieNode();
	
	public void insert(String word){
		TrieNode node = root;
		if(word.isEmpty()){
			return ;
		}else if(root!=null ){
			int index=0;
			boolean eow = false;
			while(index!=word.length()){
				Character letter = word.charAt(index);
				if(index==word.length()-1)
					eow = true;
				node = insertData(node,letter,eow);
				index++;
			}
		}
		
	}
	
	
	public List<String> prefixSearch(String searchKeyword){
		List<String> completeWords = new ArrayList<>();
		TrieNode node = root;
		boolean found = false;
		if(searchKeyword.isEmpty()){
			return null ;
		}else if(root!=null){//&& isEmptyNode(root)
			int index=0;
			while(index!=searchKeyword.length()){
				Character letter = searchKeyword.charAt(index);
				if(node.containsLetter(letter)){
					found = true;
					node = node.getChildNode(letter);
				}else{
					found = false;
					break;
				}
				index++;
			}
			if(found){
	 			List<String> words = formWords(node);
				for(String word: words){
					String completeWord = searchKeyword+word;
					completeWords.add(completeWord);
				}
			}
		}
		return completeWords;
	}
	
	
	public boolean search(String searchKeyword){
		TrieNode node = root;
		boolean found = false;
		if(!searchKeyword.isEmpty() && root!=null){
			int index=0;
			while(index<searchKeyword.length()){
				Character letter = searchKeyword.charAt(index);
				if(node.containsLetter(letter)){
					found = true;
					node = node.getChildNode(letter);
				}else{
					found = false;
					break;
				}
				index++;
			}
			if(found && node.endOfWord){
	 				return true;
			}
		}
		return false;
	}
	
	
	public List<String> list(){
		List<String> words =null;
		TrieNode node = root;
		if(root!=null){
			words = formWords(node);
		}
		return words;
		
	}
	
	public String toString(){
		String words ="";
		TrieNode node = root;
		if(root!=null){
			for(String word: formWords(node)){
				words = words+"\n"+word;
			}
		}
		return words;
	}
	
	
	private List<String> formWords(TrieNode node) {
		ArrayList<String> words = new ArrayList<String>();
		Character[] letters = node.getCharacters();
		String word = "";
		TrieNode childNode;
		for(char letter:letters){
			word = letter+"";
			childNode = node.getChildNode(letter);
			for(String childWord: formWords(childNode)){
				String totalword = word+childWord;
				words.add(totalword);
			}	
		}
		if(node.endOfWord){
			if(word.length()>0)
					word="";
			words.add(word);
		}
		return words;
	}
	
	public int count(){
		return countItems(root);
	}

	private int countItems(TrieNode node) {
		int count = 0;
		for(char letter:node.getCharacters()){
			TrieNode childNode = node.getChildNode(letter);
			count = count+countItems(childNode);
		}	
		if(node.endOfWord){
			count++;
		}
		return count;
		
	}
	

	private TrieNode insertData(TrieNode node, Character letter,boolean endOfWord) {
		TrieNode tNode ;
			if(!node.containsLetter(letter)){
				tNode = new TrieNode();
				node.insertCharacter(letter, tNode);
				tNode.endOfWord = endOfWord;
			}else{
				tNode = node.getChildNode(letter);
			}
			return tNode;
	}
	
	public boolean deleteWord(String deletedWord){
		int index = -1;
		boolean present = search(deletedWord);
		if(present){
			removeElement(root,deletedWord,index);
			return true;
		}
		return false;
	}
	
	
	private void removeElement(TrieNode node, String word,int index) {
		int numberOfElements = node.getCharacters().length;
		char letter = '\u0000';
		index++;
		if(index<= word.length()-1){
			letter = word.charAt(index);
			TrieNode childNode = node.getChildNode(letter);
			removeElement(childNode, word, index);
		}else{
			if(index==word.length()){
				if(numberOfElements==0){
					//node.deleteNode();
					node = null;
				}else{
					//The word to be deleted is not the last word in the chain
					node.endOfWord=false;
				}
			}	
		}
		//removing the middle elements
		if(node!=null){
			if(node.getChildNode(letter)!=null && node.getChildNode(letter).getCharacters().length==0){
				node.removeElement(letter);
			}
		}
	}

	class TrieNode{
		Node[] children;
		boolean endOfWord;
		//TrieNode nextNode;
		
		public TrieNode(){
			children = new Node[26];
			endOfWord = false;
			
		}
		
		
		public void deleteNode() {
			children = null;
		}

		public void insertCharacter(char letter,TrieNode tNode){
			Node node = new Node();
			node.tNode = tNode;
			node.letter = letter;
			int counter = 0;
			for(counter=0;children[counter]!=null;counter++);
			children[counter] = node;
		}
		
		
		public boolean containsLetter(char letter){
			boolean found = false;
			for(int counter=0;children[counter]!=null;counter++){
				if(children[counter].letter == letter){
					found = true;
					//nextNode = children[counter].tNode ;
				}
			}
			return found;
		}
		
		public TrieNode getChildNode(char letter){
			TrieNode tNode = null;
			for(int counter=0;children[counter]!=null;counter++){
				if(children[counter].letter == letter){
					tNode = children[counter].tNode;
					break;
				}
			}
			return tNode;
		}
		
		public Character[] getCharacters(){
			ArrayList<Character> letters = new ArrayList<>();
			int counter=0;
			for(counter=0;children[counter]!=null;counter++){
					letters.add(children[counter].letter);
			}
			Character [] lettersArray = new Character[letters.size()];
			return letters.toArray(lettersArray);
		}
		
		public void removeElement(char letter) {
			int index = 0;
			boolean found= false;
			for(index=0;children[index]!=null;index++){
				if(children[index].letter == letter){
					//tNode = children[counter].tNode;
					found = true;
				}
				if(found){
					children[index] = children[index+1];
				}
			}
		}

		
		class Node{
			TrieNode tNode;
			Character letter;
			
		}
		
		
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    String s; // record full word at the last char
    boolean isString; // check if reaches end of string
    HashMap<Character, TrieNode> subTree;
    public TrieNode() {
        s = "";
        isString = false;
        subTree = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null){
            return;
        }
        TrieNode now = root;
        // when scanning the word, move down the trie as reading each character
        for (int i = 0; i < word.length(); i++){
            if (!now.subTree.containsKey(word.charAt(i))){
               now.subTree.put(word.charAt(i), new TrieNode());
            }
            now = now.subTree.get(word.charAt(i));
        }
        // at the ending node of a word, s got the value of the string word
        now.s = word; 
        now.isString = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null){
            return true;
        }
        TrieNode now = root;
        // evry character in the word should appear consecutively in a branch 
        // of the trie, therefore if not found any of the chars, return null
        for (int i = 0; i< word.length(); i++){
             if (!now.subTree.containsKey(word.charAt(i))){
                return false; 
             }
             now = now.subTree.get(word.charAt(i));
        }
        if (now.isString){
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null){
            return true;
        }
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++){
            if (!now.subTree.containsKey(prefix.charAt(i))){
                return false;
            }
            now = now.subTree.get(prefix.charAt(i));
        }
        return true;
        
    }
}

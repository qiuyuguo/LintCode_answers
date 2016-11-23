public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
         
    class TrieNode {
		String s; //the string representing the characters from root to this node
		boolean isString; 
		HashMap<Character, TrieNode> subtree;
		public TrieNode() {
			// TODO Auto-generated constructor stub
			isString = false;
			subtree = new HashMap<Character, TrieNode>();
			s = "";
		}
	};
 
 
	class TrieTree{
		TrieNode root ;
		public TrieTree(TrieNode TrieNode) {
			root = TrieNode;
		}
 
		public void insert(String s) {
			TrieNode now = root;
			for (int i = 0; i < s.length(); i++) {
				if (!now.subtree.containsKey(s.charAt(i))) {
					now.subtree.put(s.charAt(i), new TrieNode());
				}
				now  =  now.subtree.get(s.charAt(i));
			}
			now.s = s;
			now.isString  = true;
		}
 
		public boolean find(String s){
			TrieNode now = root;
			for (int i = 0; i < s.length(); i++) {
				if (!now.subtree.containsKey(s.charAt(i))) {
					return false;
				}
				now  =  now.subtree.get(s.charAt(i));
			}
			return now.isString;
		}
	};
 
	public int []dx = {1, 0, -1, 0};
	public int []dy = {0, 1, 0, -1};
	
	
	
	public void search(char[][] board, int x, int y, TrieNode root, ArrayList<String> ans) {
		// once the end of trie branch is reached, add the result to ans
		if(root.isString == true)
		{
			if(!ans.contains(root.s)){
				ans.add(root.s);
			}
		}
		if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
			return;
		// on the trie tree, map from any position on the board to the trie tree 
		if(root.subtree.containsKey(board[x][y])){
			char now = board[x][y];
			board[x][y] = 0; //set 0 as visited
			for(int i = 0; i < 4; i++){
				search(board, x + dx[i], y + dy[i], root.subtree.get(now), ans);
			}
			board[x][y] = now; //reset original char
		}
	}
	
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		ArrayList<String> ans = new ArrayList<String>();
		//initialze the trie tree (root.isString == false)
		TrieTree tree = new TrieTree(new TrieNode());
		//set up the trie tree
		for(String word : words){
			tree.insert(word);
		}
		for(int i = 0; i< board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				search(board, i, j, tree.root, ans);
			}
		}
		return ans;
        
    }
	
}

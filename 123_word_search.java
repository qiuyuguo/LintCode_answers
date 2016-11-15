public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0){
            return false;
        }
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (search(word, 0, board, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(String word, int index, char[][] board, int i, int j, boolean[][] visited){
        if (i<0 || i==board.length || j<0 || j == board[0].length || visited[i][j] == true){
            return false;
        }
        visited[i][j] = true;
        boolean result = false;
        if (board[i][j] == word.charAt(index)){
            if (index == word.length()-1){
                return true;
            }
            // visit every nearby spot. if any of them matches, then keep going
            result = search(word, index+1, board, i-1, j, visited) || search(word, index+1, board, i+1, j, visited) || search(word, index+1, board, i, j-1, visited) || search(word, index+1, board, i, j+1, visited);
        }
        visited[i][j] = false;
        return result;
    }
}

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S.length() == 0){
            return 0;
        }
        if(T.length() == 0){
            return 1;
        }
        
        // f[i][j] indicates the number of unique subsequences in T[0:j] found
        // in S[0:i]
        int[][] f = new int[S.length()+1][T.length()+1];
        for (int i = 0; i < S.length(); i++){
            // when j = 0, T[0:j] == "", therefore you can find 1 unique match
            f[i][0] = 1;
            for (int j = 0; j< T.length(); j++){
                f[i+1][j+1] = f[i][j+1];
                // when S[i] matches T[j], there are 2 options: 
                // 1. T[0:j] matches S[0:i]
                // 2. T[0:j] matches S[0:i-1]  
                if (S.charAt(i) == T.charAt(j)){
                    f[i+1][j+1] += f[i][j];
                }
            }
        }
        return f[S.length()][T.length()];
    }
}

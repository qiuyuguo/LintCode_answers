public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int n = word1.length();
        int m = word2.length();
        int [][] stepCount = new int[n+1][m+1];
        
        // initiate the step count matrix, value indicates number of steps to 
        // match up to letter i of word1 and letter j of word2
        for (int i=0; i<n+1; i++){
            stepCount[i][0] = i;
        }
        for (int j=0; j<m+1; j++){
            stepCount[0][j] = j;
        }
        
        for (int i=1; i<n+1; i++){
            for (int j=1; j<m+1; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    stepCount[i][j] = stepCount[i-1][j-1];
                }
                // in case of current letters not match choose from:
                // [i-1][j-1]: replace
                // [i-1][j]: insert word2[j] to word1
                // [i][j-1]: delete word1[i]
                else{
                    stepCount[i][j] = 1 + Math.min(stepCount[i-1][j-1], Math.min(stepCount[i-1][j], stepCount[i][j-1]));
                }
            }
        }
        
        return stepCount[n][m];
    }
}

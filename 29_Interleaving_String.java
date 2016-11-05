public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length()+s2.length() != s3.length()){
            return false;
        }
        // dp[i][j] stands for whether s3[0:i+j] interleaves s1[0:i] and s2[0:j]
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i<=s1.length(); i++){
            if (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }
        }
        for (int j = 1; j<=s2.length(); j++){
            if (s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1]){
                dp[0][j] = true;
            }
        }
        for (int i=1; i<=s1.length(); i++){
            for (int j=1; j<=s2.length(); j++){
                if (((s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])) || 
                ((s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]))){
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}

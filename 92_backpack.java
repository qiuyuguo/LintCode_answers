public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m==0 || A.length==0){
            return 0;
        }
        
        // dp[i][j] represent whether j can be attained by any combination of 
        // A[0:i-1]
        boolean[][] dp = new boolean[A.length+1][m+1];
        for (int i=0; i<=A.length; i++){
            for (int j=0; j<=m; j++){
                dp[i][j] = false;
            }
        }
        for (int i=0; i<=A.length; i++){
            dp[i][0] = true;
        }
        
        for (int i=1; i<=A.length; i++){
            for (int j=1; j<=m; j++){
                // consider 2 situations:
                // 1. j < A[i-1], then have to skip A[i-1]
                // 2. otherwise, can skip A[i-1] or not
                if (j-A[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]];
                }
            }
        }
        
        int max = 0;
        for (int j=m; j>=0; j--){
            if (dp[A.length][j]==true){
                max = j;
                break;
            }
        }
        return max;
    }
}

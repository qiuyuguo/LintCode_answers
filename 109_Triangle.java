public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle==null || triangle.length==0){
            return -1;
        }
        int n = triangle.length;
        int[][] minSum = new int[n][n];
        minSum[0][0] = triangle[0][0];
        for (int i=1; i<n; i++){
            minSum[i][0] = minSum[i-1][0]+triangle[i][0];
            minSum[i][i] = minSum[i-1][i-1]+triangle[i][i];
        }
        for (int i=1; i<n; i++){
            for (int j=1; j<i; j++){
                minSum[i][j]=Math.min(minSum[i-1][j-1]+triangle[i][j],minSum[i-1][j]+triangle[i][j]);
            }
        }
        int best = minSum[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, minSum[n - 1][i]);
        }
        return best;
    }
}

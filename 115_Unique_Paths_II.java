public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pathCount = new int[m][n];
        for (int i=0; i<m; i++){
            if (obstacleGrid[i][0] != 1){
                pathCount[i][0] = 1;
            }
            // it is important to realize that once you have a block on the first row, 
            // all the following spots will be blocked
            else{
                break;
            }
        }
        for (int j=0; j<n; j++){
            if (obstacleGrid[0][j] != 1){
                pathCount[0][j] = 1;
            }
            else{
                break;
            }
        }
        for (int i=1; i<m; i++){
            for (int j=1;j<n; j++){
                if (obstacleGrid[i][j]==1){
                    pathCount[i][j]=0;
                }
                else{
                    pathCount[i][j]=pathCount[i-1][j]+pathCount[i][j-1];
                }
            }
        }
        return pathCount[m-1][n-1];
    }
}

class Solution:
    """
    @param obstacleGrid: An list of lists of integers
    @return: An integer
    """
    def uniquePathsWithObstacles(self, obstacleGrid):
        # write your code here
        n=len(obstacleGrid)
        m=len(obstacleGrid[0])
        
        pathCount=[]
        for i in range(n):
            pathCount.append([])
            for j in range(m):
                pathCount[i].append(0)
        
        for i in range(n):
            if pathCount[i][0] != 1:
                pathCount[i][0] = 1
            else:
                break
        for j in range(m):
            if pathCount[0][j] != 1:
                pathCount[0][j] =1
            else:
                break
        
        for i in range(1,n):
            for j in range(1,m):
                if obstacleGrid[i][j] == 1:
                    pathCount[i][j] = 0
                else:
                    pathCount[i][j]=pathCount[i-1][j]+pathCount[i][j-1]
        
        return pathCount[n-1][m-1]

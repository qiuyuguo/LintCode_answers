class Solution: 
    # @param word1 & word2: Two string.
    # @return: The minimum number of steps.
    def minDistance(self, word1, word2):
        # write your code here
        # dp[i][j] denotes the min step to convert word1[0:i] to word2[0:j]
        dp = [[0 for j in range(len(word2)+1)] for i in range(len(word1)+1)]
        # initialize: to convert word1[0] towards word2[0:j] requires j steps
        # to convert word1[0:i] towards word2[0] requires i steps
        for i in range(len(word1)+1):
            dp[i][0] = i
        for j in range(len(word2)+1):
            dp[0][j] = j
        for i in range(1,len(word1)+1):
            for j in range(1,len(word2)+1):
                # if the last character matches, there is no gain of step count
                # if not, decide from (1) insertion to word1, (2) deletion to word1
                # or (3) replace last char of word1
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        return dp[len(word1)][len(word2)]

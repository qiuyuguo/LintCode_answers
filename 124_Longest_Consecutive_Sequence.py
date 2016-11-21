class Solution:
    """
    @param num, a list of integer
    @return an integer
    """
    def longestConsecutive(self, num):
        # write your code here
        if len(num) == 0:
            return 0;
        numSet = set(num);
        
        longest = 0
        for i in range(len(numSet)):
            left = num[i]-1
            while left in numSet:
                numSet.remove(left)
                left-=1
            right = num[i]+1
            while right in numSet:
                numSet.remove(right)
                right+=1
            longest = max(longest, right-left-1)
        
        return longest

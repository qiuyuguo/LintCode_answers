class Solution:
    # @param nums: an integer[]
    # @return: an integer
    def maxProduct(self, nums):
        # write your code here
        f, g = [], []
        # f[i], g[i] records the maximum product from any subarray within nums[0:i]
        f.append(nums[0])
        g.append(nums[0])
        # considering appearance of negative numbers, the max/min number could be
        # derived from the previous min/max number
        for i in range(1,len(nums)):
            f.append(max(nums[i], f[i-1]*nums[i], g[i-1]*nums[i]))
            g.append(min(nums[i], f[i-1]*nums[i], g[i-1]*nums[i]))
        m = f[0]
        for i in range(1, len(f)): 
            m = max(m,f[i])
        return m

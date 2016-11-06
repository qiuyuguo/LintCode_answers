class Solution:
    """
    @param nums: A list of integers
    @return: An integer denote the sum of maximum subarray
    """
    def maxSubArray(self, nums):
        # write your code here
        maxsum = nums[0]
        minsum = 0
        sum = 0
        for i in range(len(nums)):
            sum += nums[i]
            if sum - minsum > maxsum:
                maxsum = sum - minsum
            if sum < minsum:
                minsum = sum
        return maxsum

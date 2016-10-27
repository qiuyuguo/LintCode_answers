//solution 1: greedy

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums.length == 0 || nums == null){
            return -1;
        }
        int maxSub = Integer.MIN_VALUE, sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            // determine whether to add the next element
            maxSub = Math.max(maxSub, sum);
            // determine whether to keep the previous elements
            // i.e., if the sum of previous is 0, it's not helping
            sum = Math.max(sum, 0);
        }
        return maxSub;
    }
}

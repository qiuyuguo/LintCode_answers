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

//solution 2: dynamic programming

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length==0){
            return -1;
        }
        int maxSub = Integer.MIN_VALUE, minSub = 0, sum = 0;
        // up to each index, keep track of the min sum
        // the max value comes where sum thru i minus min sum so far
        for (int i = 0; i < nums.length; i++){
            minSub = Math.min(sum, minSub);
            sum += nums[i];
            maxSub = Math.max(maxSub, sum-minSub);
        }
        return maxSub;
    }
}

//solution 3: dynamic programming

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // -1 is not proper for illegal input
        if (nums == null || nums.isEmpty()) return -1;

        int size = nums.size();
        int[] local = new int[size];
        int[] global = new int[size];
        local[0] = nums.get(0);
        global[0] = nums.get(0);
        for (int i = 1; i < size; i++) {
            // drop local[i - 1] < 0
            local[i] = Math.max(nums.get(i), local[i - 1] + nums.get(i));
            // update global with local
            global[i] = Math.max(global[i - 1], local[i]);
        }

        return global[size - 1];
    }
}

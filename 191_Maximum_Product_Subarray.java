public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = nums[0];
        max[0] = min[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            // if the previoius product is smaller than the current 
            // item, then give up the previous product and start over
            max[i] = nums[i];
            min[i] = nums[i];
            if (nums[i] > 0){
                max[i] = Math.max(max[i], max[i-1]*max[i]);
                min[i] = Math.min(min[i], min[i-1]*min[i]);
            }
            else if (nums[i] < 0){
                max[i] = Math.max(max[i], min[i-1]*max[i]);
                min[i] = Math.min(min[i], max[i-1]*min[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}

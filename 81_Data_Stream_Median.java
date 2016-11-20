public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        // maxHeap stores the smaller half of the elements
        // minHeap stores the larger half of the elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        // The first item needs to be added manually as when x is called in the
        // loop, maxHeap cannot be empty
        maxHeap.add(-nums[0]);
        res[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            // if the coming element is larger than the largest one in the 
            // maxHeap (i.e., the current median), add it to the minHeap,
            // otherwise, add to the maxHeap
            int x = -maxHeap.peek();
            if (nums[i] <= x){
                maxHeap.add(-nums[i]);
            }
            else{
                minHeap.add(nums[i]);
            }
            // Now balance the two heaps
            if (maxHeap.size() > minHeap.size()+1){
                minHeap.add(-maxHeap.poll());
            }
            else if (maxHeap.size() < minHeap.size()){
                maxHeap.add(-minHeap.poll());
            }
            res[i] = -maxHeap.peek();
        }
        return res;
    }
}

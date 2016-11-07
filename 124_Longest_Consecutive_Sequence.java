public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<num.length; i++){
            set.add(num[i]);
        }
        
        int longest = 0;
        for (int i=0; i<num.length; i++){
            // look for the upper and lower boundaries of a consecutive
            // sequence from the curret item
            int down = num[i]-1;
            while (set.contains(down)){
                set.remove(down);
                down--;
            }
            int up = num[i]+1;
            while (set.contains(up)){
                set.remove(up);
                up++;
            }
            longest = Math.max(longest, up-down-1);
        }
        return longest;
    }
}

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        
        for (int i = 1; i < n; i++){
            
            // make sure the currect number is larger than the previously largest number
            int lastNumber = uglys.get(i-1);
            while (uglys.get(p2) *2 <= lastNumber) p2++;
            while (uglys.get(p3) *3 <= lastNumber) p3++;
            while (uglys.get(p5) *5 <= lastNumber) p5++;
            
            // take the smallest of the current numbers being considered
            uglys.add(Math.min(uglys.get(p2) *2, Math.min(uglys.get(p3) *3, uglys.get(p5) *5)));
        }
        
        return uglys.get(n-1);
    }
};

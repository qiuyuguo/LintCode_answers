class Solution:
    """
    @param {int} n an integer.
    @return {int} the nth prime number as description.
    """
    def nthUglyNumber(self, n):
        # write your code here
        import heapq
        if n <= 1:
            return n
        
        # initialize: make a heap with values of 2,3,5
        n -= 1
        key = [2,3,5]
        h = []
        for i in range(3):
            heapq.heappush(h,(key[i],i))
        
        # look at each current max, add that value *2, *3, *5
        value = key[0]
        while n > 0:
            value, level = heapq.heappop(h)
            while level < 3:
                new_value = key[level] * value
                heapq.heappush(h,(new_value, level))
                level += 1
            n -= 1    
        return value

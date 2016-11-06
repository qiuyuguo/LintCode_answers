class Solution:
    # @param s: A string s
    # @param dict: A dictionary of words dict
    def wordBreak(self, s, dict):
        # write your code here
        if len(dict) == 0:
            return len(s) == 0
            
        n = len(s)
        # f[i] records whether s[0:i] can be broken
        f = [False] * (n+1)
        f[0] = True
        
        maxLength = max([len(w) for w in dict])
        for i in range(1,n+1):
            # Looking for any substring that matches any words in dict 
            # (the substring has to be shorter than the longest word in dict)  
            for j in range(1, min(i,maxLength)+1):
                if not f[i-j]:
                    continue
                if s[i-j:i] in dict:
                    f[i] = True
                    break
        return f[n]

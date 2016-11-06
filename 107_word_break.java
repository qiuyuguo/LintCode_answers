public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0){
            return true;
        }
        if (dict == null || dict.isEmpty()){
            return false;
        }
        
        int maxWordLen = 0;
        for (String str : dict){
            maxWordLen = Math.max(maxWordLen, str.length());
        }
        
        // state: canBreak[i] means whether s can break up to s[i]
        boolean[] canBreak = new boolean[s.length()+1];
        // initialize: empty string can break
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++){
            // look for any break within s[0:i]
            for (int j = i-1; j >= 0; j--){
                // the substring cannot be longer than the longest word in dict
                if (i-j > maxWordLen){
                    break;
                }
                // function: if the substrings s[0:j] can break, and s[j:1]
                // can be found in dict
                String word = s.substring(j,i);
                if (canBreak[j] && dict.contains(word)){
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}

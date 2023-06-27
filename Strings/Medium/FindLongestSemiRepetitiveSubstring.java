// https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/


class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        
        // to store index of last pair of same char
        int lastPairIndex = -1;
        // index of start of current string
        int start = 0;
        // to store max length 
        int max = 1;
        
        for(int end=1; end<s.length(); end++){
            
            // if both char are same then we need to store index of it
            if(s.charAt(end) == s.charAt(end-1)){
                
                // if lastPairIndex is not at -1 then its already found pair so we have start new string so update start 
                if(lastPairIndex != -1)
                    start = lastPairIndex;
                
                // storing index of last pair
                lastPairIndex = end;
            }
            
            // everytime store current string length and take max out of it
            max = Math.max(max, (end - start + 1));
        }
        
        return max;
    }
}
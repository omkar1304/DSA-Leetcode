// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        
        // To store length of the longest balanced substring of s
        int result = 0;
        
        // counters for 1 and 0
        int zeroCount = 0;
        int oneCount = 0;
        
        for(int i=0; i<s.length(); i++){
            
            // if this is true then new subtring is going to start so reset the both counters
            if(i > 0 && s.charAt(i) == '0' && s.charAt(i-1) == '1')
                zeroCount = oneCount = 0;
            
            // if its 0 then inc 0's counter else 1
            if(s.charAt(i) == '0')
                zeroCount++;
            else
                oneCount++;
            
            // at every step store max out result and min of counter * 2
            // why minimum ? 00111 here we only get "0011" as valid string so we need to take minimum and multiply by 2 as we need to consider both 0 and 1
            result = Math.max(result, Math.min(zeroCount, oneCount)*2);
        }
        
        return result;
    }
}
// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int helper(char[] c, int start, int end, int k){
        
        // if string length is less than k then return 0
        if(end-start < k){
            return 0;
        }
        
        // to create frequency value array
        int[] count = new int[26];
        for(int i=start; i<end; i++){
            count[c[i] - 'a'] = count[c[i] - 'a'] + 1;
        }
        
        // to find peak where char count is less than k then we can divide string into two part 
        // start to i and i+1 to end and return max length out of it.
        for(int i=start; i<end; i++){
            if(count[c[i] - 'a'] < k){
                int j = i + 1;
                
                while(j < end && count[c[j] - 'a'] < k)
                    j++;
                    
                return Math.max(helper(c, start, i, k), helper(c, j, end, k));
            }
        }   
        return end - start;
    }
    
    
    
    public int longestSubstring(String s, int k) {
        
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length();
        
        return helper(c, start, end, k); 
    }
}

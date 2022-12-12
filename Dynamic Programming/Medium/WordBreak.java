// https://leetcode.com/problems/word-break/

import java.util.*;

public class WordBreak {
    public boolean helper(String s, Set<String> set, int index, Boolean[] dp){
        // base case
        
        // if index == length of s then string is empty hence we can form string by taking no elements from dict hence true
        if(index >= s.length())
            return true;
        
        // if present then return
        if(dp[index] != null)
            return dp[index];
        
        // to store temporary word in variable
        String temp = "";
        for(int k=index; k<s.length(); k++){
            temp = temp + s.charAt(k);
            // if that word is present in set then we can break problem into subproblem and start from next index and again call same function.
            if(set.contains(temp)){
                if(helper(s, set, k+1, dp))
                    return dp[index] = true;
            }
        }
        
        // storing for future use
        return dp[index] = false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // memoization
        Boolean[] dp = new Boolean[s.length() + 1];
        
        Set<String> set = new HashSet<>();
        for(String word : wordDict)
            set.add(word);
        
        return helper(s, set, 0, dp);
    }
}

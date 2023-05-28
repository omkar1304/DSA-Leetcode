// https://leetcode.com/problems/extra-characters-in-a-string/

class Solution {
    public int minExtraChar(String s, String[] dict) {
        
        // Create set for dictionary for O(1) search in dictionary.
        Set<String> set = new HashSet<>();
        for(String word : dict)
            set.add(word);
        
        // Memoization ->
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return helper(0, s, set, dp);
    }
    
    public int helper(int index, String s, Set<String> set, int[] dp){
        
        // if index reached at the end of the string there no extra character remaining.
        if(index >= s.length())
            return 0;
        
        // if dictionary contains word for subtring from index to length then here is no extra character.
        if(set.contains(s.substring(index, s.length())))
            return 0;
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // at start consider all are extra characters
        int min = s.length() - index;
        
        for(int i=index+1; i<s.length(); i++){
            
            // if this substring is in dictionary there are zero characters.
            // else all characters of this substring are remaining.
            int count = set.contains(s.substring(index, i)) ? 0 : i - index;
            // check for second half after split.
            count = count + helper(i, s, set, dp);
            // updated the minimum value from every index 
            min = Math.min(min, count);
        }
        
        // return and store min for future calculations
        return dp[index] = min;
    }
}
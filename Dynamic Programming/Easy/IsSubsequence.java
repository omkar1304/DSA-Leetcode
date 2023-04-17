// https://leetcode.com/problems/is-subsequence/

// Recursion + Memo -> 
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        // Memoization ->
        Boolean[][] dp = new Boolean[s.length()+1][t.length()+1];
        return helper(0, 0, s, t, dp);
        
    }
    
    public boolean helper(int i, int j, String s, String t, Boolean[][] dp){
        
        // if we complete s string the there is subsequence in t so return true
        if(i == s.length())
            return true;
        
        // if we complete t before s then there is no subsequence so return false
        if(j == t.length())
            return false;
        
        // if present then return
        if(dp[i][j] != null)
            return dp[i][j];
        
        // if both char is same then check for next char in both string
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = helper(i+1, j+1, s, t, dp);
        
        // else check next char in t string as we have to find s subsequence in t.
        return dp[i][j] = helper(i, j+1, s, t, dp);
    }
}
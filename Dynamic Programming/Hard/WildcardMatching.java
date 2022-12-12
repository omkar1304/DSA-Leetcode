// https://leetcode.com/problems/wildcard-matching/

public class WildcardMatching {
    public boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        // base case
        
        // if string and pattern both end then its valid hence retrun true
        if(i<0 && j<0)
            return true;
        
        // if pattern ends then its invalid hence return false
        if(i>=0 && j<0)
            return false;
        
        // if string ends and pattern still there then we have two possiblities 
        // 1. it contains '*' so we can replace * with empty so retrun true
        // 2. it contains normal char so its invalid retrun false
        if(i<0 && j>=0){
            for(int k=0; k<=j; k++)
                if(p.charAt(k) != '*') return false;
            
            return true;
        }
        
        // if present then return
        if(dp[i][j] != null)
            return dp[i][j];
        
        // if both chars are matching or p contains '?' then we can move both index
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = helper(s, p, i-1, j-1, dp);
        
        // if p contains '*' then we have two choice 
        // replace '*' with empty space then move j or replace '*' with another *and char so move i
        // and get OR from both
        if(p.charAt(j) == '*')
            return dp[i][j] = helper(s, p, i-1, j, dp) || helper(s, p, i, j-1, dp);
        
        // else chars not matching then return false
        else
            return dp[i][j] = false;
        
    }
    
    
    public boolean isMatch(String s, String p) {
        // Memoization ->
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        
        return helper(s, p, s.length()-1, p.length()-1, dp);
    }
}

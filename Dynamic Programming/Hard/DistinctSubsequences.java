// https://leetcode.com/problems/distinct-subsequences/

public class DistinctSubsequences {
    public int helper(String s1, String s2, int i, int j, int[][] dp){
        // base case ->
        
        // if s2 completes then we found 1 string hence return 1
        if(j == s2.length())
            return 1;
        
        // if s1 completes before s2 then s2 not present in s1 hence retrun 0
        if(i == s1.length())
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // if chars are matching then we have 2 ways to get ans 
        // way 1 : move both index by 1 and check further
        // way 2 : move index of s1(i.e. ith index) and check further as we can assume this same char can appear in future as well
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = helper(s1, s2, i+1, j+1, dp) + helper(s1, s2, i+1, j, dp);
        
        // if chars are not matching then move index of s1 by 1 and check futher
        else
            return dp[i][j] = helper(s1, s2, i+1, j, dp);
    }
    
    
    public int numDistinct(String s1, String s2) {
        // Memoization ->
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(s1, s2, 0, 0, dp);
    }
}

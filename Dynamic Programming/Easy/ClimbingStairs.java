// https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {
    public int helper(int n, int[] dp){
        
        // if 1 or 2 stairs then we know only 1 or 2 ways to climb respectively
        if(n==1 || n==2)
            return n;
        
        if(dp[n] != 0)
            return dp[n];
        
        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
    }
    
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        return helper(n, dp);
    }
}

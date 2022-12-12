// https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/

class Solution {
    static int MOD = (int)(1e9 + 7);
    
    public int rearrangeSticks(int n, int k) {
        // Memoization ->
        int[][] dp = new int[1001][1001];
        
        return helper(n, k, dp);
    }
    
    public int helper(int n, int k, int[][] dp){
        //base case 
        
        //there is 0 way for k stick visible 
        if(k == 0) return 0;
        
        //there is only 1 way for k stick visible 
        if(n == k) return 1;
        
        // if present then return
        if(dp[n][k] != 0) return dp[n][k];
        
        //Case 1: Last stick is the longest stick. In this case, it would always be visible. So, the problem is reduced to rearranging remaining n-1 sticks such that only k-1 of them are visible. How do you do it? Call rearrangeSticks(n - 1, k - 1) recursively.
        long ways1 = 1L * helper(n - 1, k - 1, dp);
        
        //Case 2: Last stick is not the longest stick (but any other stick apart from longest). So you select any of those not the longest stick in n-1 ways. And since, the last stick is not the longest, it would definitely not be visible from the left. So, now you have remaining (n-1) sticks to rearrange out of which k should be visible. How to do it? rearrangeSticks(n - 1, k).

// Therefore, why multiplying by (n-1) ? This is because we have n-1 ways to select any stick apart from the longest to place as the last stick. 
        long ways2 = 1L * helper(n - 1, k, dp) * (n - 1);
        
        //store in the cache
        dp[n][k] = (int)((ways1 +  ways2) % MOD);
        
        
        return dp[n][k];
        
    }
}
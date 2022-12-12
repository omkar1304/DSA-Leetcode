// https://leetcode.com/problems/last-stone-weight-ii/submissions/

class Solution {
    public int helper(int[] stones, int index, int sumL, int sumR, int[][] dp){
        
        // base case
        
        // if index goes out of bound then we need to give diff from left and right
        if(index >= stones.length)
            return Math.abs(sumR - sumL);
        
        // if present then return
        if(dp[index][sumL] != -1)
            return dp[index][sumL];
        
        // we have to choice to put in left side or right and take min out of it.
        // same as knapsack problem
        int putLeft = helper(stones, index+1, sumL+stones[index], sumR, dp);
        int putRight = helper(stones, index+1, sumL, sumR+stones[index], dp);
        
        // storing for future
        return dp[index][sumL] = Math.min(putLeft, putRight);
        
    }
    
    public int lastStoneWeightII(int[] stones) {
        
        // Memoization ->
        int n = stones.length;
        int totalWeight = 0;
        for(int i=0; i<n; i++)
            totalWeight = totalWeight + stones[i];
        
        int[][] dp = new int[n+1][totalWeight+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<totalWeight+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(stones, 0, 0, 0, dp);
    }
}
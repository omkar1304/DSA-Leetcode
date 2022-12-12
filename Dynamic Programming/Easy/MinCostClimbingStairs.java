// https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {
    public int helper(int[] cost, int index, int[] dp){
        // Base case
        
        // if out of bound then cost is 0
        if(index < 0)
            return 0;
        // if index 0 or 1 then return cost as it is as we need to stop here
        if(index == 0 || index == 1)
            return cost[index];
        
        // memoization->
        if(dp[index] != -1)
            return dp[index];
        
        // include cost and take min of 1 step or 2 step
        return dp[index] = cost[index] + Math.min(helper(cost, index-1, dp), helper(cost, index-2, dp));
    }
    
    public int minCostClimbingStairs(int[] cost) {
        // memoization
        int[] dp = new int[cost.length];
        for(int i=0; i<cost.length; i++)
            dp[i] = -1;
        // we need to start from either from 0 or 1 index and return min of both
        // calling same function twice with last and second last index and return min of it.
        // as we know that we can reach n stair by using n-1 or n-2 hence take min cost of it.
        return Math.min(helper(cost, cost.length -1, dp), helper(cost, cost.length -2, dp));
    }
}

// https://leetcode.com/problems/profitable-schemes/


// Recursion + Memoization ->
class Solution {
    
    int mod = (int) (1e9 + 7);
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        // Memoization ->
        int[][][] dp = new int[group.length][minProfit+1][n+1];
        
        for(int i=0; i<group.length; i++)
            for(int j=0; j<minProfit+1; j++)
                for(int k=0; k<n+1; k++)
                    dp[i][j][k] = -1;
        
        return helper(0, 0, n, minProfit, group, profit, dp);
        
    }
    
    public int helper(int index, int currProfit, int n, int minProfit, int[] group, int[] profit, int[][][] dp){
        
        // base case ->
        
        // if required members is less than 0 then we cant peform crime so no scheme can be made henece return 0
        if(n < 0)
            return 0;
        
        // if index is reached to length of group i.e. we have visit every crime and our currProfit >= minprofit then we made one scheme so return 1
        if(index == group.length && currProfit >= minProfit && n >= 0)
            return 1;
        
        // if index is reached to length of group i.e. we have visit every crime but we didnt make required profit then we didnt make scheme hence return 0
        if(index == group.length)
            return 0;
        
        // if present then return
        if(dp[index][currProfit][n] != -1)
            return dp[index][currProfit][n];
        
        // at every crime we have two choice either pick crime or skip crime
        
        // skip ->
        int op1 = helper(index+1, currProfit, n, minProfit, group, profit, dp);
        // pick -> 
        // Math.min(currProfit+profit[index], minProfit) ? as we have made dp with minProfit size so avoid out of bound error. We only need to gain minProfit  
        int op2 = helper(index+1, Math.min(currProfit+profit[index], minProfit), n-group[index], minProfit, group, profit, dp);
        
        // add no of scheme made from both choices 
        int op = (op1 + op2) % mod;
        
        // store for future use
        return dp[index][currProfit][n] = op;
    }
}
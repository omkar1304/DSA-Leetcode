// https://leetcode.com/problems/coin-change-2/

public class CoinChange2 {
    public int change(int sum, int[] nums) {
        // subet sum + unbounded knapsack
        
        int n = nums.length;
        
        int[][] dp = new int[n+1][sum+1];
        
        // intilization -> 
        for(int j=0; j<sum+1; j++)
            dp[0][j] = 0;
        for(int i=0; i<n+1; i++)
            dp[i][0] = 1;
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                // if current item is less or equal than sum then do skip + pick   
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i][j-nums[i-1]] + dp[i-1][j];
                // if current item is greater than sum -> just skip it
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}

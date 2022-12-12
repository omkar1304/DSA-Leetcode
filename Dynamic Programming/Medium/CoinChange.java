// https://leetcode.com/problems/coin-change/

public class CoinChange {
    public int coinChange(int[] nums, int sum) {
        
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        
        // initialization -> 
        
        // if array is empty then to fill required sum we need infinite coins
        for(int j=0; j<sum+1; j++)
            dp[0][j] = Integer.MAX_VALUE-1;
        // if required sum is zero and array size is greater than 0 then we need zero coins to get sum
        for(int i=1; i<n+1; i++)
            dp[i][0] = 0;
        // only when size of array 1 and sum greater than 0
        // we need to check if then first coin present in array is able to divide the required sum or not.
        // if yes then save their quotient else store infinite max - 1
        for(int j=1; j<sum+1; j++){
            if(j % nums[0] == 0)
                dp[1][j] = j / nums[0];
            else
                dp[1][j] = Integer.MAX_VALUE-1;
        }
        
        // fill remaining 
        
        // if we pick curent coin then add 1 same as in knapsack we add value -> but here we have to take min
        for(int i=2; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(nums[i-1] <= j)
                    dp[i][j] = Math.min(1+dp[i][j-nums[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum] == Integer.MAX_VALUE-1 ? -1 : dp[n][sum];
    }
}

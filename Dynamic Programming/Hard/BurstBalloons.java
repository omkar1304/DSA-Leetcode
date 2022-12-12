// https://leetcode.com/problems/burst-balloons/

public class BurstBalloons {
    public int helper(int[] nums, int i, int j, int[][] dp){
        
        // base case
        
        // if i overcomes j then we dont have any balloons to burst then we can return coins 0
        if(i > j)
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // calculating left and right value if it gets out of bound
        int left = i-1 >= 0 ? nums[i-1] : 1;
        int right = j+1 <= nums.length -1 ? nums[j+1] : 1;
        
        int max = 0;
        // here we need to pick every singke balloons and need to solve further and return max value
        // so its totally depend on which one we pick hence try every single balloons and return max our of it.
        // k will run from i to j as we already taking care of out of bound for i-1 and j+1 above.
        for(int k=i; k<=j; k++){
            int temp = (left * nums[k] * right) + helper(nums, i, k-1, dp) + helper(nums, k+1, j, dp);
            max = Math.max(max, temp);
        }       
               
        return dp[i][j] = max;
    
    }
    
    
    public int maxCoins(int[] nums) {
        // Memoization ->
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0; i<nums.length+1; i++){
            for(int j=0; j<nums.length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums, 0, nums.length -1, dp);
    }
}

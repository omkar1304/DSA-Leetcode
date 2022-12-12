// https://leetcode.com/problems/house-robber/

import java.util.Arrays;

public class HouseRobber {
    public int helper(int[] nums, int index, int[] dp){
        // base case
        
        // if index goes out of bound then profit will be zero
        if(index >= nums.length)
            return 0;
        // if present then return value
        if(dp[index] != -1)
            return dp[index];
        
        // if we start robbering from first house then store profit and move to next to next house(i. e. index + 2)
        int pick = nums[index] + helper(nums, index+2, dp);
        // if we dont want to start robbering from first house then skip to next house
        int skip = helper(nums, index+1, dp);
        
        
        // return max profit out of both decision
        return dp[index] = Math.max(pick, skip);
    }
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        
        return helper(nums, 0, dp);
    }
}

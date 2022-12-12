// https://leetcode.com/problems/house-robber-ii/

import java.util.Arrays;

public class HouseRobber2 {
    public int helper(int[] nums, int index, int n, int[] dp){
        // base case
        
        // if index goes out of bound then profit will be zero
        if(index >= n)
            return 0;
        // if present then return value
        if(dp[index] != -1)
            return dp[index];
        
        // if we start robbering from first house then store profit and move to next to next house(i. e. index + 2)
        int pick = nums[index] + helper(nums, index+2, n, dp);
        // if we dont want to start robbering from first house then skip to next house
        int skip = helper(nums, index+1, n, dp);
        
        // return max profit out of both decision
        return dp[index] = Math.max(pick, skip);
    }
    
    
    public int rob(int[] nums) {
        // if 1 house only then return that profit
        if(nums.length == 1) return nums[0];
        
        int[] dp1 = new int[nums.length + 1];
        Arrays.fill(dp1, -1);
        
        int[] dp2 = new int[nums.length + 1];
        Arrays.fill(dp2, -1);
        
        // starting robbering from first house to second last (as its circular we cant robber last house as its neighbour of first house)
        int firstHouse = helper(nums, 0, nums.length-1, dp1);
        // starting robbering from second house to last house
        int secondHouse = helper(nums, 1, nums.length, dp2);
        
        // return max out of it
        return Math.max(firstHouse, secondHouse);
    }
}

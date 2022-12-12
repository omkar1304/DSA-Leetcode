// https://leetcode.com/problems/greatest-sum-divisible-by-three/

class Solution {
    public int helper(int[] nums, int index, int rem, int[][] dp){
        // base case
        
        // if index goes out of bound then check if rem is 0 then we can consider this as its divisible by 3 else return min value
        if(index >= nums.length)
            return rem == 0 ? 0 : -1000000;
        
        // if present then return
        if(dp[index][rem] != -1)
            return dp[index][rem];
        
        // here we have two chice either we include this or not 
        // and return max out of it
        // here why rem ? as if we pick sum then we are getting "Memory limit exceeded" error
        // to make efficient we used rem as it will take 3 space only which is constant
        int pick = nums[index] + helper(nums, index+1, (rem + nums[index])%3, dp);
        int skip = helper(nums, index+1, rem, dp);
        
        // storing for future use
        return dp[index][rem] = Math.max(pick, skip);
    }
    
    public int maxSumDivThree(int[] nums) {
        // Memoization ->
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums, 0, 0, dp);
    }
}
// https://leetcode.com/problems/reducing-dishes/

class Solution {
    public int helper(int[] nums, int index, int time, int[][] dp){
        // base case
        
        // if index goes out of bound then satisfaction is 0
        if(index >= nums.length)
            return 0;
        
        // if present then return
        if(dp[index][time] != -1)
            return dp[index][time];
        
        // we have two choice either pick or skip same as 0/1 knapsack
        int pick = (nums[index] * time) + helper(nums, index+1, time+1, dp);
        int skip = 0 + helper(nums, index+1, time, dp);
        
        // return max out of it
        return dp[index][time] = Math.max(pick, skip);
    }
    
    public int maxSatisfaction(int[] nums) {
        // Memoization ->
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0; i<nums.length+1; i++){
            for(int j=0; j<nums.length+1; j++){
                dp[i][j] = -1;
            }
        }
        
        // why sorting ? as we know nums contains negative numbers as well
        // if we sort array then all neg numbers will come first so sattisfaction will be less
        // [-9, -8, 1] -> -9 * 1(i.e. time) else if it not sorted then -> [-8, 1, -9] -> -9 * 3(i.e.time)
        Arrays.sort(nums);
        return helper(nums, 0, 1, dp);
    }
}


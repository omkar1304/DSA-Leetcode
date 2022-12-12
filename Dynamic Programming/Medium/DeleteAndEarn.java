// https://leetcode.com/problems/delete-and-earn/

public class DeleteAndEarn {
    public int helper(int[] house, int index, int[] dp){
        // base case
        
        // if index goes out of bound then profit will be zero
        if(index >= house.length)
            return 0;
        
        // if present then return value
        if(dp[index] != -1)
            return dp[index];
        
        // if we pick then we have to delete its neighbour so we just skip by index + 2 just like house robber
        int pick = house[index] + helper(house, index+2, dp);
        // if we skip then just check for next profit
        int skip = helper(house, index+1, dp);
        
        // and retrun max out of it
        return dp[index] = Math.max(pick, skip);
    }
    
    public int deleteAndEarn(int[] nums) {
        
        // to make this problem as house robber we need to build house with profit mentioned in nums
        // calculating to max to determine how many houses do we have 
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
            max = Math.max(max, nums[i]);
        
        // now according to nums building each house containing how many profit.
        int[] house = new int[max+1];
        for(int i=0; i<nums.length; i++)
            house[nums[i]] = house[nums[i]] + nums[i];
        
        // Memoization ->
        int[] dp = new int[max+1];
        Arrays.fill(dp, -1);
        
        return helper(house, 0, dp);
        
    }
}

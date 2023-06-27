// https://leetcode.com/problems/combination-sum-iv/

import java.util.*;

public class CombinationSum4 {
    public int helper(int[] nums, int target, int[] dp){
        // base case
        
        // if target is 0 then we found 1 combination hence retrun 1
        if(target == 0)
            return 1;
        
        // if target is less than zero then we cant find given target further hence this combination retruns count 0
        if(target < 0)
            return 0;
        
        // if present then return
        if(dp[target] != -1)
            return dp[target];
        
        // here different sequences are counted as different combinations
        // hence we can pick on element from array and can again start from first element to get permutations and store count
        int count = 0;
        for(int i=0; i<nums.length; i++)
            count = count + helper(nums, target - nums[i], dp);
        
        // storing for future use
        return dp[target] = count;
        
    }
    public int combinationSum4(int[] nums, int target) {
        // Memoization ->
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        
        return helper(nums, target, dp);
    }
}

// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

import java.util.*;

public class MaximumSumOfNonadjacentElements {
    public static int helper(ArrayList<Integer> nums, int index, int[] dp){
        // base case

        // if index goes out of bound then value is 0
        if(index >= nums.size())
            return 0;
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // we have two choice either pick and move to next to next value or else skip to next 
        // and return max out of it 
        int pick = nums.get(index) + helper(nums, index+2, dp);
        int skip = helper(nums, index+1, dp);
        
        // storing for future use
        return dp[index] = Math.max(pick, skip);
    }
    
    
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Memoization ->
        int[] dp = new int[nums.size() + 1];
        Arrays.fill(dp, -1);

        return helper(nums, 0, dp);
	}
}

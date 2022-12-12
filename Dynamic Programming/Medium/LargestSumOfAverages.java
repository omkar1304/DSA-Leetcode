// https://leetcode.com/problems/largest-sum-of-averages/

public class LargestSumOfAverages {
    public double helper(int[] nums, int k, int index, double[][] dp){
        // base case
        
        // if k is zero then we dont have to do partition hence return 0 if index is out of bound or else retrun mentioned value
        if(k == 0)
            return index == nums.length ? 0 : -10000000;
        
        // if present then return
        if(dp[index][k] != -1)
            return dp[index][k];
        
        double res = 0;
        double sum = 0;
        // partition from index upto k ->
        for(int j=index; j<=nums.length-k; j++){
            sum = sum + nums[j];
            // storing avg of each subarray and solving further and return max out of it.
            res = Math.max(res, sum/(j-index+1) + helper(nums, k-1, j+1, dp));
        }
        
        // storing for future use
        return dp[index][k] = res;
    }
    
    public double largestSumOfAverages(int[] nums, int k) {
        // Memoization->
        double[][] dp = new double[nums.length+1][k+1];
        for(int i=0; i<nums.length+1; i++){
            for(int j=0; j<k+1; j++){
                dp[i][j] = -1;
            }
        }      
        return helper(nums, k, 0, dp);
    }
}

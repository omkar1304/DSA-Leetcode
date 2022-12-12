// https://leetcode.com/problems/predict-the-winner/

public class PredictTheWinner{
    public int helper(int[] nums, int start, int end, int turn, int[][] dp){
        
        if(start > end)
            return 0;
        
        if(start == end)
            return nums[start];
        
        if(dp[start][end] != -1)
            return dp[start][end];
        
        int totalScore = 0;
        
        if(turn == 0)
            totalScore = Math.max(nums[start] + helper(nums, start+1, end, 1, dp), nums[end] + helper(nums, start, end-1, 1, dp));
        else
            totalScore = Math.min(-nums[start] + helper(nums, start+1, end, 0, dp), -nums[end] + helper(nums, start, end-1, 0, dp));
        
        return dp[start][end] = totalScore;
        
    }
    
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        int res = helper(nums, 0, nums.length-1, 0, dp);
        return res >= 0 ? true : false;
    }
}
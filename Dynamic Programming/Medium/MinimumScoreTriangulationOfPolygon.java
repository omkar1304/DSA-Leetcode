// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

class Solution {
    public int helper(int[] nums, int i, int j, int[][] dp){
        // base case
        
        // if only two points left then it cant form traingle so return 0
        if(i+1 == j)
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // idea is we know that first and last point will always be connected
        // for example -> [1,3,1,4,1,5] here 1 and 5 will always be connected so we can choose any point in this -> [_,3,1,4,1,_] and that would be our k and if we pick then will get our triangle with three points -> 1, k, j and solve recursively for both -> i to k and k to j and return min
        int ans = Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            int temp = (nums[i] * nums[k] * nums[j]) + helper(nums, i, k, dp) + helper(nums, k, j, dp);
            ans = Math.min(ans, temp);
        }
        
        // storing for future use
        return dp[i][j] = ans;
    }
    
    public int minScoreTriangulation(int[] nums) {
        int n = nums.length;
        
        // Memoization ->
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(nums, 0, n-1, dp);
        
    }
}
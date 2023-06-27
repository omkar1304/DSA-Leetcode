// https://leetcode.com/problems/minimum-path-sum/

import java.util.*;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // Memoization ->
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] num : dp)
            Arrays.fill(num, -1);
        
        
        return helper(0,0,n,m,grid, dp);
    }
    
    public int helper(int i, int j, int n, int m, int[][] grid, int[][] dp){
        // base case
        
        // if out of bound then return max as we need to calculate min as result
        if(i >= n || j >=m)
            return Integer.MAX_VALUE;
        
        // if we reched last cell then we can return cell value as no need to go further
        if(i == n-1 && j == m-1)
            return grid[i][j];
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // Calculate down sum and right sum and return min out of both including current cell value
        int down = helper(i+1, j, n, m, grid, dp);
        int right = helper(i, j+1, n, m, grid, dp);
        
        // storing for future use
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}

// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

class Solution {
    
    int mod = 1000000007;
    
    public int countPaths(int[][] grid) {
        
        // Memoization ->
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                dp[i][j] = -1;
        
        // to count no of increasing paths in grid
        int count = 0;
        
        // traverse through each cell
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                count = (count + helper(i, j, grid, -1, dp)) % mod;
            }
        }
        
        return count;
    }
    
    public int helper(int i, int j, int[][] grid, int prev, int[][] dp){
        
        // if out of bound or not increasing path then return 0 as no path can be made
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev)
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // traverse through all 4 directions ->
        int op1 = helper(i+1, j, grid, grid[i][j], dp) % mod;
        int op2 = helper(i-1, j, grid, grid[i][j], dp) % mod;
        int op3 = helper(i, j+1, grid, grid[i][j], dp) % mod;
        int op4 = helper(i, j-1, grid, grid[i][j], dp) % mod;
        
        // and add 1 as self cell + 4 directions value 
        return dp[i][j] = (1 + op1 + op2 + op3 + op4) % mod;
    }
}
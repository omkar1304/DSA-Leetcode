// https://leetcode.com/problems/minimum-falling-path-sum-ii/

public class MinimumFallingPathSum2 {
    public int helper(int[][] grid, int n, int r, int c, int[][] dp){
        // base case
        
        // if reached to last row then return that cell value
        if(r == n-1)
            return grid[r][c];
        
        // if present then return
        if(dp[r][c] != -1)
            return dp[r][c];
        
        // explore all below cells except cell that has same column number
        // as we know we cant take adjcent element
        // take cells and return min out of it
        int min = Integer.MAX_VALUE;
        for(int k=0; k<n; k++){
            if(k != c)
                min = Math.min(min, grid[r][c] + helper(grid, n, r+1, k, dp));
        }
        
        // storing for future use
        return dp[r][c] = min;
    }
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int min = Integer.MAX_VALUE;
        
        // Memoization ->
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        // explore all cells from first row of grid and return min
        for(int j=0; j<n; j++){
            int temp = helper(grid, n, 0, j, dp);
            min = Math.min(min, temp);
        }
        
        return min;
    }
}

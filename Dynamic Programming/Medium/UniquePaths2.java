// https://leetcode.com/problems/unique-paths-ii/

public class UniquePaths2 {
    public int helper(int[][] grid, int m, int n, int i, int j, int[][] dp){
        // base case
        
        // if we reached to end and its space then we found 1 path to reach end hence return 1
        if(i == m-1 && j == n-1 && grid[i][j] == 0)
            return 1;
        
        // if cell goes out of bound or its obstacle then we cant proceed hence return 0
        if(i >= m || j >= n || grid[i][j] == 1)
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // calculate no of ways from down and right and return
        int down = helper(grid, m, n, i+1, j, dp);
        int right = helper(grid, m, n,  i, j+1, dp);
        
        // storing for future use
        return dp[i][j] = down + right;
        
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        // Memoization ->
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(grid, m, n, 0, 0, dp);
        
    }
}

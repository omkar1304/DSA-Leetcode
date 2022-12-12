// https://leetcode.com/problems/unique-paths/

public class UniquePaths {
    public int helper(int m, int n, int x, int y, int[][] dp){
        // base case
        
        // if we reached to goal then found 1 path hence return 1
        if(x == m-1 || y == n-1)
            return 1;
        
        // if we go out of bound then there will be no path hence return 0
        if(x >= m || y >= n)
            return 0;
        
        // if present then return
        if(dp[x][y] != -1)
            return dp[x][y];
        
        int count = 0;
        // to get no of paths from right and down side
                // to go right             // to go down 
        count = helper(m, n, x, y+1, dp) + helper(m, n, x+1, y, dp);
        
        // storing value for future use
        return dp[x][y] = count;
        
    }
    
    public int uniquePaths(int m, int n) {
        // memoization->
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(m, n, 0, 0, dp);
    }
}

// https://leetcode.com/problems/out-of-boundary-paths/

public class OutOfBoundaryPaths {
    int[][][] dp;
    int mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Memoization ->
        dp = new int[m+1][n+1][maxMove + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= maxMove; k++)
                    dp[i][j][k] = -1;
        
        return count(m, n, maxMove, startRow, startColumn) % mod;
    }
    public int count(int m, int n, int move, int r, int c) {
        
        // if ball goes out of bound then we found 1 path hence return 1
        if (r < 0 || c < 0 || r >= m || c >= n)
            return 1;
        
        // if we dont have enough moves then return 0
        if (move <= 0)
            return 0;
        
        // if present then return
        if (dp[r][c][move] != -1)
            return dp[r][c][move] % mod;
        
        // count no of paths from all four directions
        int down = count(m, n, move - 1, r + 1, c) % mod;
        int up = count (m, n, move - 1, r - 1, c) % mod;
        int right = count (m, n, move - 1, r, c + 1) % mod;
        int left = count(m, n, move - 1, r, c - 1) % mod;
        
        // Storing for future use
        dp[r][c][move] = ((down + up) % mod + (right + left) % mod) % mod;
        return dp[r][c][move] % mod;
    }
}

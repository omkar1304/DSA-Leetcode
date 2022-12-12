// https://leetcode.com/problems/minimum-falling-path-sum/

public class MinimumFallingPathSum {
    public int helper(int[][] matrix, int n, int i, int j, int[][] dp){
        // base case
        
        // if index goes out of bound then return max value
        //we are adding something to INT_MAX and it can cause overflow as it will be out of bounds for an integer so we subtract some number from it so that after addition, In remains in integer range
        if(i<0 || j<0 || j>=n)
            return Integer.MAX_VALUE-10000;
        
        // if we reached destination that is last row then return cell value
        if(i == n-1)
            return matrix[i][j];
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // explore all three direction and return min of it
        int down = matrix[i][j] + helper(matrix, n, i+1, j, dp);
        int diagLeft = matrix[i][j] + helper(matrix, n, i+1, j-1, dp);
        int diagRight = matrix[i][j] + helper(matrix, n, i+1, j+1, dp);
        
        // storing for future use
        return dp[i][j] = Math.min(down , Math.min(diagLeft, diagRight));
    }
    
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        
        // Memoization ->
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        // statring to explore for every cell in first row as mentioned in problem statement
        // and return min out of every cell of first row
        for(int j=0; j<n; j++){
            int ans = helper(matrix, n, 0, j, dp);
            min = Math.min(min, ans);
        }
        
        return min;
    }
}

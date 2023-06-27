// https://leetcode.com/problems/range-sum-query-2d-immutable/

public class RangeSumQuery2DImmutable {
    int[][] dp;
    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];
        
        // calculate perfix sum for 2D matrix ->
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                // Initialization
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    // take current cell value from matrix(less index by 1) -> matrix[i-1][j-1];
                    // and add left and top cell from dp to add total but top-left digonal cell will repeat twice in addtiton hence remove it once
                    dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        
        // retrun sum value based on dp -> prefix sum for 2D
        //dp[r2+1][c2+1] -> holds sum from 0,0 to r2,c2
        // remove unnecessary parts -> like top and left and add top-left as we removed twice while doing for top and left so add once
        // Reverse method of adding value in dp (above formula)
        return dp[r2+1][c2+1] - dp[r1][c2+1] - dp[r2+1][c1] + dp[r1][c1];
    }
}

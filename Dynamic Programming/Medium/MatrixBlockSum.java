// https://leetcode.com/problems/matrix-block-sum/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                // building prefix sum matrix same as we did for problem -> Range sum Query 2D
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
        int[][] ans = new int[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                
                // here we have to max for start points as it can goes out of bound at negative sides
                int r1 = Math.max(0, r-k);
                int c1 = Math.max(0, c-k);
                // here we have to get min for end points as it can goes out of bound at positive sides
                int r2 = Math.min(m-1, r+k);
                int c2 = Math.min(n-1, c+k);
                
                // dp array is 1 point ahead than original one hence incrementing every point by 1
                r1++;
                r2++;
                c1++;
                c2++;
                
                // here we have to store sum as per mentioned in question same as problem -> Range sum Query 2D
                ans[r][c] = dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];
            }
        }
        
        // returning sum matrix
        return ans;
    }
}
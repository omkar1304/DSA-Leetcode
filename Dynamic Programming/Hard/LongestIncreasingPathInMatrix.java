// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

public class LongestIncreasingPathInMatrix {
    public int helper(int[][] matrix, int i, int j, int prev, int[][] dp){
        
        // base condition : check "out of boundaries" situation and 
        // also if "current <= previous" then these are invalid conditions. 
        if(i<0 || i>= matrix.length || j<0 || j>=matrix[0].length || matrix[i][j] <= prev)
            return 0;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // expand and look in all four directions using simple depth first search
        int left = helper(matrix, i, j-1, matrix[i][j], dp);
        int right = helper(matrix, i, j+1, matrix[i][j], dp);
        int top = helper(matrix, i-1, j, matrix[i][j], dp);
        int bottom = helper(matrix, i+1, j, matrix[i][j], dp);
        
        // return max depth of longest increasing path and 
        // plus 1 to consider the current element.
        int max = Math.max(bottom, Math.max(top, Math.max(right, left))) + 1;
        
        // storing for future use
        return dp[i][j] = max;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        // Memoization
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<matrix.length+1; i++){
            for(int j=0; j<matrix[0].length+1; j++){
                dp[i][j] = -1;
            }
        }
        // prev -1 as number between 0 to 9
        int prev = -1;
        int max = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                // checking every number in matrix and storing max length count in max variiable
                max = Math.max(max, helper(matrix, i, j, prev, dp));
            }
        }
        
        return max;
    }
}

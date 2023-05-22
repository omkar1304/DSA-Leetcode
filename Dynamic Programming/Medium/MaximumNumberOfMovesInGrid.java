// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/

class Solution {
    public int maxMoves(int[][] grid) {
        
        // to store maximum number of moves
        int max = 0;
        
        // Memoiation ->
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        // Calling helper function for every cell in first column and store max moves in mas variable
        for(int i=0; i<grid.length; i++){
            
            int result = helper(i, 0, grid, dp);
            max = Math.max(max, result);
        }
        
        return max;
    }
    
    public int helper(int row, int col, int[][] grid, int[][] dp){
        
        // if out of bound return 0 as we cant move further
        if(row < 0 || row > grid.length || col < 0 || col > grid[0].length)
            return 0;
        
        // if present then return
        if(dp[row][col] != -1)
            return dp[row][col];
        
        // as per question we have three options at every cells if next cell is greater than current cell
        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        
        // 1. (row - 1, col + 1) -> 
        if(row - 1 >= 0 && col + 1 < grid[0].length && grid[row-1][col+1] > grid[row][col])
            op1 = 1 + helper(row-1, col+1, grid, dp);
        
        // 2. (row, col + 1) -> 
        if(col + 1 < grid[0].length && grid[row][col+1] > grid[row][col])
            op2 = 1 + helper(row, col+1, grid, dp);
        
        // 3. (row + 1, col + 1) -> 
        if(row + 1 < grid.length && col + 1 < grid[0].length && grid[row+1][col+1] > grid[row][col])
            op3 = 1 + helper(row+1, col+1, grid, dp);
        
        // return and store max out of 3 values
        return dp[row][col] = Math.max(op1, Math.max(op2, op3));
    }
}
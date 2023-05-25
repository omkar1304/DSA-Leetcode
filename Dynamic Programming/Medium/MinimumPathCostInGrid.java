// https://leetcode.com/problems/minimum-path-cost-in-a-grid/

/*

here we just have to start from any cell of first to row and need to reach any cell of last row with minimum cost. where cost is nothing but all cell value included from first row to last row + total cost of moves we take to move from cell1 to cell2.

moveCost is constructed as nothing but suppose cell value is 5 and that cell needs to move on 1th column in next row then cost of move is moveCost[cellValue][1] which is 3 in example1.

*/

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        // taking out no of rows and cols
        int m = grid.length;
        int n = grid[0].length;
        
        // Memoization ->
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m+1; i++)
            for(int j=0; j<n+1; j++)
                dp[i][j] = -1;
        
        // to store minValue from every cell of first row
        int minVal = Integer.MAX_VALUE;
        
        for(int col=0; col<n; col++){
            
            // get the ans for every cell of first row using helper and return min out of it.
            int ans = helper(0, col, m, n, grid, moveCost, dp);
            minVal = Math.min(minVal, ans);
        }
        
        return minVal;
    }
    
    public int helper(int row, int col, int m, int n, int[][] grid, int[][] moveCost, int[][] dp){
        
        // if we reached to last row then just return cell value only as no need to return move cost for last row
        if(row == m-1)
            return grid[row][col];
        
        // if present then return 
        if(dp[row][col] != -1)
            return dp[row][col];
        
        // now at every cell we can move to n cells on next row. so move to every cell on next row and calculate cost and return min out of it
        int minVal = Integer.MAX_VALUE;
        
        for(int move=0; move<n; move++){
            
            // fetching cell value from grid
            int cellValue = grid[row][col];
            // calculation cost = cellvalue + movecost + next further movements...
            int cost = cellValue + moveCost[cellValue][move] + helper(row+1, move, m, n, grid, moveCost, dp);
            
            // storing minimum
            minVal = Math.min(minVal, cost);
        }
        
        // return min cost
        return dp[row][col] = minVal;
    }
}
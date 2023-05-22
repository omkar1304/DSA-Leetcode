// https://leetcode.com/problems/where-will-the-ball-fall/

class Solution {
    public int[] findBall(int[][] grid) {
        
        // creating result array
        int[] result = new int[grid[0].length];
        
        for(int index=0; index<grid[0].length; index++){
            
            // helper function will return fallen col value 
            result[index] = helper(0, index, grid);
        }
        
        return result;
    }
    
    public int helper(int row, int col, int[][] grid){
        
        // ball is traversed through the last row then ball successfully fallen down. hence return col
        if(row == grid.length && col < grid[0].length)
            return col;
        
        // at any case if its out of grid then return -1
        if(row >= grid.length || col >= grid[0].length)
            return -1;
        
        // now we have to case 1. go to right diagonal side if 1 | 2. go to left diagonal side if -1
        
        // if its 1 then ->
        if(grid[row][col] == 1){   
            
            // check if its right neighbour is -1 or not. if not then ball can fall to next right diagonal if no then it will get stuck in V shape so return -1
            if(col+1 < grid[0].length && grid[row][col+1] != -1)
                return helper(row+1, col+1, grid);
            else
                return -1;    
        }
        
        // if its -1 then ->
        else{
            
            // check if its left neighbour is 1 or not. if not then ball can fall to next left diagonal if no then it will get stuck in V shape so return -1
            if(col -1 >= 0 && grid[row][col-1] != 1)
                return helper(row+1, col-1, grid);
            else
                return -1;
        }
    }
}
// https://leetcode.com/problems/number-of-closed-islands/

class Solution {
    public int closedIsland(int[][] grid) {
        
        int numberOfIsland = 0;
        
        /*
         * In the perimeter of the grid, irrespective of land(0) or water(0) it will never be a closed island.
         * So, we want to confined our search from (row - 1) to (grid.length - 2) i.e. Skipping first row and last row.
         * Same thing is applicable to columns also for column also we want to confined our search from
         * (col - 1) to (grid[0].length - 2) i.e. Skipping first col and last col.
         */
        
        for(int i=1; i<grid.length-1; i++){
            
            for(int j=1; j<grid[0].length-1; j++){
                
                // Try to explore if is a land
                if(grid[i][j] == 0){
                    
                    if(DFS(i, j, grid) == true)
                        
                        numberOfIsland++;
                }
            }
        }
        
        return numberOfIsland;
        
    }
    
    /*
     * Will try to explore the part with DFS
     * 0 : Land  ,   1 : Water     &   2 : Visited Position
     */
    
    public boolean DFS(int i, int j, int[][] grid){
        
        // if that grid is water or already visited then no need to apply DFS we can pass true as its not boundary cell with land
        if(grid[i][j] == 1 || grid[i][j] == 2)
            return true;
        
        // so if its not water and visited then it will be land cell only and if its at boundary then return false as its not closed island
        if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1)
            return false;
        
        // if everything is okay then mark cell as visited
        grid[i][j] = 2;
        
        // explore its four directions ->
        boolean down = DFS(i+1, j, grid);
        boolean up = DFS(i-1, j, grid);
        boolean right = DFS(i, j+1, grid);
        boolean left = DFS(i, j-1, grid);
        
        // if all returns true then its closed else its not
        return down && up && right && left;
    }
}
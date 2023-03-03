// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

class Solution {
    public int minDays(int[][] grid) {
        
        // if we get no of island other than 1 then no need to do anything its already disconnected so return 0
        if(noOfIsland(grid) != 1)
            return 0;
        
        // else try to make every island cell as water and check no of island if it return other than 0 then return 1 as we switched one cell else put back 1 to the cell(i.e make it island again) and check for another cell
        for(int i=0; i<grid.length; i++){
            
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    
                    // switch to water from island
                    grid[i][j] = 0;
                    
                    // if we get no of island other than 1 then return 1
                    if(noOfIsland(grid) != 1)
                        return 1;
                    
                    // switch back to island from water
                    grid[i][j] = 1;
                }
            }
        }
        
        // if all checks are incomplete then return 2 as max it requires to cell to make grid disconnected
        return 2;
        
    }
    
    // To check no of island in grid
    public int noOfIsland(int[][] grid){
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        
        int count = 0;
        
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    
                    count++;
                    DFS(i, j, grid, visited);
                }
            }
        }
        
        return count;
    }
    
    // To apply DFS 
    public void DFS(int i, int j, int[][] grid, int[][] visited){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0)
            return;
        
        visited[i][j] = 1;
        
        DFS(i+1, j, grid, visited);
        DFS(i-1, j, grid, visited);
        DFS(i, j+1, grid, visited);
        DFS(i, j-1, grid, visited);
        
    }
}
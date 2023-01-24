// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // to jeep track of number of island component in graph
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                // if it is island i.e 1 then its start point of component
                if(grid[i][j] == '1'){
                    // inc count by 1 as we found one compoent
                    count = count + 1;
                    // apply DFS of that node
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, char[][] grid){
        
         // if node is out of bound or its visited already then return from here 
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        
        // else mark it as visited
        grid[i][j] = '0';
        
        // and explore its eight direction
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i-1, j-1, grid);
        dfs(i+1, j-1, grid);
        dfs(i-1, j+1, grid);
        dfs(i+1, j+1, grid);
    }
}
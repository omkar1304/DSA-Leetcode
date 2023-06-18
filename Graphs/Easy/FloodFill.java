// https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] matrix, int sr, int sc, int color) {
        
        int prevCol = matrix[sr][sc];
        int nextCol = color;
        
        if(prevCol == nextCol)
            return matrix;
        
        dfs(matrix, sr, sc, prevCol, nextCol);
        
        return matrix;
    }
    
    public void dfs(int[][] matrix, int x, int y, int prevCol, int nextCol){
        
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != prevCol)
            return;
        
        matrix[x][y] = nextCol;
        
        dfs(matrix, x+1, y, prevCol, nextCol);
        dfs(matrix, x-1, y, prevCol, nextCol);
        dfs(matrix, x, y+1, prevCol, nextCol);
        dfs(matrix, x, y-1, prevCol, nextCol);
    }
}
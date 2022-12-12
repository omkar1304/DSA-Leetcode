// https://leetcode.com/problems/flood-fill/

public class FloodFill {
    public void helper(int[][] image, int x, int y, int prevCol, int nextCol){
        
        // base case ( boundary conditions)
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != prevCol)
            return;
        
        image[x][y] = nextCol;
        
        helper(image, x+1, y, prevCol, nextCol);
        helper(image, x-1, y, prevCol, nextCol);
        helper(image, x, y+1, prevCol, nextCol);
        helper(image, x, y-1, prevCol, nextCol);
        
        return;
        
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int prevCol = image[sr][sc];
        int nextCol = color;
        
        // if its same only then no need to do anything just retrun it.
        if(prevCol == nextCol) return image;
        
        helper(image, sr, sc, prevCol, nextCol);
        return image;
    }
}

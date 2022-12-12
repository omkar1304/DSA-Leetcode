// https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        
        if(matrix.length == 1 && matrix[0].length == 1 ){
            if(matrix[0][0]==target) return true;
            else return false;
        }
            
        
        
        while(row<matrix.length && col>=0){
            
            if(matrix[row][col] == target) return true;
            
            if(target > matrix[row][col]) row++;
            else col--;
        }
        
        return false;
    }
}

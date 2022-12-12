// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row<matrix.length && col>=0){
            
            if(target == matrix[row][col]) return true;
            
            else if(target>matrix[row][col]) row++;
            else col--;
        }
        
        return false;
    }
}

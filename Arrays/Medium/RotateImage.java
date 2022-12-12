// https://leetcode.com/problems/rotate-image/



public class RotateImage {
    public void rotate(int[][] matrix) {
        
        // 1. Transpose (swap[i][j] == swap[j][i])
        
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // clock -> horizontal flip -> (swap[i][j] == swap[i][(matrix.length-1) - j])
        // Anti-clock -> vertical flip -> (swap[i][j] == swap[(matrix.length-1) - i][j])
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(matrix.length - 1) - j];
                matrix[i][(matrix.length - 1) - j] = temp;
            }
        }
        
    }
}

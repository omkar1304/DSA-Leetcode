// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.HashSet;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        HashSet<Integer> setr = new HashSet<>();
        HashSet<Integer> setc = new HashSet<>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    setr.add(i);
                    setc.add(j);
                }
            }
        }
        
        for(int sr : setr){
            for(int j=0; j<matrix[0].length; j++)
                matrix[sr][j] = 0;
        }
        
        for(int sc : setc){
            for(int i=0; i<matrix.length; i++)
                matrix[i][sc] = 0;
        }
        
        
    }
}

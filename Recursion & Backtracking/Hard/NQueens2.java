// https://leetcode.com/problems/n-queens-ii/

package Hard;

public class NQueens2 {
    public boolean isSafe(int[][] board, int row, int col, int n){
        
        for(int i=col-1; i>=0; i--){
            if(board[row][i] == 1) return false;
        }
        
        for(int i=row+1,j=col-1; i<n&&j>=0; i++,j--){
            if(board[i][j] == 1) return false;
        }
        
        for(int i=row-1,j=col-1; i>=0&&j>=0; i--,j--){
            if(board[i][j] == 1) return false;
        }
        
        return true;
    }
    
    
    public int helper(int[][] board, int n,int col){
        
        if(col == n){ 
            return 1;
        }
        
        int count = 0;
        for(int row=0; row<n; row++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 1;
                count = count + helper(board, n, col+1);   
                board[row][col] = 0;
            }
        }
        
        return count;
    }
         
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int col = 0;
        int ans = helper(board, n, col);
        return ans;
        
    }
}

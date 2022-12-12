// https://leetcode.com/problems/sudoku-solver/

package Hard;

public class SudokuSolver {
    public boolean isSafe(char[][] board, int row, int col, int n, int val){
        // row
        for(int i=0; i<n; i++){
            if(board[row][i] == (char)(48 + val)) 
                return false;
        }
        
        // col
        for(int i=0; i<n; i++){
            if(board[i][col] == (char)(48 + val))
                return false;
        }
        
        // 3X3 
        int idxi = row - row%3;
        int idxj = col - col%3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[idxi + i][idxj + j] == (char)(48 + val))
                    return false;
            }
        }
        
        return true;
        
    }
    
    public boolean helper(char[][] board, int row, int col, int n){
        if(row == n) return true;
        if(col == n) return helper(board, row+1, 0, n);
        if(board[row][col] != '.') return helper(board, row, col+1, n);
        
        for(int number=1; number<=9; number++){
            if(isSafe(board, row, col, n, number)){
                board[row][col] = (char)(48 + number);
                // checking if fill number is giving us true value or not
                // if yes then proceed 
                if(helper(board, row, col+1, n))
                    return true;
                else
                // if not then maintain previous state and try next number
                    // backtarck
                    board[row][col] = '.';
            }
            
        }
        return false;
        
    }
    
    public void solveSudoku(char[][] board) {
        int n = board.length;
        helper(board, 0, 0, n);
    }
}

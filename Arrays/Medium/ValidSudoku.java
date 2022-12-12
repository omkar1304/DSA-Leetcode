// https://leetcode.com/problems/valid-sudoku/

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(isValid(board, i, j)) continue;
                    else return false;
                }
            }
        }  
        return true;
    }
    
   public boolean isValid(char[][] board, int r, int c){
       char temp = board[r][c];
       
       // for vertical
       for(int i=0; i<9; i++){
           if(r != i && board[i][c] == temp) return false;
       }
       
       // for horizontal
       for(int j=0; j<9; j++){
           if(c!= j && board[r][j] == temp) return false;
       }
       
       // 3X3 box
       int idxi = r - r%3;
       int idxj = c - c%3;
       
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               if((idxi + i) != r && (idxj + j)!= c && board[idxi+i][idxj+j] == temp) return false;
           }
       }
       
       return true;
   } 
}

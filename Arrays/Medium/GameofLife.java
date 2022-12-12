// https://leetcode.com/problems/game-of-life/

public class GameofLife {
    public void gameOfLife(int[][] board) {
        // current -> next = values
        //     0   ->   0  = 0
        //     1   ->   0  = 1
        //     0   ->   1  = 2
        //     1   ->   1  = 3
        
        int rows = board.length;
        int cols = board[0].length;
        // to update values
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                int count = helper(board, r, c, rows, cols);
                if(board[r][c] == 1){
                    if(count == 2 || count == 3)
                        board[r][c] = 3;
                }
                if(board[r][c]==0){
                    if(count==3)
                        board[r][c] = 2;
                }
            }
        }
       
        // updating to next state
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(board[r][c] == 1)
                    board[r][c] = 0;
                if(board[r][c] == 2 || board[r][c] == 3)
                    board[r][c] = 1;
            }              
        }      
    }
    
    // here we have to count no of 1's it is respresented in either 1 or 3
    public int helper(int[][] board, int r, int c, int rows, int cols){
        int count = 0;
        for(int i=r-1; i<r+2; i++){
            for(int j=c-1; j<c+2; j++){
                if((r==i && c==j) || i < 0 || i >= rows || j < 0 || j >= cols)
                    continue;
                else{
                    if(board[i][j] == 1 || board[i][j]==3)
                        count++;
                }
            }
        } 
        return count;
    }
}

// https://leetcode.com/problems/n-queens/

package Hard;

import java.util.*;

public class NQueens {
    public boolean isSafe(int[][] board, int n, int row, int col){
        
        // row
        for(int i=col-1; i>=0; i--){
            if(board[row][i] == 1)
                return false;
        }
        
        // down diagonal
        for(int i=row+1, j=col-1; i<n && j>=0; i++, j--){
            if(board[i][j] == 1)
                return false;
        }
        
        // up diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1)
                return false;
        }
        
        return true;
    }
    
    public void helper(int[][] board, List<List<String>> ans, int n, int col){
        // base case
        if(col == n){
            List<String> strs = new ArrayList<>();
            for(int i=0; i<n; i++){
                String str = "";
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1)
                        str = str + "Q";
                    else
                        str = str + ".";
                }
                strs.add(str);
            }
            ans.add(strs);
            return;
        }
        
        // small calulation
        for(int row=0; row<n; row++){
            if(isSafe(board, n, row, col)){
                board[row][col] = 1;
                //recursive call
                helper(board, ans, n, col+1);
                //backtarck
                board[row][col] = 0;
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        int col = 0;
        helper(board, ans, n, col);
        return ans;     
    }
}


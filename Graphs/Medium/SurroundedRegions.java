// https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] matrix){
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // check at boundary of matrix if we find 'O' there then its DFS neighbours will never be surrounded by 'X'
        // rest we can replace with 'X'
        
        // Column ->
        for(int i=0; i<m; i++){
            // first column 
            if(matrix[i][0] == 'O')
                DFS(i, 0, matrix);
            // last column
            if(matrix[i][n-1] == 'O')
                DFS(i, n-1, matrix);  
        }
        
        // Row ->
        for(int j=0; j<n; j++){
            // first row
            if(matrix[0][j] == 'O')
                DFS(0, j, matrix);
            // last row
            if(matrix[m-1][j] == 'O')
                DFS(m-1, j, matrix);
        }
        
        // now replace '0' with 'X' and '#' with 'O'
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // here if its 'O' then its sourrended by 'X' hence replace with 'X'
                if(matrix[i][j] == 'O')
                    matrix[i][j] = 'X';
                
                // here if its '#' then its part of DFS neighbours hence replce with old value 'O'
                if(matrix[i][j] == '#')
                    matrix[i][j] = 'O';
            }
        }        
    }
    
    public void DFS(int i, int j, char[][] matrix){
        // if its out of bound or already visited means '#' or its 'X' then return it
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '#' || matrix[i][j] == 'X')
            return;
        
        // mark it as visited with '#'
        matrix[i][j] = '#';
        
        // and check for its four neighbours
        DFS(i-1, j, matrix);
        DFS(i+1, j, matrix);
        DFS(i, j-1, matrix);
        DFS(i, j+1, matrix);
    }
}
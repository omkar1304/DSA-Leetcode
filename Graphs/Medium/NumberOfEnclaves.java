// https://leetcode.com/problems/number-of-enclaves/

// BFS ->
class Solution {
    public int numEnclaves(int[][] matrix){
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // creating queue to store pair -> (row, col)
        Queue<Pair> queue = new LinkedList<>();
        
        // check at boundary of matrix if we find 1 there then its BFS neighbours will also can get out of bound
        // hence first check at 4 boundries and if we get 1 then mark it as -1 (to identify as visited) and add in queue
        
        // column ->
        for(int i=0; i<m; i++){
            // first col ->
            if(matrix[i][0] == 1){
                matrix[i][0] = -1;
                queue.offer(new Pair(i, 0));
            }           
            // last col ->
            if(matrix[i][n-1] == 1){
                matrix[i][n-1] = -1;
                queue.offer(new Pair(i, n-1));
            }
        }
        
        // row ->
        for(int j=0; j<n; j++){
            // first col ->
            if(matrix[0][j] == 1){
                matrix[0][j] = -1;
                queue.offer(new Pair(0, j));
            }
            // last col ->
            if(matrix[m-1][j] == 1){
                matrix[m-1][j] = -1;
                queue.offer(new Pair(m-1, j));
            }  
        }
        
        // To traverse four direction
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            // take out each pair from queue and get the values -> row, col
            int r = queue.peek().row;
            int c = queue.peek().col;
            
            queue.poll();
            
            for(int i=0; i<4; i++){
                // get new rows and cols by exploring four direction
                int nRow = r + drow[i];
                int nCol = c + dcol[i];
                
                // if cell is not out of bound and cell is 1 then mark it as visited with -1 and store in queue
                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && matrix[nRow][nCol] == 1){
                    matrix[nRow][nCol] = -1;
                    queue.offer(new Pair(nRow, nCol));
                }
            }
            
        }
        
        // now just count how many 1 left in matrix and return it as all remainng ones cant go out of bound
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1)
                    count++;
            }
        }
        
        return count;
    }
}

class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

// DFS ->
class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        // check at boundary of matrix if we find 1 there then its neighbours will also can get out of bound
        // hence first check at 4 boundries and if we get 1 then mark it as -1 (to identify as visited) and apply DFS to them so all connceted neighbours will get marked as -1 
        for(int i=0; i<m; i++){        
            if(grid[i][0] == 1)
                DFS(i, 0, grid);         
            if(grid[i][n-1] == 1)
                DFS(i, n-1, grid);
        }
        
        for(int j=0; j<n; j++){
            if(grid[0][j] == 1)
                DFS(0, j, grid);
            if(grid[m-1][j] == 1)
                DFS(m-1, j, grid);
        }
        
        // now just calculate how many cells are there with value 1 (land cells)
        int counter = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    counter++;
            }
        }
        
        return counter;
    }
    
    public void DFS(int i, int j, int[][] grid){
        
        // if cell is out of bound or not land cell then skip
        if(i < 0 || j < 0 || i>= grid.length || j>=grid[0].length || grid[i][j] != 1)
            return;
        
        // else mark it as -1 (visited) and apply DFS to its 4 neighborus
        grid[i][j] = -1;
        
        DFS(i+1, j, grid);
        DFS(i-1, j, grid);
        DFS(i, j+1, grid);
        DFS(i, j-1, grid);
    }
}
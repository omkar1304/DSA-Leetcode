// https://leetcode.com/problems/number-of-enclaves/

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
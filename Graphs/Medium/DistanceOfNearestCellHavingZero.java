// https://leetcode.com/problems/01-matrix/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // creating visited and dist for result
        int[][] visited = new int[m][n];
        int[][] dist = new int[m][n];
        
        // creating queue to store pair -> (row, col, step)
        Queue<Pair> queue = new LinkedList<>();
        
        // put all cell with step 0 who has 0 value in matrix and mark them as visited
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        
        // To traverse four direction
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            
            // take out each pair from queue and get the values -> row, col, step
            int row = queue.peek().row;
            int col = queue.peek().col;
            int step = queue.peek().step;
            
            queue.poll();
            // storing steps for current cell in dist matrix
            dist[row][col] = step;
            
            for(int i=0; i<4; i++){
                // get new rows and cols 
                int nRow = row + drow[i];
                int nCol = col + dcol[i];
                
                // if it in bounded in grid and its not visited then mark it visited and store cell in queue 
                if(nRow >=0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] != 1){
                    visited[nRow][nCol] = 1;
                    queue.offer(new Pair(nRow, nCol, step+1));
                }
            }
        }
        // return update dist matrix
        return dist;
    }
}

class Pair{
    
    int row;
    int col;
    int step;
    
    public Pair(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
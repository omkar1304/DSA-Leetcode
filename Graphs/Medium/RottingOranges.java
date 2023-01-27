// https://leetcode.com/problems/rotting-oranges/

class Pair{
    int row;
    int col;
    int time;
    
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        // taking number of rows and cols 
        int m = grid.length;
        int n = grid[0].length;
        
        // created visited matrix and queue to store -> (row, col, time)
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        // to count no of fresh oranges in grid
        int fresh = 0;
        
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                // if we find rotten orange then store as pair in queue with time 0 as its initial stage
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    queue.offer(new Pair(i, j, 0));
                }
                
                // if we find fresh orange then inc fresh by 1 
                if(grid[i][j] == 1){
                    fresh++;
                } 
            }
        }
        
        // to count how many fresh oranges got rotted
        int count = 0;
        // to store max time to make all oranges rotten
        int maxTime = 0;
        // created row and col for traverse four directions
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        
        while(!queue.isEmpty()){
            // take out each pair from queue and get the values -> row, col, time
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            
            queue.poll();
            
            // store max time if any
            maxTime = Math.max(maxTime, t);
            
            // then traverse all four directions
            for(int i=0; i<4; i++){
                // get new rows and cols 
                int nRow = r + drow[i];
                int nCol = c + dcol[i];
                
                // if it in bounded in grid and its not visited and its fresh orange then we need to rotten it
                if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n && visited[nRow][nCol] != 2 && grid[nRow][nCol] == 1){
                    
                    // store in queue and mark it as visited and inc count by 1
                    queue.offer(new Pair(nRow, nCol, t+1));
                    visited[nRow][nCol] = 2;
                    count++;
                }
                    
            }
            
        }
        
        // if no of fresh oranges is equal to rotten oranges then return maxTime else not possible hence return -1
        return fresh == count ? maxTime : -1;
        
    }
}
// https://leetcode.com/problems/path-with-minimum-effort/

class Solution {
    public int minimumEffortPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        // creating dist array and putting max value in it and for src cell putting 0
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        
        // to traverse in 4 direction
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        // using PQ to implement Dijkstra algo and add src in it
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        pq.offer(new Pair(0, 0, 0));
        
        while(!pq.isEmpty()){
            
            // pop out top minimum distance from queue
            int row = pq.peek().row;
            int col = pq.peek().col;
            int distance = pq.peek().distance;
            
            pq.poll();
            
            // if pop out cell is destination cell then just return min as we know Dijkstra algo follows minimun path so it will always reach to dest cell with minimum effort
            if(row == m-1 && col == n-1)
                return distance;
            
            // to traverse 4 directions
            for(int i=0; i<4; i++){
                
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                // if that cell is under bount 
                if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n){
                    
                    // calculate abs diff and store max as we need to carry max effort throughout path
                    int newDistance = Math.abs(grid[row][col] - grid[nRow][nCol]);
                    newDistance = Math.max(newDistance, distance);
                    
                    // if new distance is less than dist cell then update and add in queue
                    if(newDistance < dist[nRow][nCol]){
                        
                        dist[nRow][nCol] = newDistance;
                        pq.offer(new Pair(nRow, nCol, dist[nRow][nCol]));
                    }
                }
            }
        }
        
        // if not possible then return 0
        return 0;
    }
}

class Pair{
    
    int row;
    int col;
    int distance;
    
    public Pair(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
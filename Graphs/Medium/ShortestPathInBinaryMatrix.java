// https://leetcode.com/problems/shortest-path-in-binary-matrix/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        
        // if starting point itself 1 then there is no way to start so return -1
        if(grid[0][0] == 1)
            return -1;
        
        // creating queue to perform BFS on grid
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));
        
        // to traverse all 8 directions
        int[] dRow = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dCol = {0, 1, 0, -1, -1, 1, 1, -1};
        
        while(!queue.isEmpty()){
            
            // poping out cell with distance
            int row = queue.peek().row;
            int col = queue.peek().col;
            int distance = queue.peek().distance;
            
            queue.poll();
            
            // if we reached destination cell then return distance + 1(to add destination node)
            // its unit distance problem so if we reached first time to destination cell thats means in future path leading to dest cell with cost same distance or more than that
            if(row == n-1 && col == n-1)
                return distance + 1;
            
            // traverse all 8 directions
            for(int i=0; i<8; i++){
                
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                
                // if its under bound and cell is 0 then add in quueu and cell = -1 as visited
                if(nRow >=0 && nRow < n && nCol >=0 && nCol < n && grid[nRow][nCol] == 0){
                    
                    grid[nRow][nCol] = -1;
                    queue.add(new Pair(nRow, nCol, distance+1));
                }
            }
        }
        
        // if not possible then return -1
        return -1;
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
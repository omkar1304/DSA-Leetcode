// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        // taking length of rows and cols
        int m = grid.length;
        int n = grid[0].length;
        
        // creating 3D visited to check if cell[row][col] is already visited with balance k 
        boolean[][][] visited = new boolean[m][n][k+1];
        
        // to traverse 4 directions
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        // creating queue for BFS and adding soruce cell with balance k
        // Pair -> {row, col, balanced obs}
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, k));
        
        // to count number of steps required to reach target cell
        int steps = 0;
        
        while(!queue.isEmpty()){
            
            // to apply BFS level wise to cell
            int size = queue.size();
            for(int index=0; index<size; index++){
                
                // get row and col and balanced obs with pair from queue
                int row = queue.peek().row;
                int col = queue.peek().col;
                int obs = queue.peek().obs;
                
                // if we reached to target cell then return steps
                if(row == m-1 && col == n-1)
                    return steps;
                
                queue.poll();
                
                // to traverse 4 directions
                for(int i=0; i<4; i++){
                    
                    // get the new row and col
                    int nRow = row + drow[i];
                    int nCol = col + dcol[i];
                    
                    // if new row and col are in bound then only check for next conditions ->
                    if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n){
                        
                        // if cell empty and its not visited with obs balance 
                        if(grid[nRow][nCol] == 0 && visited[nRow][nCol][obs] == false){   
                            // then mark it as visisted and add in queue
                            visited[nRow][nCol][obs] = true;
                            queue.offer(new Pair(nRow, nCol, obs));
                        }
                        // if cell is obstacle and its not visited with obs-1 balance..why obs -1 > because this cell is obstacle so we need to remove 1 from balance to cross this cell
                        else if(grid[nRow][nCol] == 1 && obs > 0 && visited[nRow][nCol][obs-1] == false){
                            // then mark it as visisted and add in queue
                            visited[nRow][nCol][obs-1] = true;
                            queue.offer(new Pair(nRow, nCol, obs-1));
                        }
                    }
                }
            }
            
            // at every level incerement steps by 1
            steps++;
        }
        
        // if not possible return -1
        return -1;
    }
}

class Pair{
    
    int row;
    int col;
    int obs;
    
    public Pair(int row, int col, int obs){
        
        this.row = row;
        this.col = col;
        this.obs = obs;
        
    }
}
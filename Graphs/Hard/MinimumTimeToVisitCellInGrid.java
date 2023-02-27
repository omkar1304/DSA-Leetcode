// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/

/*
1.If grid[0][1] > 1 and grid[1][0] > 1 we can not move anywhere from cell grid[0][0] hence answer is -1
2.Use priority queue to find next cell with minimum required time to move to it
3. If time for a neighbor (target) cell is > 1 + time for current cell. We can not directly move to target cell. We will have to "ping pong" between previous cell and current cell. When playing ping pong between previous and current cell there can be two cases.
    Let's say time for target cell is 4 and current time is 2, difference = 2 (even).
    Move to prev cell, time = 3
    Move to curr cell, time = 4
    Move to target cell, time = 5.
    Hence we reach target cell with time: target cell time + 1 when difference between target cell time and curr cell time is even.
    
    Let's say time for target cell is 5 and current time is 2, difference = 3 (odd).
    Move to prev cell, time = 3
    Move to curr cell, time = 4
    Move to target cell, time = 5.
    Hence we reach target cell with time: target cell time when difference between target cell time and curr cell time is odd.
*/

class Solution {

    public int minimumTime(int[][] grid) {
        
        // if bottom cell and right cell of start cell is greater than 1 then we cant proceed further hence return -1
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // to traverse 4 directions
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        // implement PQ to apply Dijkstra Algo and adding starting cell with 0 time
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(0, 0, 0));
        
        boolean[][] visited = new boolean[m][n];
        
        while (!pq.isEmpty()) {
            
            // poping out row,col,time with pair from PQ
            int row = pq.peek().row;
            int col = pq.peek().col;
            int time = pq.peek().time;
            
            pq.poll();
            
            // if we reached to final cell then return time as this time is minimum. so even in future we get time to reach final cell it would be same or greater than this
            if (row == m - 1 && col == n - 1)
                return time;
            
            // if cell is already visited then leave it
            if (visited[row][col])
                continue;
            
            // else mark it as visited
            visited[row][col] = true;
            
            // traverse in 4 direction of current cell
            for (int i=0; i<4; i++) {
                
                int r = row + drow[i];
                int c = col + dcol[i];
                
                // if out of bound or visited then return
                if (r < 0 || r == m || c < 0 || c == n || visited[r][c]) {
                    continue;
                }
                
                // if time to reach next cell is greater than or equal to next cell value then add in PQ
                if (grid[r][c] <= time + 1) 
                    pq.offer(new Pair(r, c, time+1));
                
                // if time to reach next cell is smaller than next cell value then we need to check diff of it. so if diff is even then we need next cell value + 1 time to reach next cell else if diff is odd then we need next cell value time to reach next cell and add in PQ respectively
                else{

                    int diff = grid[r][c] - time;
                    
                    if (diff % 2 == 1)
                        pq.offer(new Pair(r, c, grid[r][c]));
                    else
                        pq.offer(new Pair(r, c, grid[r][c]+1));
                }
            }
        }
        
        // if PQ becomes exmpty then no path found so retrun -1
        return -1;
    }
}

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
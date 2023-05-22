// https://leetcode.com/problems/minimum-cost-of-a-path-with-special-roads/

// readble solution ->
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        
        // created set to store position and check if position is already visited or not.
        Set<Pair> visited = new HashSet<>();
        
        // created PQ to perform Dijkstra Algo and store edge (x, y, cost)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        
        while(!pq.isEmpty()){
            
            // popping out x, y, cost from edge 
            int[] edge = pq.peek();
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];
            
            pq.poll();
            
            // check if position is visited if yes then continue
            Pair pair = new Pair(x, y);
            if(visited.contains(pair))
                continue;
            
            // check if we reached the traget position if yes return cost
            if(x == target[0] && y == target[1])
                return cost;
            
            // else mark this position as visited
            visited.add(pair);
            
            // Now we have 2 choice ->
            // 1. directly jump from start to target position 
            // 2. use of specialRoads + cost of start to specialRoads
            // hence adding both in pq and pq will store smaller cost at top 
            
            // 1. directly jump from start to target position
            pq.offer(new int[]{target[0], target[1], cost + Math.abs(target[0] - x) + Math.abs(target[1] - y) } );
            
            // 2. use of specialRoads + cost of start to specialRoads
            for(int[] road : specialRoads){
                
                // if not visited then only 
                if(!visited.contains(new Pair(road[2], road[3]))){
                    
                    // cost -> to reach till here
                    // Math.abs(road[0] - x) + Math.abs(road[1] - y) -> cost of start cell to start cell of specialRoads
                    // road[4] -> cost of start cell of specialRoads to end cell of specialRoads
                    pq.offer(new int[]{road[2], road[3], cost + Math.abs(road[0] - x) + Math.abs(road[1] - y) + road[4] } );
                }
            }
        }
        
        // else retrun -1 if not possible to reach
        return -1;
    }
}
class Pair {
    
    int x;
    int y;
    
    public Pair(int x, int y){
        
        this.x = x;
        this.y = y;
        
    }
}

// accepted solution (same code with diff datatypes) ->
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
      var visited = new HashSet<Pair<Integer, Integer>>();
  
      var queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
      queue.offer(new int[] {start[0], start[1], 0});
  
      while (!queue.isEmpty()) {
        var a = queue.poll();
        int x = a[0], y = a[1], cost = a[2];
        var pos = new Pair(x, y);
  
        if (visited.contains(pos)) continue;
  
        if (x == target[0] && y == target[1])
          return cost;
  
        visited.add(pos);
  
        queue.offer(new int[] {target[0], target[1], cost + Math.abs(target[0] - x) + Math.abs(target[1] - y)});
  
        for (var r : specialRoads)
          if (!visited.contains(new Pair(r[2], r[3])))
            queue.offer(new int[] {r[2], r[3], Math.abs(r[0] - x) + Math.abs(r[1] - y) + cost + r[4]});
  
      }
      return -1;
    }
  }

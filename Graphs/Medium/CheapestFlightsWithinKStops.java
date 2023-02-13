// https://leetcode.com/problems/cheapest-flights-within-k-stops/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // creating adj list with pair(v, wt)
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        // creating dist array to store minimun distance from src to at every index
        int[] dist = new int[n];
        for(int i=0; i<n; i++)
            dist[i] = Integer.MAX_VALUE;
        // intialize distance of src to src is 0
        dist[src] = 0;
        
        // why queue not PQ as here stops going to increase by unit value so its always going to be in inc oder
        // create Queue to store tuple -> (stops, node, wt)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, src, 0));
        
        while(!queue.isEmpty()){
            
            // pop out tuple from queue
            int u = queue.peek().node;
            int wt = queue.peek().wt;
            int stops = queue.peek().stops;
            
            queue.poll();
            
            // check of its neighbours
            for(Pair pair : adj.get(u)){
                
                int v = pair.node;
                int vwt = pair.wt;
                
                // if cost from u to v is less than dist[v] and also it's withing k stops then add in queue and update dist[v]
                if(wt + vwt < dist[v] && stops <= k){
                    
                    dist[v] = wt + vwt;
                    queue.offer(new Tuple(stops+1, v, dist[v]));
                }
            }
        }
        
        // why we didnt return in queue itself? if suppose we can reach dest node with 2 path which are within stops so we need to return minimum dist among them so dist will store that for us.
        // if its max value then its not reachable else return dist[dest]
        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}

// to create adj list with {v, wt}
class Pair{
    
    int node;
    int wt;
    
    public Pair(int node, int wt){
        
        this.node = node;
        this.wt = wt;
    }
}

// to store tuple in queue with {stops, node, wt}
class Tuple{
    
    int stops;
    int node;
    int wt;
    
    public Tuple(int stops, int node, int wt){
        
        this.stops = stops;
        this.node = node;
        this.wt = wt;
    }
}
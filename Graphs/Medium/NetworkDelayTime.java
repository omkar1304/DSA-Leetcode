// https://leetcode.com/problems/network-delay-time/

class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        
        // creating adj list with pair(v, wt)
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        // creating dist array to store minimun distance from src to at every index
        int[] dist = new int[n+1];
        for(int i=0; i<n+1; i++)
            dist[i] = Integer.MAX_VALUE;
        // intialize distance of k to k is 0
        dist[k] = 0;
        
        // why queue not PQ as here network going to increase by unit value so its always going to be in inc oder
        // create Queue to store tuple -> (node, wt)
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(k, 0));
        
        while(!queue.isEmpty()){
            
            // pop out u and uwt with pair from queue
            int u = queue.peek().node;
            int uwt = queue.peek().wt;
            
            queue.poll();
            
            // check of its neighbours
            for(Pair pair : adj.get(u)){
                
                int v = pair.node;
                int vwt = pair.wt;
                
                // if cost from u to v is less than dist[v] then update dist[v] and add in queue
                if(uwt + vwt < dist[v]){
                    
                    dist[v] = uwt + vwt;
                    queue.offer(new Pair(v, dist[v]));
                }
            }
        }
        
        // now we have minimum distance from k to every node so whatever maximum number from dist array will determin that at least max number of time required to node k to reach every node
        int max = 0;
        for(int i=1; i<n+1; i++){ // its 1 based graph so startin from 1
            
            // if node is not reachable from k then return -1
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            
            // else keep storing max value in max 
            max = Math.max(max, dist[i]);
        }
        
        // return max
        return max;
    }
}

class Pair{
    
    int node;
    int wt;
    
    public Pair(int node, int wt){
        
        this.node = node;
        this.wt = wt;
        
    }
}
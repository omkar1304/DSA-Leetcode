// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

class Solution {
    public int countPaths(int n, int[][] edges) {
        
        // creating adj list from edges using pair -> (node , wt)
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        // creating dist array to store minimum cost at every node from src node
        // also creating ways array to store number of ways from src to that node which having minimum cost
        int[] dist = new int[n];
        int[] ways = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0; // initially distance from src to src is 0
        ways[0] = 1; // initially ways from src to src is 1
        
        // creating PQ to implement Dijkstra algo so we can get minimum wt at top and storing src node in pq
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            
            // poping out node and wt with pair from pq
            int u = pq.peek().node;
            int uwt = pq.peek().wt;
            
            pq.poll();
            
            // checking for its neighbours 
            for(Pair pair : adj.get(u)){
                
                int v = pair.node;
                int vwt = pair.wt;
                
                // if dist[u] + wt < dist[v] then its first time we encounting way which has minimum cost 
                // so update as usual dist and pq but this time update ways as well. put same no of ways of u to v as its first time. so whatever ways come to u will same ways come to v
                if(uwt + vwt < dist[v]){  
                    dist[v] = uwt + vwt;
                    pq.offer(new Pair(v, dist[v]));
                    ways[v] = ways[u];
                }
                // if dist[u] + wt == dist[v] then we already encountered ways which has minimum cost.
                // so just add up ways to ways[v]
                else if(uwt + vwt == dist[v]){
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                }
            }
        }
        
        // at the end return no ways to reach n-1 node from ways array
        return ways[n-1] % 1000000007;
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
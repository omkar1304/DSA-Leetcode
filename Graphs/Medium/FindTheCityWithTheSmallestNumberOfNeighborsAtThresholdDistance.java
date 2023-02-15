// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

// using Dijkstra Algo -> 63ms
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++){           
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        // to store minimun number of city which can be reached under distanceThreshold
        int min = n;
        // city number 
        int result = -1;
        
        // as Dijkstra only works for single source and positive weight.
        // we can apply DG on every node and get minimum city count for every node and store in min variable and city number in result
        for(int node=0; node<n; node++){
            
            int minCity = Dijkstra(n, node, adj, distanceThreshold);
            
            // if current count is less than or equal to min then update min and city number
            if(minCity <= min){
                min = minCity;
                result = node;
            }
        }
        
        return result;
    }
    
    // Simple DG algo ->
    public int Dijkstra(int n, int src, List<List<Pair>> adj, int distanceThreshold){
        
        // create dist array to store minimum dist from src to every node
        int[] dist = new int[n];
        for(int i=0; i<n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        
        // creating PQ to put minimum distance pair top
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            
            int u = pq.peek().node;
            int uwt = pq.peek().wt;
            
            pq.poll();
            
            for(Pair pair : adj.get(u)){
                
                int v = pair.node;
                int vwt = pair.wt;
                
                // relaxation ->
                if(uwt + vwt < dist[v]){
                    dist[v] = uwt + vwt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        
        // countimg how many cities are reachable from src to every node under distanceThreshold
        int counter = 0;
        for(int i=0; i<n; i++){
            if(dist[i] <= distanceThreshold)
                counter++;
        }
        
        // returning counter 
        return counter;
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


// using Floyd Warshall Algo -> 8ms
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        // creating matrix as per Flyod Warshall algo ->
        
        // passing max value to every path initially
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        // from i to i node distance will always be 0
        for(int i=0; i<n; i++){
            matrix[i][i] = 0;
        }  
        // now mark weight to path as per edge
        for(int[] edge : edges){
            
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }
        
        // Apply Flyod Warshall Algo to get minimum diatance from every node to every oher node
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE)
                        continue;
                    
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // to store minimun number of city which can be reached under distanceThreshold
        int minCity = n;
        // city number 
        int city = -1;
        
        for(int i=0; i<n; i++){
            
            int counter = 0;
            for(int j=0; j<n; j++){
                
                // calculate how many cities are reachable from i city under distanceThreshold
                if(matrix[i][j] <= distanceThreshold)
                    counter++;
            }
            
            // if current count is less than or equal to min then update min and city number
            if(counter <= minCity){
                minCity = counter;
                city = i;
            }
        }
        
        // return city
        return city;
        
    }
}
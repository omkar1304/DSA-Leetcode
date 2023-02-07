// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        // n -> no of nodes 
	    // m -> no of edges
	    
	    // creating adj list from edges
	    List<List<Integer>> adj = new ArrayList<>();
	    for(int i=0; i<n; i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<m; i++){
	        
	        adj.get(edges[i][0]).add(edges[i][1]);
	        adj.get(edges[i][1]).add(edges[i][0]);
	    }
	    
	    // creating distance array to store distance from source node to target node
	    int[] dist = new int[n];
	    for(int i=0; i<n; i++){
	        dist[i] = Integer.MAX_VALUE;
	    }
        dist[src] = 0; // source to source distance is 0 only
        
        // creating queue to apply BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src); // adding source as we need to start from source only
        
        while(!queue.isEmpty()){
            
            // pop out node from queue
            int u = queue.peek();
            queue.poll();
            
            // and check its neighbours ->
            for(int v : adj.get(u)){
                
                // if distance of u + 1(unit wt) < distance of v then update it and add in queue
                if(dist[u] + 1 < dist[v]){
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }
        
        // if any ndoe is not reachable from source node then update dist with -1
        for(int i=0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}


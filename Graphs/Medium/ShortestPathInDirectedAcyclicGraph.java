// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
	    
	    // n -> no of nodes 
	    // m -> no of edges
	    
	    // creating adj list from edges but here weight is also there so we need to store in form of pair
	    // suppose there is edge between u and v and their cost is wt then it will store like this -> u -> {v, wt}
	    List<List<Pair>> adj = new ArrayList<>();
	    for(int i=0; i<n; i++){
	        List<Pair> temp = new ArrayList<>();
	        adj.add(temp);
	    }
	    for(int i=0; i<m; i++){
	        
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new Pair(v, wt));
	    }
	    
	    // creating visited array to keep tracck of visited nodes
	    int[] visited = new int[n];
	    // creating stack to store nodes in topological order
	    Stack<Integer> stack = new Stack<>();
	    for(int i=0; i<n; i++){
	        
	        // if node not visited then apply topoSortDFS on that node
	        if(visited[i] == 0){
	            topoSortDFS(i, adj, visited, stack);
	        }
	    }
	    
	    // once topoSortDFS is done we will be having nodes in stack in topo order
	    
	    // creating distace array for every node to store minimum distance from source to target node
	    int[] dist = new int[n];
	    for(int i=0; i<n; i++){
	        dist[i] = Integer.MAX_VALUE; // initially mark it as max value
	    }
	    dist[0] = 0; // source to source distance is 0 only
	    
	    // run while loop till stack becomes empty
	    while(!stack.isEmpty()){
	        
	        // pop out top node from stack
	        int u = stack.peek();
	        stack.pop();
	        
	        // and check for its neighbours(v) with weight(wt)
	        for(int i=0; i<adj.get(u).size(); i++){
	            int v = adj.get(u).get(i).v;
	            int wt = adj.get(u).get(i).wt;
	            
	            // if source node distance + weight to reach target node < distance of target node then update the value as we need minimum
	            if(dist[u] + wt < dist[v]){
	                dist[v] = dist[u] + wt;
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
	
	public void topoSortDFS(int u, List<List<Pair>> adj, int[] visited, Stack<Integer> stack){
	    
	    // mark node as visited 
	    visited[u] = 1;
	    
	    // check for its neigbours and apply topoSortDFS if not visited already
	    for(int i=0; i<adj.get(u).size(); i++){
	       
	       int v = adj.get(u).get(i).v;
	       if(visited[v] == 0){
	           topoSortDFS(v, adj, visited, stack);
	       }
	    }
	    
	    // now node has been completed their path so store its node 
        //so at the end while poping out from stack this node will come out first as u and then its neighbours as v 
	    stack.push(u);
	}
}

class Pair{
    int v;
    int wt;
    
    public Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
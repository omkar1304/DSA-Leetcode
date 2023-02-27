// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1


/* Using Prims Algp -> */
class Solution{
    // Minimum Spanning Tree -> tree with n node and it should have n-1 edge with minimum total cost
    // to find this we can use Prim's Algo 
    
    
	static int spanningTree(int n, int e, int edge[][]){
	    
	    // creating adj list from edge array
	    List<List<Pair>> adj = new ArrayList<>();
	    for(int i=0; i<n; i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0; i<e; i++){
	        adj.get(edge[i][0]).add(new Pair(edge[i][1], edge[i][2]));
	        adj.get(edge[i][1]).add(new Pair(edge[i][0], edge[i][2]));
	    }
	    
	    // created visited array to keep track of visited node
	    int[] visited = new int[n];
	    
	    // creating PQ with min heap as we need to keep minimum dist at top
	    PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
	    // adding starting node with 0 wt and -1 as parent
	    pq.offer(new Tuple(0, 0, -1));
	    
	    int sum = 0;
	    
	    while(!pq.isEmpty()){
	        
	        // pop out element from pq 
	        int wt = pq.peek().wt;
	        int node = pq.peek().node;
	        int parent = pq.peek().node;
	        
	        pq.poll();
	        
	        // if current node already visited then skip 
	        if(visited[node] == 1){
	            continue;
	        }
	        
	        // else add its weight in sum and mark it as visited
	        sum = sum + wt;
	        visited[node] = 1;
	        
	        // check for its neighbours
	        for(Pair pair : adj.get(node)){
	            
	            int v = pair.node;
	            int vwt = pair.wt;
	            
	            // if neighbours not visited then only add in PQ
	            if(visited[v] == 0){
	                // NOTE : in Prim's algo do no mark neighbour node visited here
	                pq.offer(new Tuple(vwt, v, node));
	            }
	        }
	    }
	    
	    // return calculate sum
	    return sum;
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

class Tuple {
    
    int wt;
    int node;
    int parent;
    
    public Tuple(int wt, int node, int parent){
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

/* Using Kruskal's + DSU Algp -> */

class Solution{
    
    // Kruskal's algo -> create edge -> (u, v, wt) and store all edges in list and sort list based on edge in ascending order
    // now take edge one by one and check if both u and v elongs to same component or not using DSU(here we are building tree based on edge)
    // if same then ignore else update wt in sum to get minimum sum from MSP and also update size in DSU
    // why sort ? so we can store minimum wt at start to connect u and v
    
    
	static int spanningTree(int n, int e, int adj[][]){
	    
	    List<Edge> edges = new ArrayList<>();
	    for(int i=0; i<e; i++){
	        int u = adj[i][0];
	        int v = adj[i][1];
	        int wt = adj[i][2];
	        
	        Edge temp = new Edge(u, v, wt);
	        edges.add(temp);
	    }
	    
	    DSU dsu = new DSU(n);
	    
	    Collections.sort(edges);
	    
	    int sum = 0;
	    
	    for(int i=0; i<edges.size(); i++){
	        
	        int u = edges.get(i).src;
	        int v = edges.get(i).dest;
	        int wt = edges.get(i).weight;
	        
	        if(dsu.findUPar(u) != dsu.findUPar(v)){
	            sum = sum + wt;
	            dsu.unionBySize(u, v);
	        }
	        
	    }
	    
	    return sum;
	}
}

class DSU {
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n){
        
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    
    public void unionBySize(int u, int v){
        
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge>{
    
    int src;
    int dest;
    int weight;
    
    public Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
    
}
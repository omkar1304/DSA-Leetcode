// https://leetcode.com/problems/find-if-path-exists-in-graph/

// DFS -> 148 ms
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] visited = new int[n];
        
        return DFS(source, destination, adj, visited);
    }
    
    public boolean DFS(int node, int dest, List<List<Integer>> adj, int[] visited){
        
        visited[node] = 1;
        
        if(node == dest)
            return true;
        
        for(Integer it : adj.get(node)){
            
            if(visited[it] == 0)
                
                if(DFS(it, dest, adj, visited) == true)
                    return true;
        }
        
        return false;
    }
}

// BFS -> 65 ms
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(source);
        visited[source] = 1;
        
        while(!queue.isEmpty()){
            
            int node = queue.peek();
            queue.poll();
            
            if(node == destination)
                return true;
            
            for(Integer it : adj.get(node)){ 
                if(visited[it] == 0){   
                    queue.offer(it);
                    visited[it] = 1; 
                }
            }
        }
        
        return false;
    }
}

// DSU -> 49 ms
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        DSU dsu = new DSU(n);
        
        for(int i=0; i<edges.length; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            // connecting node u and v using union by size method of DSU
            dsu.unionBySize(u, v);
        }
        
        // to make sure source and destination node updated with theit ultimate parent
        int parent1 = dsu.findUPar(source);
        int parent2 = dsu.findUPar(destination);

        // if ultimate parent same then its connected else not
        return parent1 == parent2;
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
        
        if(node == parent.get(node))
            return node;
        
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        
        return ulp;
    }
    
    public void unionBySize(int u, int v){
        
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v)
            return;
        
        else if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
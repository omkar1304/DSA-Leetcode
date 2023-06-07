// https://practice.geeksforgeeks.org/problems/number-of-provinces/1
//https://leetcode.com/problems/number-of-provinces/


// using DFS ->
class Solution {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        // This function does DFS on graph
        visited[node] = 1;
        
        for(int neighbour : adjList.get(node)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adjList, visited);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        // converting adj matrix to adj list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(adj.get(i).get(j) == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        // creating visited array to keep track of visited node
        int[] visited = new int[n];
        // keeping counter to count no of components in entire graph
        int count = 0;
        for(int i=0; i<n; i++){
            // for every DFS start node will be not-visited. 
            // so we can inc count by 1 as we found one component and DFS will mark all nodes which are connected to start node
            // if next time if we get any not visited node then it must of start of another component hence inc count by 1
            if(visited[i] == 0){
                count = count + 1;
                dfs(i, adjList, visited);
            }
        }
        
        return count;
    }
};

// using BFS ->
class Solution {
    public int findCircleNum(int[][] edges) {
        
        int n = edges.length;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(edges[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int[] visited = new int[n];
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            
            if(visited[i] == 0){
                visited[i] = 1;
                count++;
                
                queue.offer(i);
                
                while(!queue.isEmpty()){
                    
                    int node = queue.poll();
                    
                    for(int neighbor : adj.get(node)){
                        if(visited[neighbor] == 0){
                            visited[neighbor] = 1;
                            queue.offer(neighbor);
                        }
                            
                    }
                }
            }
        }
        
        return count;
    }
}

// Using DSU(Disjoint union set) ->
class Solution {
    public int findCircleNum(int[][] edges) {
        
        int n = edges.length;
        
        // creating object of DSU class
        DSU dsu = new DSU(n);
        
        // checking for edge between i and j
        for(int i=0; i<n; i++){
            
            for(int j=i+1; j<n; j++){ // here skipping visited edge i -> j so we dont need to go again with j -> i and also itself j -> j
                
                // if there is edge then we have to update parent, size, count in DSU
                if(edges[i][j] == 1)
                    
                    dsu.unionBySize(i, j);
            }
        }
        
        // at the end return DSU count
        return dsu.count;

        // alternate -> we can also check no of provinces using parent list. if i == parent.get(i) then it will different compoent so we can take count of how many ndes satisfy this condition and we can return count
    }
}
class DSU {
    
    int count = 0;
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DSU(int n){
        
        // initially every node is consider as single component
        count = n;
        
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
        
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        
        count--;
    }
}
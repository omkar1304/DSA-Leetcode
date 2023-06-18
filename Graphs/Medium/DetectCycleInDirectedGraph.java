// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1


// DFS ->
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        
        // creating visited array to keep track of nodes
        int[] visited = new int[n];
        // creating path visited array as its directed graph so keep track of visited nodes under particular path
        int[] pathVisited = new int[n];
        
        // running for loop for component of graph
        for(int i=0; i<n; i++){
            
            // if node visited then apply DFS else leave it
            if(visited[i] == 0){
                
                // if it returns true then we found cycle hence return true 
                if(DFS(i, adj, visited, pathVisited) == true){
                    return true;
                }
            }
        }
        
        // if everything is fine then return false as we didnt find any cycle
        return false;
    }
    
    public boolean DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited){
        // as soon as we apply DFS to any node mark them as visited and pathvisited
        visited[node] = 1;
        pathVisited[node] = 1;
        
        for(int neighbour : adj.get(node)){
            
            // if not visited then apply DFS to its neighbour
            if(visited[neighbour] == 0){
                
                // if that is true then there is cycle hence return true
                if(DFS(neighbour, adj, visited, pathVisited) == true){
                    return true;
                }
            }
            
            // if both visited and pathvisited == 1 then its cycle hence return true
            else if(pathVisited[neighbour] == 1){
                return true;
            }
        }
        
        // mark its as path unvisited for future paths
        pathVisited[node] = 0; // backtracking 
        
        // if everything is fine then return false as we didnt find any cycle
        return false;
    }
}

// BFS ->
class Solution {
    // As we know topoligcal sort only applicable when graph is DAG if not then in topo array all nodes will not cover
    // hence if count == no of nodes then there is no cycle else there is cycle
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        
        // Creating inDegree array to store no of incoming edges to node
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int neighbour : adj.get(i)){
                inDegree[neighbour] = inDegree[neighbour] + 1;
            }
        }
        
        // queue to store node which having inDegree value 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        // instead of topo array we can use counter
        int count = 0;
        while(!queue.isEmpty()){
            
            int node = queue.peek();
            queue.poll();
            count++;
            
            for(int neighbour : adj.get(node)){
                
                // reduce count of inDegree of neighbour by 1 (remove one edge)
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                // if it becomes 0 then add in queue else continue
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
        
        // if count is same as no of nodes then there is no cycle else there is cycle
        return count == n ? false : true;
    }
}
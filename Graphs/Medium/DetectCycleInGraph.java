// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1


// BFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // this is for if graph is given in components
        int[] visited = new int[n];
        for(int index=0; index<n; index++){
            
            if(visited[index] == 0){
                // if cycle detected then return true
                if(BFS(index, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean BFS(int src, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
        // store source node with its parent in queue
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, -1));
        // and mark source node as visited
        visited[src] = 1;
        
        while(!queue.isEmpty()){
            // take out current node and parent node
            int currNode = queue.peek().node;
            int parentNode = queue.peek().parent;
            
            queue.poll();
            
            for(int neighbour : adj.get(currNode)){
                
                // checking for its neighbours
                
                // if its not visited then mark it as visited and add in queue
                if(visited[neighbour] != 1){
                    visited[neighbour] = 1;
                    queue.offer(new Pair(neighbour, currNode));
                }
                
                // if its visited then check that current node is coming from that neighbour node or not
                // if its coming from them thats why it is visited
                // if not then some other node visited that so its cycle hence return true
                else if(parentNode != neighbour){
                    return true;
                }
            }
        }
        
        // else return false
        return false;
    }
}
class Pair{
    int node;
    int parent;
    
    public Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

// DFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // this is for if graph is given in components
        int[] visited = new int[n];
        for(int index=0; index<n; index++){
            
            if(visited[index] == 0){
                // if cycle detected then return true
                if(DFS(index, -1, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
        visited[node] = 1;
        
        for(int neighbour : adj.get(node)){
            if(visited[neighbour] == 0){
                if(DFS(neighbour, node, adj, visited)){
                    return true;
                }
            }
            
            else if(parent != neighbour){
                return true;
            }
        }
        
        return false;
    }
}
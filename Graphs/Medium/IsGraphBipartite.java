// https://leetcode.com/problems/is-graph-bipartite/


// BFS ->
class Solution {
    // (directed) and (undirected graph with even cycle length) is always bipartite graph else not.
    // Simple bipartite means if we want to color a node using two colors then adjacent node should not have same color.

    public boolean isBipartite(int[][] matrix) {
        
        // taking no of nodes in graph
        int n = matrix.length;
        
        // making visited array which will act as color array
        // -1 : no color, 0 : color1, 1 : color1
        int[] visited = new int[n];
        for(int i=0; i<n; i++)
            // marking all nodes to as no color
            visited[i] = -1;
        
        // running for loop to handle component case in graph
        
        for(int i=0; i<n; i++){
            // if not visited then apply BFS on it
            if(visited[i] == -1){
                // if at any node we get that adjcent color is same return false as its not bipartite graph
                if(BFS(i, n, matrix, visited) == false)
                    return false;
            }
        }
        
        // if everything is fine then its bipartite graph
        return true;
    }
    
    public boolean BFS(int startNode, int n, int[][] matrix, int[] visited){
        
        // create Queue and add start node to it and color it with 0 
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = 0;
        
        while(!queue.isEmpty()){
            
            // polling out current node
            int node = queue.peek();
            queue.poll();
            
            for(int neighbour : matrix[node]){
                
                // if its not visited then add in queue and give opposite color of current node to maintain bipartite property
                if(visited[neighbour] == -1){
                    queue.offer(neighbour);
                    visited[neighbour] = visited[node] == 0 ? 1 : 0 ;
                }
                
                // if its visited and neighbour color == current node color then its not bipartite.
                else if(visited[neighbour] == visited[node])
                    return false;
            }
        }
        
        // if everything is fine then its bipartite graph
        return true;
    }
}

// DFS ->
class Solution {
    // (directed) and (undirected graph with even cycle length) is always bipartite graph else not
    public boolean isBipartite(int[][] matrix) {
        
        // taking no of nodes in graph
        int n = matrix.length;
        
        // making visited array which will act as color array
        // -1 : no color, 0 : color1, 1 : color1
        int[] visited = new int[n];
        for(int i=0; i<n; i++)
            // marking all nodes to as no color
            visited[i] = -1;
        
        // running for loop to handle component case in graph
        
        for(int i=0; i<n; i++){
            // if not visited then apply BFS on it
            if(visited[i] == -1){
                // if at any node we get that adjcent color is same return false as its not bipartite graph
                if(DFS(i, -1, n, matrix, visited) == false)
                    return false;
            }
        }
        
        // if everything is fine then its bipartite graph
        return true;
    }
    
    public boolean DFS(int startNode, int parentNode, int n, int[][] matrix, int[] visited){
        
        // if its start node if component then we can give any color for exmple 0
        if(parentNode == -1)
            visited[startNode] = 0;
        // if its not start node then its should be colored with opposite with its parent/adj 
        else
            visited[startNode] = visited[parentNode] == 0 ? 1 : 0;
        
        for(int neighbour : matrix[startNode]){
            
            // if not visited then apply DFS and check if its returning false then return false immediaetly 
            if(visited[neighbour] == -1){
                if(DFS(neighbour, startNode, n, matrix, visited) == false)
                    return false;
            }
            
            // if its visited and neighbour color == current node color then its not bipartite.
            else if(visited[neighbour] == visited[startNode])
                return false;
        }
        
        // if everything is fine then its bipartite graph
        return true;
    }
}
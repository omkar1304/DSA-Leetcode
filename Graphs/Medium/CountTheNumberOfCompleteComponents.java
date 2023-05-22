// https://leetcode.com/problems/count-the-number-of-complete-components/

class Solution {
    
    // globally defining edge and vertex count
    int edge = 0;
    int vertex = 0;
    
    public int countCompleteComponents(int n, int[][] edges) {
        
        // to return count of complete component
        int resultCount = 0;
        
        // converting edge into adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // to keep track of visited node
        int[] visited = new int[n];
        // to keep count of previously count of visited node
        int prevVisitedCount = 0;
        
        for(int i=0; i<n; i++){
            
            if(visited[i] == 0){
                
                // to keep track of all visited node count in visited array
                int VisitedCount = 0;
                
                // apply DFS to mark component as visited
                dfs(i, adj, visited);
                
                // after completing DFS we can get total count of visited nodes 
                for(int j=0; j<n; j++){
                    if(visited[j] == 1)
                        VisitedCount++;
                }
                
                // now with help of prev count we can get count of current visited node in DFS
                vertex = VisitedCount - prevVisitedCount;
                // update previous count with total visited count for next component
                prevVisitedCount = VisitedCount;
                
                // if its complete component then inc result counter by 1
                // why edge/2 ? as its undirected graph so it for 1 to 2 it will store edge count as 2 hence divide egde by 2 to make it directed edge for count
                if(isComplete(vertex, edge/2))
                    resultCount++;
                
                // reseting edge counter for next component cycle
                edge = 0;
            }
        }
        
        return resultCount;
    }
    
    public void dfs(int node, List<List<Integer>> adj, int[] visited){
        
        // mark node as visited
        visited[node] = 1;
        
        // in compoent we can get no of edges using adj list of that node in component
        edge = edge + adj.get(node).size();
        
        // apply DFS to its neighbours
        for(int neighbour : adj.get(node)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adj, visited);
            }
        }
        
    }
    
    public boolean isComplete(int vertex, int edge){
        
        // A connected component is complete if and only if the number of edges in the component is equal to vertex*(vertex-1)/2
        int ans = vertex * (vertex - 1) / 2;
        return ans == edge;
    }
}
// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

class Solution {
    public int minReorder(int n, int[][] edges) {
        
        // here we have given directed graph so we can convert this DG to UG in adj. if there is edge from a to b then we will store as it is but for b to a we will store negative value. as we know we have to reach 0 here so all path must be in forward direction towards 0 node. so here we are storing UG because we want to reach every node from 0 to perform DFS. if we see any positive edge from 0 to that node then we have to reverse it.
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(-edge[0]);
        }
        
        // to keep track of visited node
        int[] visited = new int[n];
        
        return DFS(0, visited, adj);
    }
    
    public int DFS(int node, int[] visited, List<List<Integer>> adj){
        
        // mark them as visited and intialize the count
        visited[node] = 1;
        int count = 0;
        
        for(Integer it : adj.get(node)){
            
            // child node is not visited then proceed 
            if(visited[Math.abs(it)] == 0)
                
                // check count for further childeren using DFS and also add 1 if that node is positive 
                // i.e. if positive node is reachable via 0 then that edge has be reversed hence add 1
                count = count + DFS(Math.abs(it), visited, adj) + (it > 0 ? 1 : 0);
        }
        
        // return updated count
        return count;
    }
}
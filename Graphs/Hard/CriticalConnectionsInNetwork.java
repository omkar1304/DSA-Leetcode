// https://leetcode.com/problems/critical-connections-in-a-network/

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // creating adj list from connections list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] visited = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        
        List<List<Integer>> bridges = new ArrayList<>();
        
        // calling DFS ->
        DFS(0, -1, adj, visited, time, low, 0, bridges);
        
        return bridges;
    }
    
    public void DFS(int node, int parent, List<List<Integer>> adj, int[] visited, int[] time, int[] low, int timer, List<List<Integer>> bridges){
        
        // mark node as visited
        visited[node] = 1;
        // currently time to react at node is timer and low also same untill its neighnour complete their DFS
        time[node] = timer;
        low[node] = timer;
        
        for(Integer it : adj.get(node)){
            
            // if neighbour node is parent then dont consider as its low[parent] always going to be less than low[node] so it will affect result
            if(it == parent)
                continue;
            
            // if neighbour its not parent and not visited then apply DFS
            else if(visited[it] == 0){
                DFS(it, node, adj, visited, time, low, timer+1, bridges);
                
                // once we done with neighbour node DFS then check for its low and update min of low of node, neighbour
                low[node] = Math.min(low[node], low[it]);
                
                // now we need to check if we remove this edge -> node --- neighbour then graph will break into two or more components
                // we can determine using logic -> if we remove edge between neighbour and node then also there is another path which connects node and neighbour then its note bridge(critical connection) else it is bridge.
                // suppose if node is 8 then its position(time array) will be 8 only so if low[neighbour] is greater than position of node then its indicate that neighbour node cant reach back to node as its lowest is after the node postion.
                if(low[it] > time[node])
                    bridges.add(Arrays.asList(it, node));
            }
            
            // if its not parent and its visited then just check of low time and update it
            else 
                low[node] = Math.min(low[node], low[it]);
        }
        
    }
}
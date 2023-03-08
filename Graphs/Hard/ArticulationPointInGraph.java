// https://practice.geeksforgeeks.org/problems/articulation-point-1/1

class Solution
{   
    int timer = 1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        
        for(int i=0; i<n; i++){
            
            if(visited[i] == 0){
                
                DFS(i, -1, adj, visited, time, low, mark);
                
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mark[i] == 1){
                result.add(i);
            }
        }
        
        if(result.size() == 0){
            result.add(-1);
        }
        
        return result;
    }
    
    public void DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] time, int[] low, int[] mark){
        
        visited[node] = 1;
        time[node] = timer;
        low[node] = timer;
        timer++;
        
        int child = 0;
        
        for(Integer it : adj.get(node)){
            
            if(parent == it)
                continue;
                
            else if(visited[it] == 0){
                DFS(it, node, adj, visited, time, low, mark);
                
                low[node] = Math.min(low[node], low[it]);
                
                if(low[it] >= time[node] && parent != -1)
                    mark[node] = 1;
                    
                child++;
            }
            
            else 
                low[node] = Math.min(low[node], time[it]);
                
            if(child > 1 && parent == -1)
                mark[node] = 1;
                
        }
        
    }
   
}
// https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        // creating dest node and path, result list as per requirement
        int dest = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        // adding start node in path
        path.add(0);
        DFS(0, dest, graph, path, result);
        
        // return updated result
        return result;
    }
    
    public void DFS(int src, int dest, int[][] graph, List<Integer> path, List<List<Integer>> result){
        
        // if src node is dest node then we have completed the path hence add in result and return
        if(src == dest){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // else check for its neighbours and add in path and apply DFS to them
        for(int neighbour : graph[src]){
            
            path.add(neighbour);
            DFS(neighbour, dest, graph, path, result);
            path.remove(path.size() - 1); // backtracking
            
        }

    }
}
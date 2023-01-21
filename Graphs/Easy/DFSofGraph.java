// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        // creating result to store DFS nodes
        ArrayList<Integer> result = new ArrayList<>();
        // creating visited array so every node should visit only once
        int[] visited = new int[n];
        
        // starting from 0th node
        int start = 0;
        
        helper(adj, result, visited, start);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, int[] visited, int node){
        
        // once we have one node then we can mark it as visited and also add in result
        visited[node] = 1;
        result.add(node);
        
        // now lets apply DFS to their neighbours if not visited already
        for(Integer neighbour : adj.get(node)){
            if(visited[neighbour] == 0){
                helper(adj, result, visited, neighbour);
            }
        }
    }
}
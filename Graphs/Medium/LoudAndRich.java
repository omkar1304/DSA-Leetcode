// https://leetcode.com/problems/loud-and-rich/

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        
        // creating reverse adj list from richer array to apply DFS
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<richer.length; i++)
            adj.get(richer[i][1]).add(richer[i][0]);
        
        // intially adding -1 to all node values in result array
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        // apply DFS to every node
        for(int i=0; i<n; i++)
            DFS(i, adj, quiet, result);
        
        return result;
        
    }
    
    public int DFS(int node, List<List<Integer>> adj, int[] quiet, int[] result){
        
        // if node value in result is -1 then only we have to apply DFS else we can retrun already computed value 
        if(result[node] == -1){
            
            // adding node value in result as node so if there is no DFS further then it will consider itself as quiet node
            result[node] = node;
            
            // check for neighbours
            for(Integer neighbour : adj.get(node)){
                
                // and get the last most node in DFS path
                int current = DFS(neighbour, adj, quiet, result);
                
                // check if last node in path has less quiet value than quiet value of node value in result if yes then update it
                if(quiet[current] < quiet[result[node]])
                    result[node] = current;
            }
        }
        
        // return node value in result array
        return result[node];
    }
}
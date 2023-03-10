// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

class Solution {
    /*
    in-degree:
    number of edges going into a node
    If there is no edges coming into a node its a start node and has to be part of the solution set

    out-degree:
    number of edges coming out of a node
    */
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        
        // get the edge(u -> v) from edges array and mark indegree of v as 1 i.e. it can be reached via some other node so it should not be in result set
        for(List<Integer> edge : edges)
            indegree[edge.get(1)] = 1;
        
        // now just check if indegree is 0 then that node can be reached to itself so add in  result. rest can be reached through some nodes
        for(int i=0; i<n; i++){
            
            if(indegree[i] == 0)
                result.add(i);
        }
        
        return result;
    }
}
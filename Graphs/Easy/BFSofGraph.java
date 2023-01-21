// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // creating result to store BFS nodes
        ArrayList<Integer> result = new ArrayList<>();
        // creating visited array so every node should visit only once
        int[] visited = new int[n];
        // creating queue to peform BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // adding starting node in queue and marking as visited
        queue.offer(0);
        visited[0] = 1;
        
        while(!queue.isEmpty()){
            // polling out node from queue and add in result.
            Integer node = queue.poll();
            result.add(node);
            
            // after that just add its neighbours if not visited already
            for(Integer neighbour : adj.get(node)){
                if(visited[neighbour] == 0){
                    queue.offer(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }
        
        // at the end return result
        return result;
    }
}
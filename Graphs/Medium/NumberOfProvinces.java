// https://practice.geeksforgeeks.org/problems/number-of-provinces/1

class Solution {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        // This function does DFS on graph
        visited[node] = 1;
        
        for(int neighbour : adjList.get(node)){
            if(visited[neighbour] == 0){
                dfs(neighbour, adjList, visited);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        // converting adj matrix to adj list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(adj.get(i).get(j) == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        // creating visited array to keep track of visited node
        int[] visited = new int[n];
        // keeping counter to count no of components in entire graph
        int count = 0;
        for(int i=0; i<n; i++){
            // for every DFS start node will be not-visited. 
            // so we can inc count by 1 as we found one component and DFS will mark all nodes which are connected to start node
            // if next time if we get any not visited node then it must of start of another component hence inc count by 1
            if(visited[i] == 0){
                count = count + 1;
                dfs(i, adjList, visited);
            }
        }
        
        return count;
    }
};
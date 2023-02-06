// https://practice.geeksforgeeks.org/problems/topological-sort/1


 // Topo sort -> store all nodes in sequence such that if there is edge between u -> v then u comes before v
// topo sort only applicable for DAG(Directed Acyclic Graph)

// DFS ->
class Solution
{
   
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        // creating visited array to keep track of nodes
        int[] visited = new int[n];
        // to store node in toplogical sort
        Stack<Integer> stack = new Stack<>();
        
        // running for loop for component of graph
        for(int i=0; i<n; i++){
            
            if(visited[i] == 0){
                
                DFS(i, adj, visited, stack);
            }
        }
        
        // creating result array to store node from stack in topo sort
        int[] result = new int[n];
        int i = 0;
        
        while(!stack.isEmpty()){
            
            result[i] = stack.peek();
            stack.pop();
            i++;
        }
        
        return result;
    }
    
    static void DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack){
        // mark it as visited
        visited[node] = 1;
        
        // check its neighbours if not visited then apply DFS
        for(int neighbour : adj.get(node)){
            if(visited[neighbour] == 0){
                DFS(neighbour, adj, visited, stack);
            }
        }
        
        // now node has been completed their path so store its node 
        //so at the end while poping out from stack this node will come out first as u and then its neighbours as v
        stack.push(node);
    }
}


// BFS ->
class Solution
{
    // Topo logical sort using BFS -> Kahn's Algo
    // Step 1: Create inDegree(number of incoming edges) array for every node 
    // Step 2: add node which having 0 indegree value
    // Step 3: run while loop till queue becomes empty and as soon as we pop out element from queue add into topo array
    // Step 4: and check its neighbours and reduce inDegree count of it by 1 and check if it becomes 0 then add in queue.
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {   
        // Creating inDegree array to store no of incoming edges to node
        int[] inDegree = new int[n];
        
        for(int i=0; i<n; i++){
            for(int neighbour : adj.get(i)){
                inDegree[neighbour] = inDegree[neighbour] + 1;
            }
        }
        
        // queue to store node which having inDegree value 0
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        // creating result array to store nodes in topological order
        int[] result = new int[n];
        int index=0;
        
        while(!queue.isEmpty()){
            
            // pop out node from queue and add in result array and inc index by 1 for next index
            int node = queue.peek();
            queue.poll();
            result[index] = node;
            index++;
            
            for(int neighbour : adj.get(node)){
                
                // reduce count of inDegree of neighbour by 1 (remove one edge)
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                // if it becomes 0 then add in queue else continue
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
            
        }
        
        // at the end return topo array 
        return result;
    }
}

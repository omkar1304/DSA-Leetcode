// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

class Solution

// Strongly Connected Components -> suppose the there is node 1 and 2 which can be reach via both i.e 1 to 2 and 2 to 1 so this SCC.
// SCC only works with Directed graph. A single node can be consider as SCC if its not reachable via any node in graph
// we can use Kosaraju's Alg to count no of SCC or print SCC
// Step 1 : sort the node according to finishing time i.e start from 0 node and apply DFS once we reached at terminal point which leaf point in tree we can store in stack
// step 2 : reverse the graph(reverse all edges)
// step 3 : Now using stack we can pop out nodes and apply same DFS on component and count comonents as no of times we call DFS for start node


// why we reversing graph here? so suppose we call DFS on given graph then we might end up with visiting all nodes
// so we need some edge that tells us this break edge where two SCC can be split.
// so we know that in SCC even if reverse edge then it doesnt gonna affect on nodes for example suppose we have SCC of node 1 and 2 so we have 2 edges 1-> 2 and 2 -> 1 so even if we reverse it will stay same
// but for rest we can get break edgees which are single SCC so we can indetify no of SCC

{
    public void DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack){
        visited[node] = 1;
        
        for(int neighbour : adj.get(node)){
            
            if(visited[neighbour] == 0)
                DFS(neighbour, adj, visited, stack);
        }
        
        stack.push(node);
    }
    
    public void DFS2(int node, ArrayList<ArrayList<Integer>> adjT, int[] visited){
        visited[node] = 1;
        
        for(int neighbour : adjT.get(node)){
            
            if(visited[neighbour] == 0)
                DFS2(neighbour, adjT, visited);
        }
    }
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // step 1 -> sort the node according to finishing time
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<n; i++){
            
            if(visited[i] == 0){
                
                DFS(i, adj, visited, stack);
            }
        }
        
        // step 2 -> reverse the graph(reverse all edges)
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjT.add(new ArrayList<>());
            
        for(int i=0; i<n; i++){
            
            for(int neighbour : adj.get(i)){
                
                adjT.get(neighbour).add(i);
            }
        }
        
        // step 3 ->Now using stack we can pop out nodes and apply same DFS on component and count comonents as no of times we call DFS for start node
        Arrays.fill(visited, 0); // to reuse visited array
        int count = 0;
        while(!stack.isEmpty()){
            
            int node = stack.pop();
            if(visited[node] == 0){
                DFS2(node, adjT, visited);
                count++;
            }
        }
        
        return count;
    }
}
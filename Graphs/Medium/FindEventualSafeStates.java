// https://leetcode.com/problems/find-eventual-safe-states/


// DFS ->
class Solution {
    // nodes are safe node if they are not part of cycle or their path not going to cycle
    public List<Integer> eventualSafeNodes(int[][] adj) {
        
        int n = adj.length;
        
        // creating visited array to keep track of nodes
        int[] visited = new int[n];
        // creating path visited array as its directed graph so keep track of visited nodes under particular path
        int[] pathVisited = new int[n];
        // creating array to check nodes are safe. if 0 -> not safe node | 1 -> safe node
        int[] checked = new int[n];
        
        // running for loop for component of graph
        for(int i=0; i<n; i++){
            
            // if node visited then apply DFS else leave it
            if(visited[i] == 0)
                DFS(i, adj, visited, pathVisited, checked);
        }
        
        // after applying DFS to all nodes we will get checked array filled. store into result list which are having value 1
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(checked[i] == 1)
                result.add(i);
        }
        
        // return list
        return result;
    }
    
    public boolean DFS(int node, int[][] adj, int[] visited, int[] pathVisited, int[] checked){
        
        // as soon as we apply DFS to any node mark them as visited and pathvisited
        visited[node] = 1;
        pathVisited[node] = 1;
        // as of now we are considering it as not safe node(default condition)
        checked[node] = 0;
        
        for(int neighbour : adj[node]){
            
            // if not visited then apply DFS to its neighbours
            if(visited[neighbour] == 0){
                // if that is true then there is cycle hence return true. so all nodes which are part of cycle will become remains checked = 0
                if(DFS(neighbour, adj, visited, pathVisited, checked) == true) 
                    return true;
            }
            
            // if both visited and pathvisited == 1 then its cycle hence return true
            else if(pathVisited[neighbour] == 1)
                return true;
        }
        
        // if not then its not part of cycle hence we can mark it as checked = 1 (safe node)
        pathVisited[node] = 0; // backtracking 
        checked[node] = 1;
        
        // and we didnt find any cycle hence return false
        return false;
    }
}

// BFS ->
class Solution {
    public List<Integer> eventualSafeNodes(int[][] matrix) {
        
        int n = matrix.length;
        
        // creating reverse of adj list so that insteand of going safe node to terminal we can go terminal node to safe node as we know terminal node is always going to be safe node
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjRev.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            for(int neighbour : matrix[i]){
                adjRev.get(neighbour).add(i);
            }
        }
        
        // Creating inDegree array to store no of incoming edges to node
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int neighbour : adjRev.get(i)){
                inDegree[neighbour] = inDegree[neighbour] + 1;
            }
        }
        
        // creating result to store safe nodes
        // queue to store node which having inDegree value 0
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            // pop out node which having 0 inDegree value so its safe node add in result and check for its neighbours
            int node = queue.peek();
            queue.poll();
            result.add(node);
            
            for(int neighbour : adjRev.get(node)){
                
                 // reduce count of inDegree of neighbour by 1 (remove one edge)
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                 // if it becomes 0 then add in queue else continue
                if(inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        
        // sort result as per requirement and return it
        Collections.sort(result);
        return result;
    }
}
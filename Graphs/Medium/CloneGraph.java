// https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    // To keep track of all newly created node
    Node[] visited = new Node[101];
    
    public Node cloneGraph(Node node) {
        
        return DFS(node);
    }
    
    public Node DFS(Node node){
        
        // if node is null then return null
        if(node == null)
            return null;
        
        // if node is not visited then we have to create copy of it and same need to do it for its neighbours
        if(visited[node.val] == null){
            
            // creating newnode and adding it in visited array
            Node newNode = new Node(node.val);
            visited[node.val] = newNode;
            
            // now check for its neighbours
            for(Node neighbour : node.neighbors){
                
                Node newNeighbour = DFS(neighbour);
                newNode.neighbors.add(newNeighbour);
                
            }
            
            // and at the end return newnode
            return newNode;
        }
        
        // if copy of node is already created then return it
        else{
            return visited[node.val];
        }
    }
}
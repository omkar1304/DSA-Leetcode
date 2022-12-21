// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        // To store list of nodes in list 
        List<List<Integer>> result = new ArrayList<>();
        
        // if root is empty then return empty list
        if(root == null)
            return result;
        
        // creating queue to store node in level order manner
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            // to store nodes at each level
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                
                // polling out each node from queue
                Node tempNode = queue.poll();
                temp.add(tempNode.val);
                
                // and storing its next level nodes
                for(Node child : tempNode.children)
                    queue.offer(child);
            }
            
            // adding level nodes list in result
            result.add(temp);
        }
        
        return result;
    }
}
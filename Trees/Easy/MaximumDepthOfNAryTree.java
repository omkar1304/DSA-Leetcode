// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

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
    // we can solve this using level order traversal
    public int maxDepth(Node root) {
        // base case ->
        
        // if root is null then return 0 height
        if(root == null)
            return 0;
        
        // creating max to store max height of tree
        int max = 0;
        
        for(Node child : root.children)
            // checking if max is greater or children depth 
            max = Math.max(max, maxDepth(child));
        
        // adding 1 as need to count root node as well
        return 1 + max;
   
    }
}
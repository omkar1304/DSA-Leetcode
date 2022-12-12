// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // if root is null then return root as it is
        if(root == null)
            return root;
        
        // creating two pointers
        Node current = root;
        Node post = root.left;
        
        // if post points to null then stop. it means we reached leaf node level
        while(post != null){
            // connections ->
            
            // pointing left node next to right node
            current.left.next = current.right;
            // and right node next to next node left if present
            if(current.next != null)
                current.right.next = current.next.left;
            
            // updating current pointer to point right part of node
            current = current.next;
            // if right part doesnt exist then go to next level
            if(current == null){
                current = post;
                post = current.left;
            }
        }
        
        return root;
    }
}
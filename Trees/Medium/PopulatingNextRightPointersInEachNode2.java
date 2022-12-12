// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

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
        
        // keeping current pointer to iterate over tree
        Node current = root;
        // creating dummyNode which will hold next level of current
        Node dummyNode = new Node();
        // creating pre node to make connections
        Node pre = dummyNode;
        
        // if current == null then we reached the leaf node hence stop
        while(current != null){
            // condition 1 : if left child is present then make connection using pre and update pre
            if(current.left != null){
                pre.next = current.left;
                pre = pre.next;
            }
            
            // confition 2 : if right child is present then make connection using pre and update pre
            if(current.right != null){
                pre.next = current.right;
                pre = pre.next;
            }
            
            // now we have to update our current to right part 
            current = current.next;
            // if right part not exist then move to next level using dummmyNode and perform same operations
            if(current == null){
                pre = dummyNode;
                current = dummyNode.next;
                dummyNode.next = null;
            }
            
        }
        
        return root;
    }
}
// https://leetcode.com/problems/binary-tree-preorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // using recursion ->
    public void preOrderRec(TreeNode root, List<Integer> ans){
         // base case
        
        // if root is null then no need to add anything just return from here
        if(root == null)
            return;
        
        // preorder -> root | left | right 
        ans.add(root.val);
        preOrderRec(root.left, ans);
        preOrderRec(root.right , ans);
    }
    
    // using iterative ->
    public List<Integer> preOrderIter(TreeNode root){
        
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        // creating stack to store nodes 
        Stack<TreeNode> stack = new Stack<>();
        // pushing first root node in stack
        stack.push(root);
        while(!stack.empty()){
            // popout first node and add into list and push its left and right node if any
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        // for recursion  ->
            // List<Integer> ans = new ArrayList<>();
            // preOrderRec(root, ans);
            // return ans;
        
        // for iterative
        return preOrderIter(root);
        
        
    }

    // Morris Traversal | Preorder ->

    public List<Integer> inorderTraversal(TreeNode root) {
        
        // to store nodes in preorder manner
        List<Integer> result = new ArrayList<>();
        
        // starting from root node
        TreeNode current = root;
        
        while(current != null){
            
            // first we need to check if it has left ? if not then add root value in result and move to right
            if(current.left == null){
                result.add(current.val);
                current = current.right;
            }
            // if it has left then ->
            else{
                
                // first thing find its right most node in left subtree
                TreeNode tempNode = current.left;
                
                // keeping going down until we get rightmost node which either pointing to null OR
                // there is thread between rightmost node to current node
                while(tempNode.right != null && tempNode.right != current)
                    tempNode = tempNode.right;
                
                // if its pointing to null then make thread between rightmost node and current node
                // and again start iterating in left subtree and add in result
                if(tempNode.right == null){
                    tempNode.right = current;
                    result.add(current.val);
                    current = current.left;
                }
                // if there is already thread means we added all nodes in result list then remove thread
                // add current node in result and move its right part as we already done with left part
                else{
                    tempNode.right = null;
                    current = current.right;
                }
            }
        }
        
        return result;
    }
}
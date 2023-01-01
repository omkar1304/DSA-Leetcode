// https://leetcode.com/problems/increasing-order-search-tree/

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
    
    List<TreeNode> result = new ArrayList<>();
    
    public TreeNode increasingBST(TreeNode root) {
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // apply inorder traversal and fill result
        inorder(root);
        
        // pointer for head and iterater currrent
        TreeNode head = result.get(0);
        TreeNode current = result.get(0);
        
        for(int index=1; index<result.size(); index++){
            // attaching next node to current's right 
            current.right = result.get(index);
            // updating current to next node
            current = current.right;
            // marking next node's left as null
            current.left = null;   
            
        }
        
        // returning head of tree
        return head;
    }
    
    public void inorder(TreeNode root){
        
        if(root == null)
            return;
        
        inorder(root.left);
        result.add(root);
        inorder(root.right);
    }
}
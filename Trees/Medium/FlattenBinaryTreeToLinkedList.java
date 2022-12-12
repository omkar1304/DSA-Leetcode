// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
    public void flatten(TreeNode root) {
        
        // creating two pointer to itrate over tree
        TreeNode current = root;
        TreeNode prev = null;
        
        // we will continue untill we hit right most leaf node
        while(current != null){
            
            // if current.left is not null then in we have to connect leftsubtree's right most node to current.right
            if(current.left != null){
                prev = current.left;
                
                // for that we will go to last leaf node of left subtree
                while(prev.right != null)
                    prev = prev.right;
                
                // connections -> (draw picture and see)
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            
            // update the current pointer
            current = current.right;
            
        }
        
    }
}
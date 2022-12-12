// https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        // base case
        
        // if root is null then return as it is
        if(root == null)
            return root;
        
        // then go till left and right node and put pointers on left and right node respectively
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // just swap it 
        root.left = right;
        root.right = left;
        
        // return root node after inverting tree
        return root;
        
        
    }
}
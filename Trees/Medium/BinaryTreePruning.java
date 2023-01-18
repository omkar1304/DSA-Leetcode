// https://leetcode.com/problems/binary-tree-pruning/

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
    public TreeNode pruneTree(TreeNode root) {
        // if root is null then return null
        if(root == null)
            return null;
        
        // deletion operation -> always start from bottom to up -> postorder
        
        // get the left and right from bottom
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        // if both are null and root is 0 then this can be deleted so return null
        if(root.left == null && root.right == null && root.val == 0)
            return null;
        
        // else return root as it is
        return root;
    }
}
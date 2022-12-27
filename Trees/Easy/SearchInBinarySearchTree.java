// https://leetcode.com/problems/search-in-a-binary-search-tree/

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
    public TreeNode searchBST(TreeNode root, int val) {
        
        // if root is null then retrun null
        if(root == null)
            return null;
        
        // if root has same value as val then return root
        else if(root.val == val)
            return root;
        
        // if root has greater value then go to left tree
        else if(root.val > val)
            return searchBST(root.left, val);
        
        // if root has less value then go to right tree
        else
            return searchBST(root.right, val);
    }
}
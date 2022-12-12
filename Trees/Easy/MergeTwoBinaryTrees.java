// https://leetcode.com/problems/merge-two-binary-trees/

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // base case
        
        // if both root nodes are null then return null
        if(root1 == null && root2 == null)
            return null;
        
        // if root1 is null then return root2
        if(root1 == null)
            return root2;
        
        // if root2 is null then return root1
        if(root2 == null)
            return root1;
        
        // if both are not null then update their sum in root1 node
        root1.val = root1.val + root2.val;
        
        // and now do it same for its left and right part
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        // at the end return updated root1
        return root1;
        
    }
}
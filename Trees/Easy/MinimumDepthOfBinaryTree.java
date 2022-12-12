// https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    public int minDepth(TreeNode root) {
        
        // if root is null then height is 0
        if(root == null)
            return 0;
        
        // if root.left is null then min will return 0 value but thats not correct ans as tree might be present on right side so call function to move right side
        if(root.left == null)
            return 1 + minDepth(root.right);
        
        // same as above for root.right
        if(root.right == null)
            return 1 + minDepth(root.left);
        
        // if both are not null then return min out of it
        int left = minDepth(root.left);
        int right = minDepth(root.right); 
        
        return 1 + Math.min(left, right);
    }
}
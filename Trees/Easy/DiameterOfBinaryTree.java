// https://leetcode.com/problems/diameter-of-binary-tree/

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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // calling maximum depth of tree function which will return max height of tree only but it will update max value if it found at any particular node diamete is greater than max
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root){
        // base case
        
        // if root is null then height is 0
        if(root == null)
            return 0;
        
        // get the height of left subtree and right subtree
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // diameter -> combination of left subtree height + right subtree height
        max = Math.max(max, left+right);
        
        // And return max out of it with + 1 (as we need to include root heigth value)
        return 1 + Math.max(left, right);
    }
}
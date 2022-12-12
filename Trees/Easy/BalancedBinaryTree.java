// https://leetcode.com/problems/balanced-binary-tree/

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
    
    public boolean isBalanced(TreeNode root) {
        
        return maxDepth(root) == -1 ? false : true;
    }
    
    public int maxDepth(TreeNode root){
        // we know that height of tree will always be 0 or greater than 0 it never be -1 
        // so if we get absoulte diff is more than 1 then we will imeediately return -1
        // and that recursive call might be for left or right so will check if left or right -1 or not
        
        // base case
        
        // if root is null then return height 0
        if(root == null)
            return 0;
        
        // calculate same for left and right
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        // if left or right gets -1 then its left or right subtree is not balanaced hence return -1 0R if that not case then check if their right and left subtree diff is greater than 1 or not if yes return -1
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        
        // else normally return max height from left and right
        return 1 + Math.max(left, right);
    }
}
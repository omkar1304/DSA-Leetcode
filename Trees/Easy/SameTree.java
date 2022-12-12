// https://leetcode.com/problems/same-tree/

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
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        // base case
        
        // if both roots are null then return true 
        if(root1 == null && root2 == null)
            return true;
        
        // if root1 is null and root2 is not then return false
        if(root1 == null && root2 != null)
            return false;
        
        // if root2 is null and root1 is not then return false
        if(root1 != null && root2 == null)
            return false;
        
        // else we have to check three conditions ->
        // 1. check both node value same or not
        // 2. both leftsubtree is same or not
        // 3. both rightsubtree is same or not
        boolean isSame = (root1.val == root2.val);
        boolean isLeft = isSameTree(root1.left, root2.left);
        boolean isRight = isSameTree(root1.right, root2.right);
        
        // return their value 
        return (isSame && isLeft && isRight);
        
    }
}
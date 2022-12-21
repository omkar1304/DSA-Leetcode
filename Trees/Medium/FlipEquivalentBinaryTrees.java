// https://leetcode.com/problems/flip-equivalent-binary-trees/

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // base case 
        
        // if both root is null then its equivalent hence return true
        if(root1 == null && root2 == null)
            return true;
        
        // if any root node is null then return false
        if(root1 == null || root2 == null)
            return false;
        
        // if both are not null but their value is not same then return false
        if(root1.val != root2.val)
            return false;
        
        // else check if root1.left & root2.left are matching and also root1.right & root2.right are matching if yes then return true
        if(flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
            return true;
        
        // else we are allowed to swap then check in reverse match
        else if(flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
            return true;
        
        // if everything fails then return false
        else
            return false;
        
    }
}
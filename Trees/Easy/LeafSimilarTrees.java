// https://leetcode.com/problems/leaf-similar-trees/

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // get leaf string from both tree
        String str1 = helper(root1);
        String str2 = helper(root2);
    
        // check both string matching or not
        return str1.equals(str2);
    }
    
    public String helper(TreeNode root){
        // base case 
        
        // if root is null then return empty string 
        if(root == null)
            return "";
        
        // if root's left and right part is null then its leaf node so add value in string and return 
        if(root.left == null && root.right == null)
            return root.val + "->";
        
        // else get string from left and right
        return helper(root.left) + helper(root.right);
    }
}
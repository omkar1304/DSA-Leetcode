// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

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
    // creating global variable and storing min value in it
    int maxDiff = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        
        helper(root, root.val, root.val);
        return maxDiff;
    }
    
    public void helper(TreeNode root, int minAncestor, int maxAncestor){
        // base case ->
        
        // if root is null then path ended return it
        if(root == null)
            return;
        
        // Calculating and storing max value in maxDiff
        // we have equation like this -> v = | a - b | so to get max value of v -> a can be max or min as well
        // so we take both condition and take max out of it as follow 
        // Math.abs(minAncestor - root.val) ->  | a - b | where a is min      
        // Math.abs(maxAncestor - root.val) ->  | a - b | where a is max  
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(minAncestor - root.val), Math.abs(maxAncestor - root.val)));
        
        // for next left and right child calculating minAnc and maxAnc 
        minAncestor = root.val < minAncestor ? root.val : minAncestor;
        maxAncestor = root.val > maxAncestor ? root.val : maxAncestor;
        
        // Calling left subtree and right subtree
        helper(root.left, minAncestor, maxAncestor);
        helper(root.right, minAncestor, maxAncestor);
        
    }
}
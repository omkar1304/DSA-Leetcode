// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

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
    
    int maxLength = 0;
    
    public int longestZigZag(TreeNode root) {
        // 0 -> left, 1 -> right
        
        // calling two times as root its start so we assum that its coming from both right and left
        helper(root, 0, 0);
        helper(root, 1, 0);
        
        // retrun updated max zigzag length
        return maxLength;
    }
    
    public void helper(TreeNode root, int dir, int currLength){
        
        // if root is null then return
        if(root==null)
            return;
        
        // update maxLength at every node with max zig zag length
        maxLength=Math.max(maxLength,currLength);
        
        // if root is coming from right then left child can continue zigzag path and right will start from 1
        if(dir==1){
            helper(root.left, 0, currLength+1);
            helper(root.right, 1, 1);
        }
        // if root is coming from left then right child can continue zigzag path and left will start from 1
        else{
            helper(root.right, 1, currLength+1);
            helper(root.left, 0, 1);
        }
    }
}
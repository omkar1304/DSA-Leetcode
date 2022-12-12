// https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case
        
        // if root is null then return false its not equal to 0
        if(root == null)
            return false;
        
        // if root has null left & right then just check if sum - current value == 0 if yes return true
        if(root.left == null && root.right == null && (sum - root.val) == 0)
            return true;
        
        // if tree has more nodes then check in left subtree and right subtree and at least any one of them need to be true that means sum equals to 0
        boolean leftPart = hasPathSum(root.left, sum - root.val);
        boolean rightPart = hasPathSum(root.right, sum - root.val);
        
        // just check if any one part is true else return false
        return leftPart || rightPart;
        
    }
}
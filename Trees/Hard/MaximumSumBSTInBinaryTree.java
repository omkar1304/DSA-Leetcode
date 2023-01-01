// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

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
class Pair{
    
    int sum;
    int minVal;
    int maxVal;
    
    Pair(int sum, int minVal, int maxVal){
        this.sum = sum;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
    
}

class Solution {
    int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        // similar problem - https://practice.geeksforgeeks.org/problems/largest-bst/1
        helper(root);
        return maxSum;
    }
    
    public Pair helper(TreeNode root){
        
         // if root is null then return pair -> (0, max, min) as its BST
        if(root == null)
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        // go to its left and right and collect respective pairs
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        // if its BST by following condition then calculate sum and store max sum in maxSum global variable
        if(left.maxVal < root.val && root.val < right.minVal){
            int sum = (root.val + left.sum + right.sum);
            maxSum = Math.max(maxSum, sum);
            return new Pair(sum, Math.min(root.val, left.minVal), Math.max(root.val, right.maxVal));
        }
            
        // if its not BST then return sum = 0 and also return min as minimum int val and max as maximum int val so it cant be BST for its parent node
        return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
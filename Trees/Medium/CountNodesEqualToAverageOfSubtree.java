// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

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
    // declaring global variable to update its value
    int res = 0;
    
    public int averageOfSubtree(TreeNode root) {
        
        helper(root);
        return res;
        
    }
    
    public int[] helper(TreeNode root){
        // base case
        
        // if root is null then return sum -> 0, count -> 0
        if(root == null)
            return new int[] {0, 0};
        
        // if not then go for its left part and right part
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        // then calculate its sum -> root + left + right
        int currSum = root.val + left[0] + right[0];
        // then calculate its count -> root node + left nodes + right nodes
        int numNodes = 1 + left[1] + right[1];
        
        // if avg matches with current node value then increament by 1
        if(currSum / numNodes == root.val)
            res = res + 1;
        
        // returing array of size 2 which contains sum of its subtree and no of nodes in subtree
        return new int[] {currSum, numNodes};
    }
}
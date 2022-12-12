// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

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
    public int sumEvenGrandparent(TreeNode root) {
        // passing default parent value as 1 which odd it wont get added in result 
        // to get grandparent we need to move at level 2
        // to get parent we need to move at level 1
        return helper(root, 1, 1);
    }
    
    public int helper(TreeNode root, int parent, int grandParent){
        // base case
        
        // if root is null then return 0
        if(root == null)
            return 0;
        
        // then call for left and right child and also pass their parent and grandparent
        // and check if grandparent value is even then add it in result
        return helper(root.left, root.val, parent) 
             + helper(root.right, root.val, parent) 
             + (grandParent % 2 == 0 ? root.val : 0);
    }
}
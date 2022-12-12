// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

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
    public TreeNode reverseOddLevels(TreeNode root) {
        // We call the function from level 0, and everything starts from level 1
        helper(root.left, root.right, 1);
        return root;
    }
    
    public void helper(TreeNode node1, TreeNode node2, int level){
        // base case
        
        // if any node is null then return from it
        if(node1 == null || node2 == null)
            return;
        
        // if its odd level then swap its node value
        if(level % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        
        // here while making call we need to consider outer nodes at level and then inner nodes at level
        // hence calling node1 left and node2 right so incase if that needs to be swap so it will be possible
        helper(node1.left, node2.right, level+1);
        // after that we can call for inner nodes so they can swap
        helper(node1.right, node2.left, level+1);
        // after both call if level is odd then by swaping nodes we can make that level reverse
        
    }
}
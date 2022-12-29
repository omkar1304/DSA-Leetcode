// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
// recursive method -> 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // if root is null then return null
        if(root == null)
            return null;
        
        // if both nodes value less than root value then go to left subtree
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        
        // if both nodes value more than root value then go to right subtree
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        
        // if one in left and one node in right then this is intersection point which is LCA return root
        return root;
    }
    
    
// iterative method -> (to avoid extra stack space for recursive call)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        
        while(root != null){
            
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            
            else
                break;
            
        }
        
        return root;
    }
    
}
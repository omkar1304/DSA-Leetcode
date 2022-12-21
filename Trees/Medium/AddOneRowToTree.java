// https://leetcode.com/problems/add-one-row-to-tree/

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        // if only one depth then attach newnode top of root
        if(depth == 1)
            return new TreeNode(val, root, null);
        
        // if depth is 2 then create newleft and newright node with val and attach it to root.
        // also atach new nodes left and right respectively with old left and right
        else if(depth == 2){
            
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }
        
        // else go to its left and right path if not null and reduce depth by 1
        else{
            
            if(root.left != null)
                addOneRow(root.left, val, depth-1);
            if(root.right != null)
                addOneRow(root.right, val, depth-1);
        }
        
        return root;
    }
}
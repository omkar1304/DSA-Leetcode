// https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // if root is null then create new node and return it 
        if(root == null)
            return new TreeNode(val);
        
        // to iterate over entire BST
        TreeNode tempNode = root;
        
        while(true){
            
            // if value is greater then we have to move to right side
            if(tempNode.val < val){
                // if right part is not null then keep moving 
                if(tempNode.right != null){
                    tempNode = tempNode.right;
                }  
                // if null then create node attach it and break loop
                else{
                    TreeNode newNode = new TreeNode(val);
                    tempNode.right = newNode;
                    break;
                }
            }
            // if value is smaller then we have to move to right side
            else{
                // if left part is not null then keep moving 
                if(tempNode.left != null){
                    tempNode = tempNode.left;
                }
                // if null then create node attach it and break loop
                else{
                    TreeNode newNode = new TreeNode(val);
                    tempNode.left = newNode;
                    break;
                }
            }
        }
        // return BST
        return root;
    }
}
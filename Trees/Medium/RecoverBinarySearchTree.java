// https://leetcode.com/problems/recover-binary-search-tree/

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
    
    // creating variables to store value 
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode second;
    
    public void recoverTree(TreeNode root) {
        // passing lowest min val in prev as it has to check with root.val and null to rest variables
        prev = new TreeNode(Integer.MIN_VALUE);
        first = null;
        middle = null;
        second = null;
        
        // perform inoder traversal
        inorder(root);
        
        // if first and second not null then two times condition violet it means not adjecents nodes
        // swap those
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        // if second is null then only one time condition violets it means they are adjecent node 
        // swap those
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
    public void inorder(TreeNode root){
        
        // if root is null return it from here
        if(root == null)
            return;
        
        // go to left
        inorder(root.left);
        
        // if prev is not null and root value is less than prev value then condition violets 
        if(prev != null && root.val < prev.val){
            
            // if first time then store in first and middle 
            if(first == null){
                
                first = prev;
                middle = root;
            }
            // second time store in second 
            else{
                second = root;
            }
        }
        
        // store root in prev for next node
        prev = root;
        
        // go to right
        inorder(root.right);
    }
}
// https://leetcode.com/problems/delete-node-in-a-bst/

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
    public TreeNode deleteNode(TreeNode root, int key) {
        // if root null then no need to delete anything return root as it is
        if(root == null)
            return root;
        
        // if root.val == key then root has to delete so pass keynode in helper function to get deleted
        if(root.val == key)
            return helper(root);
        
        // els we have to search keynode in BST and then pass it to helper function to get deleted
        TreeNode tempNode = root;
        
        while(tempNode != null){
            
            // if val > key then we have to move to left to search keynode
            if(tempNode.val > key){
                
                // if we get keynode then pass it to helper function and it will return rebuilt tree after deletion
                if(tempNode.left != null && tempNode.left.val == key){
                    tempNode.left = helper(tempNode.left);
                    break;
                }
                // else keep moving left side
                else{
                    tempNode = tempNode.left;
                }
            }
            // if val < key then we have to move to right to search keynode
            else{
                // if we get keynode then pass it to helper function and it will return rebuilt tree after deletion
                if(tempNode.right != null && tempNode.right.val == key){
                    tempNode.right = helper(tempNode.right);
                    break;
                }
                // else keep moving right side
                else{
                    tempNode = tempNode.right;
                }
            }
        }
        
        return root;
    }
    
    public TreeNode helper(TreeNode root){
        // if keynode has no left then return its right part 
        if(root.left == null)
            return root.right;
        
        // if keynode has no right then return its left part
        if(root.right == null)
            return root.left;
        
        // else store its both left and right part
        TreeNode rightTree = root.right;
        TreeNode leftTree = root.left;
        
        // now what we have to do we just need rightmost element of leftTree so we can point its right to rightTree of keynode
        // by doing this we can maintain BST property(dry run)
        TreeNode rightMost = getRightMost(root.left);
        rightMost.right = rightTree;
        
        // and return leftTree
        return leftTree;
        
        // Note : this same way we can do it for right part as well. find leftmost node in rightTree and attach its left to leftTree
    }
    
    public TreeNode getRightMost(TreeNode root){
        // this function will return rightmost node of tree
        if(root.right == null)
            return root;
        
        return getRightMost(root.right);
    }
    
}
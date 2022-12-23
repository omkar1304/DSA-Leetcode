// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

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
    int ptr = 0;
        
    public TreeNode recoverFromPreorder(String str) {
        
        return helper(str, 0);
    }
    
    public TreeNode helper(String str, int level){
        // base case
        
        // if we reached to end of string then return null
        if(ptr >= str.length())
            return null;
        
        // setting index to get count of "-" 
        // if we have same no of "-" as level then we can consider value to be a node
        int index = ptr;
        int count = 0;
        
        while(str.charAt(index) == '-'){
            count = count + 1;
            index = index + 1;
        }
        
        // if count == level then we need to create node for this and generate left and right for it
        if(count == level){
            
            // to store start index of number(for exmple number can be any digits)
            int start = index;
            
            // extracting number from string untill we get '-'
            while(index < str.length() && str.charAt(index) != '-')
                index = index + 1;
            
            // storing index to ptr for next recursive call
            ptr = index;
            
            // converting string to number
            int val = Integer.parseInt(str.substring(start, index));
            
            // create node of that value and build left and right node recursively
            TreeNode root = new TreeNode(val);
            root.left = helper(str, level+1);
            root.right = helper(str, level+1);
            
            // and at the end return root
            return root;   
        }
        
        // else return null 
        else{
            return null;
        }
    }
}
// https://leetcode.com/problems/smallest-string-starting-from-leaf/

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
    // creating string to store smallest string 
    String smallest = "";
    
    public String smallestFromLeaf(TreeNode root) {
        
        helper(root, "");
        return smallest;
    }
    
    public void helper(TreeNode root, String currString){
        // base case
        
        // if root is null then retrun it from here
        if(root == null)
            return;
        
        // converting into char and storing in string in reverse order as we need to store path from leaf to root
        currString = (char)(root.val + 'a') + currString;
        
        // if its both child empty then check if smallest is already empty or currString is smaller than smallest if yes then update currString in smallest
        if(root.left == null && root.right == null){
            if(smallest.isEmpty() || currString.compareTo(smallest) < 0)
                smallest = currString;
        }
        
        // else just make calls for left and right part
        helper(root.left, currString);
        helper(root.right, currString);
        
    }
}
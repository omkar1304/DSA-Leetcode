// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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

 class BSTIterator{
    // creating stack to add all left or right side nodes
    Stack<TreeNode> stack = new Stack<>();
    // if reverse is true then we need to it for right side nodes else for left side nodes
    boolean reverse;
    
    // custom constructor and calling helper function to fill stack with node depending upon reverse 
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        helper(root);
    }
    
    public void helper(TreeNode root){
        // creating iterator
        TreeNode tempNode = root;
        while(tempNode != null){
            // push node in stack
            stack.push(tempNode);
            
            // if revese true then we need push node in reverse order that from rigth side of BST
            if(reverse == true)
                tempNode = tempNode.right;
            // else reverse false then we need push node in asceding order that from left side of BST
            else
                tempNode = tempNode.left;
        }
    }
    
    public int nextORbefore(){
        // pop out top element from stack and return its value
        TreeNode node = stack.pop();
        
        // but before returning check if reverse is true then we need to check fore left 
        if(reverse == true)
            helper(node.left);  
        // if reverse is false then we need to check for right
        else
            helper(node.right);
        
        
        return node.val;
    }
    
    // if stack empty then it has no next else it has
    public boolean hasNextorBefore(){
        
        return !stack.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
        // if root is null then return false
        if(root == null)
            return false;
        
        // creating two objects of BSTIterator (one for next and one for before)
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
        
        // getting top element of from stack of each 
        int low = left.nextORbefore();
        int high = right.nextORbefore();
        
        // it like soreted order list where i in pointing at start of list and j is pointing end of list
        // and perform same operation as Two Sum problem
        
        while(low < high){
            // if sum == k then we got the result return true
            if(low + high == k)
                return true;
            
            // if sum is less than k then we need to update low so calling its next to get next value from stack
            else if(low + high < k)
                low = left.nextORbefore();
            
            // if sum is more than k then we need to update high so calling its next to get before value from stack
            else
                high = right.nextORbefore();
        }
        
        // if not found then return false
        return false;
    }
}
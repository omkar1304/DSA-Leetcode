// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    public int kthSmallest(TreeNode root, int k) {
        // As we know inorder of BST will give us sorted nodes list. so apply morris traversal and keep counting how many nodes passed if count == k then we found node hence return node.val
        
        // to make count of how many nodes passed
        int count = 0;
        // starting from root node
        TreeNode current = root;
        
        while(current != null){
            // first we need to check if it has left ? if not then add root value in result and move to right
            if(current.left == null){
                count = count + 1; // instead of storing in list we can update count by 1 and check if == k
                if(count == k)
                    return current.val;
                
                current = current.right;
            }
            // if it has left then ->
            else{
                // first thing find its right most node in left subtree
                TreeNode tempNode = current.left;
                
                // keeping going down until we get rightmost node which either pointing to null OR
                // there is thread between rightmost node to current node
                while(tempNode.right != null && tempNode.right != current)
                    tempNode = tempNode.right;
                
                // if its pointing to null then make thread between rightmost node and current node
                // and again start iterating in left subtree and add in result
                if(tempNode.right == null){
                    tempNode.right = current;
                    current = current.left;
                }
                
                // if there is already thread means we added all nodes in result list then remove thread
                // add current node in result and move its right part as we already done with left part
                if(tempNode.right == current){
                    tempNode.right = null;
                    count = count + 1; // instead of storing in list we can update count by 1 and check if == k
                    if(count == k)
                        return current.val;
                    current = current.right;
                }
                    
            }
        }
        return -1;
    }
}
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

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
    // complete tree means if we reached the last node in tree then after that every node should be null
    // if we received any null node then we reached to end and after that every node should be null then its complete tree else its not
    
    public boolean isCompleteTree(TreeNode root) {
        
        // marking end as false at start
        boolean isEnd = false;
        // doing same level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            // polling out each node 
            TreeNode tempNode = queue.poll();
            
            // if node is null then we reached to the end 
            if(tempNode == null)
                isEnd = true;
            
            // if we already reached to the end and current tempnode is not null then its not complete binary tree return false
            else if(isEnd == true && tempNode != null)
                return false;
            
            // else if not reached to the end and its not null then add its left and right child for next level
            else{
                queue.offer(tempNode.left);
                queue.offer(tempNode.right);
            }
        }
        
        // if evrything goes correctly then return true
        return true;
    }
}
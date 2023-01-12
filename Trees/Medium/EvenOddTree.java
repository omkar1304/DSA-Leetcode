// https://leetcode.com/problems/even-odd-tree/

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
    public boolean isEvenOddTree(TreeNode root) {
        
        // To store node in level manner
        Queue<TreeNode> queue = new LinkedList<>();
        // adding root node
        queue.offer(root);
        
        // to maintain level even or odd
        boolean isEven = true;

        while(!queue.isEmpty()){
            
            int size = queue.size();
            // if level is even then we need odd values in inc so we can assign 0 to prev
            // if level is odd then we need even values in dec so we can assign max to prev
            int prev = isEven ? 0 : Integer.MAX_VALUE;
            
            for(int index=0; index<size; index++){
                
                TreeNode tempNode = queue.poll();
                
                // even level ->
                if(isEven){
                    // if value is even or prev value greater than current node value then return false
                    if(tempNode.val % 2 == 0 || prev >= tempNode.val)
                        return false;
                }
                // odd level ->
                else{
                    // if value is odd or prev value smaller than current node value then return false
                    if(tempNode.val % 2 != 0 || prev <= tempNode.val)
                        return false;
                }
                
                // else current level under condition so add next level value in queue
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
               
                // updating prev value with current
                prev = tempNode.val;
            }    
            
            // once one level is completed then reverse isEven
            isEven = !isEven;
        }
        
        // if everything is correct then return true
        return true;
    }
}
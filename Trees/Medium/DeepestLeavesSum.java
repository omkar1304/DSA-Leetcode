// https://leetcode.com/problems/deepest-leaves-sum/

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
    public int deepestLeavesSum(TreeNode root) {
        
        // creating queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int sum = 0;
        
        while(!queue.isEmpty()){
            // sum = 0 so at every level will get sum of node and at last we will get sum of last level which deepest level
            sum = 0;
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                TreeNode tempNode = queue.poll();
                // storing value in sum
                sum = sum + tempNode.val;
                
                // if it has left then add in queue
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                
                // if it has right then add in queue
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
        }
        
        // return sum of last level
        return sum;
    }
}
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

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
    public int maxLevelSum(TreeNode root) {
        
        // storing min values to get maxsum and maxlevel
        int maxLevel = -1;
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        
        // creating queue to hold nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int sum = 0;
            int size = queue.size();
            
            // calculating sum for each level and storing its left and right in queue for next level
            for(int i=0; i<size; i++){
                
                TreeNode tempNode = queue.poll();
                
                sum = sum + tempNode.val;
                
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            
            // checking if level has maxSum if yes then update maxSum and maxLevel 
            if(sum > maxSum){
                maxSum = sum;
                maxLevel = level;
            }
            
            // updating level value by 1 
            level = level + 1;
        }
        
        return maxLevel;
    }
}
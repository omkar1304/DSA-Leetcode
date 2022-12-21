// https://leetcode.com/problems/average-of-levels-in-binary-tree/

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
    public List<Double> averageOfLevels(TreeNode root) {
        
        // creating list to store avg at each level
        List<Double> result = new ArrayList<>();
        
        // if root is null then return empty result list
        if(root == null)
            return result;
        
        // creating queue to store level wise node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            // calculatting size and sum at each level
            int size = queue.size();
            double sum = 0.0;
            
            for(int i=0; i<size; i++){
                
                // polling out node and adding into sum
                TreeNode tempNode = queue.poll();
                sum = sum + tempNode.val;
                
                // if left is not null then adding in queue for next level
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                
                // if right is not null then adding in queue for next level
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            
            // adding avg in result list at each level
            result.add(sum / size);
        }
        
        return result;
    }
}
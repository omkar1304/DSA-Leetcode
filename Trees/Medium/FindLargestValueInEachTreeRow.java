// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    public List<Integer> largestValues(TreeNode root) {
        
        // To store max value 
        int max = Integer.MIN_VALUE;
        
        // to store level wise nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // result list which will store max nodes at each level
        List<Integer> result = new ArrayList<>();       
        if(root == null)
            return result;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                // polling node and storing in max if its maximum
                TreeNode tempNode = queue.poll();
                max = Math.max(max, tempNode.val);
                
                // storing next level nodes if not null
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            
            // adding max at each level and make max with min value again to start again with new level 
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        
        return result;
    }
}
// https://leetcode.com/problems/find-bottom-left-tree-value/

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
    public int findBottomLeftValue(TreeNode root) {
        // to store lefmost node value in every level
        int ans = root.val;
        
        // creating queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            // at every level first value we need to store so making is as true
            boolean isFirst = true;
            
            for(int index=0; index<size; index++){
                
                TreeNode tempNode = queue.poll();
                
                // once we get that first value at every node mark it as false
                if(isFirst){
                    ans = tempNode.val;
                    isFirst = false;
                }
                
                // storing left and right for future level
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                if(tempNode.right != null)
                    queue.offer(tempNode.right);
            }
        }
        // retruning last level first node value
        return ans;
    }
}
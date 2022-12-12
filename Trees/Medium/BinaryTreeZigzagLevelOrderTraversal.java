// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        // creating result to store list of integers
        List<List<Integer>> result = new ArrayList<>();
        // if root is null then return empty result
        if(root == null)
            return result;
        
        // creating queue to add node at back and also adding root node in queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // to keep track of direction 
        boolean leftToRight = true;
        
        while(!queue.isEmpty()){
            
            // creating temp to store level wise nodes in list
            List<Integer> temp = new ArrayList<>();
            // getting size so we can iterate size times in loop as its define how many nodes present in current level
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                // poping out that from front
                TreeNode tempNode = queue.poll();
                // now if direction is letf -> right then we need to add from back side of list
                if(leftToRight)
                    temp.add(tempNode.val);
                // if direction right -> left then we need to add from front side of list
                else
                    temp.add(0, tempNode.val);
                
                // storing its left and right child to get next level nodes only if its not null 
                if(tempNode.left != null)
                    queue.offer(tempNode.left);
                if(tempNode.right != null)
                    queue.offer(tempNode.right);   
                
            }
            
            // chaching the direction at each level
            leftToRight = !leftToRight;
            // add list of nodes at each level in result list
            result.add(temp);
        }
        
        return result;
    }
}
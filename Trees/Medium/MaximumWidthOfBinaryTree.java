// https://leetcode.com/problems/maximum-width-of-binary-tree/

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

/*
The idea is to traverse all the node in the tree in level order(Here I use one Queue to store each level's nodes. The time I traverse each level is the queue's size(the number of nodes from upper level)). Each time a node is traversed, the position of the node(as it is in a full binary tree) is stored in the HashMap. If the position of the parent node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'. The width of each level is the last node's position in this level subtracts the first node's position in this level plus 1.
that is in this case width at each level = end - start + 1

*/
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // if root is null then return 0
        if(root == null)
            return 0;
        
        // creating queue to store node in Level Order Traversal wise
        Queue<TreeNode> queue = new LinkedList<>();
        // creating map to store treeNode and its corrensponding index
        Map<TreeNode, Integer> map = new HashMap<>();
        
        // putting root node in queue and giving starting index as 1
        queue.offer(root);
        map.put(root, 1);
        
        // everytime will store currWidth and maxWidth
        int curW = 0;
        int maxW = 0;
        
        while(!queue.isEmpty()){
            
            // taking size to poll every node at each level
            int size = queue.size();
            int start = 0;
            int end = 0;
            
            for(int i=0; i<size; i++){
                
                // polling node
                TreeNode tempNode = queue.poll();
                
                // here we are storing index of leftmost node at level using map
                if(i == 0)
                    start = map.get(tempNode);
                
                // here we are storing index of rightmost node at level using map
                if(i == size-1)
                    end = map.get(tempNode);
                
                // if node has left then store in queue and put in map with index -> 2 * currNode
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                    map.put(tempNode.left, map.get(tempNode) * 2);
                }
                
                // if node has right then store in queue and put in map with index -> 2 * currNode + 1
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                    map.put(tempNode.right, map.get(tempNode) * 2 + 1);
                }

            }
            
            // after polling out every node at each level just get width from rightmost node index - leftmost node index + 1 and store max out of it
            curW = end - start + 1;
            maxW = Math.max(maxW, curW);
        }
        
        // return max width
        return maxW;
    }
}
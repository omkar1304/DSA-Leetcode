// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // this fucntion will build child : parent relation map
    public void getParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        // base case
        
        // if root is null then return from here
        if(root == null)
            return;
        
        // if root.left is not null then store its child : parent relation in map
        if(root.left != null)
            parentMap.put(root.left, root);
        
        // if root.right is not null then store its child : parent relation in map
        if(root.right != null)
            parentMap.put(root.right, root);
        
        // and do the same for its left and right part
        getParentMap(root.left, parentMap);
        getParentMap(root.right, parentMap);
             
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // creating result to store values in list
        List<Integer> result = new ArrayList<>();
        // if root is null then return empty list
        if(root == null)
            return result;
        
        // to store parent of each child node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParentMap(root, parentMap);
        
        // creating set to avoid visited nodes again 
        Set<TreeNode> visited = new HashSet<>();
        // creating queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // adding target node in queue
        queue.add(target);
        
        while(!queue.isEmpty()){
            
            // getting size and looping that time to poll nodes in queue
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                // polling out node from queue and adding into set as consider visited node
                TreeNode tempNode = queue.poll();
                visited.add(tempNode);
                
                // if distance 0 then store upcoming nodes in result
                if(k==0)
                    result.add(tempNode.val);
                
                // if node has parent and its not visited already then add in queue
                if(parentMap.containsKey(tempNode) && !visited.contains(parentMap.get(tempNode)))
                    queue.offer(parentMap.get(tempNode));
                
                // if node has left and its not visited already then add in queue
                if(tempNode.left != null && !visited.contains(tempNode.left))
                    queue.offer(tempNode.left);
                
                // if node has right and its not visited already then add in queue
                if(tempNode.right != null && !visited.contains(tempNode.right))
                    queue.offer(tempNode.right);
            }
            // decrementing by 1 as we covered 1 time distance. so reducing it
            k = k - 1;
            // if our distance becoms < 0 then we got the result just break loop
            if(k < 0)
                break;
        }
        
        // return result list
        return result;
        
    }
}
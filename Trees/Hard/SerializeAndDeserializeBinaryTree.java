// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // base case if root is already null then return empty string
        if(root == null)
            return "";
        
        // here we are building string using Level Order Traversal
        StringBuilder sb = new StringBuilder();
        
        // creating queue to hold treeNodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            // pop out every time node from queue
            TreeNode tempNode = queue.poll();
            
            // if node is empty then put "n " in string
            if(tempNode == null){
                sb.append("n ");
                continue;
            }
            
            // else put node value in string and put its left and right child in queue as even if it is null as we are checking null check at start
            sb.append(tempNode.val + " ");
            queue.offer(tempNode.left);
            queue.offer(tempNode.right);
        }
        
        // return string
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // base case -> if string empty then return null 
        if(data.equals(""))
            return null;
        
        // converting string into array based on space split
        String[] values = data.split(" ");
        
        // creating queue to store Treenode to keep track of parent node while adding its left and right child
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        // add root node first in queue to start iterate
        queue.offer(root);
        
        // we already added first one in queue hence starting from index = 1
      for(int index=1; index<values.length; index++){
            
          // take out node from queue which will refer as parent
            TreeNode parent = queue.poll();
            
            // if value is not null then create node and attach it to left child of parent and store that node in queue
            if(!values[index].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                parent.left = left;
                queue.offer(left);
            }
          
          // if value is not null then create node and attach it to right child of parent and store that node in queue
          // ++index ? as we need go to next index of value 
            if(!values[++index].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                parent.right = right;
                queue.offer(right);
            }
        }
        
        // return root node
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
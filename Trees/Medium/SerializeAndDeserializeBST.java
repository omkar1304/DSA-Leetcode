// https://leetcode.com/problems/serialize-and-deserialize-bst/

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

    public String serialize(TreeNode root) {
        // if root is null then return empty string
        if(root == null)
            return "";
        
        // else build string and pass it to preorder to get updated with BST
        StringBuilder sb = new StringBuilder();
        
        preorder(root, sb);
        
        return sb.toString();
        
    }

    public TreeNode deserialize(String data) {
        // if string is empty then return null
        if(data.equals(""))
            return null;
        
        // else split string on basis of " "
        String[] values = data.split(" ");
        
        // and pass it to helper funtion to get BST
        return helper(values, 0, values.length-1);
    }
    
    public void preorder(TreeNode root, StringBuilder sb){
        // This function will perform preorder traversal
        if(root == null)
            return;
        
        sb.append(root.val + " ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    
    public TreeNode helper(String[] values, int start, int end){
        // if start is greater than end then return null
        if(start > end)
            return null;
        
        // as we know in preoder 1st value in values is root
        // and then all values less than root value are going to be left part of root
        // and rest values are going to be right part of root
        
        // hence finding index where we can split left and right part
        int index = start;
        while(index <= end){
            // if we get index where its value is greater than root value then break loop
            if(Integer.parseInt(values[index]) > Integer.parseInt(values[start]))
                break;
            index = index + 1;
        }
        
        // create root from start value in values array and build left and right recursively using index
        TreeNode root = new TreeNode(Integer.parseInt(values[start]));
        root.left = helper(values, start+1, index-1);
        root.right = helper(values, index, end);
        
        // at the end return root
        return root;
    }
}

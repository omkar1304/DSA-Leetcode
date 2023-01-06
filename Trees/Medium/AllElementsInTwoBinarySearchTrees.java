// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

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

 // Method 1 -> Two pass
 class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // creating two list for both root1 and root2
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        
        // apply inorder to both and it will update both list in sorted manner
        inorder(root1, result1);
        inorder(root2, result2);
        
        List<Integer> ans = new ArrayList<>();
        
        int index1 = 0;
        int index2 = 0;
        
        // compare there values and merge them in another list
        while(index1 < result1.size() && index2 < result2.size()){
            
            // if result1 value is less than result2 value then add result1 value
            if(result1.get(index1) <= result2.get(index2)){
                ans.add(result1.get(index1));
                index1 = index1 + 1;
            }
            // else add result2 value
            else{
                ans.add(result2.get(index2));
                index2 = index2 + 1;
            }
        }
        
        // now check if index1 goes out of bound then we traverse whole result1 so add result2 values in ans list
        if(index1 >= result1.size()){
            while(index2 < result2.size()){
                ans.add(result2.get(index2));
                index2 = index2 + 1;
            }
        }
        
        // if index2 goes out of bound then we traverse whole result1 so add result1 values in ans list
        if(index2 >= result2.size()){
            while(index1 < result1.size()){
                ans.add(result1.get(index1));
                index1 = index1 + 1;
            }
        }
        
        // return ans list 
        return ans;
    }
    
    // this function will perform inorder traversal
    public void inorder(TreeNode root, List<Integer> result){
        
        if(root == null)
            return;
        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

// Method 2 -> one Pass

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // creating two list for both root1 and root2
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        
        // apply inorder to both and it will update both list in sorted manner
        inorder(root1, result1);
        inorder(root2, result2);
        
        List<Integer> ans = new ArrayList<>();
        
        int index1 = 0;
        int index2 = 0;
        
        // compare there values and merge them in another list
        while(index1 < result1.size() && index2 < result2.size()){
            
            // if result1 value is less than result2 value then add result1 value
            if(result1.get(index1) <= result2.get(index2)){
                ans.add(result1.get(index1));
                index1 = index1 + 1;
            }
            // else add result2 value
            else{
                ans.add(result2.get(index2));
                index2 = index2 + 1;
            }
        }
        
        // now check if index1 goes out of bound then we traverse whole result1 so add result2 values in ans list
        if(index1 >= result1.size()){
            while(index2 < result2.size()){
                ans.add(result2.get(index2));
                index2 = index2 + 1;
            }
        }
        
        // if index2 goes out of bound then we traverse whole result1 so add result1 values in ans list
        if(index2 >= result2.size()){
            while(index1 < result1.size()){
                ans.add(result1.get(index1));
                index1 = index1 + 1;
            }
        }
        
        // return ans list 
        return ans;
    }
    
    // this function will perform inorder traversal
    public void inorder(TreeNode root, List<Integer> result){
        
        if(root == null)
            return;
        
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
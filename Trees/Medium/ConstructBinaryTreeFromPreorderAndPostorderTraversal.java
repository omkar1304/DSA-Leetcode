// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
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
    /* observation ->
    Given preorder : 1 2 4 5 3 6;     postorder: 4 5 2 6 3 1.
    We see it as preorder : 1 (2 4 5) (3 6); postorder: (4 5 2) (6 3) 1 
    */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        // to store index of each value in postorder array
        Map<Integer, Integer> postMap = new HashMap<>();
        
        for(int index=0; index<postorder.length; index++)
            postMap.put(postorder[index], index);
        
        return helper(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1, postMap);
        
    }
    
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> postMap){
        
        // if start > end then no value present in array return null
        if(preStart > preEnd || postStart > postEnd)
            return null;
        
        // if both are equal then only 1 value present hence create node and return it
        if(preStart == preEnd){
            TreeNode root = new TreeNode(preorder[preStart]);
            return root;
        }
        
        // else create node and build its left and right 
        TreeNode root = new TreeNode(preorder[preStart]);

        // as we know in preoder after root we can consider whole array as combo -> left + right
        
        // left subtree will start after root index i.e. preStart + 1
        int leftSubtreeStart = preStart + 1;
        // to get length of left subtree we can use postMap so we will get end value of left subtree
        // just observe above example and dry run
        int postIndex = postMap.get(preorder[leftSubtreeStart]);
        int leftSubtreeEnd = leftSubtreeStart + (postIndex - postStart);
        
        // once we get leftstart and leftend then rightstart will be leftend + 1 and rightend will be end in preorder
        
        // build left and right subtree of root
        root.left = helper(preorder, leftSubtreeStart, leftSubtreeEnd, postorder, postStart, postIndex, postMap);
        root.right = helper(preorder, leftSubtreeEnd+1, preEnd, postorder, postIndex+1, postEnd-1, postMap);
        
        // return root at the end
        return root;
            
    }
}
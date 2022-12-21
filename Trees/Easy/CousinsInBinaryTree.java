// https://leetcode.com/problems/cousins-in-binary-tree/

// creating class pair
class Pair{
    
    int level;
    TreeNode current;
    TreeNode parent;
    
}

class Solution {
    
    // global varibales 
    Pair xPair = new Pair();
    Pair yPair = new Pair();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(xPair, root, x, 0);
        helper(yPair, root, y, 0);
        
        // depth should be same and parent should be different then return true else false
        return (xPair.level == yPair.level && xPair.parent != yPair.parent);
        
    }
    
    public void helper(Pair pair, TreeNode root, int value, int level){
        // base case ->
        
        // if root is null then return from it 
        if(root == null)
            return;
        
        // if we get that value in left side then store its depth, parent and current node using pair
        if(root.left != null && root.left.val == value){
            pair.level = level + 1;
            pair.parent = root;
            pair.current = root.left;
            return;
        }
        
        // if we get that value in right side then store its depth, parent and current node using pair
        if(root.right != null && root.right.val == value){
            pair.level = level + 1;
            pair.parent = root;
            pair.current = root.right;
            return;
        }
        
        // else start seacrhing for left and right
        helper(pair, root.left, value, level+1);
        helper(pair, root.right, value, level+1);
    }
}
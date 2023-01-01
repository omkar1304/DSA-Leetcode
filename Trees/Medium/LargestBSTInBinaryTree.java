// https://practice.geeksforgeeks.org/problems/largest-bst/1


class Pair{
    int size;
    int minVal;
    int maxVal;
    
    Pair(int size, int minVal, int maxVal){
        this.size = size;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
}


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {   
        // this fucntion will return pair. extract size value from pair and return it
        Pair result = helper(root);
        return result.size;
    }
    
    static Pair helper(Node root){
        
        // if root is null then return pair -> (0, max, min)
        if(root == null){
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        // go to its left and right and collect respective pairs
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        // if max value from left side is smaller than root value and 
        // if min value from right side is greater than root value 
        // then its BST so return pair ->(root+left+right, min value(minVal, rootval), max value(maxValue, root))
        if(left.maxVal < root.data && root.data < right.minVal){
            return new Pair((1 + left.size + right.size),
                            Math.min(root.data, left.minVal),
                            Math.max(root.data, right.maxVal));
        }
        
        // if not BST then pass max value from size left and right
        // and return minVal as loweest min value 
        // and return maxVal as largest max value 
        // because it can be never be BST for its parent tree (Dry run)
        return new Pair(Math.max(left.size, right.size), 
                                 Integer.MIN_VALUE, 
                                 Integer.MAX_VALUE);
   
    }
    
}
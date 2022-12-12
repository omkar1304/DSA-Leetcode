// https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    // global variables -> to get updated everytime and store max sum and level
    int maxSum = 0;
    int maxLevel = 0;
    
    public void helper(Node root, int level, int sum){
        // if root null that means we reached to leaf node
        // hence check if level is heigher than maxlevel then update both with current len and sum
        // else if level and maxlevel are matching then update max sum out of both -> sum and maxSum
        if(root == null){
            if(level > maxLevel){
                maxLevel = level;
                maxSum = sum;
            }
            else if(level == maxLevel){
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }
        
        // if not leaf node then we need to travers its left and right
        // as we are traversing down we need update level by 1 and sum by current data
        helper(root.left, level+1, sum+root.data);
        helper(root.right, level+1, sum+root.data);
    }
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        // starting variable
        int level = 0;
        int sum = 0;

        helper(root, level, sum);
        return maxSum;
        
        
    }
}
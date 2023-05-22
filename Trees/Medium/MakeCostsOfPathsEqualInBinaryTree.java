// https://leetcode.com/problems/make-costs-of-paths-equal-in-a-binary-tree/

/*
We can move level by level from the the leaves and make sure that the adjacent nodes have equal cost. First make the cost of adjacent leaves equal. Then move one level up. Make sure that the cost of the two children are equal and so on. If they are not equal just increment the node with the lower cost to make it equal to the other node.

Use (2 * i + 1) instead of 2 * i for child node because 2 * i will go into infinite loop when you run dfs(0)
*/

class Solution {
    
    // to store min no of increment need to make cost of path equal from root to leaf
    int result = 0;
    
    public int minIncrements(int n, int[] cost) {
        
        DFS(0, n, cost);
        return result;
        
    }
    
    public int DFS(int i, int n, int[] cost){
        
        // if we go out of leaf node then return 0 
        if(i >= n)
            return 0;
        
        // go for node's left and right child and then come up from bottom to up
        int left = DFS(2 * i + 1, n, cost);
        int right = DFS(2 * i + 2, n, cost);
        
        // at every node we have to make its both childeren equal that will be our minimum increamt for that node. suppose left cost is 2 and right cost is 3 then we have to make both equal so we will add 1 to left node. hence take diff and store in result.
        result = result + Math.abs(left - right);
        
        // while returning we are returning cost of from leaf to current node (bottom to up)
        // return the value => cost of current node + max out of its left & right
        return cost[i] + Math.max(left, right);
    }
}
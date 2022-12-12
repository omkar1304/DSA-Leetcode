// https://leetcode.com/problems/triangle/submissions/

public class Triangle {
    public int helper(List<List<Integer>> triangle, int level, int index, int[][] dp){
        // base case 
        
        // if level goes out of bound then we dont have any childeren to take values from them hence return 0
        if(level >= triangle.size())
            return 0;
        
        // if present then return
        if(dp[level][index] != -1)
            return dp[level][index];
        
        // take the path from first child of next level
        int first = helper(triangle, level+1, index, dp);
        // take the path from second child of next level
        int second = helper(triangle, level+1, index+1, dp);
        
        // include current value + min of first and second child and return it
        return dp[level][index] = triangle.get(level).get(index) + Math.min(first, second);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        // Memoization ->
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int i=0; i<triangle.size()+1; i++){
            for(int j=0; j<triangle.size()+1; j++){
                dp[i][j] = -1;
            }
        }
                     
        return helper(triangle, 0, 0, dp);
        
    }
}

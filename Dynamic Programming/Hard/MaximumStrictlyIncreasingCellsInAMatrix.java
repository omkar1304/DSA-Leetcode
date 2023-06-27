// https://leetcode.com/problems/maximum-strictly-increasing-cells-in-a-matrix/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
// Recursion + Memoization ->
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        
        int max = 0;
        
        int[][] dp = new int[mat.length+1][mat[0].length+1];
        for(int i=0; i<mat.length; i++)
            for(int j=0; j<mat[0].length; j++)
                dp[i][j] = -1;
                
                
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                int ans = helper(i, j, mat, dp);
                max = Math.max(max, ans);
            }
        }
        
        return max;
    }
    
    public int helper(int x, int y, int[][] mat, int[][] dp){
        
        if(dp[x][y] != -1)
            return dp[x][y];
        
        int ans = 1;
        
        // row ->
        for(int col=0; col<mat[0].length; col++){
            
            if(mat[x][col] > mat[x][y]){
                
                int rowAns = 1 + helper(x, col, mat, dp);
                ans = Math.max(ans, rowAns);
            }
        }
        
        // col ->
        for(int row=0; row<mat.length; row++){
            
            if(mat[row][y] > mat[x][y]){
                
                int colAns = 1 + helper(row, y, mat, dp);
                ans = Math.max(ans, colAns);
            }
        }
        
        return dp[x][y] = ans;
                
    }
}


// optimal Sol -> (Need to watch videos on yt for this)
class Solution1 {

    public int maxIncreasingCells(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = mat[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<int[]>());
                }
                map.get(val).add(new int[] {i, j});
            }
        }
        int[][] memo = new int[n][m];
        int[] res = new int[n+m];
        AtomicInteger max = new AtomicInteger();
        map.keySet().stream().sorted().forEach( a -> {
            for (int[] pos : map.get(a)) {
                int i = pos[0], j = pos[1];
                memo[i][j] = Math.max(res[i], res[n + j]) + 1;
                max.set(Math.max(max.get(), memo[i][j]));
            }
            for (int[] pos : map.get(a)) {
                int i = pos[0], j = pos[1];
                res[n + j] = Math.max(res[n + j], memo[i][j]);
                res[i] = Math.max(res[i], memo[i][j]);
            }
        });
        return max.get();
    }
}
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

package Medium;

import java.util.*;

public class RatInMazeProblem1 {
    public static boolean isSafe(int[][] m, int n, int x, int y, boolean[][] visited){
        if(x>=0 && x<n && y>=0 && y<n && m[x][y]==1 && !visited[x][y])
            return true;
        else
            return false;
        
    }
    
    public static void helper(int[][] m, int n, ArrayList<String> ans, String path, boolean[][] visited, int x, int y){
        
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
        }
        
        visited[x][y] = true;
        
        // Down ->
        if(isSafe(m, n, x+1, y, visited)){
            path = path + 'D';
            helper(m, n, ans, path, visited, x+1, y);
            // backtrack
            path = path.substring(0, path.length() - 1);
        }
        
        // left ->
        if(isSafe(m, n, x, y-1, visited)){
            path = path + 'L';
            helper(m, n, ans, path, visited, x, y-1);
            // backtrack
            path = path.substring(0, path.length() - 1);
        }
        
        // Right ->
        if(isSafe(m, n, x, y+1, visited)){
            path = path + 'R';
            helper(m, n, ans, path, visited, x, y+1);
            // backtrack
            path = path.substring(0, path.length() - 1);
        }
        
        // Up ->
        if(isSafe(m, n, x-1, y, visited)){
            path = path + 'U';
            helper(m, n, ans, path, visited, x-1, y);
            // backtrack
            path = path.substring(0, path.length() - 1);
        }
        
        // backtrack
        visited[x][y] = false;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        
        if(m[0][0] == 0) return ans;
        
        String path = "";
        boolean[][] visited = new boolean[n][n];
        int scrx = 0;
        int srcy = 0;
        
        helper(m, n, ans, path, visited, scrx, srcy);
        return ans;
    }
}

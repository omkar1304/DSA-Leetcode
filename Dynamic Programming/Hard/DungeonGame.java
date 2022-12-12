// https://leetcode.com/problems/dungeon-game/

public class DungeonGame {
    public int helper(int[][] matrix, int m, int n, int i, int j, int[][] dp){
        // base case
        
        // if index goes out of bound then we cant reach last cell hence return max value
        if(i >= m || j >= n)
            return Integer.MAX_VALUE;
        
        // if we recahed at last index then -> suppose last cell value -5 
        // then to beat that demon we need +5 health and to keep knight alive we need atleast 1 else -5 + 5 = 0 and he will die
        // but if cell contains any positive value lets say +4 then we only need 1 from that as we need minimum
        if(i == m-1 && j == n-1)
            return matrix[i][j] <= 0 ? Math.abs(matrix[i][j]) + 1 : 1;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // calculate two path
        int down = helper(matrix, m, n, i+1, j, dp);
        int right = helper(matrix, m, n, i, j+1, dp);
        
        // once we get both direction cost then we need to subtract from current cell as we need that health to move on to next cell(down, right)
        int minrequired = Math.min(down, right) - matrix[i][j];
        
        // if minrequired is less than 0 then matrix[i][j] is greater than whatever cost we got from down and right then we only need 1 from that to keep knight alive else if minrequired is greater than 0 then we need minrequired health to keep knight alive
        return dp[i][j] = minrequired <= 0 ? 1 : minrequired;
    }
    
    public int calculateMinimumHP(int[][] matrix) {
        // Memoization->
        int [][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<matrix.length+1; i++){
            for(int j=0; j<matrix[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(matrix, matrix.length, matrix[0].length, 0, 0, dp);
        
    }
}

// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/

public class PathsInMatrixWhoseSumIsDivisibleByK {
    static int mod=1000000007;
    
    public static int helper(int i,int j,int sum ,int k,int grid[][],Integer dp[][][]){
        // base case
        
        // if index goes out of bound then no such path hence return 0
        if(i<0 || j<0)
            return 0;
        
        // if reached at end cell then check if sum is divisible by k or not if yes then we found 1 path else 0
        if(i==0 && j==0){
            if((sum+grid[0][0])% k ==0)
                return 1;
            return 0;
        }
        
        // if present then return
        if(dp[i][j][sum]!=null)
            return dp[i][j][sum]%mod;
        
        // move both direction as mentioned and return sum out of it
        int dir1 = helper(i-1, j, (sum+grid[i][j])%k, k, grid, dp);
        int dir2 = helper(i, j-1, (sum+grid[i][j])%k, k, grid, dp);
        
        // storing for future use
        return dp[i][j][sum]= (dir1 + dir2)%mod;
    } 
    
    public int numberOfPaths(int[][] grid, int k) {
        // Memoization ->
        Integer dp[][][] = new Integer[grid.length+1][grid[0].length+1][k+1];
        
        return helper(grid.length-1,grid[0].length-1,0,k,grid,dp)%mod;

    }
}

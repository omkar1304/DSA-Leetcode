// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/

public class TwoEggDrop {
    public int solve(int e, int f, int[][] dp){
        // base case
        
        // if only 1 egg then we can try same egg for every floor 
        if(e == 1)
            return f;
        // if floor is 1 or 0 then chance to test 0 or 1 
        if(f == 1 || f == 0)
            return f;
        
        // if value present then return
        if(dp[e][f] != -1)
            return dp[e][f];
        
        
        int min = Integer.MAX_VALUE;
        int start = 1; // starting from 1st floor
        int end = f;  // ending from last floor
        
        while(start <= end){
            // find mid and reduce problem into small floor
            int k = start + (end-start) /2;
            
            int left = solve(e-1, k-1, dp); // if egg breaks
            int right = solve(e, f-k, dp); // if egg doesnt break
            
            // already used 1 egg hence adding 1
            // and take max from next break and not break as we need to check for worst condition
            int temp = 1 + Math.max(left, right); 
            // from all worst cases we need to take out small number of ways
            min = Math.min(min, temp);
            
            // reducing problem into small
            // if right is bigger then go to end(as we need to check for worst condition) 
            if(left < right)
                start = k + 1;
            //if left is bigger then go to start
            else
                end = k - 1;
            
        }

        return dp[e][f] = min;
    }
    
    public int twoEggDrop(int n) {
        // Memoization ->
        int[][] dp = new int[2+1][n+1];
        for(int i=0; i<2+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return solve(2, n, dp);
    }
}

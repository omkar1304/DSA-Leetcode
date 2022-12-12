// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

public class MatrixChainMultiplication {
    static int MCM(int[] nums, int i, int j, int[][] dp){
        // base condition -> if i overcomes or equal to array then we dont have any matrix
        // for matrix we need atleast size of 2 array
        if( i >= j)
            return 0;
        
        // if value present then retrun    
        if(dp[i][j] != -1)
            return dp[i][j];
            
        // storing max value as we need to return min    
        int ans = Integer.MAX_VALUE;
        // here we are stopping k at max j-1 as we need to divide problem into two
        // so when k= j-1 then problem -> (i, k) and (k+1, j) -> to avoid out of bound error
        for(int k=i; k<j; k++){ 
            // dividing problem into subproblem -> (i, k) and (k+1, j)
            // and also calculating cost and taking min of at every step
            int temp = MCM(nums, i, k, dp) + MCM(nums, k+1, j, dp) + (nums[i-1] * nums[k] * nums[j]);
            ans = Math.min(ans, temp);
        }
        
        return dp[i][j] = ans;
    }
    
    static int matrixMultiplication(int n, int nums[])
    {
        // code here
        
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        /*
        here i starts from 1 as we know that formula for taking matrix dimensions->
        Ai = nums[i-1] * nums[i] // here we cant start i from 0 as we dont have nums[0-1] i.e. nums[-1]
        */
        return MCM(nums, 1, n-1, dp);
    }
}

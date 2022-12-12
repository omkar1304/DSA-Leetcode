// https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

public class PerfectSumProblem {
    public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n+1][sum+1];
	    int m=1000000007;
	    
        //intializatioin ->
        
        // if array -> i is zero then we cant get required sum hence false(except zero)
	    for(int j=0; j<sum+1; j++)
	        dp[0][j] = 0;
	     
        // if sum is zero then we can get subset by not ioncluding any values hence true   
	    for(int i=0; i<n+1; i++)
	        dp[i][0] = 1;

	    // fill remaining ->
	    for(int i=1; i<n+1; i++){
	        for(int j=0; j<sum+1; j++){
	            
	            if(arr[i-1] <= j)
	                dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j]) % m;
	                
	            else
	                dp[i][j] = (dp[i-1][j]) % m;
	        }
	    }
	        
	    return dp[n][sum] % m; 
	       
	} 
}

// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

public class Minimumsumpartition {
    public void subsetSum(int[] arr, int sum, int n, boolean[][] dp){
        for(int j=0; j<sum+1; j++)
            dp[0][j] = false;
        
        for(int i=0; i<n+1; i++)
            dp[i][0] = true;
            
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    //calculating sum
	    for(int i=0; i<n; i++)
	        sum = sum + arr[i];
	    
	    // just normal subset problem     
	    boolean[][] dp = new boolean[n+1][sum+1];
	    subsetSum(arr, sum, n, dp);
	     
	    // we need to check with last row of dp as its define range of s1 and s2 from 0 to sum where size of array n    
	    int diff = Integer.MAX_VALUE;
	    // we know that in middle diff is less hence start from middle 
	    // as soon as we get true thats at that sum i.e. j is sumsubset 
	    for (int j = sum / 2; j >= 0; j--) { 
            if (dp[n][j] == true) {
                diff = sum - 2 * j;  // (s2 - s1) -> (sum - s1 - s1) -> (sum - 2s1)
                break;
            }
        }
        return diff;
	} 
}

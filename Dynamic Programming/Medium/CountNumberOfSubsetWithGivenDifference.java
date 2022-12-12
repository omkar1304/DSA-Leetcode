// https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628?leftPanelTab=0

public class CountNumberOfSubsetWithGivenDifference {
    public static int subsetSum(int arr[],int n, int sum) 
    { 
        // Your code goes here
        int[][] dp = new int[n+1][sum+1];
        
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
                    dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j]);
                    
                else
                    dp[i][j] = (dp[i-1][j]);
            }
        }
            
        return dp[n][sum]; 
           
    } 
    
	public static int countPartitions(int n, int d, int[] arr) {
        /*
         * 
         * Let sum of subset 1 be s1 and subset 2 with s2
            s1 - s2 = diff (given)
            s1 + s2=sum of array (logical)
            Therefore adding both eq we get :
            2s1= diff + sum of array
            s1= (diff + sum of array)/2;
            Problem reduces to find no of subsets with given sum
         */
        int sum =0;
        for(int x: arr)
            sum = sum + x;
        int s1 = (d + sum) / 2;
        // if diff is greater than sum then 0 subset possible
        // if s1 is decimal thats means we cant divide array with (d+sum) hence no subset
        if(sum < d || (d+sum) %2 != 0) return 0;
        return subsetSum(arr, n, s1);
            
	}
}

// https://leetcode.com/problems/target-sum/

public class TargetSum {
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
    
    public int findTargetSumWays(int[] nums, int target) {
        
        // same problem as -> Count Number Of Subset With Given Difference
        /*
         * Let sum of subset 1 be s1 and subset 2 with s2
            s1 - s2 = diff (given)
            s1 + s2=sum of array (logical)
            Therefore adding both eq we get :
            2s1= diff + sum of array
            s1= (diff + sum of array)/2;
            Problem reduces to find no of subsets with given sum
         */
        int n = nums.length;
        
        int sum = 0;
        for(int x : nums)
            sum = sum + x;
        
        // if target is greater than sum then 0 subset possible
        // if s1 is decimal thats means we cant divide array with (target+sum) hence no subset
        if(sum < Math.abs(target) || (target + sum) % 2 != 0) return 0;
        
        int s1 = (target + sum) / 2;
        return subsetSum(nums, n, s1);
    }
}

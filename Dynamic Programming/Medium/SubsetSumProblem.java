// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

public class SubsetSumProblem {
    static Boolean isSubsetSum(int n, int arr[], int sum){
        
        boolean[][] dp = new boolean[n+1][sum+1];
        
        //intializatioin ->
        
        // if array -> i is zero then we cant get required sum hence false(except zero)
        for(int j=0; j<sum+1; j++)
            dp[0][j] = false;
        
        // if sum is zero then we can get subset by not ioncluding any values hence true   
        for(int i=0; i<n+1; i++)
            dp[i][0] = true;
            
        // fill remaining ->
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                
                // if usum is greater or equal than current value then consider for pick of skip
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                // if not then skip 
                else
                    dp[i][j] = dp[i-1][j];
            } 
        }
        
        return dp[n][sum];
        
    }
}
// memo version

/*
 * public int helper(int n , int arr[] , int sum , int[][]dp){
  
    if(sum < 0){
        return 0;
    }
    
    if(n == 0){
        if(sum == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    if(dp[n][sum] != -1){
        return dp[n][sum];
    }
    
    if(sum >= arr[n-1]){
        
        int include = helper(n-1 , arr , sum-arr[n-1] , dp);
        int exclude = helper(n-1 , arr , sum , dp);
        
        return dp[n][sum] = include | exclude; -> just like OR for number --> 0 | 1 -> 1
    }
    else{
        return dp[n][sum] = helper(n-1 , arr ,sum , dp);
    }
    
}

public boolean canPartition(int[] nums) {
    
    int n = nums.length;
    
    int[][]dp = new int[n+1][sum/2+1];
    for(int []a : dp){
        Arrays.fill(a , -1);
    }
    
    
}
 */
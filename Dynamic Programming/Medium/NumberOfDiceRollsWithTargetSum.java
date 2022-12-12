// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

public class NumberOfDiceRollsWithTargetSum {
    public int helper(int n, int face, int target, int[][] dp){
        // base case
        
        // if dice = 0 and target = 0 then we can do it in one way hence return 1
        if(n == 0 && target==0)
            return 1;
        
        // if anyone is equal or less then 0 then not possible hence return 0
        if(n <= 0 || target <= 0)
            return 0;
        
        // if present then return
        if(dp[n][target] != -1)
            return dp[n][target];
        
        // try with all possiblities and subtract current face from target and return to solve to new subproblem recursively
        // for example -> target 7 then if we throw dice then possible faces -> 1,2,3,4,5,6
        // then subtract each face from target and pass to next call with n-1 dice as we used 1 dice now
        // nd store in sum variable
        int sum = 0;
        for(int index=1; index<=face; index++){
            sum = (sum % 1000000007 + helper(n-1, face, target-index, dp) % 1000000007) % 1000000007;
        }
        
        // store for future use
        return dp[n][target] = sum;
    }
    
    public int numRollsToTarget(int n, int face, int target) {
        // Memoization ->
        int[][] dp = new int[n+2][target+2];
        for(int i=0; i<n+2; i++){
            for(int j=0; j<target+2; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(n, face, target, dp);
        
    }
}

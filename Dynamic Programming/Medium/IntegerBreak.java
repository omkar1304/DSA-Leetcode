// https://leetcode.com/problems/integer-break/

import java.util.*;

public class IntegerBreak {
    public int helper(int num, int index, int[] dp){
        // base case
        
        // if number is 1 then we cant brake into another parts hence retrun 1
        if(index == 1)
            return 1;
        
        // if present then return
        if(dp[index] != -1)
            return dp[index];
        
        // here we only have to divide number for first time 
        // for example n = 4 -> then intgere break -> (1,3), (2,2), (3,1)
        // now (1,3) we know if we make call for 1 then it will retrun 1
        // but for 3 we know max we will get 3 only as we can brake like this
        // 3 -> (3), (1,2), (2,1) why 3 ? as we know the brake condition mentioned in question only applies to start number which is 4 in this case
        // hence if num == index -> we are first time dividing the number hence max = 0
        // if not then we know max we will get is that index only as we see for 3 in above example
        int max = num == index ? 0 : index;
        
        for(int i=1; i<index; i++){
            // get multiplcation of break points
            // e.g. if n == 4 -> helper(1) * helper(3) ->
            int temp = helper(num, i, dp) * helper(num, index-i, dp);
            // store max of every combo of multiplication
            max = Math.max(max, temp);
        }
        
        // storing for future use
        return dp[index] = max;
    }
    
    
    public int integerBreak(int n) {
        // Memoization ->
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return helper(n, n, dp);
    }
}

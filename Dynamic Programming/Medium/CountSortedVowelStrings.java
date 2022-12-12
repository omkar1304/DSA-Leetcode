// https://leetcode.com/problems/count-sorted-vowel-strings/

public class CountSortedVowelStrings {
    public int helper(int n, int index, int[][] dp){
        // base case 
        
        // if string needs that has length 0 then it can be only done in 1 way. hence return 1
        if(n == 0)
            return 1;
        
        // if index goes out of "aeiou" then no need to build any string return 0
        if(index >= 5)
            return 0;
        
        // if present then return
        if(dp[n][index] != -1)
            return dp[n][index];
        
        // for example -> index pointing at a in srtring of "aeiou"
        // then we have two choice pick or skip
        // if pick then this same char we can take further as well hence index remains same and we picked one char hence length should get reduced by 1 
        // if skip then we need to take next element hence increment index by 1 and we didnt pick any hence needed length should be same only
        // return addition of it
        int pick = helper(n-1, index, dp);
        int skip = helper(n, index+1, dp);
        
        // storing for future use
        return dp[n][index] = pick + skip;
        
    }
    
    public int countVowelStrings(int n) {
        // Memoization ->
        int[][] dp = new int[n+1][6];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<6; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(n, 0, dp);
    }
}

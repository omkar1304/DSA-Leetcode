// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        // intialization ->
        // s1 = "" s2 = "ea" -> then ascii cost to make string equal is ascii of ea
        for(int i=1; i<m+1; i++)
            dp[i][0] = dp[i-1][0] + (int)(s1.charAt(i-1));
        for(int j=1; j<n+1; j++)
            dp[0][j] = dp[0][j-1] + (int)(s2.charAt(j-1));
        
        // calculation ->
        // if chars are matching then no need to delete anything so take previous cost i.e diagnoal cell -> dp[i-1][j-1]
        // if chars not matching then we have two delete costs ->
        // cost from s1 + delete current s1 char and cost from s2 + delete current s2 char
        // take min of both and store current
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j] + (int)(s1.charAt(i-1)) ,
                                        dp[i][j-1] + (int)(s2.charAt(j-1)));
            }
        }
        
        // at last cell will get all cost for both whole strings
        return dp[m][n];
    }
}

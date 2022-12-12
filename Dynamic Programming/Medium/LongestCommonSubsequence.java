// https://leetcode.com/problems/longest-common-subsequence/

public class LongestCommonSubsequence {

    // top - dopwn ->
    public int longestCommonSubsequence(String x, String y) {
        
        int m = x.length();
        int n = y.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1; 
            }
        }
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                // initialization
                if(i ==0 || j==0)
                    dp[i][j] = 0;
                    
                // fill remaining

                // if char is matching then add 1 and continue
                else if(x.charAt(i-1) == y.charAt(j-1)) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                // if not then reduce either first string and continue or second string and continue
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
            }
        }

        return dp[m][n];
        
    }
    


    // Recusriopn + Memo ->
    /*
     * static int LCS(String x, String y, int m, int n, int[][] dp){
        
        if(m==0 || n==0)
            return 0;
            
        if(dp[m][n] != -1)
            return dp[m][n];
            
        if(x.charAt(m-1) == y.charAt(n-1))
            return dp[m][n] = 1 + LCS(x, y, m-1, n-1, dp);
            
        else
            return dp[m][n] = Math.max(LCS(x, y, m-1, n, dp) , LCS(x, y, m, n-1, dp));
        
    }
    
    static int lcs(int m, int n, String x, String y)
    {
        // your code here
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1; 
            }
        }

        return LCS(x, y, m, n, dp);
    }
     */
    
}

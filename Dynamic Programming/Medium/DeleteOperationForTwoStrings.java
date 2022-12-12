// https://leetcode.com/problems/delete-operation-for-two-strings/

public class DeleteOperationForTwoStrings {
    public int minDistance(String x, String y) {
        
        int m = x.length();
        int n = y.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                // initialization
                if(i == 0 || j == 0)
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
        
        return m - dp[m][n] + n - dp[m][n];  // additon of deletion formula for both string
    }
}

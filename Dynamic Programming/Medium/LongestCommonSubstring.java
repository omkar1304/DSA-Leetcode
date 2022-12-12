// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

public class LongestCommonSubstring {
    int longestCommonSubstr(String x, String y, int m, int n){
        // code here
        
        int[][] dp = new int[m+1][n+1];
        
        int max = 0;
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                // initialization
                if(i==0 || j==0)
                    dp[i][j] = 0;

                // fill remaining

                // if char is matching then add 1 and continue
                else if(x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                // else string is break now hence put zero    
                else
                    dp[i][j] = 0;
                
                // max substring can be anywher in matrix hence storing max value in max variable
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}

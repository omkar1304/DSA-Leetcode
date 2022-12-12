// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[m+1][n+1];
        
        
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

        // in worst case what we can do add both string to make this as supersequence 
        // but we need to return shortest one. so if we subtract LCS from then as we know LCS will be present in both string.
        // hence its taking place twice -> one in x string and second in y string 
        // hence removing LCS one time will give shortest string hence follow ->  m + n - dp[m][n];
        return m + n - dp[m][n];
    }
}

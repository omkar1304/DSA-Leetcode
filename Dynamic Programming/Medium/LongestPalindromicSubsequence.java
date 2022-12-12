// https://leetcode.com/problems/longest-palindromic-subsequence/

public class LongestPalindromicSubsequence {
    public String reverse(String s){    
        String y = "";
        
        for(int i=s.length()-1; i>=0; i--)
            y = y + s.charAt(i);
        
        return y;  
    }
    
    public int LCS(String x, String y){
        
        int m = x.length();
        int n = y.length();
        
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

        return dp[m][n];
    }
    
    public int longestPalindromeSubseq(String x) {
        
        // formula -> LPS(a) = LCS(a, reverse(a));
        
        String y = reverse(x);
        int lps = LCS(x, y);
        return lps;
        
    }
}

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

// Recursion + Memoization ->
class Solution {
    
    // same problem as LCS here just we need to find palindrome so take another string which is reverse of x and now apply LCS logic
    
    public int longestPalindromeSubseq(String x) {
        
        // get the reverse of x
        String y = reverse(x);
        int count = 0;
        int n = x.length();
        
        // Memoization ->
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++)
            for(int j=0; j<n+1; j++)
                dp[i][j] = -1;
        
        return lps(x, y, 0, 0, dp);
        
    }
    
    public int lps(String x, String y, int i, int j, int[][] dp){
        
        // if any string is completed then just return 0 as we cant match further
        if(i >= x.length() || j >= y.length())
            return 0;
        
        // if present then return 
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // if both are same then we got first palindrom char so add 1 and move both pointers by 1 and check further
        if(x.charAt(i) == y.charAt(j))
            return dp[i][j] = 1 + lps(x, y, i+1, j+1, dp);
        
        // else if doesnt match then we have two choice either inc i pother or j pointer
        int op1 = lps(x, y, i+1, j, dp);
        int op2 = lps(x, y, i, j+1, dp);
        
        // take max out of it and return
        return dp[i][j] = Math.max(op1, op2);
    }
    
    
    public String reverse(String s){    
        String y = "";
        
        for(int i=s.length()-1; i>=0; i--)
            y = y + s.charAt(i);
        
        return y;  
    }
}
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class MinimumInsertionStepsToMakeStringPalindrome {
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
    
    public int minInsertions(String x) {
        
        // formula -> delete : x.length() - lcs.length() and for insert : y.length() - lcs.length()
        // formula -> LPS(a) = LCS(a, reverse(a))
        
        String y = reverse(x);
        int lps = LCS(x, y);
        // here x or y dosent matter as we are making y by doing reverse of x only hence length will be same
        return x.length() - lps; // delete formula -> x.length() - lcs or lps length
    }
}


// Recursion + Memo ->
class Solution {
    public int minInsertions(String x) {
        
        String y = reverse(x);
        
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i=0; i<x.length()+1; i++)
            for(int j=0; j<y.length()+1; j++)
                dp[i][j] = -1;
        
        return x.length() - helper(0, 0, x, y, dp);
    }
    
    public int helper(int i, int j, String x, String y,int[][] dp){
        
        if(i == x.length() || j == x.length())
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(x.charAt(i) == y.charAt(j))
            return 1 + helper(i+1, j+1, x, y, dp);
        
        int op1 = helper(i+1, j, x, y, dp);
        int op2 = helper(i, j+1, x, y, dp);
        
        return dp[i][j] = Math.max(op1, op2);
    }
    
    
    public String reverse(String s){    
        String y = "";
        
        for(int i=s.length()-1; i>=0; i--)
            y = y + s.charAt(i);
        
        return y;  
    }
}
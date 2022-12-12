// https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

public class LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence1(String str)
    {
        // code here
        String x = str;
        String y = str;
        int m = x.length();
        int n = y.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            
            for(int j=0; j<n+1; j++){
                // initialization
                if(i ==0 || j== 0)
                    dp[i][j] = 0;
                    
                // fill remaining

                // if char is matching then add 1 and continue   only if i and j are not at same position
                // as we know we need to take  repeating chars so its should be on different index
                else if(x.charAt(i-1) == y.charAt(j-1) && i != j )
                    dp[i][j] = 1 + dp[i-1][j-1];
                 // if not then reduce either first string and continue or second string and continue    
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    
            }
        }
        
        return dp[m][n];
        
    }
}

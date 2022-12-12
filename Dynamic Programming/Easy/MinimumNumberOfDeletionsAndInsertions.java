// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

public class MinimumNumberOfDeletionsAndInsertions {
    public int minOperations(String x, String y) 
	{ 
	    // Your code goes here
	    
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
        
        int delete = m - dp[m][n]; // formula -> delete : x.length() - lcs.length()
        int insert = n - dp[m][n]; // formula -> insert : y.length() - lcs.length()
        
        return insert + delete;
	} 
}

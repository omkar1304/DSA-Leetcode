// https://leetcode.com/problems/edit-distance/

public class EditDistance {
    public int helper(String s1, String s2, int i, int j, int[][] dp){   
        // base case -?
        
        // if s1 completes first then to make s2 -> whateevr remaining element in s2 we need to add in s1 hence return subtraction of lenght of s2 - currrent index of s2.
        if(i == s1.length())
            return s2.length() - j;
        
        // if s2 completes first then to make s1 -> whateevr remaining element in s1 we need to delete hence return subtraction of lenght of s1 - currrent index of s1.
        if(j == s2.length())
            return s1.length() - i;
        
        // if present then return
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // if chars are matching then opetations -> 0 and move both index by 1
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 0 + helper(s1, s2, i+1, j+1, dp);
        }  
        // if not matching then we have 3 operations -> insert, delete, replace 
        // add 1 as we need to use any operation here and take min of out of three and retrun
        else{
            int insert = 1 + helper(s1, s2, i, j+1, dp);
            int delete = 1 + helper(s1, s2, i+1, j, dp);
            int replace = 1 + helper(s1, s2, i+1, j+1, dp);
            
            return dp[i][j] = Math.min(replace, Math.min(insert, delete));
        }
    }
    
    public int minDistance(String s1, String s2) {
        
        // Memoization ->
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length()+1; i++){
            for(int j=0; j<s2.length()+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(s1, s2, 0, 0, dp);
    }
}

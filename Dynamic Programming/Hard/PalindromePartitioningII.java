// https://leetcode.com/problems/palindrome-partitioning-ii/

public class PalindromePartitioningII {
    public boolean isPalindrome(String s, int l, int r){
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;  
    }
    
    public int solve(String s, int i, int j, int[][] dp){
        if(i>=j)
            return 0;
        
        if(isPalindrome(s, i, j))
            return dp[i][j] = 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            
            // we only want to partition the string and continue if the string we're looking at is a palindrome, incase s[i:k+1] is not a plaindrom, not point trying to split/ add cuts to the seond half of the string. Hence abandon if s[i:k+1] is not a plaindrome. Also if s[i:k+1] is a palindrome, you know the min number of cuts will be zero so no need to recusively call the solve function
            
            // for example -> "aab" then if "aa" is palindrome then only we will partition -> "aa | b"
            // what if we had -> "aba" -> "ab" is not palindrome so no point to calculate this -> "ab | a"
            if(isPalindrome(s, i, k)){
                int temp = 1 + solve(s, k+1, j, dp);
                ans = Math.min(ans, temp);
            }
            
            
        }
        return dp[i][j] = ans;
    }
    
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        return solve(s, 0, s.length()-1, dp);
    }
}

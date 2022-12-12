// https://leetcode.com/problems/regular-expression-matching/

public class RegularExpressionMatching {
    public boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        // base case
        
        // if both strings complete at same time means p can form into s hence return true
        if(i >= s.length() && j>= p.length())
            return true;
        
        // if p strings completes first then we dont have any chars to convert p into s so return false
        if(j >= p.length())
            return false;
        
        // if present then retrun
        if(dp[i][j] != null)
            return dp[i][j];
        
        // we need to check if i in bound(as we cant check in base case)
        // and also if either chars are macthing of both string or there is dot in p
        // and store in result true or false in match
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        
        // for example : a* = ["", "a", "aa", "aaa", ....]
        // if there is '*' then we have two choice either use it or dont use it.
        // use -> then match should be true and we can move index of s by 1 as we found char at i and j remains same.
        // dont use -> then we can move index of p by 2 as we dont want to use '*' e.g. 'a*b' if j at a then we dont want to use it we can jump(j+2) to b and check further
        
        // return OR out of both choice
        if(j+1 < p.length() && p.charAt(j+1) == '*')
            return dp[i][j] = (match && helper(s, p, i+1, j, dp)) || helper(s, p, i, j+2, dp);
        
        // if '*' is not there then its simple char comparsion. if match is true then move both i,j by 1
        if(match)
            return dp[i][j] = helper(s, p, i+1, j+1, dp);
        
        // if they dont match then return false
        return dp[i][j] = false;
   
    }
    
    public boolean isMatch(String s, String p) {
        // Memoization ->
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        
        return helper(s, p, 0, 0, dp);
    }
}

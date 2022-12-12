// https://leetcode.com/problems/interleaving-string/

public class InterleavingString {
    public boolean helper(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][] dp){
        // base case
        
        // if all index reached to -1 position then we succesfully scan s3 string hence return true
        if(index1<0 && index2<0 && index3<0)
            return true;
        
        // if present then return(also take care out of bound error)
        if(index1>=0 && index2>=0 && dp[index1][index2] != null)
            return dp[index1][index2];
        
        // if index1 of s1 and index2 of s2 both matching to index3 of s3 then we need to consider both and return OR out of it
        if(index1>=0 && s1.charAt(index1) == s3.charAt(index3) && index2>=0 && s2.charAt(index2) == s3.charAt(index3))
            return dp[index1][index2] = helper(s1,s2,s3,index1-1,index2,index3-1, dp) || helper(s1,s2,s3,index1,index2-1,index3-1, dp);
        
        // if only index1 of s1 is matching with index3 of s3 then just shift index1 by -1 and same with index3
        else if(index1>=0 && s1.charAt(index1) == s3.charAt(index3))
            return helper(s1,s2,s3,index1-1,index2,index3-1, dp);
        
        // if only index2 of s2 is matching with index3 of s3 then just shift index1 by -1 and same with index3
        else if(index2>=0 && s2.charAt(index2) == s3.charAt(index3))
            return helper(s1,s2,s3,index1,index2-1,index3-1, dp);
        
        // if none of them matching then s3 cant be form using s1 and s2 hence return false
        else return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        // if lengths are not matching then return false
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        // Memoization ->
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        
        return helper(s1, s2, s3, s1.length()-1, s2.length()-1, s3.length()-1, dp);
    }
}

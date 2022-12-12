// https://leetcode.com/problems/palindromic-substrings/

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            
            // odd length ->
            
            // inside to outside palindrome
            int left = i;
            int right = i;
            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                res = res + 1;
                left--;
                right++;
            }
            
            // even length ->
            
            // inside to outside palindrome
            left = i;
            right = i+1;
            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                res = res + 1;
                left--;
                right++;
            }
        }
        
        return res;
    }
}

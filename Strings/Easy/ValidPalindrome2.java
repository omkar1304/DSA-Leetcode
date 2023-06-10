// https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public boolean validPalindrome(String s) {
        
        // apply same isPlaindrome technique ->
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            
            // if both are same then keep checking inside
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            
            // if char not matching then we can either skip ith char or jth char so apply palindrome to them and check if anyone is true then its possible else not
            else
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
        }
        
        // if we come out of while loop then its palidrome so return true
        return true;
    }
    
    // same as isPalindrome method ->
    public boolean isPalindrome(String s, int i, int j){
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}

// https://leetcode.com/problems/reverse-string/

public class ReverseString {
    public void helper(char[] s, int i, int j){
        // base case
        if(i>j)
            return;
        
        // small calculations
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        
        // recursive call
        helper(s, i+1, j-1);
    }
    
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
}

// https://leetcode.com/problems/valid-palindrome/

public class ValidPalindrome {
    public boolean helper(String res){
        int i = 0;
        int j = res.length() - 1;
        while(i < j){
            if(res.charAt(i) != res.charAt(j))
                return false;
            i++;
            j--;
        }      
        return true;
    } 
    public boolean isPalindrome(String s) {
        
        String res = "";
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                res = res + Character.toLowerCase(s.charAt(i));
        }
        return helper(res);
    }
}

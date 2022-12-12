// https://leetcode.com/problems/palindrome-number/



public class PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        // to check num is negative or not
        if(x<0)
            return false;

        // old method to check if its palindrome or not
        int num = x;
        int rev = 0;
        while(num!= 0){
            
            rev = rev*10 + num%10;
            num = num / 10;
        }
        
        return rev == x;
    }
}

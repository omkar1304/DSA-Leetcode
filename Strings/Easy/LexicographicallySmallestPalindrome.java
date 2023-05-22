// https://leetcode.com/problems/lexicographically-smallest-palindrome/

class Solution {
    public String makeSmallestPalindrome(String s) {
        
        // converting string to char Array
        char[] ch = s.toCharArray();
        // two pointers
        int i = 0;
        int j = ch.length - 1;
        
        while(i < j){
            // if matching then update pointer and go for next 
            // if both chars are not matching then update both with min between both char and update pointer. 
   
            if(ch[i] != ch[j]){
               char minChar = (char)(Math.min(ch[i] - 'a', ch[j] - 'a') + 'a');
                ch[i] = minChar;
                ch[j] = minChar;
            }       
                i++;
                j--;   
        }
        
        // convert back char array to string and return
        String result = new String(ch);
        return result;
    }
}
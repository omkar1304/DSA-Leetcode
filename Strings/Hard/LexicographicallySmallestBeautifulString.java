// https://leetcode.com/problems/lexicographically-smallest-beautiful-string/

import java.util.*;
class Solution {
    public String smallestBeautifulString(String s, int k) {
        
        // converting string to char array
        char[] ch = s.toCharArray();
        
        // to iterate char array in reverse order. just like same as next value of 123 is 124
        int index = ch.length - 1;
        
        while(index >= 0){
            
            // increment char at index 
            ch[index]++;
            
            // check if its under k if not then go for its previous char
            if(ch[index] - 'a' >= k)
                index--;
            
            // else if its under k then check for palindrome condition ->
            // for even palindrome -> s[i] != s[i-1]
            // for odd palindrome -> s[i] != s[i-2]
            // same thing we have to check here if its not out bound. if this gives us true then come out from iteration
            else if((index - 1 < 0 || ch[index] != ch[index -1]) && (index - 2 < 0 || ch[index] != ch[index-2]))
                break;
        }
        
        // if we come out due to out of bound like i < 0 then no string possible return empty string
        if(index < 0)
            return "";
        
        // else now we have to make lexicographic string from index + 1 till n 
        // like 1234 so if we change 2 to 3 -> 1334 so we have to make its immediate next -> 1312 (ignoe palindrome here)
        for(int j=index + 1; j<ch.length; j++){
            
            // as we know k always going to be more 3 so to replace all next char from index we can use a,b,c chars. so we dont have to check under k condition anymore
            SortedSet<Character> set = new TreeSet<>(Arrays.asList('a', 'b', 'c'));
            
            // if we get any same character due to which its forming palindrome then remove it from set if its present
            // so if any two char which is equal to a or b or c will get removed and next char will get assigned to char
            if(j - 1 >= 0)
                set.remove(ch[j-1]);
            if(j - 2 >= 0)
                set.remove(ch[j-2]);
            
            // and at last assign first char in set to current jth in char array
            ch[j] = set.first();
            
        }
        
        return new String(ch);
    }
}
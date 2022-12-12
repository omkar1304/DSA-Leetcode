// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

package Medium;

import java.util.*;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    public boolean compare(int[] selected, String currString){
        // first need to check if string itself containing duplicates characters if yes return false
        int[] selfCheck = new int[26];
        for(int j=0; j<currString.length(); j++){
            if(selfCheck[currString.charAt(j) - 'a'] == 1)
                return false;
            selfCheck[currString.charAt(j) - 'a'] = 1;
        }
        // second check if characters from currString already appeard in selected array or not if yes return false;
        for(int j=0; j<currString.length(); j++){
            if(selected[currString.charAt(j) - 'a'] == 1)
                return false;
        }
        
        // if everything is fine then we can consider this string for pick or skip
        return true;
        
    }
    
    public int helper(List<String> arr, int[] selected, int len, int index){
        // base case
        if(index == arr.size())
            return len;
        
        
        String currString = arr.get(index); // interate each string
        
        if(!(compare(selected, currString))) // if it is overlapping we can skip this string
            return helper(arr, selected, len, index+1);
        
        else{
            //pick 
            for(int j=0; j<currString.length(); j++){
                selected[currString.charAt(j) - 'a'] = 1; // marking as 1 -> its selected now
            }
            len = len + currString.length(); // adding length of currString as we pick this
            int op1 = helper(arr, selected, len, index+1);
            
            // skip
            for(int j=0; j<currString.length(); j++){
                selected[currString.charAt(j) - 'a'] = 0; // marking as 0 -> to cleanup
            }
            len = len - currString.length();  // removing length of currString as we skip this
            int op2 = helper(arr, selected, len, index+1);
            
            return Math.max(op1, op2); // returning max from picking choice and skipping choice
            
        }
        
    }
    
    public int maxLength(List<String> arr) {
        int[] selected = new int[26];
        int len = 0;
        int index = 0;
        int ans = helper(arr, selected, len, index);
        return ans;
    }
}

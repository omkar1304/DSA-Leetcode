// https://leetcode.com/problems/letter-case-permutation/

package Medium;

import java.util.*;

public class LetterCasePermutation {
    public void helper(String s, String temp, List<String> res, int index){
        // base case
        if(index == s.length()){
            res.add(temp);
            return;
        }
        // if number is there then we have only one choice include and move ahead
        if(Character.isDigit(s.charAt(index))){
            temp = temp + s.charAt(index);
            helper(s, temp, res, index+1);
            temp = temp.substring(0, temp.length()-1);
        }
        else{
            // if letter is there then we have two choice
            
            // include with lower case
            temp = temp + Character.toLowerCase(s.charAt(index));
            helper(s, temp, res, index+1); // recursive call
            temp = temp.substring(0, temp.length()-1); // backtrck
            
            // include with upper case
            temp = temp + Character.toUpperCase(s.charAt(index));
            helper(s, temp, res, index+1); // recursive call
            temp = temp.substring(0, temp.length()-1); // backtrack
  
        }
    }
    
    
    public List<String> letterCasePermutation(String s) {
        
        List<String> res = new ArrayList<>();
        String temp = "";
        int index = 0;
        helper(s, temp, res, index);
        return res;
    }
}

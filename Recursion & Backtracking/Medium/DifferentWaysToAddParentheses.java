// https://leetcode.com/problems/different-ways-to-add-parentheses/

package Medium;

import java.util.*;

public class DifferentWaysToAddParentheses {
    public int helper(int x, int y, char c){
        if(c == '+') return x + y;
        if(c == '-') return x - y;
        if(c == '*') return x * y;
        return -1;
    }
    public List<Integer> diffWaysToCompute(String str) {
        
        List<Integer> result = new ArrayList<>();
        boolean number = true;
        
        for(int i=0; i<str.length(); i++){
            // check if current character is an operator
            if(!Character.isDigit(str.charAt(i))){
                // if current character is not a digit then
                // exp is not purely a number
                number = false;
                
                // list of first operands
                List<Integer> left = diffWaysToCompute(str.substring(0, i));
                // list of second operands
                List<Integer> right = diffWaysToCompute(str.substring(i+1));
                //cslculations
                for(int x : left){
                    for(int y: right){
                        int val = helper(x, y, str.charAt(i));
                        result.add(val);
                    }
                }
                
            }
        }
        // if number is positibve -> str contains only numbers then convert into int and add in res.
        if(number)
            result.add(Integer.valueOf(str));
        
        return result;
        
    }
}

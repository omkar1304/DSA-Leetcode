// https://leetcode.com/problems/generate-parentheses/

package Medium;

import java.util.*;

public class GenerateParentheses {
    public void helper(List<String> res, String temp, int open, int close){
        if(open == 0 && close==0){
            res.add(temp);
            return;
        }
        
        if(open > 0){
            temp = temp + '(';
            helper(res, temp, open-1, close); // recursive call 
            temp = temp.substring(0, temp.length()-1); // backtrack
        }
        
        if(close > open){
            temp = temp + ')';
            helper(res, temp, open, close-1); // recursive call 
            temp = temp.substring(0, temp.length()-1); // backtrack
        }   
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        String temp = "";
        int open = n;
        int close = n;
        
        helper(res, temp, open, close);
        return res;
        
    }
}

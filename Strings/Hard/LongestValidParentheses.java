// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.*;
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        
        // stack to store index of '('
        Stack<Integer> stack = new Stack<>();
        // pushing -1 as what if we get ')' then we dont have anything to pop hence putting -1 
        stack.push(-1);
        
        int max = 0;
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            // if we get open bracket then push index of it in stack
            if(c == '(')
                stack.push(i);
            else{
            // if we get close bracket then pop out top index from stack as we found 1 pair only if stack is not empty if stack is empty then close bracket is apppreas before open hence push index of close
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }     
                else{
                    // if not then get length of current pair -> current index - peek element
                    int len = i - stack.peek();
                    // store max pair length everytime
                    max = Math.max(max, len);
                }
            }
        }
        
        return max;
    }
}

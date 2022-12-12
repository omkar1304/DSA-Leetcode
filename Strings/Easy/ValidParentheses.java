// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            
            char a = s.charAt(i);
            
            if(a == '(' || a == '{' || a == '[') stack.push(a);
            if(stack.isEmpty()) return false;
            if(a == ')' && stack.pop() != '(') return false;
            if(a == '}' && stack.pop() != '{') return false;
            if(a == ']' && stack.pop() != '[') return false;
        }
        
        return stack.isEmpty();
        
    }
}

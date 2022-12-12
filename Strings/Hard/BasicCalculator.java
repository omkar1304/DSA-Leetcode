// https://leetcode.com/problems/basic-calculator/

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 1;
        
        for(int i=0; i<s.length(); i++){
            
        // number
        if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int num = 0;
            while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            
            sum = sum + num * sign;
            i--;
        }
        // +
        else if(s.charAt(i) == '+')
            sign = 1;
        // -
        else if(s.charAt(i) == '-')
            sign = -1;
        // (
        else if(s.charAt(i) == '('){
            stack.push(sum);
            stack.push(sign);
            sum = 0;
            sign = 1;
        }
        // )
        else if(s.charAt(i) == ')'){
            sum = stack.pop() * sum;
            sum = sum + stack.pop();
        }
            
        }
        return sum;
    }
}

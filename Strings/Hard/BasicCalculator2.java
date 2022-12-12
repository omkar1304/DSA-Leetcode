// https://leetcode.com/problems/basic-calculator-ii/

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            
            //number
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--; // to avoid skip part
                
                // storing number with current sign
                
                // + -> directly push num
                if(sign == '+')
                    stack.push(num);
                // - -> directly push num with - sign 
                else if(sign == '-')
                    stack.push(-num);
                // * -> get the previous number from stack and multiply and push in stack.
                else if(sign == '*'){
                    num = stack.pop() * num;
                    stack.push(num);
                }
                // / -> get the previous number from stack and divide and push in stack.
                else if(sign == '/'){
                    num = stack.pop() / num;
                    stack.push(num);
                }
            }
            // if not number then space or operator
            else if(s.charAt(i) != ' ')
                sign = s.charAt(i);   
            
        }
        
        
    
    // now stack only conatins number which either positive or negavtive. just add them and get the result.
    int sum = 0;
    for(int n : stack)
        sum = sum + n;
    
    return sum;
        
    }
}

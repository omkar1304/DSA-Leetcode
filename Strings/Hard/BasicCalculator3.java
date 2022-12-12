// https://www.lintcode.com/problem/849/description

import java.util.Stack;

public class BasicCalculator3 {
    static class Pair{
        Stack<Integer> stack;
        char sign;
        Pair(Stack<Integer> st , char si){
            stack = st;
            sign = si;
        }
    }

    public void helper(Stack<Integer> stack, int num, char sign){
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
    
    public int calculate(String s) {
        Stack<Pair> stackP = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for(int i=0; i<s.length(); i++){
            // number
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                helper(stack, num, sign);
            }
            else if(s.charAt(i) == '('){
                stackP.push(new Pair(stack, sign));
                sign = '+';
                stack = new Stack<>();
            }
            else if(s.charAt(i) == ')'){
                int num = 0;
                while(stack.size() > 0)
                    num = num + stack.pop();
                Pair p = stackP.pop();
                helper(p.stack, num, p.sign);
            }
            else if(s.charAt(i) != ' ')
                sign = s.charAt(i); 
        }

        int sum = 0;
        for(int n : stack)
            sum = sum + n;
        
        return sum;

    }
}

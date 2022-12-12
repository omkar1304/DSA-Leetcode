// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

class Solution {
    public boolean isValidSerialization(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        
        if(preorder == null)
            return false;
        
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        
        // taking each string in strs
        for(int i=0; i<strs.length; i++){
            
            String curr = strs[i];
            
            // if curr is # and stack top also # then its both childeren null hence node is visited hence pop # first and check if stack is empty if yes then return false as to visited any node we need order in stack like this # # node
            while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals(curr)){
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            // if its num or #(only if stack top not equal to #) then push into stack
            stack.push(curr);
        }
        
        // at the end stack left with # if this condition matches then return true else false
        if(stack.size() == 1 && stack.peek().equals("#"))
            return true;
        else
            return false;
    }
}
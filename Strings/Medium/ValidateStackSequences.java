// https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        // to itrate over popped array
        int popIndex = 0;
        Stack<Integer> stack = new Stack();
        
        // taking out psuh number from pushed array
        for(Integer pushNumber : pushed){
            
            // push number in stack
            stack.push(pushNumber);
            
            // if popindex is less than popped lenegth and stack is not empty and also number at popindex in popped array is equal to stack top number then pop out element and move to next pop number
            while(popIndex < popped.length && !stack.isEmpty() && popped[popIndex]==stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        
        // at last if stack is empty then all numbers are executed successfully then return true else return false
        return stack.isEmpty();
    }
}
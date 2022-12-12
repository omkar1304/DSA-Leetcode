// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                res[stack.peek()] = i - stack.pop();
            
            stack.push(i);
        }
        
        return res;
    }
}

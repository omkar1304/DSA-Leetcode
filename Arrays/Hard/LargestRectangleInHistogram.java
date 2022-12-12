// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        
        // fill left
        for(int i=0; i<n; i++){
            
            if(leftStack.isEmpty()){
                left[i] = 0;
                leftStack.push(i);
            }
            
            else{
                while(!leftStack.isEmpty() && a[leftStack.peek()] >= a[i])
                    leftStack.pop();
            
                left[i] = leftStack.isEmpty() ? 0 : leftStack.peek() + 1;
                leftStack.push(i);
            }
        }
        // System.out.println(Arrays.toString(left));
        // fill right
        for(int i=n-1; i>=0; i--){
            if(rightStack.isEmpty()){
                right[i] = n - 1;
                rightStack.push(i);
            }
            
            else{
                while(!rightStack.isEmpty() && a[rightStack.peek()] >= a[i])
                    rightStack.pop();
            
                right[i] = rightStack.isEmpty() ? n -1 : rightStack.peek() - 1;
                rightStack.push(i);
            }
        }
        // System.out.println(Arrays.toString(right));
        // calculate maxArea
        int maxArea = 0;
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * a[i]);
        }
        
        return maxArea;
    }
}

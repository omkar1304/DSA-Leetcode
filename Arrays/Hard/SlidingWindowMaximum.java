// https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            
            // to remove index from dq which is out of window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.pollFirst();
            
            // to remove indices whose corresponding values are less than nums[i]
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            
            // add index of nums
            dq.offerLast(i);
            
            // add max in res array when i >= 2 if k = 3
            if(i >= k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
        }
        
       return res;
    }
}

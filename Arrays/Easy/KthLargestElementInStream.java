// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.*;

class KthLargest {
    // largest kth means we have to create priority queue with min heap
    PriorityQueue<Integer> pq;
    // setting global variable to get k value everywhere
    int limit;
    
    public KthLargest(int k, int[] nums) {
        
        // assigning value based on k
        limit = k;
        pq = new PriorityQueue<>(k);
        
        // filling queue with give nums using below add method
        for(int val : nums)
            add(val);
        
    }
    
    public int add(int val) {
        
        // if pq has size less than k then just add it
        if(pq.size() < limit)
            pq.add(val);
        // if its alreayd fill with k elements then check top element in pq.
        // if its less than current val then remove top element and add current val
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        
        // as we are using min heap and storing max values in pq with size k
        // so whichever minimum value from maximum values will be always on top so we can return that
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
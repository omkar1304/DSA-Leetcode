// https://leetcode.com/problems/wiggle-sort-ii/

import java.util.*;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new  PriorityQueue<>(Collections.reverseOrder());
         
         for(int i: nums)
             pq.add(i);
         
         int size = pq.size();
         for(int i=1; i<size; i=i+2)
             nums[i] = pq.poll();
         
         for(int i=0; i<size; i=i+2)
             nums[i] = pq.poll();
     }
}

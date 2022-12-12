// https://leetcode.com/problems/the-skyline-problem/

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<int[]> height = new ArrayList<>();     // height list to store all buildings' heights
        for (int[] b : buildings) {
            height.add(new int[]{b[0], - b[2]});    // start of a building, height stored as negtive
            height.add(new int[]{b[1], b[2]});      // end of a building, height stored as positive
        }
        Collections.sort(height, (a,b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int cht = 0;
        
        for (int[] h : height) {
            if (h[1] < 0) {     // h[1] < 0, that means it meets a new building, so add it to pq
                pq.offer(-h[1]);
            } else {            // h[1] >=0, that means it has reached the end of the building, so remove it from pq
                pq.remove(h[1]);
            }
            
            // the current max height in all encountered buildings
            int curMax = pq.peek();
            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if (curMax != cht) {
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(pq.peek());
                res.add(temp);
                cht = curMax;
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/merge-intervals/

import java.util.*;


public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length != 0 || intervals != null){
            Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

            int start = intervals[0][0];
            int end = intervals[0][1];

            for(int[] i : intervals){

                if(end >= i[0])
                    end = Math.max(end, i[1]);

                else{
                    int[] temp = {start, end};
                    res.add(temp);
                    start = i[0];
                    end = i[1];
                }
        }
        int[] temp = {start, end};
        res.add(temp);
    }
    return res.toArray(new int[0][]); 
    }
}

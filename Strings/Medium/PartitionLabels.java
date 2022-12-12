// https://leetcode.com/problems/partition-labels/

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        // storing last index of each char in map
        for(int i=0; i<n; i++)
            map.put(s.charAt(i), i);
        
        int size = 0;
        int end = 0;
        
        for(int i=0; i<n; i++){
            int index = map.get(s.charAt(i));
            end = Math.max(end, index);
            // if i==end then we reached maximum of last index
            if(i == end){
                ans.add(size+1);
                size = 0;
            }
            else
                size++;
        }
        return ans;
    }
}

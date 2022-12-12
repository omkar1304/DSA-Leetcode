// https://leetcode.com/problems/intersection-of-two-arrays-ii/


import java.util.*;

class IntersectionofTwoArraysII {
    public int[] intersect(int[] num1, int[] num2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : num2){
          if(map.containsKey(i))
              map.put(i, map.get(i)+1);
          else
              map.put(i, 1);
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : num1){
            if(map.containsKey(i) && (map.get(i) > 0)){
                al.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        
        int[] res = new int[al.size()];
        for(int i=0; i<al.size(); i++){
            res[i] = al.get(i);
        }
        return res;
    }
}
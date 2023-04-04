// https://leetcode.com/problems/intersection-of-two-arrays-ii/


import java.util.*;

// TC -> O(n) | SC -> O(n) 
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

// TC -> O(nlogn) | SC -> O(1) (ignore result array and list space)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while(i < n && j < m){
            
            int a = nums1[i], b= nums2[j];
            
            if(a == b){
                list.add(a);
                i++;
                j++;
                
            }else if(a < b){
                i++;
                
            }else{
                j++;
            }
        }
        
        int[] ret = new int[list.size()];
        
        for(int k = 0; k < list.size();k++) 
            ret[k] = list.get(k);
        
        return ret;
    }
}
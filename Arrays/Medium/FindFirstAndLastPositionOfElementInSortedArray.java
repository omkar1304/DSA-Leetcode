// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/



public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = bsfirst(nums, target);
        res[1] = bslast(nums, target);
        return res;
        
    }
    
    
    public int bsfirst(int[] a, int t){
        int idx = -1;
        int l = 0;
        int h = a.length - 1;
        while(l <= h){
            int m = (l+h) / 2;
            
            if(a[m] == t) 
                idx = m;
            
            if(t <= a[m])
                h = m - 1;
            else
                l = m + 1;
            
            
        }
        return idx;
    }
    
    public int bslast(int[] a, int t){
        int idx = -1;
        int l = 0;
        int h = a.length - 1;
        while(l <= h){
            int m = (l+h) / 2;
            
            if(a[m] == t) 
                idx = m;
            
            if(t >= a[m])
                l = m + 1;
            else
                h = m - 1;
        }
        return idx;
    }
}

// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

import java.util.*;
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        // to check Arithmetic progression we need elememts in sorted order
        Arrays.sort(arr);
        // get the intial diff
        int diff = arr[1] - arr[0];
        
        // iterate over array and if any difference is not equal to initial diff then return false. if loops end without any false then return true
        for(int i=2; i<arr.length; i++)
            if(arr[i] - arr[i-1] != diff)
                return false;
        
        return true;
    }
}
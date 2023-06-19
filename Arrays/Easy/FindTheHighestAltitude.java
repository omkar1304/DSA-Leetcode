// https://leetcode.com/problems/find-the-highest-altitude/

class Solution {
    public int largestAltitude(int[] gain) {
        
        // to store max altitude 
        int max = 0;
        // to store prefix sum of altitude
        int prefix = 0;
        
        for(int i=0; i<gain.length; i++){
            
            // take sum of altitudes
            int sum = prefix + gain[i];
            // store max out of it
            max = Math.max(max, sum);
            // update prefix
            prefix = sum;
        }
        
        return max;
    }
}
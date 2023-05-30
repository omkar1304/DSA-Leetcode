// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal/

class Solution {
    public long minimumCost(String s) {
        
        int n = s.length();
        // to store min cost 
        long ans = 0;
        
        for(int index=1; index<n; index++){
            
            // if we see characters are not matching then at we have to perfrom invert opeation. so check what invert operation we can choose to make cost min. i.e. from the front or from the back.
            if(s.charAt(index - 1) != s.charAt(index))
                ans = ans + Math.min(index, n - index);
            
        }
        
        return ans;
    }
}
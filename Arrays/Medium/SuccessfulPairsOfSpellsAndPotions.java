// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        // sorting potions so we can apply Binary Search to avoid unneccessary checks
        Arrays.sort(potions);
        
        // creating result array to store success count of each spells
        int[] result = new int[spells.length];
        
        for(int i = 0; i < spells.length; i++) {
            
            // creating two pointer to implement BS
            int low = 0, high = potions.length;
            
            while(low < high) {
                
                // calculating mid
                int mid = low + (high - low) / 2;
                
                // if thier product is higher than success then whatever spells right after mid index is going to be part of success product so moving high to left side
                if((long)spells[i]*potions[mid]  >= success)
                    high = mid;
                
                // else their product is less than success then whatever spells left side of mind index is not going to part of success product hence to skip those we can move low to right side
                else
                    low = mid+ 1;
            }
            
            // after BS low will stand at index where after low all values of spell can be part of success product so getto=ing count
            result[i] = potions.length - low;
        }
        
        // at the end return result
        return result;
    }
}
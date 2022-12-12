// https://leetcode.com/problems/contains-duplicate/


import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }
        
        return !(nums.length == set.size());
        
    }
}

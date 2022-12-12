// https://leetcode.com/problems/two-sum/


import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            Integer diff = (Integer)(target - nums[i]);
            if (map.containsKey(diff)){

                int toreturn[] = {map.get(diff), i};
                return toreturn;
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

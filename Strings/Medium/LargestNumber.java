// https://leetcode.com/problems/largest-number/

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        
        // convert int array into string array
        String[] strNums = new String[nums.length];
        for (int i=0; i<nums.length; i++) 
            strNums[i] = Integer.toString(nums[i]);
        
        // sort array based on -> 1 > 2 ? 1 : 2
        Arrays.sort(strNums, (a,b) -> ((b+a).compareTo(a+b)));
        
        // if array contains leading zero then whole number would be zero only
        if(strNums[0].equals("0")) return "0";
        
        // converting String array into string
        String res = "";
        for (String str : strNums)
            res = res + str;
            
        return res;
        
    }
}

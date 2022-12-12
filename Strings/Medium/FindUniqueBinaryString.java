// https://leetcode.com/problems/find-unique-binary-string/

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        String ans = "";
        for(int i=0; i<nums.length; i++){
            ans += nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return ans;
        
    }
}

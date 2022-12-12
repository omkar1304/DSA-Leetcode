// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package Medium;
import java.util.*;
public class LetterCombinationsOfPhoneNumber {
    private void helper(String digits, String temp, List<String> ans, int index, String[] mapping){
        // base case
        if(index == digits.length()){
            ans.add(temp);
            return;
        }
        
        // small calculation
        int number = digits.charAt(index) - '0';
        String value = mapping[number];
        
        for(int i=0; i<value.length(); i++){
            temp = temp + value.charAt(i);
            helper(digits, temp, ans, index+1, mapping);
            temp = temp.substring(0, temp.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        int index = 0;
        String[] mapping = {"", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits, "", ans, index, mapping);
        return ans;
        
    }
}

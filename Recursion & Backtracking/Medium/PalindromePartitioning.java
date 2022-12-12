// https://leetcode.com/problems/palindrome-partitioning/

package Medium;

import java.util.*;

public class PalindromePartitioning {
    public boolean isPalindrome(String s, int l, int r){
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;  
    }
    
    public void helper(String s, List<String> temp, List<List<String>> res, int index){
        // base case
        if(index >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int j=index; j<s.length(); j++){
            if(isPalindrome(s, index, j)){
                temp.add(s.substring(index, j+1));
                //recursive call
                helper(s, temp, res, j+1);
                //backtrack
                temp.remove(temp.size() - 1);
            }
        } 
    }
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        int index = 0;
        helper(s, new ArrayList<>(), res, index);
        return res;
        
    }
}

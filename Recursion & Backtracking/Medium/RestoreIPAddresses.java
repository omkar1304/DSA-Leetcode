// https://leetcode.com/problems/restore-ip-addresses/

package Medium;

import java.util.*;

public class RestoreIPAddresses {
    public void helper(String s, String temp, int dots, int index, List<String> res){
        
        if(dots == 4 && index == s.length()){ // if 4 dots included and index == length then valid temp 
            res.add(temp.substring(0, temp.length() - 1)); // to extract last dot
            return;
        }
        
        if(dots > 4)
            return;
        
        // we can run j for 3 times only as we know that last valid number is 255
        // to avoid out of bound error taking min of index+3 and string length
        for(int j=index; j<(Math.min(index+3, s.length())); j++){ 
            // value should be less than 256 and first char should not be 0 followed by 1 to 9
            if(Integer.parseInt(s.substring(index, j+1)) < 256 && (index==j || s.charAt(index)!='0')){
                helper(s, temp + s.substring(index, j+1) + ".", dots+1, j+1, res);   
            } 
        }
        
    }
    
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4) return res;
        int index = 0;
        int dots = 0;
        String temp = "";
        helper(s, temp, dots, index, res);
        return res;
        
    }
}

// https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for(int i=0; i<strs[0].length(); i++){ // iterate first string
            
            for(String s : strs){ // iterate through every strings
                if(i >= s.length() || s.charAt(i) != strs[0].charAt(i))
                    return res;
            }
            res = res + strs[0].charAt(i);
        }   
        return res;  
    }
}

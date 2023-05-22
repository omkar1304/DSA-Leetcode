// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/

class Solution {
    public int minLength(String s) {
        
        // keep removing until s contains "AB" or "CD"
        while(s.contains("AB") || s.contains("CD")){
            
            // if s contains "AB" then update s with before "AB" part and after "AB" part
            if(s.contains("AB"))
                s = s.substring(0, s.indexOf("AB")) + s.substring(s.indexOf("AB")+2, s.length());
            
            // if s contains "CD" then update s with before "CD" part and after "CD" part
            if(s.contains("CD"))
                s = s.substring(0, s.indexOf("CD")) + s.substring(s.indexOf("CD")+2, s.length());
            
        }
        
        // return length of s
        return s.length();
    }
}
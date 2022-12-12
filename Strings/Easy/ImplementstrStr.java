// https://leetcode.com/problems/implement-strstr/

public class ImplementstrStr {
    public int strStr(String s1, String s2) {
        
        if(s2.length() == 0) return 0;
        if(s1.length() < s2.length()) return -1;
        
        for(int i=0; i<s1.length(); i++){
            // Math.min(i+s2.length(), s1.length()) -> to avoid out of bound error
            if(s1.charAt(i) == s2.charAt(0) && s2.equals(s1.substring(i, Math.min(i+s2.length(), s1.length()))))
                return i;
        }
        
        return -1;
        
    }
}

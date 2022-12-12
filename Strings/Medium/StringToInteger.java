// https://leetcode.com/problems/string-to-integer-atoi/

public class StringToInteger {
    public int myAtoi(String s) {
        
        if(s.length() == 0) return 0;
        
        int res = 0;
        int i = 0;
        int sign = 1;
        
        //to ignore whitespace at start
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        
        // to check if there is any negative or positive sign
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        // now we just have to check char should be between 0 to 9 and it should not exceed max value.
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)){
                if(sign == -1)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
               
            res = res * 10 + (int)(s.charAt(i) - '0');
            i++;
               
        }
        
        return res*sign;  
        
    }
}

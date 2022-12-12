// https://leetcode.com/problems/fraction-to-recurring-decimal/

import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // checking if any negative number if yes then store
        boolean isNegative = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? true : false;
         
        // storing it in long as value is bigger
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        
        // creating map and string
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        
        // first remainder and quotient
        long q = num / deno;
        long r = num % deno;
        
        sb.append(q);

        // if remiander is not zero that means it contains decimal henece add "."
        if (r != 0) {
            sb.append(".");
        }
        
        // now same as we do in maths if number is not divisble then multiply by 10 and check again 
        // here if same remainder already there in map then by using index value we can retrun ans in correct pattern.
        // but if not then add quotient in ans and add remainder in map.
        int index = 0;
        while (r != 0) {
            r = r * 10; 
            q = Math.abs(r / deno);
            if (!map.containsKey(r)) {
                sb.append(q);
                map.put(r, index);
                index++;
            } else {
                int pos = 1 + map.get(r) + sb.indexOf(".");
                sb.insert(pos, '(');
                sb.append(")");
                break;
            }
            r = r % deno;
        }
        
        // if it is negative then add "-";
        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}

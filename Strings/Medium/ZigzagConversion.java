// https://leetcode.com/problems/zigzag-conversion/

public class ZigzagConversion {
    public String convert(String s, int rows) {
        if(rows == 1) return s;
        
        String res = "";
        // to imagine num of rows we are creating 
        for(int r=0; r<rows; r++){
            int increment = (rows - 1) * 2; // it will constant 
            for(int i=r; i<s.length(); i=i+increment){
                res = res + s.charAt(i);
                // it will only run when row is miidle one(expect first and last row)
                // just add (- 2 * r) to original increment formula to get second char as well
                if(r > 0 && r < rows-1 && (i+increment - 2 * r) < s.length())
                    res = res + s.charAt(i+increment - 2 * r);
            }
        }
        
        return res;
    }
}

// optimized ->
class Solution {
    public String convert(String s, int numRows) {
        
        char[] c = s.toCharArray();
        int len = c.length;
        
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for(int i=0; i<sb.length; i++)
            sb[i] = new StringBuilder();
        
        int index = 0;
        
        while(index < len){
            // vertically down
            for(int idx=0; idx<numRows && index<len; idx++)
                sb[idx].append(c[index++]);
            // obliquely up
            for(int idx=numRows-2; idx>0 && index<len; idx--)
                sb[idx].append(c[index++]);
        }
        
        for(int i=1; i<sb.length; i++)
            sb[0].append(sb[i]);
        
        return sb[0].toString();
    }
}

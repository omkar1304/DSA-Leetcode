// https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

package Medium;

public class SplittingStringIntoDescendingConsecutiveValues {
    
    public boolean helper(int index, double prev, String s){
        
        if(index == s.length())
            return true;
        
        for(int j=index; j<s.length(); j++){ // to get second half
            double val = Double.parseDouble(s.substring(index, j+1)); // storing second half
            // if prev is greater than val then sattisfy both condition.
            if((val + 1 == prev) && helper(j+1, val, s)) 
                return true;
        }
        
        return false;
        
    }
    
    public boolean splitString(String s) {
        
        for(int i=0; i<s.length() -1; i++){ // to get first half
            
            double val = Double.parseDouble(s.substring(0, i+1)); // storing first half
             if(helper(i+1, val, s)) // looking for next half
                 return true;
        }
        
        return false;
    }
}

// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

class Solution {
    public int countSubstrings(String s, String t) {
        
        /*
        Try every single substring from s and t then check if its differ by 1 then inc count by 1 if its greater than 1 then we can skip it
        */
        
        int count = 0;
        
        // taking every string from s
        for(int i=0; i<s.length(); i++){
            
            // taking every string from t
            for(int j=0; j<t.length(); j++){
                
                // at every i and j from s and t we have to find substring. so created x, y to iterate the same
                int x = i;
                int y = j;
                // at every combination we have to check differ count
                int diff = 0;
                
                while(x < s.length() && y < t.length()){
                    
                    // if any string is not matching then inc diff by 1
                    if(s.charAt(x) != t.charAt(y))
                        diff++;
                    
                    // if diff is 1 then its required substring as per question so inc counter
                    if(diff == 1)
                        count++;
                    
                    // if diff goes beyond by 1 then its not gonna give us result so stop it here
                    if(diff == 2)
                        break;
                    
                    // else just update counter
                    x++;
                    y++;
                }
            }
        }
        
        // return count at the end
        return count;
    }
}
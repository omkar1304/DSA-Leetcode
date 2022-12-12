// https://leetcode.com/problems/scramble-string/

import java.util.HashMap;

public class ScrambleString {
    public boolean solve(String a, String b, HashMap<String, Boolean> map){
        // if both are same then its scramble
        if(a.equals(b))
            return true;
        // if length of any string is less or equal to 1 then it cant be scramble
        if(a.length() <= 1)
            return false;
        
        // check if its present in map or not if yes then return
        String temp = "";
        temp = temp + a + " " + b;
        if(map.containsKey(temp))
            return map.get(temp);
        
        int n = a.length();
        boolean isScrambled  = false;
        // i=1 s we need atleast one char to check
        for(int i=1; i<n ; i++){
            // condition 1 (swap done) -> gr | eat === eat | gr
            // solve(first part of a, second part of b) && solve(second art of a, first part of b) -> both should true if it needs to be scramble
            if(solve(a.substring(0, i), b.substring(n-i, n), map) && solve(a.substring(i, n), b.substring(0, n-i), map)  || 
            // condition 2 (swap not done) ->  gr | eat === gr | eat
            // solve(first part of a, second part of b) && solve(second part of a, second part of b) -> both should true if it needs to be scramble
               solve(a.substring(0, i), b.substring(0, i), map) && solve(a.substring(i, n), b.substring(i, n), map) ){
                // if anyone is true then its scramble
                isScrambled  = true;
                break;
            }   
        }
        
       // put before returning into map for future calculation 
        map.put(temp, isScrambled);
        return isScrambled ;     
    }
    
    
    public boolean isScramble(String a, String b) {
        
        // if length not same then it cant be scramble string
        if(a.length() != b.length())
            return false;
        // if both empty then it is scramble
        if(a == "" && b == "")
            return true;
        
        HashMap<String, Boolean> map = new HashMap<>();
        return solve(a,b, map);
    }
}

// https://leetcode.com/problems/isomorphic-strings/

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // key -> char of s
        // value -> char of t
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            // if key is not present but value already present then retrun false
            if(!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i)))
                return false;
            // if key only not present then add into map and value in set
            else if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
            // key present in map but value dosen't match then return false
            else if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
        }  
        
        // if everything is fine then return true
        return true;   
    }
}

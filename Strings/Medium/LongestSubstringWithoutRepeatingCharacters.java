// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int i=0, j=0, max=0;
        
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j = j + 1;
            }
            else{
                set.remove(s.charAt(i));
                i = i + 1;
            }
        }
        return max;
    }
}

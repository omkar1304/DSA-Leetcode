// https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.*;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //if p length is greater than s then return empty res
        if(s.length() < p.length())
            return res;
        
        int[] parray = new int[26];
        int[] sarray = new int[26];
        int window = p.length();
        int len = s.length();
        int left = 0;
        int right = 0;
        
        // just filling first window
        while(right < window){
            parray[p.charAt(right) - 'a'] = parray[p.charAt(right) - 'a'] + 1;
            sarray[s.charAt(right) - 'a'] = sarray[s.charAt(right) - 'a'] + 1;
            right++;
        }
        // to comeback at window last index
        right--;
        while(right < len){
            
            // just check if array same or not if yes then store left index as it is start index
            if(Arrays.equals(sarray, parray))
                res.add(left);
            // now we have to expand window from right side and shrink window from left side
            // expanding right side -> by adding next right index count
            right++;
            if(right != len) // just checking if its going out of length
                sarray[s.charAt(right) - 'a'] = sarray[s.charAt(right) - 'a'] + 1;
            
            // shrinking left side -> by removing previous left index count
            sarray[s.charAt(left) - 'a'] = sarray[s.charAt(left) - 'a'] - 1;
            left++;
        }
        
        return res;
    }
}

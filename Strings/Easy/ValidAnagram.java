// https://leetcode.com/problems/valid-anagram/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int[] alphabet = new int[26];
        // to fill alphabet number with their occurance count as per s string
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        // to fill alphabet number with decrementing thier count as per t string 
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        // if i is not zero then that means count is mismatch retrun false. 
        for (int i : alphabet) if (i != 0) return false;
        return true;
        
    }
}

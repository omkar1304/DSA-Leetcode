// https://leetcode.com/problems/count-vowels-permutation/

import java.util.*;
public class CountVowelsPermutation {
    private int mod = (int)1e9 + 7;
    
    public long helper(int n, char c, Map<String, Long> map){
        // if n is 0 then we found ine string hence return 1
        if(n == 0)
            return 1L;
        
        // if present then return
        String temp = String.valueOf(n) + String.valueOf(c);
        if(map.containsKey(temp))
            return map.get(temp);
        
        long count = 0;
        // check current c and calculate recursively
        switch (c) {
            case 'a':
                // after a only e is allowed
                count = helper(n-1, 'e', map);
                break;
            case 'e':
                // after e only a and i are allowed
                count = (helper(n-1, 'a', map) + helper(n-1, 'i', map));
                break;
            case 'i':
                // after i except i everything is allowed
                count = (helper(n-1, 'a', map) + helper(n-1, 'e', map) + helper(n-1, 'o', map) + helper(n-1, 'u', map));
                break;
            case 'o':
                // after o only i and u are allowed
                count = (helper(n-1, 'i', map) + helper(n-1, 'u', map));
                break;
            case 'u':
                // after u only a is allowed
                count = (helper(n-1, 'a', map));
                break;
            default :
                return 0;
        }
        
        // storing for future use
        map.put(temp, count % mod);
        return count;
    }
    
    
    public int countVowelPermutation(int n) {
        // Memoization ->
        Map<String, Long> map = new HashMap<>();
        
        //call for each starting from each vowel after that for changing the character values our recursive call will take care of
        return (int) ((helper(n-1, 'a', map) + helper(n-1, 'e', map) + helper(n-1, 'i', map) + helper(n-1, 'o', map) + helper(n-1, 'u', map)) % mod);
        
    }
}

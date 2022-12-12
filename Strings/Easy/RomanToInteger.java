// https://leetcode.com/problems/roman-to-integer/

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        int i=0;
        while(i < s.length()){
            // I can be placed before V (5) and X (10) to make 4 and 9. 
            if(s.charAt(i) == 'I'){
                if((i+1 < s.length()) && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    sum += s.charAt(i+1) == 'V' ? (map.get('V') - map.get('I')) : (map.get('X') - map.get('I'));
                    i = i + 2;
                }
                else{
                    sum += map.get('I');
                    i = i + 1;
                }
            }
            // X can be placed before L (50) and C (100) to make 40 and 90. 
            else if(s.charAt(i) == 'X'){
                if((i+1 < s.length()) && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    sum += s.charAt(i+1) == 'L' ? (map.get('L') - map.get('X')) : (map.get('C') - map.get('X'));
                    i = i + 2;
                }
                else{
                    sum += map.get('X');
                    i = i + 1;
                }
            }
            // C can be placed before D (500) and M (1000) to make 400 and 900.
            else if(s.charAt(i) == 'C'){
                if((i+1 < s.length()) && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    sum += s.charAt(i+1) == 'D' ? (map.get('D') - map.get('C')) : (map.get('M') - map.get('C'));
                    i = i + 2;
                }
                else{
                    sum += map.get('C');
                    i = i + 1;
                }
            }
            // if other charcters then jus add value
            else{
                sum += map.get(s.charAt(i));
                i = i + 1;
            }
              
        }
        
        return sum;
        
    }
}

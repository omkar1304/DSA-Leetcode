// https://leetcode.com/problems/largest-palindromic-number/

class Solution {
    public String largestPalindromic(String num) {
        
        // create frequency table using array for 0 to 9 numbers
        int[] frequency = new int[10];
        for(int i=0; i<num.length(); i++){    
            char ch = num.charAt(i);
            frequency[ch - '0']++;
        }
        
        // to get center number in longest palindromic string
        int center = -1;
        // to store first half of longest palindromic string
        StringBuilder first = new StringBuilder();
        
        // we need largest so we will start from 9 to 0 so it will take large number first
        for(int i=9; i>=0; i--){
            
            // if frequency count of number is odd that means we can put number in center so assigned it to center
            if(frequency[i] % 2 == 1 && center == -1)
                center = i;
            
            // if string is empty and number is 0 then we can skip as we dont need leading zeroes
            if(first.length() == 0 && i == 0)
                continue;
            
            // else we can form number. take pair variable to check how many pairs we stored in first string
            int pair = 0;
            while(pair < frequency[i] / 2){
                first.append(String.valueOf(i));
                pair++;
            }
        }
        
        // for example num = "444947137". then first will contain -> "744"
        // copy same to second string
        StringBuilder second = new StringBuilder(first.toString());
        
        // if center is there then add it so now string -> "7449"
        if(center != -1)
            first.append(String.valueOf(center));
        
        // now store reverse of second in first. so finally -> "7449447"
        first.append(second.reverse().toString());
        
        // return string
        return first.length() == 0 ? "0" : first.toString();
    }
}
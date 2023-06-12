// https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/

class Solution {
    public String smallestString(String s) {
        
        // converting string to char array
        char[] ch = s.toCharArray();
        // index to iterate over char array 
        int index = 0;
        
        // here we have to check if char is a then on its previous element we can perform operations or if strings starts with a then on its next elements we can perform opertions until we get another a
        
        // if string starts with a then move the index till we get another char than a
        if(ch[0] == 'a'){
            
            // skip char a 
            while(index < s.length() && ch[index] == 'a')
                index++;
            
            // in case if string ends(exaample s="aaaa") then we have to add z at the end to make it next lexicographically smaller and return            
            if(index == s.length()){
                ch[index - 1] = 'z';
                return String.valueOf(ch);
            }
        }
        
        // if strings not ends then simply we have to perform operation until we get another a or string ends
        if(ch[index] != 'a'){
            
            while(index < s.length() && ch[index] != 'a'){
                ch[index] = (char)(ch[index] - 1);
                index++;
            }
        }
        
        // return updated char to string 
        return String.valueOf(ch);
        
    }
}
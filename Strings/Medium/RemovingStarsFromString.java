// https://leetcode.com/problems/removing-stars-from-a-string/

class Solution {
    public String removeStars(String s) {
        
        // creating string builder to perform remove and add functionalities 
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            // if current char is * then remove last element in string 
            if(ch == '*')
                sb.setLength(sb.length() - 1);
            // else add it
            else
                sb.append(ch);
        }
        
        return sb.toString();
    }
}
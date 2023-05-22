// https://leetcode.com/problems/number-of-senior-citizens/

class Solution {
    public int countSeniors(String[] details) {
        
        // created counter to count no of passengers having age more than 60
        int count = 0;
        
        for(String s : details){
            
            // calculate age ->
            int age = (s.charAt(11) - '0') * 10 + (s.charAt(12) - '0');
            
            // if greater than 60 then inc count by 1
            if(age > 60)
                count++;
        }
        
        return count;
    }
}
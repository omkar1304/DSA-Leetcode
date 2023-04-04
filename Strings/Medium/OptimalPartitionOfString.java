// https://leetcode.com/problems/optimal-partition-of-string/

// Brute force ->
class Solution {
    public int partitionString(String s) {
        
        // to store unique char in set
        Set<Character> set = new HashSet<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            // if char is not in set then add in set
            if(!set.contains(ch)){
                set.add(ch);
            }
            // if its in set then inc count by 1 as we found one substring and clear set and add current char
            else{
                count++;
                set.clear();
                set.add(ch);    
            }
        }
        
        // inc by count by 1 as we need add last substring which we missed above after for loop ends
        return count+1;
    }
}

// Optimal sol ->
class Solution {
    public int partitionString(String s) {
        
        // creating array to store last seen index as per string 
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        // creating startSubstring to store start index of substring
        int startSubstring = 0;
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            
            // if lastseen of current char is part of subtstring means its equal or greater than startSubstring then its repeating hence inc count by 1 and update startSubstring to i as we start new string 
            if(lastSeen[ch - 'a'] >= startSubstring){
                count++;
                startSubstring = i;
            }
            
            // at every step update lastseem of char to i
            lastSeen[ch - 'a'] = i;
        }
        
        // inc by count by 1 as we need add last substring which we missed above after for loop ends
        return count+1;
    }
}
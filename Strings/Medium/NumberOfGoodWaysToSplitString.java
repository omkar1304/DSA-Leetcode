// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

class Solution {
    public int numSplits(String s) {
        
        // to keep track of count of good split
        int count = 0;
        
        // creating two maps to store distinct letters at every step
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        
        // at start all letters will be in right side so put all letters with their frequncy in right map
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            rightMap.put(ch, rightMap.getOrDefault(ch, 0) + 1);
        }
        
        // now we have to split string at every index and check if left and right string contains same no of distinct letters
        for(int i=0; i<s.length()-1; i++){
            
            char ch = s.charAt(i);
            
            // so at i th index that letter will go from right map to left map 
            
            // so add that char in left map or if already present then update its frequency 
            leftMap.put(ch, leftMap.getOrDefault(ch, 0) + 1);
            
            // now decrement the frequency of that char in right map and also check if after decreasing frequency is 0 if yes then remove that char from right map
            rightMap.put(ch, rightMap.get(ch) - 1);
            if(rightMap.get(ch) == 0)
                rightMap.remove(ch);
            
            // now check if both map size is same if yes then update count by 1
            if(leftMap.size() == rightMap.size())
                count++;
        }
        
        // return count at the end
        return count;
    }
}
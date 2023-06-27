// https://leetcode.com/problems/frequency-tracker/

import java.util.*;

// Brute force -> 

class FrequencyTracker {
    
    Map<Integer, Integer> map;

    public FrequencyTracker() {
        
        map = new HashMap<>();
    }
    
    public void add(int number) {
        
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public void deleteOne(int number) {
        
        if(map.containsKey(number)){
            
            map.put(number, map.get(number) - 1);
            
            if(map.get(number) == 0)
                map.remove(number);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        
        return map.containsValue(frequency);
    }
}

// Optimal sol -> to avoid O(n) while determining if frequency is present or not in Data structure we can use frequency array which stores count of frequencies and can get result in O(1)

class FrequencyTracker1 {
    
    Map<Integer, Integer> map;
    int[] frequency;

    public FrequencyTracker1() {
        
        map = new HashMap<>();
        frequency = new int[100001];
    }
    
    public void add(int number) {
        
        if(map.containsKey(number)){            
            int count = map.get(number);         
            map.put(number, map.get(number) + 1);            
            frequency[count]--;
            frequency[count+1]++;
        }
        else{
            map.put(number, 1);
            frequency[1]++;
        }
    }
    
    public void deleteOne(int number) {
        
        if(map.containsKey(number)){
            
            int count = map.get(number);
            
            map.put(number, map.get(number) - 1);
            
            if(map.get(number) == 0)
                map.remove(number);
            
            frequency[count]--;
            frequency[count-1]++;
        }
        
    }
    
    public boolean hasFrequency(int frequencyCount) {
        
        return frequency[frequencyCount] > 0;
    }
}



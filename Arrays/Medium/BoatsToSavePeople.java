// https://leetcode.com/problems/boats-to-save-people/

import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        // sort the people array so we can weights of people in sorted order
        Arrays.sort(people);
        
        // Two pointer approach ->
        int counter = 0;
        int i = 0;
        int j = people.length - 1;
        
        // keep looping until i is less or equal to j
        while(i <= j){
            
            // if ith and jth person sum is less than limit then we can carry both of them in one boat so inc counter by 1 and shift the pointers
            if(people[i]+people[j] <= limit){
                counter++;
                i++;
                j--;
            }
            // if not possible to carry both i and j person then carry the single person which havong higher weight which is nothing but j as we sort in ascending order. inc counter by 1 and shift j pointer
            else{
                counter++;
                j--;
            }
        }
        
        // return counter
        return counter;
    }
}
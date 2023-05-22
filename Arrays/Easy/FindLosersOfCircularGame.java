// https://leetcode.com/problems/find-the-losers-of-the-circular-game/

class Solution {
    public int[] circularGameLosers(int n, int k) {
        
        // to check if anyone got ball or not. if num is present in set that means that num didnt get ball
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++)
            set.add(i);
        
        // to calculate number in circular array
        int number = 1;
        // to update passing value 
        int i = 1;
        
        // if any number is not there and we passed ball to it then its second time so stop the game
        while(set.contains(number)){
            
            // remove number from set as its got the ball
            set.remove(number);
            
            // calculate number in circular array using % n
            number = (number + (i * k)) % n;
            
            // if number == 0 then its n only in circular
            if(number == 0)
                number = n;
            i++;
        }
        
        // at last set will contain all numbers which didnt get any ball. try to convert set into int array and return
        int[] result = new int[set.size()];
        int index = 0;
        for(int num : set){
            result[index] = num;
            index++;
        }
        
        return result;
    }
}
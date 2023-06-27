// https://leetcode.com/problems/buy-two-chocolates/

import java.util.*;

class Solution {
    public int buyChoco(int[] prices, int money) {
        
        // storing initial money to sum
        int sum = money;
        // to count how many chocolates we buy
        int count = 0;
        
        // sorting array so smaller price will come at start so we can buy 2 chocolates within given money
        Arrays.sort(prices);
        
        for(int i=0; i<prices.length; i++){
            
            // if sum < 0 then we dont have money so break it
            if(sum < 0)
                break;
            
            // if count == 2 then we completed task so break
            if(count == 2)
                break;
            
            // else buy chocolate and update count 
            sum = sum - prices[i];
            count++;
        }
        
        // check if sum < 0 then return money else return remaining amount
        return sum >= 0 ? sum : money;
    }
}
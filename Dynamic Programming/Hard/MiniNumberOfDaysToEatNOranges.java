// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/

import java.util.*;
public class MiniNumberOfDaysToEatNOranges {
    private HashMap<Integer,Integer> mp = new HashMap<>();
    
    public int minDays(int n) {
        // base case
        
        // if 0 orange then no. of days to eat 0
        if(n==0)
            return 0;
        
        // if 1 orange then no. of days to eat 1
        if(n == 1)
            return 1;
        
        // if present then return
        if(mp.containsKey(n))
            return mp.get(n);
        
        // now we have three options -> eat 1 per day which gives us result nothing but n days.
        // so we know that our ans should be <= n
        // but here we have other two option n/2 and n/3 so we can say that ans should be <= log2n
        // now we can ignore 1 choice i.e. eat 1 orange per day as it gives max ans and we need small ans
        // for example we have 11 oranges -> to divide this by 2 we need to eat 1 orange and then we can divide 10 remaining oranges
        // i.e. 11%2 -> 1 and then 10/2 = 5 oranges(sub problem) left so to remove extra like here 1 we need first option
        // and how many first options do we need is depends on extras -> n % 2 
        // same we have to do it for thrid oprion i.e. n/3
        // 1 -> as we used 1 day to eat n/2 or n/3 oranges
        // and retrun min of it.
        mp.put(n, 1 + Math.min(n % 2 + minDays(n/2), n % 3 + minDays(n/3)));
        return mp.get(n);
    }
}

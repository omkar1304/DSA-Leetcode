// https://leetcode.com/problems/count-numbers-with-unique-digits/

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        // here we know that for n = 1 we have 0 to 9 unique digits 
        // so we stored it already in ans and now we have to find unique digits of length 2 to n
        int ans = 10; // 0 - 9 : 10 unique numbers for n == 1
        // now supporse we need to get unique digits for n = 4
        // how many choices do we have 
        //    _ _ _ _ 
        // -> 9 _ _ _ (1-9 can fill at first place)
        // -> 9 9 _ _ (0-9 can fill at second place with excluding which we select at first)
        // -> 9 9 8 _ (0-9 can fill at third place with excluding 2 digits which we select at first and second place)
        // -> 9 9 8 7 (0-9 can fill at fourth place with excluding 3 digitts which we select at first, second, third)
        // so total will be -> 9 * 9 * 8 * 7 for 4 digit number 
        // and res = result of 1 + result of 2 + result of 3 + resulf of 4 
        
        int current = 9; // this first place where we have 1 - 9 choice to put at start as above
        int start = 9; // this is variable which keeps decreasing as we see from second to last positon as above -> 9,8,7
        int i = 2; // as we already stored result of 1 then we only need to find 2 to n
        while(i <= n){
            current = current * start; // same as above -> 9*9 then 9*8 then 9*7 
            ans = ans + current; // storing values for future use
            start = start - 1;
            i = i + 1; // once we get result of i then calculate for i+1 till n
        }
       
       // return final ans
       return ans; 
    }
}

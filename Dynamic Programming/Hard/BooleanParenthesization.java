// https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1

import java.util.HashMap;

public class BooleanParenthesization {
    static int solve(String s, int i, int j, boolean isTrue, HashMap<String , Integer> map){
        // if string is empty then we can find any true value;
        if(i > j)
            return 0;
        // if sting contains only one then it must be 'T' or 'F'
        // if we want true value and it is T then return 1(we found 1 true value) else (we didnt find any hence 0)
        // same case with false as well(else part)
        if(i == j){
            if(isTrue)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }
        
        // make string and check if it is in map if yes then retrun
        String temp = "";
        temp = temp + i + " " + j + " " + isTrue;
        
        if(map.containsKey(temp))
            return map.get(temp);
        
        // counting ->
        int count = 0;
        // here left -> i to k-1 and right -> k+1 to j and k -> operator ( &, | , ^)
        for(int k = i+1; k<j; k=k+2){
            // same as McM but here for left part we have two calls -> True , False
            // same for right part calls -> True, False
            int lt = solve(s, i, k-1, true, map);
            int lf = solve(s, i, k-1, false, map);
            int rt = solve(s, k+1, j, true, map);
            int rf = solve(s, k+1, j, false, map);
            
            // if k is '&' then for true and false we need to calculate count. same for '|' and '^'
            if(s.charAt(k) == '&'){
                if(isTrue)
                   count = count + (lt * rt);
                else
                    count = count + (lt * rf) + (lf * rt) + (lf * rf);
            }
            else if(s.charAt(k) == '|'){
                if(isTrue)
                   count = count + (lt * rt) + (lt * rf) + (lf * rt);
                else
                    count = count  + (lf * rf);
            }
            else if(s.charAt(k) == '^'){
                if(isTrue)
                   count = count + (lt * rf) + (lf * rt);
                else
                    count = count  + (lf * rf) + (lt * rt);
            }
        }
        // store in map for future calculation and return
        map.put(temp, count%1003);
        return count%1003;
    }
    
    static int countWays(int n, String s){
        // code here
        int i = 0;
        int j = n -1;
        boolean isTrue = true;
        HashMap<String , Integer> map = new HashMap<>();
        return solve(s, i, j, isTrue, map);
    }
}

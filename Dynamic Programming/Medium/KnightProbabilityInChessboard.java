// https://leetcode.com/problems/knight-probability-in-chessboard/

import java.util.*;

public class KnightProbabilityInChessboard {
    public double helper(int n, int k, int r, int c, Map<String, Double> map){
        // base case
        
        // if index goes out of bound then 0 probability to stay knight in chess
        if(r < 0 || c < 0 || r >= n || c >= n)
            return 0;
        
        // if we done with moves then return 1
        if(k==0)
            return 1;
        
        // if present then return
        String temp = "";
        temp = temp + r + "->" + c + "->" + k;
        if(map.containsKey(temp))
            return map.get(temp);
        
        // explore all direction and return sum
        double op1 = helper(n, k-1, r+2, c+1, map);
        double op2 = helper(n, k-1, r+2, c-1, map);
        double op3 = helper(n, k-1, r-2, c+1, map);
        double op4 = helper(n, k-1, r-2, c-1, map);
        double op5 = helper(n, k-1, r-1, c+2, map);
        double op6 = helper(n, k-1, r+1, c+2, map);
        double op7 = helper(n, k-1, r+1, c-2, map);
        double op8 = helper(n, k-1, r-1, c-2, map);
        
        double sum = op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8;
        // storing for future use
        map.put(temp, sum);
        return sum;
    }
    
    public double knightProbability(int n, int k, int row, int col) {
        // Memoization ->
        Map<String, Double> map = new HashMap<>();
        
        // we have total chance which is pow(8, k)
        // and we need to return probability -> sum / chance (simple maths probability formula)
        // hence sum / pow(8, k)
        return helper(n, k, row, col, map) / Math.pow(8, k);
    }
}

// https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

package Medium;

import java.util.*;

public class PrintNBitBinaryNumbersHavingMore1sthan0s {
    void helper(ArrayList<String> res, String temp, int nOnes, int nZeros, int n){
        if(n == 0){
            res.add(temp);
            return;
        }
        
        temp = temp + '1';
        helper(res, temp, nOnes+1, nZeros, n-1);
        temp = temp.substring(0, temp.length() - 1);
        
        if(nOnes > nZeros){
            temp = temp + '0';
            helper(res, temp, nOnes, nZeros+1, n-1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
    
    
    ArrayList<String> NBitBinary(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        String temp = "";
        int nOnes = 0;
        int nZeros = 0;
        helper(res, temp, nOnes, nZeros, n);
        return res;
    }
}

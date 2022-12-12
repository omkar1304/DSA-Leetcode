// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

package Medium;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        
        if(n == 1)
            return '0'; // S1 can only give '0'
        
        int len = (int)Math.pow(2, n); // length of imaginary Sn
        
        if(k == len/2) 
            return '1'; // the middle character from S2 ... Sn will always be '1'
        
        if(k < len/2)
            return findKthBit(n-1, k); // the string to the left of middle character is the same as the string Sn-1
        
        return findKthBit(n-1, len-k) == '0' ? '1' : '0'; // if you want a character after mid you have to reverse both the position and the character
         
    }
}

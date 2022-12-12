// https://leetcode.com/problems/count-good-numbers/

package Medium;

public class CountGoodNumbers {
    public long modPow(long x, long n)
    {
        if (n == 0)
            return 1;
        long v = modPow(x, n / 2);
        
        if(n % 2 == 0)
            return ((v*v) % 1000000007);
        else
            return ((v*v*x) % 1000000007);
    }

    public int countGoodNumbers(long n) {
        
        long odd = n/2;
        long even = n - odd;
        
        return (int)(modPow(5, even) * modPow(4, odd) % 1000000007);   
        
    }
}

// https://leetcode.com/problems/powx-n/

package Medium;

public class Pow {
    public double power(double x, int n){
        if(n == 0) return 1;
        
        double v = power(x, n/2);
        
        // for example 2^10 = 2*2 ^ 10/2 -> x^n = x*x ^ n/2
        // if n is even 2^4 = 2^2 * 2^2 -> v*v
        // if n is odd 2^5 = 2 * 2^2 * 2^2; -> x * v * V
        if(n % 2 == 0)
            return v*v;
        else
            return v*v*x;
    }
    
    public double myPow(double x, int n) {
        if(n < 0)
            // 2 ^ -2 = 1 / 2^2
            return 1 / power(x, -n);
        else
            return power(x, n);
    }
}

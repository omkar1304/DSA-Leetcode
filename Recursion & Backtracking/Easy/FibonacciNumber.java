// https://leetcode.com/problems/fibonacci-number/

public class FibonacciNumber {
    public int fib(int n) {
        // base case
        if(n == 1 || n == 0)
            return n;
            
         // recursive call
        return fib(n-1) + fib(n-2);
    }
}

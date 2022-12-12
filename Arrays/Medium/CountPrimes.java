// https://leetcode.com/problems/count-primes/

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        // assuming all numbers are prime
        Arrays.fill(isPrime, true);
        
        // prime -> 2 to sqrt(n) -> i<=sqrt(n) -> i*i<=n
        for(int i=2; i*i<n; i++){
            // if number is not prime then no need to check multiples 
            if(!isPrime[i]) continue;
            
            // if number is prime then mark all their multiple as false
            for(int j=2*i; j<n; j=j+i)
                isPrime[j] = false;
        }
        
        // count no of true == no of primes
        for(int i=2; i<n; i++){
            if(isPrime[i]) count++;
        }
        
        return count;
    }
}

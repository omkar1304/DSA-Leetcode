// https://leetcode.com/problems/counting-bits/

public class CountingBits {
    public int[] countBits(int n) {
        
        int[] ans = new int[n+1];
        for(int i=1; i<n+1; i++){
            // for even -> take value of half of i from ans array
            if(i % 2 == 0)
                ans[i] = ans[i/2];
            else
            // for odd ->just add 1 from previous value
                ans[i] = ans[i-1] + 1;
        }
        
        return ans;
    }
}

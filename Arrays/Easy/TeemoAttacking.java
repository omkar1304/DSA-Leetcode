// https://leetcode.com/problems/teemo-attacking/

public class TeemoAttacking {
    public int findPoisonedDuration(int[] t, int d) {
        
        int total = 0;
        
        for(int i=0; i<t.length - 1; i++){
            // if next attack occurs before current duration ends, include the difference
            if(t[i+1] <= t[i] + d - 1)
                total = total + t[i+1] - t[i];
            else
                total = total + d;
        }
        total = total + d;
        return total;
    }
}

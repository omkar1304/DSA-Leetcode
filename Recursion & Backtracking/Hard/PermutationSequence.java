// https://leetcode.com/problems/permutation-sequence/

package Hard;

import java.util.*;

public class PermutationSequence {
    public String helper(int n, int k, List<Integer> nums, int[] fact, String res){
        
        if(nums.size() == 1){
            res = res + nums.get(0);
            return res;
        }
        
        int grp = fact[n-1] / n;
        res = res + nums.get(k/grp);
        nums.remove(k/grp);
        k = k % grp;
        
        return helper(n-1, k, nums, fact, res);
        
    }
    
    
    public String getPermutation(int n, int k) {
        
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n];
        int mul = 1;
        
        for(int i=1; i<=n; i++){
            nums.add(i);
            mul = mul * i;
            fact[i-1] = mul;
        }
        return helper(n,k-1, nums, fact, "");
        
    }
}

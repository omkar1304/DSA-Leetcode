// https://leetcode.com/problems/combination-sum-iii/

package Medium;

import java.util.*;

public class CombinationSum3 {
    public void helper(int size, int sum, List<List<Integer>> res, List<Integer> temp, int index, int currSum){

        // base cases 
        
        // if size = temp.size tehn check if sum = currSum if yes store if not then return
        if(temp.size() == size){
            if(currSum == sum){
                res.add(new ArrayList<>(temp));
                return;
            }
            else return;
        }
        
        // if temp.size > size then we no need to go further
        if(temp.size() > size) return;
        
        // if index goes beyond 9 then return
        if(index > 9) return;
        
        // if currSum > sum then no need to go further
        if(currSum > sum) return;
        
        
        //pick
        temp.add(index);
        helper(size, sum, res, temp, index+1, currSum+index);
        
        //skip 
        temp.remove(temp.size() - 1);
        helper(size, sum, res, temp, index+1, currSum);
        
        
    }
    
    
    
    public List<List<Integer>> combinationSum3(int size, int sum) {
        
        List<List<Integer>> res = new ArrayList<>();
        int index = 1;
        int currSum = 0;
        helper(size, sum, res, new ArrayList<>(), index, currSum);
        return res;
        
    }
}

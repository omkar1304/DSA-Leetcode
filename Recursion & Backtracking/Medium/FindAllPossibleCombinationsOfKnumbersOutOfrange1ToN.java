// https://www.codingninjas.com/codestudio/problems/combinations_3625257?leftPanelTab=0

package Medium;

import java.util.*;

public class FindAllPossibleCombinationsOfKnumbersOutOfrange1ToN {
    public static void helper(int n, int k, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int index){
        
        // base case1 : to get exact k elements 
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        // base case2 : if we know that at some point if we take every element then also will not get elements = k then just return it from here
        if(k - temp.size() > n - index + 1) return;

        // base case3 : if index > n then we have to stop it as we cover all elements from 1 to n
        if(index > n) return;

        //pick 
        temp.add(index);
        helper(n, k, ans, temp, index+1);
        
        //skip
        temp.remove(temp.size() - 1);
        helper(n, k, ans, temp, index+1);
        
    }
    
    
    public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
        // Write your code here..
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int index = 1;
        helper(n, k, ans, new ArrayList<>(), index);
        return ans;
    }
}

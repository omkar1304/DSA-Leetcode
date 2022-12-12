// https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1

import java.util.*;

public class FindtheSafePosition {
    static int helper(List<Integer> person, int n, int k, int index){
        if(person.size() == 1)
            return person.get(0);
            
        
        index = (index + k) % person.size();
        person.remove(index);
        return helper(person, n, k, index);
    }
    
    static int safePos(int n, int k) {
        // code here
        List<Integer> person = new ArrayList<>();
        for(int i=1; i<=n; i++){
            person.add(i);
        }
        int index = 0;
        k = k - 1;
        int ans = helper(person, n, k, index);
        return ans;
    }
}
    // // using while loop -> 
    
    // // static int safePos(int n, int k) {
    // //     // code here
    // //    List<Integer> list = new ArrayList<>();
    // //    for(int i=1;i<n+1;i++){
    // //        list.add(i);
    // //    }
    // //    int index=0;
    // //    k--;
    // //    while(list.size()!=1){
    // //        index = (index+k)%list.size();
    // //        list.remove(index);
    // //    }
    // //    return list.get(0);
    // }


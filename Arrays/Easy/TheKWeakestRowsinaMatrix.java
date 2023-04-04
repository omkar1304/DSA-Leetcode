// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/


import java.util.ArrayList;
import java.util.Collections;

public class TheKWeakestRowsinaMatrix {
     // to count number of one's in array(1D)
     public int countofone(int[] a){
        int counter = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]==1)
                counter++;
        }
        return counter;
    }
    
    // to return slice of array till k index
    public int[] getSliceOfArray(int[] res, int k){
        int[] slice = new int[k];
        for(int i=0; i<k; i++){
            slice[i] = res[i];
        }
        return slice;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        
        ArrayList<Integer> count = new ArrayList<>();
        int[] res = new int[mat.length];
        int c = 0;
        
        // to get count list 
        for(int i=0; i<mat.length; i++){
            int numofone = countofone(mat[i]);
            count.add(numofone);
        }
        
        // to get res array as per weakest rows
        while(c < count.size()){
            
            int minValue = Collections.min(count);
            int minIndex = count.indexOf(minValue);
            res[c] = minIndex;
            count.set(minIndex, Integer.MAX_VALUE);
            c = c + 1;   
        }
        
        int[] slice = getSliceOfArray(res, k);
        return slice;
        
    }
}

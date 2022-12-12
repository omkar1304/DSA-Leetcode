// https://leetcode.com/problems/plus-one/



public class PlusOne {
    public int[] plusOne(int[] a) {
        
        for(int i=a.length-1; i>=0; i--){
            
            if(a[i] < 9){
                a[i] = a[i] + 1;
                return a;
            }
            a[i] = 0;
        }
        
        int res[]= new int[a.length+1];
        res[0]=1;

        return res;
    }
}

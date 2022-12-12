// https://leetcode.com/problems/richest-customer-wealth/

public class RichestCustomerWealth {
    public int maximumWealth(int[][] a) {
        
        int maxSum =0;
        
        for(int i=0; i<a.length; i++){
            int sum = 0;
            for(int j=0; j<a[i].length; j++){
                sum = sum + a[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

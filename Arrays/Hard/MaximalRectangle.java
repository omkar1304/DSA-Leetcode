// https://leetcode.com/problems/maximal-rectangle/

import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] currRow = new int[col];
        int maxArea = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                currRow[j] = matrix[i][j] == '1' ? currRow[j]+1 : 0;
            }
            
            int currArea = helper(currRow);
            maxArea = Math.max(maxArea, currArea);
        }  
        return maxArea;
    }
    
    // same question -> LargestRectangleInHistogram(1D)
    public int helper(int[] a){
        int area = 0;
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        
        //fill left
        for(int i=0; i<n; i++){
            if(ls.isEmpty()){
                left[i] = 0;
                ls.push(i);
            }
            else{
                while(!ls.isEmpty() && a[ls.peek()] >= a[i])
                    ls.pop();
                left[i] = ls.isEmpty() ? 0 : ls.peek() + 1;
                ls.push(i);
            }
        }
        // fill right
        for(int i=n-1; i>=0; i--){
            if(rs.isEmpty()){
                right[i] = n - 1;
                rs.push(i);
            }
            else{
                while(!rs.isEmpty() && a[rs.peek()] >= a[i])
                    rs.pop();
                right[i] = rs.isEmpty() ? n-1 : rs.peek() - 1;
                rs.push(i);
            }
        }
        // to calculate maxArea
        for(int i=0; i<n; i++)
            area = Math.max(area, (right[i] - left[i] + 1) * a[i]);
        
        return area;
    }
}

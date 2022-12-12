// https://leetcode.com/problems/pascals-triangle/



import java.util.*;

public class PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<>(); // outer list
        
        if(numRows == 0) return triangle;
        
        List<Integer> first_row = new ArrayList<>();  // created first row manually 
        first_row.add(1); 
        triangle.add(first_row);
        
        for(int i=1; i<numRows; i++){
            
            List<Integer> prev_row = triangle.get(i-1);  // to calculate new row we need previous row
            List<Integer> row = new ArrayList<>();  // nee row
            
            // new row = [row.add(1) , prev_now(calculation) , row.add(1)]

            row.add(1);
            
            for(int j=1; j<i; j++){
                row.add(prev_row.get(j-1) + prev_row.get(j));
            }
            
            row.add(1);
            
            triangle.add(row);  // adding row in outer list
        }
        
        return triangle;
        
    }
}

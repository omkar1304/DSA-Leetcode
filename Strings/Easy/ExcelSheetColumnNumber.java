// https://leetcode.com/problems/excel-sheet-column-number/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        
        int number = 0;
        for(int i=0; i<s.length(); i++)
            // s.charAt(s.length() - i - 1 -> to iterate from last index
            number = number + (int)(s.charAt(s.length() - i - 1) - 'A' + 1) * (int)(Math.pow(26, i));
        
        return number;
        
    }
}

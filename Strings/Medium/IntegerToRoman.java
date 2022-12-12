// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
    public String intToRoman(int num) {
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        String s = "";
        // from large to small number checking
        for(int i=0; i<values.length; i++){
            // if num is greater than or euqal to current value then sub till num gets smaller than current value
            while(num >= values[i]){
                num = num - values[i];
                s = s + roman[i]; // adding resoective char from roman array.
            }
        }
        
        return s;
    }
}

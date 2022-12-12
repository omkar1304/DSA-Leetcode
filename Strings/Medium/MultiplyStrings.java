// https://leetcode.com/problems/multiply-strings/

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        
        if("0".equals(num1) || "0".equals(num2)) return "0";
        
        int[] res = new int[num1.length() + num2.length() - 1];
        
        // just storing multiplication values(adding if already present some value)
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                res[i+j] = res[i+j] + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
            }     
        }
        
        // taking care of carry if it there just adding into previous index and storing only %10 value in current index
        for(int k=res.length - 1; k>0; k--){
            res[k-1] = res[k-1] + res[k] / 10;
            res[k] = res[k] % 10;
        }
        
        String str = "";
        for(int index=0; index<res.length; index++)
            str = str + res[index];
        
        return str;
    }
}

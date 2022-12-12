// https://leetcode.com/problems/construct-smallest-number-from-di-string/

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String s) {

        //Input = "IIIDIDDD"
        //Output: "123549876"
        
        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        
        // 1 to n+1 -> as we need generate string with s.length + 1
        for(int i=0; i<=s.length(); i++){
            // adding value in temp string.
            temp.append((char)('1' + i));
            // if its last index or char at index is I then pattern of D ends then we have to store it in reverse order in result string and make temp string as new string.
            if(i == s.length() || s.charAt(i) == 'I'){
                res.append(temp.reverse());
                temp = new StringBuilder();
            }  
        }
        
        return res.toString();
        
    }
}

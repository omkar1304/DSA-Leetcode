// https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String helper(String s){
        int count = 1;
        char prev = s.charAt(0);
        String res = "";
        
        for(int i=1; i<s.length(); i++){
            if(prev == s.charAt(i))
                count++;
            else{
                res = res + count + prev;
                prev = s.charAt(i);
                count = 1;
            }  
        }
        // storing the count of last prev(which is not stored beacuse of out of bound length)
        res = res + count + prev;
        return res;
    }
    
    
    public String countAndSay(int n) {
        
        String res = "1";
        // to get string everytime as current result depneds on previous result.
        for(int i=1; i<n; i++){
            res = helper(res);
        } 
        return res;  
    }
}

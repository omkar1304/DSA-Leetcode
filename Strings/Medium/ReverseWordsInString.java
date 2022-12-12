// https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInString {
    public String reverseWords(String s) {
        // creating word array
        String [] words = s.split(" ");
        String res = "";
        // reversely adding word in string
        for(int i=words.length-1; i>=0; i--){
            if(words[i].isEmpty()) // if word is empty then skip
                continue;
            res = res + words[i] + " "; // else add
        }

        return res.substring(0, res.length()-1);
        
    }
}

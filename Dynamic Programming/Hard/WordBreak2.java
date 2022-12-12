// https://leetcode.com/problems/word-break-ii/

public class WordBreak2 {
    // Memoization ->
    private Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        // if present then return
        if(map.containsKey(s))
            return map.get(s);
        
        // create new res to return
        // and set to check word is prsent in set or not in O(1) time
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        // if that string itself present then add into res
        if(wordDict.contains(s))
            res.add(s);
        
        // build set from dict
        for(String str : wordDict)
            set.add(str);
        
        // check from 1 index till last if left part is present in set if yes then solve subproblem for right part
        for(int i=1; i<s.length(); i++){
            String left = s.substring(0, i);
            // check if string is present or not in set i.e in wordDict
            if(set.contains(left)){
                // solve recursively right part
                List<String> subList = wordBreak(s.substring(i), wordDict);
                // from right part we can make permutation strings
                // for example if right part returns -> res = ["and dogs", "and dog"]
                // and left part is -> cat then result will be 
                // res = ["cat and dogs", "cat and dog"]
                for(String sent : subList)
                    res.add(left + " " + sent);
            }
        }
        
        //store for future use
        map.put(s, res);
        return res;
    }
}
